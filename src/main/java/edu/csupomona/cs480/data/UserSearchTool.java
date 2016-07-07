package edu.csupomona.cs480.data;

import java.util.ArrayList;

/**
 * This class is an object used to process user objects from the UserMap class.
 * A single search function allows parameter for search by ID, Name, Major, and classes taken. 
 * A list of qualifying user searched results is provided by the search method.
 * @author HH
 *
 */
public class UserSearchTool {
	
	private ArrayList<User> listOfUsers;
	
	public UserSearchTool(UserMap users) {
		listOfUsers = new ArrayList<User>(users.values());
	}
	
	/**
	 * For a single user
	 * @return
	 */
	public ArrayList<User> searchByID(String id) {
		ArrayList<User> searchedUsers = new ArrayList<User>();
		for(User user: listOfUsers) {
			if (id.equals(user.getId())) {
				searchedUsers.add(user);
				return searchedUsers;
			}
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
	
//  /** A planned search implementation
//	public User[] searchByClasses() {
//	}


	
}