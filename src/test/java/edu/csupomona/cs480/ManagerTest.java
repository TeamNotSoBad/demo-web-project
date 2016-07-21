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
		
		usermanager.createGroup("g1", user1);
		
		usermanager.addMember(user1.getId(), user2.getId(), "g1");
		usermanager.groupMessage(user1.getId(), "g1", "test");
		System.out.println(usermanager.getGroup("g1").getMembers().size());
		assertEquals(usermanager.getGroup("g1").getWall().get(0).getMessage(), "test\n -Ilog Mark");


	}

}
