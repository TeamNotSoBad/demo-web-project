package edu.csupomona.cs480.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

/**
 * The Group class holds the IDs of its members. Groups can be accessed from the
 * GroupMap class. Groups must be made with a name, ownerID, and unique groupID.
 * This data structure allows members to be separated into the subgroups: owner,
 * admins, and members.
 * <p>
 * Note that groupIDs are unique and should only be changed from the groupMap
 * object.
 * <p>
 * There can only be one owner of the group. Another note is that the owner,
 * member set, and admin set do not intersect. There must be an owner at all
 * times.
 * <p>
 * This data structure follows a hierarchy of command. Intended use for the 3
 * subgroups follows. Members: The basic user that exists in the set may contact
 * and get updates from higher level users. Admins: These users may add/remove
 * existing and applicant members. May also post updates. Owner: This unique
 * user may add/remove anyone in the group. This user may transfer ownership of
 * the group to another user.
 * 
 * @author HH
 *
 */
public class Group {

	private String groupName;
	private String groupOwner;
	//private HashSet<User> admins;
	private ArrayList<String> members;
	//private String creationTime;
	//private boolean isMarkedForDeletion = false;
	private String description = "Welcome to our group page.";
	private ArrayList<Message> wall = new ArrayList<Message>();
	
	public Group(){
		groupName = "";
		groupOwner = "";
		wall = new ArrayList<Message>();
		members = new ArrayList<String>();
	}
	public Group(String name, User owner) {
		groupName = name;
		groupOwner = owner.getId();
	//	admins = new HashSet<User>();
		members = new ArrayList<String>();
		members.add(owner.getId());
		wall = new ArrayList<Message>();
		//members.add(owner);
		//creationTime = new Date(System.currentTimeMillis()).toString();
	}

	public String getGroupName() {
		return groupName;
	}

	/**
	 * All members, admins, group owner, and the sender themselves will recieve
	 * the message.
	 * 
	 * @param userID
	 * @param msg
	 */
	
	
	/**
	 * This method should only be called by the GroupMap object.
	 * 
	 * @param groupID
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	public String getOwner() {
		return groupOwner;
	}
	
	public void setOwner(String groupOwner){
		this.groupOwner = groupOwner;
	}
	public ArrayList<Message> getWall(){
		return wall;
	}
	
	public boolean sendMail(Message m){

		if(!members.contains(m.getFrom())){
			return false;
		}
		
		wall.add(m);
		
		return true;
	}
	/**
	 * If a new ownerID is to be set, remove the current owner then make them an
	 * admin.
	 * 
	 * @param ownerID
	 * @return
	 */
	/**public boolean setOwner(User owner) {
		if (!owner.equals(groupOwner)) {
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
	}*/
	/**
	public boolean setOwner(User owner, User newOwner) {
		if(owner.equals(groupOwner))
			return setOwner(newOwner);
		
		return false;
	}/

	public HashSet<User> getAdminSet() {
		return admins;
	}

	/**
	 * This method strips a member of their admin status. The user is then
	 * placed into the member set.
	 * 
	 * @param user
	 */
	/**public boolean removeAdministrator(User user) {
		if (admins.contains(user)) {
			admins.remove(user);
			return members.add(user.getId());
		}
		return false;

	}*/

	/**public boolean removeAdministrator(User deleter, User deletee) {
		if (deleter.equals(groupOwner)) {
			return removeAdministrator(deletee);
		}
		return false;
	}*/

	/**
	 * To add a new admin, the user must already exist in the member set. The
	 * user must also not be the group owner.
	 */

	/**public boolean addAdministrator(User user) {
		if (members.contains(user) && !groupOwner.equals(user)) {
			members.remove(user);
			return admins.add(user);
		} else {
			return false;
		}
	}*/

	/**public boolean addAdministrator(User adder, User addee) {
		if (addee.equals(groupOwner))
			return addAdministrator(addee);

		return false;
	}*/

	public ArrayList<String> getMembers() {
		return members;
	}
	

	public void addMember(User member){
		members.add(member.getId());
	}
	
	public void deleteMember(User member){
		members.remove(member.getId());
	}
	public void addMembers(String member){
		members.add(member);
	}

	/**
	 * This method removes only users from the member set. Higher level users
	 * must be striped of status first. The user who is removed must also remove
	 * this group's information from their profile.
	 * 
	 * @param id
	 */
	/**public boolean removeMember(User user) {
		if (members.remove(user) == true) {
			user.leaveGroup(groupName);
			return true;
		} else {
			return false;
		}
	}*/

	/**public boolean deleteMember(User deleter, User deletee) {
		if (admins.contains(deleter) || deleter.equals(groupOwner)) {
			return removeMember(deletee);
		} else {
			return false;
		}
	}*/

	/**
	 * A user may not be added to the member set if already in a higher level
	 * set. A toggle on the MarkedForDeletion is made to ensure the first time a
	 * member is added, a true flag will be set back to false.
	 * 
	 * @param user
	 * @return
	 */
	/**public boolean addMember(User user) {
		if (groupOwner.equals(user) || admins.contains(user)) {
			return false;
		} else {
			if (members.add(user.getId()) == true) {
				user.joinGroup(groupName);
				//toggleMarkedForDeletion();
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean addMember(User adder, User addee) {
		if (adder.equals(groupOwner) || admins.contains(adder)) {
			return addMember(addee);
		}
		return false;
	}

	/**public String getCreationTime() {
		return creationTime;
	}*/

	/**public boolean isMarkedForDeletion() {
		return isMarkedForDeletion;
	}*/

	/**
	 * If group contains 0 members, 0 admins, 1 owner, Allow toggle to
	 * false/true. If group contains at least 1 member or 1 admin, Allow toggle
	 * to false.
	 * 
	 * @return
	 */
	/**public boolean toggleMarkedForDeletion() {
		if (isMarkedForDeletion == false) {
			if (getMembersSet().isEmpty() && getAdminSet().isEmpty()) {
				isMarkedForDeletion = true;
				return true;
			} else {
				return false;
			}
		} else {
			isMarkedForDeletion = false;
			return true;
		}
	}*/
	/**
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}*/
}