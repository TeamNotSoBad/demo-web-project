package edu.csupomona.cs480.data.provider;

import java.util.ArrayList;
import java.util.List;

import edu.csupomona.cs480.data.Group;
import edu.csupomona.cs480.data.User;

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
	
	public List<User> getUsersById(String id);

	public List<User> searchByMajor(String major);
	
	public List<User> searchByFirstName(String first);
	
	public List<User> searchByLastName(String last);
	
	public List<User> searchByCourse(String course);
	
	//public List<User> searchByCommonCourses(String commoncourses);	 	
	
	public void message(String senderID, String recipientID,String msg);
	
	public void groupMessage(String userID, String groupID, String msg);
	
	public ArrayList<Boolean> getAvailabilityForDay(String userID, int day);
	
	public void flipAvailibility(String userID, int day, double time);
	
	public ArrayList<Boolean> matchingDays(String user1ID, String user2ID, int day);
	
	public List<String> getMajors();
	
	public List<String> getClassOfMajor(String maj);
	 	
	public List<String> getAllClasses();

	public List<Group> listAllGroups();

	public void deleteGroup(String groupId);
	
	public boolean createGroup(String groupId, User owner);

	public void updateGroup(Group group);

	public Group getGroup(String groupID);

	public void leaveGroup(String userID, String groupID);

	public boolean removeMember(String ownerID, String newMemberID, String groupID);

	public boolean addMember(String ownerID, String newMemberID, String groupID);



	//public void deleteMember(String groupID, String deleter, String deletee);
	
	/**public void addMember(String groupID, String adder, String addee);
	
	public void addAdmin(String groupID, String adder, String addee);

	public List<User> searchByGroupIDForUsers(String groupID);

	public void removeAdmin(String groupID, String deleter, String deletee);

	public void setOwner(String groupID, String oldOwner, String newOwner);*/
}
