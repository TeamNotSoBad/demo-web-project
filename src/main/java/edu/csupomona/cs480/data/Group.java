package edu.csupomona.cs480.data;

import java.util.Date;
import java.util.HashSet;

public class Group {

	private String groupID;
	private String groupName;
	private String groupOwnerID;
	private HashSet<String> administratorsID;
	private HashSet<String> membersID;
	private String creationTime;
	
	public Group(String name, String ownerID) {
		groupName = name;
		this.groupOwnerID = ownerID;
		administratorsID = new HashSet<String>();
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
	
	public HashSet<String> getAdministratorsID() {
		return administratorsID;
	}
	
	public void removeAdministrator(String id) {
		administratorsID.remove(id);
	}
	
	public void addAdministrator(String id) {
		administratorsID.add(id);
	}
	
	public HashSet<String> getMembersID() {
		return membersID;
	}
	
	public void removeMember(String id) {
		membersID.remove(id);
	}
	
	public void addMember(String id) {
		membersID.add(id);
	}

	public String getCreationTime() {
		return creationTime;
	}
}