package edu.csupomona.cs480.data.provider;

import edu.csupomona.cs480.data.Group;
import edu.csupomona.cs480.data.GroupMap;
import edu.csupomona.cs480.data.ListOfClasses;
import edu.csupomona.cs480.data.Message;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
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
 * The implementation of {@link UserManager} interface using file system.
 * <p>
 * This class demonstrates how you can use the file system as a database to
 * store your data.
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

	private ListOfClasses classMajorTool = new ListOfClasses();

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
	public void uploadMap() {
		AWSCredentials credentials = new ProfileCredentialsProvider("default").getCredentials();
		AmazonS3 s3c = new AmazonS3Client(credentials);
		File temp = ResourceResolver.getUserFile();
		s3c.putObject("cs480usermap", "user-map.json", temp);

	}

	/**
	 * Still working on the downloadMap because the object that is downloaded
	 * comes as a s3object and not a File
	 */

	@Override
	public void downloadMap() {
		AWSCredentials credentials = new ProfileCredentialsProvider("default").getCredentials();
		AmazonS3 s3c = new AmazonS3Client(credentials);
		S3Object temp = s3c.getObject("cs480usermap", "user-map.json");
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

	@Override
	public List<User> getUsersById(String userId) {
		List<User> result = new ArrayList<User>();
		result.add(getUser(userId));
		return result;
	}


	public void message(String senderID, String recipientID, String msg) {
		User send = getUser(senderID);
		User receive = getUser(recipientID);
		send.writeMail(receive, msg + "\n -" + send.getFirstName() + " " + send.getLastName());
		updateUser(send);
		updateUser(receive);
	}

	public List<User> searchByLastName(String name) {
		ArrayList<User> listOfUsers = new ArrayList<User>(getUserMap().values());
		ArrayList<User> searchedUsers = new ArrayList<User>();
		for (User user : listOfUsers) {
			if ((user.getLastName().contains(name))) {
				searchedUsers.add(user);
			}
		}
		return searchedUsers;
	}

	public List<User> searchByFirstName(String name) {
		ArrayList<User> listOfUsers = new ArrayList<User>(getUserMap().values());
		ArrayList<User> searchedUsers = new ArrayList<User>();
		for (User user : listOfUsers) {
			if ((user.getFirstName().contains(name))) {
				searchedUsers.add(user);
			}
		}
		return searchedUsers;
	}

	public List<User> searchByMajor(String major) {
		ArrayList<User> listOfUsers = new ArrayList<User>(getUserMap().values());
		ArrayList<User> searchedUsers = new ArrayList<User>();
		for (User user : listOfUsers) {
			if ((major.equals(user.getMajor()))) {
				searchedUsers.add(user);
			}
		}
		return searchedUsers;
	}
	@Override
	public List<Group> getGroups(String userID){
		List<String> s = getUser(userID).getGroups();
		ArrayList<Group> g = new ArrayList<Group>();
		for(int i = 0; i < s.size(); i++){
			g.add(getGroup(s.get(i)));
		}
		
		return g;
	}

	public List<User> searchByCourse(String course) {
		ArrayList<User> listOfUsers = new ArrayList<User>(getUserMap().values());
		ArrayList<User> searchedUsers = new ArrayList<User>();

		for (User user : listOfUsers) {

			if (user.getClasses().contains(course)) {
				searchedUsers.add(user);
			}
		}

		return searchedUsers;
	}

	/**public List<User> searchByCommonCourses(String userID) {
		User currentUser = getUser(userID);
		ArrayList<User> listOfUsers = new ArrayList<User>(getUserMap().values());
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
	}*/

	public ArrayList<String> getMajors() {
		return classMajorTool.getMajors();
	}

	/**
	 * this method will only work if you pass it the 3 character or 2 character
	 * abbreviation of the major. it also only takes caps
	 */

	public ArrayList<String> getClassOfMajor(String maj) {
		return classMajorTool.getClassByMajor(maj);
	}

	public ArrayList<String> getAllClasses() {
		return classMajorTool.getAllClasses();
	}

	public ArrayList<Boolean> getAvailabilityForDay(String userID, int day) {
		return getUser(userID).getTimesForDay(day);
	}

	public void flipAvailibility(String userID, int day, double time) {
		getUser(userID).flipTime(day, time);
	}

	public ArrayList<Boolean> matchingDays(String user1ID, String user2ID, int day) {
		return getUser(user1ID).matchingDays(getUser(user2ID), day);
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void persistGroupMap(GroupMap groupMap) {
		try {
			// convert the user object to JSON format
			JSON.writeValue(ResourceResolver.getGroupFile(), groupMap);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private GroupMap getGroupMap() {
		GroupMap groupMap = null;
		File groupFile = ResourceResolver.getGroupFile();
		if (groupFile.exists()) {
			// read the file and convert the JSON content
			// to the UserMap object
			try {
				groupMap = JSON.readValue(groupFile, GroupMap.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			groupMap = new GroupMap();
		}
		return groupMap;
	}
	
	public boolean createGroup(String group, User owner){
		
		if(getGroupMap().containsKey(group)){
			return false;
		}
		
		Group addGroup = new Group(group, owner);
		owner.joinGroup(group);
		updateUser(owner);
		updateGroup(addGroup);
		return true;
	}

	@Override
	public void updateGroup(Group group) {
		GroupMap groupMap = getGroupMap();
		groupMap.put(group.getGroupName(), group);
		persistGroupMap(groupMap);
	}

	@Override
	public void deleteGroup(String groupId) {
		GroupMap groupMap = getGroupMap();
		groupMap.remove(groupId);
		persistGroupMap(groupMap);
	}

	@Override
	public List<Group> listAllGroups() {
		GroupMap groupMap = getGroupMap();
		return new ArrayList<Group>(groupMap.values());
	}
	/**@Override
	public List<User> searchByGroupIDForUsers(String groupID) {
		ArrayList<User> searchedUsers = new ArrayList<User>();
		Group result = getGroupMap().get(groupID);

		if (result != null) {
			searchedUsers.add(result.getOwner());
			HashSet<User> adminsSet = result.getAdminSet();
			HashSet<User> membersSet = result.getMembersSet();

			for (User user : adminsSet) {
				searchedUsers.add(user);
			}

			for (User user : membersSet) {
				searchedUsers.add(user);
			}
		}
		return searchedUsers;
	}*/
	@Override
	public List<Group> searchByGroupName(String groupName) {
		ArrayList<Group> listOfGroups = new ArrayList<Group>(getGroupMap().values());
		ArrayList<Group> searchedGroups = new ArrayList<Group>();

		for (Group group : listOfGroups) {
			if (group.getGroupName().contains(groupName)) {
				searchedGroups.add(group);
			}
		}

		return searchedGroups;
	}
	
	/**public ArrayList<Group> searchByGroupID(String groupID) {
		ArrayList<Group> searchedGroups = new ArrayList<Group>();
		if (getGroupMap().containsKey(groupID)) {
			searchedGroups.add(getGroupMap().get(groupID));
		}
		return searchedGroups;
	}*/
	
	@Override
	public Group getGroup(String groupId) {
		GroupMap groupMap = getGroupMap();
		return groupMap.get(groupId);
	}
	
	@Override
	public boolean addMember(String ownerID, String newMemberID, String groupID){
		User owner = getUser(ownerID);
		User newMem = getUser(newMemberID);
		Group g = getGroup(groupID);
		
		if(!g.getOwner().equals(ownerID)){
			return false;
		}
		
		g.addMember(newMem);
		newMem.joinGroup(groupID);
		
		updateUser(newMem);
		updateGroup(g);
		
		return true;
	}
	@Override
	public boolean removeMember(String ownerID, String memberID, String groupID){
		User owner = getUser(ownerID);
		User member = getUser(memberID);
		Group g = getGroup(groupID);
		if(!g.getOwner().equals(ownerID)){
			return false;
		}
		
		g.deleteMember(member);
		member.leaveGroup(groupID);
		
		updateUser(member);
		updateGroup(g);
		
		return true;
	}
	@Override
	public void leaveGroup(String userID, String groupID){
		User u = getUser(userID);
		Group g = getGroup(groupID);
		u.leaveGroup(userID);
		g.deleteMember(u);
		
		updateUser(u);
		updateGroup(g);
	}
	
	
	@Override
	public void groupMessage(String userID, String groupID, String msg) {
		Group g = getGroup(groupID);
		User u = getUser(userID);
		Message m = new Message(userID, groupID, msg + "\n -" + u.getFirstName() + " " + u.getLastName());
		
		if(g.sendMail(m)){
			ArrayList<String> members = g.getMembers();
			
			for(int i = 0; i < members.size(); i++){
				User tempU = getUser(members.get(i));
				tempU.sendMail(m);
				updateUser(tempU);
			}
			
		}
		updateGroup(g);
		
	}
/**
	@Override
	public void deleteMember(String groupID, String deleter, String deletee) {
		getGroup(groupID).deleteMember(getUser(deleter), getUser(deletee));
	}
	@Override
	public void addMember(String groupID, String adder, String addee) {
		getGroup(groupID).addMember(getUser(adder), getUser(addee));
	}

	@Override
	public void addAdmin(String groupID, String adder, String addee) {
		getGroup(groupID).addAdministrator(getUser(adder), getUser(addee));
	}
	@Override
	public void removeAdmin(String groupID, String deleter, String deletee){
		getGroup(groupID).removeAdministrator(getUser(deleter), getUser(deletee));
	}
	
	@Override
	public void setOwner(String groupID, String oldOwner, String newOwner){
		getGroup(groupID).setOwner(getUser(oldOwner), getUser(newOwner));
	}
	*/
}
