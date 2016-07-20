package edu.csupomona.cs480.data.provider;

import edu.csupomona.cs480.data.Group;
import edu.csupomona.cs480.data.User;

import java.util.List;

public interface GroupManager {

	public Group getGroup(String groupId);
	
	public void updateGroup(Group group);
	
	public void deleteGroup(String userId);

	public List<Group> listAllGroups();
	
	public List<Group> searchByGroupID(String groupID);
	
	public List<Group> searchByGroupName(String groupName);
	
	public List<User> searchByGroupIDForUsers(String groupID);
}