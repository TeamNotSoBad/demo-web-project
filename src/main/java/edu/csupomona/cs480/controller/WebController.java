package edu.csupomona.cs480.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSCredentialsProviderChain;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.DescribeAvailabilityZonesResult;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.simpledb.AmazonSimpleDBClient;
import com.amazonaws.services.simpledb.model.DomainMetadataRequest;
import com.amazonaws.services.simpledb.model.DomainMetadataResult;
import com.amazonaws.services.simpledb.model.ListDomainsRequest;
import com.amazonaws.services.simpledb.model.ListDomainsResult;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.apache.commons.io.*;
import org.apache.commons.math.fraction.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import edu.csupomona.cs480.App;
import edu.csupomona.cs480.data.User;

import edu.csupomona.cs480.data.provider.UserManager;
import edu.csupomona.cs480.util.ResourceResolver;


/**
 * This is the controller used by Spring framework.
 * <p>
 * The basic function of this controller is to map
 * each HTTP API Path to the correspondent method.
 *
 */

@RestController
public class WebController extends WebMvcConfigurerAdapter {

	/**
	 * When the class instance is annotated with
	 * {@link Autowired}, it will be looking for the actual
	 * instance from the defined beans.
	 * <p>
	 * In our project, all the beans are defined in
	 * the {@link App} class.
	 */
	@Autowired
	private UserManager userManager;

	
	/**
<<<<<<< HEAD
	 * Cs480 - Assignment 3, part 3
	 * Template Method by Henry Hu.
	 */
	@RequestMapping(value = "/cs480/temptest", method = RequestMethod.GET)
	String templateMethod() {
		return "This is a test message. Success!";
	}
	
	/**
	 * Cs480 - Assignment 4, part 2 Prototype FileUpload Method by Henry Hu. The
	 * following method is NOT COMPLETE. DO NOT RUN this method. The user will
	 * provide a DiskFileItem which is a compacted upload file as an object. The
	 * write method will write the uploaded file into the disk, our server.
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/cs480/user/filespace/upload", method = RequestMethod.GET)
	String fileUploadMethod() throws Exception {

		// parseUploadRequest()
		// processUploadedItemsList()
		// ------Make the DiskFileItem object--------
		// dfi.write(dfi.getStoreLocation());
		// FileCleanUp()
		return "Testing the file upload classes";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	ModelAndView getTest() {
		ModelAndView modelAndView = new ModelAndView("signup");
		modelAndView.addObject("majors", getMajors());
		return modelAndView;
	}
	
	/**
=======
>>>>>>> e0e764890ebfc5ea605befe90b36572ed7edebfd
	 * Thomas Nguyen
	 * Assignment 4 part 2
	 * Please do not uncomment the awsTest method, currently missing some vital parts of aws
	 * that allows for the use of instantiating ec2, s3, and simpleDB,
	 * 
	 */
	
