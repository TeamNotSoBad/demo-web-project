package edu.csupomona.cs480.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;


/**
 * The basic user object.
 */
public class User {

	/** The unique user Id */
    private String id;
    /** The unique user Id */
    private String name;
    /** The unique user Id */
    private String major;
    /** The timestamp when the user is being created */
    private String creationTime = new Date(System.currentTimeMillis()).toString();
    
    private TreeMap friends;
    
    public User(){
    }
    
    public User(String id, String name, String major){
    	friends = new TreeMap <String,String>();
    	this.id = id;
    	this.name = name;
    	this.major = major;
    }
    public void addFriend(String id){
    	friends.put(id, id);
    }
    public void removeFriend(String id){
    	friends.remove(id, id);
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
}
