package edu.csupomona.cs480.data;

import java.util.HashMap;

/**
 * The groupMap class holds all mappings to groups in the data base.
 * Individual groups can be found and the instances of its members. No two groups
 * may have the same groupID.
 * @author HH
 *
 */
@SuppressWarnings("serial")
public class GroupMap extends HashMap<String, Group> {
	
	/**
	 * Overrides the HashMap put() method to restrict keys to be unique.
	 * Otherwise, the group will not be added and a null value will be returned.
	 */

	
	/**
	 * Only allow the removal of an existing group if it is marked for deletion.
	 * To mark for deletion, the group must only consist of the owner and the owner
	 * must toggle the mark for deletion to be true.
	 * @param groupID
	 * @return
	 */
	/**public Group remove(String groupID) {
		if (containsKey(groupID) == true) {
			Group group = get(groupID);
			if (group.isMarkedForDeletion() == true) {
				String owner = group.getOwner();
				//group.setOwner(null);
				//group.removeAdministrator(owner);
				//group.removeMember(owner);
				return super.remove(groupID);
			}
		}
		return null;
	}/
	
	/**
	 * Changing the groupID should be done in this class only.
	 * @param oldGroupID
	 * @param newGroupID
	 * @return
	 */
	public boolean changeGroupName(String oldGroupName, String newGroupName) {
		if (containsKey(oldGroupName) == true) {
			Group temp = get(oldGroupName);
			temp.setGroupName(newGroupName);
			remove(oldGroupName);
			put(newGroupName, temp);
			return true;
		} else {
			return false;
		}
	}
	
}