	public static void awsTest()throws Exception{
		AWSCredentials credentials = null;
		AmazonEC2Client ec2 = new AmazonEC2Client(credentials);
        AmazonS3Client s3  = new AmazonS3Client(credentials);
        AmazonSimpleDBClient sdb = new AmazonSimpleDBClient(credentials);
        try {
        	
            DescribeAvailabilityZonesResult availabilityZonesResult = ec2.describeAvailabilityZones();
            System.out.println("You have access to " + availabilityZonesResult.getAvailabilityZones().size() +
                    " Availability Zones.");

            DescribeInstancesResult describeInstancesRequest = ec2.describeInstances();
            List<Reservation> reservations = describeInstancesRequest.getReservations();
            Set<Instance> instances = new HashSet<Instance>();

            for (Reservation reservation : reservations) {
                instances.addAll(reservation.getInstances());
            }

            System.out.println("You have " + instances.size() + " Amazon EC2 instance(s) running.");
        } catch (AmazonServiceException ase) {
                System.out.println("Caught Exception: " + ase.getMessage());
                System.out.println("Reponse Status Code: " + ase.getStatusCode());
                System.out.println("Error Code: " + ase.getErrorCode());
                System.out.println("Request ID: " + ase.getRequestId());
        }

        try {
            ListDomainsRequest sdbRequest = new ListDomainsRequest().withMaxNumberOfDomains(100);
            ListDomainsResult sdbResult = sdb.listDomains(sdbRequest);

            int totalItems = 0;
            for (String domainName : sdbResult.getDomainNames()) {
                DomainMetadataRequest metadataRequest = new DomainMetadataRequest().withDomainName(domainName);
                DomainMetadataResult domainMetadata = sdb.domainMetadata(metadataRequest);
                totalItems += domainMetadata.getItemCount();
            }

            System.out.println("You have " + sdbResult.getDomainNames().size() + " Amazon SimpleDB domain(s)" +
                    "containing a total of " + totalItems + " items.");
        } catch (AmazonServiceException ase) {
                System.out.println("Caught Exception: " + ase.getMessage());
                System.out.println("Reponse Status Code: " + ase.getStatusCode());
                System.out.println("Error Code: " + ase.getErrorCode());
                System.out.println("Request ID: " + ase.getRequestId());
        }

        try {
            List<Bucket> buckets = s3.listBuckets();

            long totalSize  = 0;
            int  totalItems = 0;
            for (Bucket bucket : buckets) {

                ObjectListing objects = s3.listObjects(bucket.getName());
                do {
                    for (S3ObjectSummary objectSummary : objects.getObjectSummaries()) {
                        totalSize += objectSummary.getSize();
                        totalItems++;
                    }
                    objects = s3.listNextBatchOfObjects(objects);
                } while (objects.isTruncated());
            }

            System.out.println("You have " + buckets.size() + " Amazon S3 bucket(s), " +
                    "containing " + totalItems + " objects with a total size of " + totalSize + " bytes.");
        } catch (AmazonServiceException ase) {

            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
        	
            System.out.println("Error Message: " + ace.getMessage());
        }
    }
	
	/**
	 * This is a simple example of how the HTTP API works.
	 * It returns a String "OK" in the HTTP response.
	 * To try it, run the web application locally,
	 * in your web browser, type the link:
	 * 	http://localhost:8080/cs480/ping
	 */
	@RequestMapping(value = "/cs480/ping", method = RequestMethod.GET)
	String healthCheck() {
		// You can replace this with other string,
		// and run the application locally to check your changes
		// with the URL: http://localhost:8080/
		return "OK";
	}
	
	/**
	 * Uploads the file that contains all the users, but I don't
	 * know the name of the file that stores all the users, so I'm
	 * using the resource resolver thing
	 */
	@RequestMapping(value = "/cs480/upload", method = RequestMethod.POST)
	String upload(){
		userManager.uploadMap();
		return "redirect:/";
	}
	
	/**
	 * Downloads the file that contains all users
	 */
	@RequestMapping(value = "/cs480/download", method = RequestMethod.GET)
	String download(){
		userManager.downloadMap();
		return "redirect:/";
	}
		
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	ModelAndView getLogin() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	ModelAndView getSearch() {
		ModelAndView modelAndView = new ModelAndView("search");
		return modelAndView;
	}
	
	@RequestMapping(value = "/message", method = RequestMethod.GET)
	ModelAndView message(){
		ModelAndView modelAndView = new ModelAndView("edit");
		return modelAndView;
	}
	
	@RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
	ModelAndView getEdit(@PathVariable("userId") String userId) {
		User user = userManager.getUser(userId);
		ModelAndView modelAndView = new ModelAndView("edit");
		modelAndView.addObject("user", user);
		modelAndView.addObject("majors", getMajors());
		modelAndView.addObject("classes", new ArrayList<String>());
		modelAndView.addObject("messages", userManager.getUser(userId).getWall());
		return modelAndView;
	}
	
