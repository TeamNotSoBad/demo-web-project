package edu.csupomona.cs480.data.provider;
import edu.csupomona.cs480.data.SearchTool;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.csupomona.cs480.data.User;
import edu.csupomona.cs480.data.UserMap;
import edu.csupomona.cs480.util.ResourceResolver;

/**
 * The implementation of {@link UserManager} interface
 * using file system.
 * <p>
 * This class demonstrates how you can use the file system
 * as a database to store your data.
 *
 */
public class FSUserManager implements UserManager {

	/**
	 * We persist all the user related objects as JSON.
	 * <p>
	 * For more information about JSON and ObjectMapper, please see:
	 * http://www.journaldev.com/2324/jackson-json-processing-api-in-java-example-tutorial
	 *
	 * or Google tons of tutorials
	 *
	 */
	private static final ObjectMapper JSON = new ObjectMapper();
	private SearchTool userSearchTool;
	/**
	 * Load the user map from the local file.
	 *
	 * @return
	 */
	private UserMap getUserMap() {
		UserMap userMap = null;
		File userFile = ResourceResolver.getUserFile();
		if (userFile.exists()) {
			// read the file and convert the JSON content
			// to the UserMap object
			try {
				userMap = JSON.readValue(userFile, UserMap.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			userMap = new UserMap();
		}
		return userMap;
	}
	
	/**
	 * This method is to test whether or not the json map is found in
	 * the linux environment
	 */
	public String getLocalMapTest(){
		UserMap userMap = null;
		File userFile = ResourceResolver.getUserFile();
		if (userFile.exists()) {
			return "File was found";
		} else {
			return "Does not Exist";
		}
	}

	/**
	 * Save and persist the user map in the local file.
	 *
	 * @param userMap
	 */
	private void persistUserMap(UserMap userMap) {
		try {
			// convert the user object to JSON format
			JSON.writeValue(ResourceResolver.getUserFile(), userMap);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Created this method to see if the file is properly uploaded, because the 
	 * method in web controller created the bucket, but nothing was in it.
	 */
	
	@Override
	public void uploadMap(){
		AWSCredentials credentials =  new ProfileCredentialsProvider("default").getCredentials();
		AmazonS3 s3c = new AmazonS3Client(credentials);
		File temp = ResourceResolver.getUserFile();
		s3c.putObject("cs480usermap", "user-map.json", temp);
		
	}
	
	/**
	 * Still working on the downloadMap because the object that is downloaded comes as a s3object
	 * and not a File
	 */
	
	@Override
	public void downloadMap(){
		AWSCredentials credentials =  new ProfileCredentialsProvider("default").getCredentials();
		AmazonS3 s3c = new AmazonS3Client(credentials);
		S3Object temp = s3c.getObject("cs480usermap","user-map.json");
		S3ObjectInputStream usermapstream = temp.getObjectContent();
		try {
			JSON.writeValue(ResourceResolver.getUserFile(), usermapstream);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			temp.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			usermapstream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public User getUser(String userId) {
		UserMap userMap = getUserMap();
		return userMap.get(userId);
	}

	@Override
	public void updateUser(User user) {
		UserMap userMap = getUserMap();
		userMap.put(user.getId(), user);
		persistUserMap(userMap);
	}

	@Override
	public void deleteUser(String userId) {
		UserMap userMap = getUserMap();
		userMap.remove(userId);
		persistUserMap(userMap);
	}

	@Override
	public List<User> listAllUsers() {
		UserMap userMap = getUserMap();
		return new ArrayList<User>(userMap.values());
	}

}
