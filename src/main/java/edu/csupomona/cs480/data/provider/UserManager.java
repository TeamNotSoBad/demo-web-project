package edu.csupomona.cs480.data.provider;

import edu.csupomona.cs480.data.Group;
import edu.csupomona.cs480.data.GroupMap;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import edu.csupomona.cs480.data.User;
import edu.csupomona.cs480.data.UserMap;

public interface UserManager {

	/**
	 * Get the user information object based on
	 * the given userId.
	 * <p>
	 * If the user does not exist, simply create
	 * one.
	 *
	 * @param userId
	 * @return the User object
	 */
	public User getUser(String userId);

	/**
	 * Update the given user object and persist it.
	 * <p>
	 * If the user does not exist before, this
	 * method will create a new record; otherwise,
	 * it will overwrite whatever is currently
	 * being stored.
	 *
	 * @param user object
	 */
	public void updateUser(User user);

	/**
	 * Delete the given user from the storage.
	 *
	 * @param userId
	 */
	public void deleteUser(String userId);

	/**
	 * List all the current users in the storage.
	 *
	 * @return
	 */
	public List<User> listAllUsers();

	void uploadMap();

	void downloadMap();
	
	public List<User> getId(String id);

	public String getLocalMapTest();
	
	public List<User> searchByMajor(String major);
	
	public List<User> searchByFirstName(String first);
	
	public List<User> searchByLastName(String last);
	
	public List<User> searchByCourse(String course);
	
	public List<User> searchByCommonCourses(String commoncourses);
	
	public List<String> getAllClasses();

	public void message(String userID, String recipientID,String msg);
	public void groupMessage(String userID, String groupID, String msg);
	
	public ArrayList<Boolean> getAvailabilityForDay(String userID, int i);
	public void flipAvailibility(String userID, int day, double time);
	
}