	@RequestMapping(value = "/group/{groupId}", method = RequestMethod.GET)
	ModelAndView getGroup(@PathVariable("groupId") String groupId) {
		ModelAndView modelAndView = new ModelAndView("group");
		modelAndView.addObject("group", userManager.getGroup(groupId));
		return modelAndView;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	ModelAndView getSignUp() {
		ModelAndView modelAndView = new ModelAndView("signup");
		modelAndView.addObject("majors", getMajors());
		return modelAndView;
	}
	
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.POST)
	User updateUser(
			@PathVariable("userId") String userId,
			@RequestParam("userLast") String userLast,
			@RequestParam("userFirst") String userFirst,
			@RequestParam("userMajor") String usermajor,
			@RequestParam("userPW") String userpassword) {
		User user = new User();
		user.setId(userId);
		user.setLastName(userLast);
		user.setFirstName(userFirst);
		user.setMajor(usermajor);
		user.setPassword(userpassword);
		user.addFriend(null);
		userManager.updateUser(user);
		return user;
	}
	
	@RequestMapping(value = "/user/id/{userId}", method = RequestMethod.GET)
	void updateUserName(
			@PathVariable("userId") String userId,
			@RequestParam("userLast") String userLast,
			@RequestParam("userFirst") String userFirst) {
		User user = userManager.getUser(userId);
		user.setLastName(userLast);
		user.setFirstName(userFirst);
		userManager.updateUser(user);
	}
	
	@RequestMapping(value = "/user/major/{userId}", method = RequestMethod.GET)
	void updateUserMajor(
			@PathVariable("userId") String userId,
			@RequestParam("userMajor") String userMajor) {
		User user = userManager.getUser(userId);
		user.setMajor(userMajor);
		userManager.updateUser(user);
	}
	
	@RequestMapping(value = "/user/friends/{userId}", method = RequestMethod.GET)
	void updateUserFriend(
			@PathVariable("userId") String userId,
			@RequestParam("userFriend") String userFriend) {
		User user = userManager.getUser(userId);
		user.addFriend(userFriend);
		userManager.updateUser(user);
	}
	

	@RequestMapping(value = "/search/id/{userId}", method = RequestMethod.GET)	
	List<User> searchById(@PathVariable("userId") String userId){
		return userManager.getUsersById(userId);
	}
	
	@RequestMapping(value = "/results/id/{userId}", method = RequestMethod.GET)
	ModelAndView resultsById(@PathVariable("userId") String userId) {
		ModelAndView modelAndView = new ModelAndView("results");
		modelAndView.addObject("users", searchById(userId));
		return modelAndView;
	}
	
	@RequestMapping(value = "/search/first/{userId}", method = RequestMethod.GET)	
	List<User> searchByFirstName(@PathVariable("userId") String userId){
		List<User> results = new ArrayList<User> ();
		results = userManager.searchByFirstName(userId);
		return results;
	}
	
	@RequestMapping(value = "/results/first/{userId}", method = RequestMethod.GET)
	ModelAndView resultsByFirstName(@PathVariable("userId") String userId) {
		ModelAndView modelAndView = new ModelAndView("results");
		modelAndView.addObject("users", searchByFirstName(userId));
		return modelAndView;
	}
	
	@RequestMapping(value = "/search/last/{userId}", method = RequestMethod.GET)	
	List<User> searchByLastName(@PathVariable("userId") String userId){
		List<User> results = new ArrayList<User> ();
		results = userManager.searchByLastName(userId);
		return results;
	}
	
	@RequestMapping(value = "/results/last/{userId}", method = RequestMethod.GET)
	ModelAndView resultsByLastName(@PathVariable("userId") String userId) {
		ModelAndView modelAndView = new ModelAndView("results");
		modelAndView.addObject("users", searchByLastName(userId));
		return modelAndView;
	}
	
	@RequestMapping(value = "/search/course/{userId}", method = RequestMethod.GET)	
	List<User> searchByCourse(@PathVariable("userId") String userId){
		List<User> results = new ArrayList<User> ();
		results = userManager.searchByCourse(userId);
		return results;
	}
	
