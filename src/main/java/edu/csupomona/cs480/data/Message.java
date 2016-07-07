package edu.csupomona.cs480.data;

import java.util.Date;

public class Message{
	private String id;
	private String message;
	private Date time;
	
	Message(String id, String message){
		this.id = id;
		this.message = message;
		time = new Date();
	}
	
	String getId(){
		return id;
	}
	String getMsg(){
		return message;
	}
	Date getTime(){
		return time;
	}
}