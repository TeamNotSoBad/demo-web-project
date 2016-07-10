package edu.csupomona.cs480.data;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * This class is an object used to process user objects from the UserMap class.
 * A single search function allows parameter for search by ID, Name, Major, and classes taken. 
 * A list of qualifying user searched results is provided by the search method.
 * @author HH
 *
 */
public class UserSearchTool {
	
	private ArrayList<User> listOfUsers;
	private UserMap mapOfUsers;
	
	public UserSearchTool(UserMap users) {
		listOfUsers = new ArrayList<User>(users.values());
		mapOfUsers = users;
	}
	
	/**
	 * For a single user
	 * @return
	 */
	public ArrayList<User> searchByID(String id) {
		ArrayList<User> searchedUsers = new ArrayList<User>();

		User singleUser = mapOfUsers.get(id);
		
		if (singleUser != null) {
			searchedUsers.add(singleUser);
		}
		
		return searchedUsers;
	}

	/**
	 * For multiple users of the selected major.
	 * @return
	 */
	public ArrayList<User> searchByMajor(String major) {
		ArrayList<User> searchedUsers = new ArrayList<User>();
		for(User user: listOfUsers) {
			if ((major.equals(user.getMajor()))) {
				searchedUsers.add(user);
			}
		}		
		return searchedUsers;
	}

	/**
	 * For multiple users of matching name. May later implement last and first name search.
	 * @param name
	 * @return
	 */
	public ArrayList<User> searchByName(String name) {
		ArrayList<User> searchedUsers = new ArrayList<User>();
		for(User user: listOfUsers) {
			if ((name.equals(user.getName()))) {
				searchedUsers.add(user);
			}
		}
		return searchedUsers;
	}
	
	/**
	 * Method to search the user base if they contain one specific course.
	 * @param course
	 * @return
	 */
	public ArrayList<User> searchByCourse(String course) {
		ArrayList<User> searchedUsers = new ArrayList<User>();
		
		for(User user: listOfUsers) {
			if (user.getCourses().contains(course)) {
				searchedUsers.add(user);
			}
		}
		
		return searchedUsers;
	}
	
	/**
	 * Method to find users that share at least one course with the current user.
	 * @return
	 */
	public ArrayList<User> searchByCommonCourses(User currentUser) {
		ArrayList<User> searchedUsers = new ArrayList<User>();
		HashSet<String> currentUserCourses = currentUser.getCourses();
		
		for(User user: listOfUsers) {
			
			boolean hasCommonCourse = false;
			
			for(String course: currentUserCourses) {
				if (user.getCourses().contains(course)) {
					hasCommonCourse = true;
					break;
				}
			}
			
			if (hasCommonCourse == true) {
				searchedUsers.add(user);
			}
			
		}
		
		return searchedUsers;
	}
}