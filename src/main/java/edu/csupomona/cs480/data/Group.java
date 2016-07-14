package edu.csupomona.cs480.data;

import java.util.Date;
import java.util.HashSet;

/**
 * The Group class holds the IDs of its members. Groups can be accessed
 * from the GroupMap class. Groups must be made with a name, ownerID, and unique groupID.
 * This data structure allows members to be separated into the subgroups: owner, admins, and members.
 * Note that the members set can also contain administrators.
 * @author HH
 *
 */
public class Group {

	private String groupID;
	private String groupName;
	private String groupOwnerID;
	private HashSet<String> adminsID;
	private HashSet<String> membersID;
	private String creationTime;
	
	public Group(String name, String groupID, String ownerID) {
		groupName = name;
		groupOwnerID = ownerID;
		adminsID = new HashSet<String>();
		membersID = new HashSet<String>();
		creationTime = new Date(System.currentTimeMillis()).toString();
	}
	
	public String getGroupID() {
		return groupID;
	}
	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getOwnerID() {
		return groupOwnerID;
	}
	public void setOwnerID(String ownerID) {
		this.groupOwnerID = ownerID;
	}
	
	public HashSet<String> getAdminSet() {
		return adminsID;
	}
	
	/**
	 * This method strips a member of their admin status. To remove from group, use removeMember().
	 * @param id
	 */
	public void removeAdministrator(String id) {
		adminsID.remove(id);
	}
	
	/**
	 * To add a new admin, the userID must already be a member of this group.
	 */
	public boolean addAdministrator(String id) {
		if (membersID.contains(id)) {
			adminsID.add(id);
			return true;
		} else {
			return false;
		}
	}
	
	public HashSet<String> getMembersID() {
		return membersID;
	}
	
	/**
	 * This method cannot remove a member who is at the same time an admin.
	 * Must strip admin privileges first. If attempting to remove a nonexisting member,
	 * the method will still return true as the id is no longer in the set.
	 * @param id
	 */
	public boolean removeMember(String id) {
		if (adminsID.contains(id)) {
			return false;
		} else {
			membersID.remove(id);
			return true;
		}
	}
	
	public void addMember(String id) {
		membersID.add(id);
	}

	public String getCreationTime() {
		return creationTime;
	}
}