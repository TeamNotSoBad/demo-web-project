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

		User user1 = new User("1337", "Mark", "Ilog", "CS");
		User user2 = new User("9166", "Geoff", "Kilma", "Math");
		User user3 = new User("2912", "Tom", "Tomm", "ME");
		User user4 = new User("2132", "Lina", "Leon", "PH");

		usermanager.updateUser(user1);
		usermanager.updateUser(user2);
		usermanager.updateUser(user3);
		usermanager.updateUser(user4);

		assertEquals(usermanager.getUser("1337").getId(), user1.getId());
		assertEquals(usermanager.getUser("9166").getId(), user2.getId());
		assertEquals(usermanager.getUser("2912").getId(), user3.getId());
		assertEquals(usermanager.getUser("2132").getId(), user4.getId());


	}

}
