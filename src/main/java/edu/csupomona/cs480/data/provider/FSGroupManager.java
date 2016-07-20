package edu.csupomona.cs480.data.provider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.csupomona.cs480.data.Group;
import edu.csupomona.cs480.data.GroupMap;
import edu.csupomona.cs480.data.User;
import edu.csupomona.cs480.util.ResourceResolver;

public class FSGroupManager implements GroupManager {

	private static final ObjectMapper JSON = new ObjectMapper();	

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

	@Override
	public void updateGroup(Group group) {
		GroupMap groupMap = getGroupMap();
		groupMap.put(group.getGroupID(), group);
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
	}

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

	public ArrayList<Group> searchByGroupID(String groupID) {
		ArrayList<Group> searchedGroups = new ArrayList<Group>();
		if (getGroupMap().containsKey(groupID)) {
			searchedGroups.add(getGroupMap().get(groupID));
		}
		return searchedGroups;
	}

	@Override
	public Group getGroup(String groupId) {
		GroupMap groupMap = getGroupMap();
		return groupMap.get(groupId);
	}
}
