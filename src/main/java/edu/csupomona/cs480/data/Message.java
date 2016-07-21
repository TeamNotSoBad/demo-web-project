package edu.csupomona.cs480.data;

import java.util.Date;

public class Message{
	
	private String from;
	
	private String to;
	
	private String message;
	
	private String time;
	
	public Message(){
		from = "";
		to = "";
		message = "";
		time = new Date().toString();
	}
	public Message(String from, String to, String message){
		this.from = from;
		this.to = to;
		this.message = message;
		time = new Date().toString();
	}
	public void setFrom(String from){
		this.from = from;
	}
	
	public void setTo(String to){
		this.to = to;
	}
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public void setTime(String time){
		this.time = time;
	}
	public String getFrom(){
		return from;
	}
	
	public String getTo(){
		return to;
	}
	
	public String getMessage(){
		return message;
	}
	
	public String getTime(){
		return time;
	}
	
	public String toString(){
		String s = "From: " + from + " To: " + to + "\n";
		s += message + "\n";
		s += time;
		return s;
	}
}