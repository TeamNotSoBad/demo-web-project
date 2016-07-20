package edu.csupomona.cs480.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.HashMap;

/**
 * The basic user object.
 */
public class User {

	/** The unique user Id */
	private String id;
	
	/** The unique user Id */
	private String lastName;
	
	/** The unique user Id */
	private String firstName;
	
	/** The unique user Id */
	private String major;
	
	/** The timestamp when the user is being created */
	private String creationTime = new Date(System.currentTimeMillis()).toString();

	private String password;

	private HashSet<String> groups;
	
	private HashSet<String> courses;
	private Calendar calendar = new Calendar();
	/**
	 * friends is a HashMap that 
	 */
	private HashSet<String> friends;
	/**
	 *  blackList is a HashSet that uses a user's id as it's key/value.
	 *  people on the blackList will have all messages ignored.
	 */
	
	private HashSet<String> blackList;
	
	/** 
	 * conversations stores all of the different conversations from this user to another.
	 * A conversation is a list of messages sent in chronological order
	 */
	private HashMap<String, ArrayList> conversations;
	private ArrayList<Message> wall;
	
	public User() {
		friends = new HashSet<String>();
		blackList = new HashSet<String>();
		conversations = new HashMap<String, ArrayList>();
		groups = new HashSet<String>();
		wall = new ArrayList<Message>();
	}

	
	public User(String id, String lastName, String firstName, String major) {
		friends = new HashSet<String>();
		blackList = new HashSet<String>();
		conversations = new HashMap<String, ArrayList>();
		groups = new HashSet<String>();
		wall = new ArrayList<Message>();
		
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.major = major;
	}
	public ArrayList<Message> getWall(){
		return wall;
	}
	public void addFriend(String id) {
		friends.add(id);
	}

	public void removeFriend(String id) {
		friends.remove(id);
	}
	
	public void addBlackList(String id) {
		blackList.add(id);
	}

	public void removeBlackList(String id) {
		blackList.remove(id);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getPassword() {
		return password;
	}
	
	public boolean authenticate(String password){
		return password == this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	 * this method will be used to write mail to this instance of user
	 */
	public boolean sendMail(String from, String to, String messageBody) {
		if (blackList.contains(from)) {
			return false;
		}

		Message msg = new Message(from,to, messageBody);
		wall.add(msg);
		if (!conversations.containsKey(id)) {
			ArrayList<Message> chatLog = new ArrayList<Message>();
			chatLog.add(msg);
			conversations.put(id, chatLog);
		} else {
			conversations.get(id).add(msg);
		}

		return true;
	}

	public boolean sendMail(Message msg) {
		if (blackList.contains(msg.getFrom())) {
			return false;
		}
		wall.add(msg);
		if (!conversations.containsKey(msg.getFrom())) {
			ArrayList<Message> chatLog = new ArrayList<Message>();
			chatLog.add(msg);
			conversations.put(msg.getFrom(), chatLog);
		} else {
			conversations.get(msg.getFrom()).add(msg);
		}
		return true;
	}

	/**
	 * This instance of user will send mail to an instance of another user, on this users behalf.
	 */
	public boolean writeMail(User recipient, String messageBody) {
		if (recipient.blackList.contains(id)) {
			return false;
		}

		Message msg = new Message(id, recipient.getId(), messageBody);
		
		recipient.sendMail(msg);
		wall.add(msg);
		
		if (!conversations.containsKey(recipient.id)) {
			ArrayList<Message> chatLog = new ArrayList<Message>();
			chatLog.add(msg);
			conversations.put(recipient.id, chatLog);
		} else {
			conversations.get(recipient.id).add(msg);
		}

		return true;
	}

	public boolean writeMail(User recipient, Message msg) {
		if (recipient.blackList.contains(id)) {
			return false;
		}
		
		recipient.sendMail(msg);
		wall.add(msg);
		
		if (!conversations.containsKey(recipient.id)) {
			ArrayList<Message> chatLog = new ArrayList<Message>();
			chatLog.add(msg);
			conversations.put(recipient.id, chatLog);
		} else {
			conversations.get(recipient.id).add(msg);
		}

		return true;
	}

	public ArrayList <Message> conversation(String id) {
		if(conversations.containsKey(id)){
			return conversations.get(id);
		}
		else{
			return new ArrayList<Message>();
		}
	}

	public HashSet<String> getGroups() {
		return groups;
	}

	public void joinGroup(String newGroupID) {
		groups.add(newGroupID);
	}
	
	public void leaveGroup(String newGroupID) {
		groups.remove(newGroupID);
	}
	
	public void flipTime(int day, double time){
		calendar.flipTime(day, time);
	}
	
	public ArrayList<Boolean> getTimesForDay(int day){
		return calendar.getTimesForDay(day);
	}
	
	public ArrayList<Boolean>matchingDays(User user2, int day){
		return calendar.matchingDays(day, user2.calendar);
	}
	

}
