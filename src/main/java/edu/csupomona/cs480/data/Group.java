package edu.csupomona.cs480.data;

import java.util.ArrayList;
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
 * Admins: These users may add/remove existing and applicant members. May also post updates.
 * Owner: This unique user may add/remove anyone in the group. This user may transfer ownership of the
 * group to another user. 
 * @author HH
 *
 */
public class Group {

	private String groupID;
	private String groupName;
	private User groupOwner;
	private HashSet<User> admins;
	private HashSet<User> members;
	private String creationTime;
	private boolean isMarkedForDeletion = false;
	
	public Group(String name, String groupUniqueID, User owner) {
		groupName = name;
		groupID = groupUniqueID;
		groupOwner = owner;
		admins = new HashSet<User>();
		members = new HashSet<User>();
		creationTime = new Date(System.currentTimeMillis()).toString();
	}
	
	public String getGroupID() {
		return groupID;
	}
	
	/**
	 * All members, admins, group owner, and the sender themselves will recieve the message.
	 * @param userID
	 * @param msg
	 */
	public void sendGroupMessage(String userID, String msg){
		ArrayList<User> groupMembers = new ArrayList<User> (members);
		groupMembers.addAll(getAdminSet());
		groupMembers.add(groupOwner);
		
		for(User groupMember: groupMembers){
			groupMember.sendMail(groupID, msg + "\n -" + userID);
		}
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
	
	public User getOwner() {
		return groupOwner;
	}
	
	/**
	 * If a new ownerID is to be set, remove the current owner then make them an admin.
	 * @param ownerID
	 * @return
	 */
	public boolean setOwner(User owner) {
		if(!owner.equals(groupOwner)) {
			User tempUser = groupOwner;
			groupOwner = null;
			addMember(tempUser);
			addAdministrator(tempUser);
			removeAdministrator(owner);
			removeMember(owner);
			groupOwner = owner;
			return true;
		} else {
			return false;
		}
	}
	
	public HashSet<User> getAdminSet() {
		return admins;
	}
	
	/**
	 * This method strips a member of their admin status.
	 * The user is then placed into the member set.
	 * @param user
	 */
	public boolean removeAdministrator(User user) {
		if (admins.contains(user)) {
			admins.remove(user);
			return members.add(user);
		} else {
			return false;
		}
	}
	
	/**
	 * To add a new admin, the user must already exist in the member set.
	 * The user must also not be the group owner.
	 */
	public boolean addAdministrator(User user) {
		if (members.contains(user) && !groupOwner.equals(user)) {
			members.remove(user);
			return admins.add(user);
		} else {
			return false;
		}
	}
	
	public HashSet<User> getMembersSet() {
		return members;
	}
	
	/**
	 * This method removes only users from the member set. Higher level users
	 * must be striped of status first. The user who is removed must also
	 * remove this group's information from their profile.
	 * @param id
	 */
	public boolean removeMember(User user) {
		if (members.remove(user) == true) {
			user.leaveGroup(groupID);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * A user may not be added to the member set if already in a higher level set.
	 * A toggle on the MarkedForDeletion is made to ensure the first time a member
	 * is added, a true flag will be set back to false.
	 * @param user
	 * @return
	 */
	public boolean addMember(User user) {
		if (groupOwner.equals(user) || admins.contains(user)) {
			return false;
		} else {
			if (members.add(user) == true) {
				user.joinGroup(groupID);
				toggleMarkedForDeletion();
				return true;
			} else {
				return false;
			}
		}
	}

	public String getCreationTime() {
		return creationTime;
	}

	public boolean isMarkedForDeletion() {
		return isMarkedForDeletion;
	}

	/**
	 * If group contains 0 members, 0 admins, 1 owner, Allow toggle to false/true.
	 * If group contains at least 1 member or 1 admin, Allow toggle to false.
	 * @return
	 */
	public boolean toggleMarkedForDeletion() {
		if (isMarkedForDeletion == false) {
			if(getMembersSet().isEmpty() && getAdminSet().isEmpty()) {
				isMarkedForDeletion = true;
				return true;
			} else {
				return false;
			}
		} else {
			isMarkedForDeletion = false;
			return true;
		}
	}
}