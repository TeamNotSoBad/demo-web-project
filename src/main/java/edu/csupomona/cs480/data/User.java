package edu.csupomona.cs480.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.HashMap;

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
    
    private HashSet<String> courses;
    
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
	private String id;
	/** The unique user Id */
	private String name;
	/** The unique user Id */
	private String major;
	/** The timestamp when the user is being created */
	private String creationTime = new Date(System.currentTimeMillis()).toString();

	private HashMap friends;
	private HashMap blackList;
	private ArrayList mail;
	private ArrayList sent;

	public User() {
		friends = new HashMap<String, String>();
		blackList = new HashMap<String, String>();
		mail = new ArrayList<Message>();
		sent = new ArrayList<Message>();
	}

	public User(String id, String name, String major) {
		friends = new HashMap<String, String>();
		blackList = new HashMap<String, String>();
		mail = new ArrayList<Message>();
		sent = new ArrayList<Message>();
		this.id = id;
		this.name = name;
		this.major = major;
	}

	public void addFriend(String id) {
		friends.put(id, id);
	}

	public void removeFriend(String id) {
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

	public void setName(String name) {
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
	
	public HashSet<String> getCourses() {
		return courses;
	}

	public void setCourses(HashSet<String> courses) {
		this.courses = courses;
	}
	
	/**
	 *  this method will be used to write mail to this instance of user
	 */
	public boolean sendMail(String id, String message){
		if(blackList.containsKey(id)){
			return false;
		}
		
		Message msg = new Message(id, message);
		mail.add(msg);
		
		return true;
	}
	
	public boolean writeMail(User recipient, String message){
		if(recipient.blackList.containsKey(id)){
			return false;
		}
		
		Message msg = new Message(id, message);
		recipient.mail.add(msg);
		sent.add(msg);
		
		return true;
	}
}
