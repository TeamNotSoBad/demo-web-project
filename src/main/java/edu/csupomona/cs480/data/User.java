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

	private HashMap<String, ArrayList> mail;

	private HashMap<String, ArrayList> sent;

	public User() {
		friends = new HashMap<String, String>();
		blackList = new HashMap<String, String>();
		mail = new HashMap<String, ArrayList>();
		sent = new HashMap<String, ArrayList>();
	}

	public User(String id, String name, String major) {
		friends = new HashMap<String, String>();
		blackList = new HashMap<String, String>();
		mail = new HashMap<String, ArrayList>();
		sent = new HashMap<String, ArrayList>();
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

		if (!mail.containsKey(id)) {
			ArrayList<Message> chatLog = new ArrayList<Message>();
			chatLog.add(msg);
			mail.put(id, chatLog);
		} else {
			mail.get(id).add(msg);
		}

		return true;
	}

	public boolean sendMail(Message msg) {
		if (blackList.containsKey(msg.getId())) {
			return false;
		}
		if (!mail.containsKey(msg.getId())) {
			ArrayList<Message> chatLog = new ArrayList<Message>();
			chatLog.add(msg);
			mail.put(msg.getId(), chatLog);
		} else {
			mail.get(msg.getId()).add(msg);
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

		if (!sent.containsKey(recipient.id)) {
			ArrayList<Message> chatLog = new ArrayList<Message>();
			chatLog.add(msg);
			sent.put(recipient.id, chatLog);
		} else {
			sent.get(recipient.id).add(msg);
		}

		return true;
	}

	public boolean writeMail(User recipient, Message msg) {
		if (recipient.blackList.containsKey(id)) {
			return false;
		}
		recipient.sendMail(msg);

		if (!sent.containsKey(recipient.id)) {
			ArrayList<Message> chatLog = new ArrayList<Message>();
			chatLog.add(msg);
			sent.put(recipient.id, chatLog);
		} else {
			sent.get(recipient.id).add(msg);
		}

		return true;
	}

	public ArrayList conversation(String id) {
		ArrayList<Message> conversation = new ArrayList<Message>();
		ArrayList<Message> outgoing = new ArrayList<Message>();
		ArrayList<Message> incoming = new ArrayList<Message>();
		Message[] conv = new Message[1];
		if (sent.containsKey(id)) {
			conversation.addAll(sent.get(id));
		}
		if (mail.containsKey(id)) {
			conversation.addAll(mail.get(id));
		}
		conv = conversation.toArray(conv);
		Arrays.sort(conv);
		return conversation;
	}
}
