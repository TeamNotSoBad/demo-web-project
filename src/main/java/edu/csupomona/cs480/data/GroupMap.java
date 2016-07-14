package edu.csupomona.cs480.data;

import java.util.HashMap;

/**
 * The groupMap class holds all mappings to groups in the data base.
 * Individual groups can be found and the IDs of its members. No two groups
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
	public Group put(String groupID, Group newGroup) {
		if (containsKey(groupID) != true) {
			super.put(groupID, newGroup);
			return newGroup;
		} else {
			return null;
		}
	}
	
	/**
	 * Changing the groupID should be done in this class only.
	 * @param oldGroupID
	 * @param newGroupID
	 * @return
	 */
	public boolean changeGroupID(String oldGroupID, String newGroupID) {
		if (containsKey(oldGroupID) == true) {
			Group temp = get(oldGroupID);
			temp.setGroupID(newGroupID);
			remove(oldGroupID);
			put(newGroupID, temp);
			return true;
		} else {
			return false;
		}
	}
	
}
