package edu.csupomona.cs480;

import org.junit.BeforeClass;
import junit.*;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.ArrayList;

import edu.csupomona.cs480.data.Message;
import edu.csupomona.cs480.data.User;


/**
 * 
 * @author kevin
 * A6
 * 
 * This was a test case to see if the messaging methods from the users
 * work properly.
 * 
 */
public class MessageTest extends TestCase{
	User user1;
	User user2;

	public void testMessage() throws IOException {

		user1 = new User("user1", "bob", "bom", "cs");
		user2 = new User("user2", "ricky", "rock", "math");

		String messageBody1 = "What is your name?";
		String messageBody2 = "bob";
		user1.sendMail(user2.getId(), messageBody1);
		user1.writeMail(user2, messageBody2);
		ArrayList<Message> conversation = user1.conversation(user2.getId());

		assertEquals(conversation.remove(0).getMsg(), messageBody1);
	}

}
