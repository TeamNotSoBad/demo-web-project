package edu.csupomona.cs480;

import org.junit.BeforeClass;
import junit.*;
import junit.framework.TestCase;

import edu.csupomona.cs480.data.provider.FSUserManager;
import edu.csupomona.cs480.data.User;


/**
 * 
 * @author mark
 * A6
 * 
 * This is a test case to see if the manager methods for the users
 * work properly.
 * 
 */
public class ManagerTest extends TestCase{


	public void testManager() {

		FSUserManager usermanager = new FSUserManager();

		User user1 = new User("1337", "Mark", "firstName", "CS");
		User user2 = new User("9166", "Geoff", "firstName", "Math");
		User user3 = new User("2912", "Tom", "firstName", "ME");
		User user4 = new User("2132", "Lina", "firstName", "PH");

		usermanager.updateUser(user1);
		usermanager.updateUser(user2);
		usermanager.updateUser(user3);
		usermanager.updateUser(user4);

		assertEquals(usermanager.getUser("Mark"), user1);
		assertEquals(usermanager.getUser("Geoff"), user2);
		assertEquals(usermanager.getUser("Tom"), user3);
		assertEquals(usermanager.getUser("Lina"), user4);


	}

}
