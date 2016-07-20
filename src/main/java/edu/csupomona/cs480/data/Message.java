package edu.csupomona.cs480.data;

import java.util.Date;

public class Message{
	private String from;
	private String to;
	
	private String message;
	
	private String time;
	
	public Message(String from, String to, String message){
		this.from = from;
		this.to = to;
		this.message = message;
		time = new Date().toString();
	}
	
	public String getFrom(){
		return from;
	}
	
	public String getTo(){
		return to;
	}
	
	public String getMsg(){
		return message;
	}
	
	public String getTime(){
		return time;
	}
	
	public String time(){
		return time.toString();
	}
	
	public String toString(){
		String s = "From: " + from + "To: " + to + "\n";
		s += message + "\n";
		s += time;
		return s;
	}
}