	@RequestMapping(value = "/results/course/{userId}", method = RequestMethod.GET)
	ModelAndView resultsByCourse(@PathVariable("userId") String userId) {
		ModelAndView modelAndView = new ModelAndView("results");
		modelAndView.addObject("users", searchByCourse(userId));
		return modelAndView;
	}
	
	@RequestMapping(value = "/search/commoncourses/{userId}", method = RequestMethod.GET)	
	List<User> searchByCommonCourses(@PathVariable("userId") String userId){
		List<User> results = new ArrayList<User> ();
		results = userManager.searchByCommonCourses(userId);
		return results;
	}
	
	@RequestMapping(value = "/results/commoncourses/{userId}", method = RequestMethod.GET)
	ModelAndView resultsByCommonCourses(@PathVariable("userId") String userId) {
		ModelAndView modelAndView = new ModelAndView("results");
		modelAndView.addObject("users", searchByCommonCourses(userId));
		return modelAndView;
	}
	
	@RequestMapping(value = "/search/major/{userId}", method = RequestMethod.GET)	
	List<User> searchByMajor(@PathVariable("userId") String userId){
		List<User> results = new ArrayList<User> ();
		results = userManager.searchByMajor(userId);
		return results;
	}
	
	@RequestMapping(value = "/results/major/{userId}", method = RequestMethod.GET)
	ModelAndView resultsByMajor(@PathVariable("userId") String userId) {
		ModelAndView modelAndView = new ModelAndView("results");
		modelAndView.addObject("users", searchByMajor(userId));
		return modelAndView;
	}
	
	@RequestMapping(value = "/list/majors", method = RequestMethod.GET)	
	List<String> getMajors(){
		List<String> majors = userManager.getMajors();
		return majors;
	}
	
	@RequestMapping(value = "/list/classes/{dep}", method = RequestMethod.GET)	
	List<String> getClasses(@PathVariable("dep") String dep){
		List<String> classes = userManager.getClassOfMajor(dep);
		return classes;
	}
	//TODO Need to test this method with free marker
	/**
	 * Test function to see if an image can be uploaded to ec2 client, idk how to 
	 * use free marker though to create something that accepts a file
	 * @param image
	 */
	@RequestMapping(value = "/uploadImageTest", method = RequestMethod.POST)
	void transferImageTest(File file)throws IOException{
		int width = 100;
		int height = 100;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		image = ImageIO.read(file);
		String BASE_DIR = System.getProperty("user.home") + "/images/database";
		file = new File(BASE_DIR + "/" + "test.jpg");
		ImageIO.write(image, "jpg", file);
	}
	
	@RequestMapping(value = "/upload/{userId}", method = RequestMethod.POST)
	void uploadUserImage(File file, @PathVariable("userId") String userId)throws IOException{
		int width = 100;
		int height = 100;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		image = ImageIO.read(file);
		String BASE_DIR = System.getProperty("user.home") + "/images/database";
		file = new File(BASE_DIR + "/" + userId +".jpg");
		ImageIO.write(image, "jpg", file);
	}
	
	@RequestMapping(value = "/user/profile/{userId}", method = RequestMethod.GET)
	BufferedImage getUserImage(@PathVariable("userId") String userId) throws IOException{
		int width = 100;
		int height = 100;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		File f = ResourceResolver.getUserImage(userId);
		image = ImageIO.read(f);
		
		return image;		
	}
	
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	ModelAndView getUser(@PathVariable("userId") String userId) {
		User user = userManager.getUser(userId);
		ModelAndView modelAndView = new ModelAndView("user");
		modelAndView.addObject("user", user);
		modelAndView.addObject("friends", user.getFriends());
		return modelAndView;
	}
	
	@RequestMapping(value = "/user/{userName}", method = RequestMethod.DELETE)
	void deleteUser(
			@PathVariable("userName") String name) {
		userManager.deleteUser(name);
	}
	
	@RequestMapping(value = "/users/list", method = RequestMethod.GET)
	List<User> listAllUsers() {
		return userManager.listAllUsers();
	}
}
