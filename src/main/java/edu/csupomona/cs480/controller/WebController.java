package edu.csupomona.cs480.controller;

import java.util.List;
import org.apache.commons.io.*;
import org.apache.commons.math.fraction.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.csupomona.cs480.App;
import edu.csupomona.cs480.data.User;
import edu.csupomona.cs480.data.provider.UserManager;


/**
 * This is the controller used by Spring framework.
 * <p>
 * The basic function of this controller is to map
 * each HTTP API Path to the correspondent method.
 *
 */

@RestController
public class WebController {

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
	 * Cs480 - Assignment 3, part 3
	 * Template Method by Henry Hu.
	 */
	@RequestMapping(value = "/cs480/temptest", method = RequestMethod.GET)
	String templateMethod() {
		return "This is a test message. Success!";
	}
	
	/**
	 * Cs480 - Assignment 4, part 2
	 * Prototype FileUpload Method by Henry Hu.
	 * The following method is NOT COMPLETE. DO NOT RUN this method.
	 * The user will provide a DiskFileItem which is a compacted upload file as an object.
	 * The write method will write the uploaded file into the disk, our server.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/cs480/user/filespace/upload", method = RequestMethod.GET)
	String fileUploadMethod() throws Exception {
		
		//parseUploadRequest()
		//processUploadedItemsList()
		//------Make the DiskFileItem object--------
		//dfi.write(dfi.getStoreLocation());
		//FileCleanUp()
		return "Testing the file upload classes";
	}
	
	/**
	 *  CS480 - Assignment 3 
	 *  Kevin Liu
	 */
	@RequestMapping(value = "/cs480/WeAreNotThatBad", method = RequestMethod.GET)
	String notThatBadMethod() {
		return "We're not that bad";
	}
	
	/**
	 * CS480 - Assignment 4
	 * Kevin Liu 
	 */
	@RequestMapping(value = "/print_test", method = RequestMethod.GET)
		String printer() throws Exception{
		Fraction f = new Fraction(3.4);
		return f.toString();
	}
	/**
	 * cs480 - Assignment 3
	 * Method by Mark Ilog.
	 */

	@RequestMapping(value = "/cs480/marktest", method = RequestMethod.GET)
	String markMethod() {
		return "Hello World";
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
	 * This is a simple example of how to use a data manager
	 * to retrieve the data and return it as an HTTP response.
	 * <p>
	 * Note, when it returns from the Spring, it will be
	 * automatically converted to JSON format.
	 * <p>
	 * Try it in your web browser:
	 * 	http://localhost:8080/cs480/user/user101
	 */
	@RequestMapping(value = "/cs480/user/{userId}", method = RequestMethod.GET)
	User getUser(@PathVariable("userId") String userId) {
		User user = userManager.getUser(userId);
		return user;
	}

	/**
	 * This is an example of sending an HTTP POST request to
	 * update a user's information (or create the user if not
	 * exists before).
	 *
	 * You can test this with a HTTP client by sending
	 *  http://localhost:8080/cs480/user/user101
	 *  	name=John major=CS
	 *
	 * Note, the URL will not work directly in browser, because
	 * it is not a GET request. You need to use a tool such as
	 * curl.
	 *
	 * @param id
	 * @param name
	 * @param major
	 * @return
	 */
	@RequestMapping(value = "/cs480/user/{userId}", method = RequestMethod.POST)
	User updateUser(
			@PathVariable("userId") String id,
			@RequestParam("name") String name,
			@RequestParam(value = "major", required = false) String major) {
		User user = new User();
		user.setId(id);
		user.setMajor(major);
		user.setName(name);
		userManager.updateUser(user);
		return user;
	}

	/**
	 * This API deletes the user. It uses HTTP DELETE method.
	 *
	 * @param userId
	 */
	@RequestMapping(value = "/cs480/user/{userId}", method = RequestMethod.DELETE)
	void deleteUser(
			@PathVariable("userId") String userId) {
		userManager.deleteUser(userId);
	}

	/**
	 * This API lists all the users in the current database.
	 *
	 * @return
	 */
	@RequestMapping(value = "/cs480/users/list", method = RequestMethod.GET)
	List<User> listAllUsers() {
		return userManager.listAllUsers();
	}
	
	
	
	/**
	 * This is a test method for part 3 of assignment 3.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/cs480/testing", method = RequestMethod.GET)
	String doSomething() {
		return "something";
	}

	/*********** Web UI Test Utility **********/
	/**
	 * This method provide a simple web UI for you to test the different
	 * functionalities used in this web service.
	 */
	@RequestMapping(value = "/cs480/home", method = RequestMethod.GET)
	ModelAndView getUserHomepage() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("users", listAllUsers());
		return modelAndView;
	}

}
