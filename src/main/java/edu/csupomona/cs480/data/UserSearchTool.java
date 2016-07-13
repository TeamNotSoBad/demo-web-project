package edu.csupomona.cs480.data;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * This class is an object used to process user objects from the UserMap class.
 * A single search function allows parameter for search by ID, Name, Major, and
 * classes taken. A list of qualifying user searched results is provided by the
 * search method.
 * 
 * @author HH
 *
 */
public class UserSearchTool {

	private ArrayList<User> listOfUsers;
	private UserMap mapOfUsers;
	private GroupMap mapOfGroups;

	public UserSearchTool(UserMap users, GroupMap groups) {
		listOfUsers = new ArrayList<User>(users.values());
		mapOfUsers = users;
		mapOfGroups = groups;
	}

	/**
	 * For a single user
	 * 
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
	 * 
	 * @return
	 */
	public ArrayList<User> searchByMajor(String major) {
		ArrayList<User> searchedUsers = new ArrayList<User>();
		for (User user : listOfUsers) {
			if ((major.equals(user.getMajor()))) {
				searchedUsers.add(user);
			}
		}
		return searchedUsers;
	}

	/**
	 * For multiple users of matching name. May later implement last and first
	 * name search. If a user has part of the searched name, will be applicable.
	 * 
	 * @param name
	 * @return
	 */
	public ArrayList<User> searchByLastName(String name) {
		ArrayList<User> searchedUsers = new ArrayList<User>();
		for (User user : listOfUsers) {
			if ((user.getLastName().contains(name))) {
				searchedUsers.add(user);
			}
		}
		return searchedUsers;
	}
	
	/**
	 * For multiple users of matching name. May later implement last and first
	 * name search. If a user has part of the searched name, will be applicable.
	 * 
	 * @param name
	 * @return
	 */
	public ArrayList<User> searchByFirstName(String name) {
		ArrayList<User> searchedUsers = new ArrayList<User>();
		for (User user : listOfUsers) {
			if ((user.getFirstName().contains(name))) {
				searchedUsers.add(user);
			}
		}
		return searchedUsers;
	}

	/**
	 * Method to search the user base if they contain one specific course.
	 * 
	 * @param course
	 * @return
	 */
	public ArrayList<User> searchByCourse(String course) {
		ArrayList<User> searchedUsers = new ArrayList<User>();

		for (User user : listOfUsers) {

			if (user.getCourses().contains(course)) {
				searchedUsers.add(user);
			}
		}

		return searchedUsers;
	}

	/**
	 * Method to find users that share at least one course with the current
	 * user. Excludes the user self.
	 * 
	 * @return
	 */
	public ArrayList<User> searchByCommonCourses(User currentUser) {
		ArrayList<User> searchedUsers = new ArrayList<User>();
		HashSet<String> currentUserCourses = currentUser.getCourses();

		for (User user : listOfUsers) {

			if (!user.equals(currentUser)) {

				boolean hasCommonCourse = false;

				for (String course : currentUserCourses) {
					if (user.getCourses().contains(course)) {
						hasCommonCourse = true;
						break;
					}
				}

				if (hasCommonCourse == true) {
					searchedUsers.add(user);
				}
			}
		}
		return searchedUsers;
	}
	
	/**
	 * Retrieves all users from the master groupMap object.
	 * Given a groupID, this method will generate the list of the group's members.
	 * @param groupID
	 * @return
	 */
	public ArrayList<User> searchByGroupID(String groupID) {
		ArrayList<User> searchedUsers = new ArrayList<User>();
		Group result = mapOfGroups.get(groupID);
		
		if(result != null) {
			HashSet<String> membersID = result.getMembersID();
			for(String member: membersID) {
				User user = mapOfUsers.get(member);
				if(user != null) {
					searchedUsers.add(user);
				}
			}
		}
		return searchedUsers;
	}
}