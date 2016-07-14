package edu.csupomona.cs480.data;

import java.util.Date;
import java.util.HashSet;

/**
 * The Group class holds the IDs of its members. Groups can be accessed
 * from the GroupMap class. Groups must be made with a name, ownerID, and unique groupID.
 * This data structure allows members to be separated into the subgroups: owner, admins, and members.
 * <p>
 * Note that groupIDs are unique and should only be changed from the groupMap object.
 * <p>
 * There can only be one owner of the group.
 * Another note is that the owner, member set, and admin set do not intersect.
 * There must be an owner at all times.
 * <p>
 * This data structure follows a hierarchy of command.
 * Intended use for the 3 subgroups follows.
 * Members: The basic user that exists in the set may contact and get updates from higher level users.
 * Admins: These users may add/remove existing and applicant members. May also post udpates.
 * Owner: This unique user may add/remove anyone in the group. This user may transfer ownership of the
 * group to another user. 
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
	
	/**
	 * This method should only be called by the GroupMap object.
	 * @param groupID
	 */
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
	
	/**
	 * If a new ownerID is to be set, remove the current owner then make them an admin.
	 * @param ownerID
	 * @return
	 */
	public boolean setOwnerID(String ownerID) {
		if(!ownerID.equals(groupOwnerID)) {
			groupOwnerID = "";
			addMember(groupID);
			addAdministrator(groupID);
			removeAdministrator(ownerID);
			removeMember(ownerID);
			groupOwnerID = ownerID;
			return true;
		} else {
			return false;
		}
	}
	
	public HashSet<String> getAdminSet() {
		return adminsID;
	}
	
	/**
	 * This method strips a member of their admin status.
	 * The user is then placed into the member set.
	 * @param id
	 */
	public boolean removeAdministrator(String id) {
		if (adminsID.contains(id)) {
			adminsID.remove(id);
			return membersID.add(id);
		} else {
			return false;
		}
	}
	
	/**
	 * To add a new admin, the userID must already exist in the member set.
	 * The user must also not be the group owner.
	 */
	public boolean addAdministrator(String id) {
		if (membersID.contains(id) && !groupOwnerID.equals(id)) {
			membersID.remove(id);
			return adminsID.add(id);
		} else {
			return false;
		}
	}
	
	public HashSet<String> getMembersSet() {
		return membersID;
	}
	
	/**
	 * This method removes only users from the member set. Higher level users
	 * must be striped of status first. The user who is removed must also
	 * remove this group's information from their profile.
	 * @param id
	 */
	public boolean removeMember(String id) {
		return membersID.remove(id);
	}
	
	/**
	 * A user may not be added to the member set if already in a higher level set.
	 * @param id
	 * @return
	 */
	public boolean addMember(String id) {
		if (groupOwnerID.equals(id) || adminsID.contains(id)) {
			return false;
		} else {
			return membersID.add(id);
		}
	}

	public String getCreationTime() {
		return creationTime;
	}
}