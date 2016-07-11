package edu.csupomona.cs480.data;

import java.util.ArrayList;
import java.util.Arrays;
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

	private String password;

	private HashSet<String> courses;

	private HashMap friends;

	private HashMap blackList;

	private HashMap<String, ArrayList> conversation;



	public User() {
		friends = new HashMap<String, String>();
		blackList = new HashMap<String, String>();
		conversation = new HashMap<String, ArrayList>();
		
	}

	public User(String id, String name, String major) {
		friends = new HashMap<String, String>();
		blackList = new HashMap<String, String>();
		conversation = new HashMap<String, ArrayList>();
	
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

	public String getPassword() {
		return password;
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
	public boolean sendMail(String id, String messageBody) {
		if (blackList.containsKey(id)) {
			return false;
		}

		Message msg = new Message(id, messageBody);

		if (!conversation.containsKey(id)) {
			ArrayList<Message> chatLog = new ArrayList<Message>();
			chatLog.add(msg);
			conversation.put(id, chatLog);
		} else {
			conversation.get(id).add(msg);
		}

		return true;
	}

	public boolean sendMail(Message msg) {
		if (blackList.containsKey(msg.getId())) {
			return false;
		}
		if (!conversation.containsKey(msg.getId())) {
			ArrayList<Message> chatLog = new ArrayList<Message>();
			chatLog.add(msg);
			conversation.put(msg.getId(), chatLog);
		} else {
			conversation.get(msg.getId()).add(msg);
		}
		return true;
	}

	/**
	 * This instance of user will send mail to an instance of another user.
	 */
	public boolean writeMail(User recipient, String messageBody) {
		if (recipient.blackList.containsKey(id)) {
			return false;
		}

		Message msg = new Message(id, messageBody);
		recipient.sendMail(msg);

		if (!conversation.containsKey(recipient.id)) {
			ArrayList<Message> chatLog = new ArrayList<Message>();
			chatLog.add(msg);
			conversation.put(recipient.id, chatLog);
		} else {
			conversation.get(recipient.id).add(msg);
		}

		return true;
	}

	public boolean writeMail(User recipient, Message msg) {
		if (recipient.blackList.containsKey(id)) {
			return false;
		}
		recipient.sendMail(msg);

		if (!conversation.containsKey(recipient.id)) {
			ArrayList<Message> chatLog = new ArrayList<Message>();
			chatLog.add(msg);
			conversation.put(recipient.id, chatLog);
		} else {
			conversation.get(recipient.id).add(msg);
		}

		return true;
	}

	public ArrayList <Message> conversation(String id) {
		if(conversation.containsKey(id)){
			return conversation.get(id);
		}
		else{
			return new ArrayList<Message>();
		}
		
	}
}
