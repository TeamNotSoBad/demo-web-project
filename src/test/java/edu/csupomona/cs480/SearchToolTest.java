package edu.csupomona.cs480;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.BeforeClass;
import org.junit.Test;

import edu.csupomona.cs480.data.GroupMap;
import edu.csupomona.cs480.data.User;
import edu.csupomona.cs480.data.UserMap;
import edu.csupomona.cs480.data.SearchTool;

public class SearchToolTest {

	private static SearchTool searchToolTester;
	private static ArrayList<User> listOfResults;
	private static ArrayList<User> listOfAllUsers = new ArrayList<User>();

	@BeforeClass
	public static void initialize() {
		UserMap userMap = new UserMap();
		GroupMap groupMap = new GroupMap();
		listOfResults = new ArrayList<User>();

		User user1 = new User("001", "kevin", "l", "Computer Science");
		User user2 = new User("002", "bob", "somename", "Computer Science");
		User user3 = new User("003", "mark", "man", "Physics");
		User user4 = new User("004", "markZero", "hi", "English");

		HashSet<String> courses1 = new HashSet<String>();
		HashSet<String> courses2 = new HashSet<String>();
		HashSet<String> courses3 = new HashSet<String>();
		HashSet<String> courses4 = new HashSet<String>();

		courses1.add("CS480");
		courses1.add("MAT370");

		courses2.add("CS480");
		courses2.add("ENG101");
		courses2.add("CS128");

		courses3.add("PHYS131");
		courses3.add("ENG101");

		courses4.add("ENG101");
		courses4.add("MU102");
		courses4.add("CS128");

		user1.setCourses(courses1);
		user2.setCourses(courses2);
		user3.setCourses(courses3);
		user4.setCourses(courses4);

		userMap.put("001", user1);
		userMap.put("002", user2);
		userMap.put("003", user3);
		userMap.put("004", user4);

		listOfAllUsers.add(user1);
		listOfAllUsers.add(user2);
		listOfAllUsers.add(user3);
		listOfAllUsers.add(user4);

		searchToolTester = new SearchTool(userMap, groupMap);
	}

	@Test
	public void testSearchByID() {
		// Test case true if not empty.
		listOfResults = searchToolTester.searchByID("001");
		if (listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
		listOfResults = searchToolTester.searchByID("002");
		if (listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
		listOfResults = searchToolTester.searchByID("003");
		if (listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
		listOfResults = searchToolTester.searchByID("004");
		if (listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
		// Fail Test Cases. Fail if list is not empty.
		listOfResults = searchToolTester.searchByID("005");
		if (!listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
		listOfResults = searchToolTester.searchByID("999");
		if (!listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
		listOfResults = searchToolTester.searchByID("ABCDE");
		if (!listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
	}

	@Test
	public void testSearchByMajor() {
		// Test case true if not empty.
		listOfResults = searchToolTester.searchByMajor("Computer Science");
		if (listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
		listOfResults = searchToolTester.searchByMajor("Physics");
		if (listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
		listOfResults = searchToolTester.searchByMajor("English");
		if (listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
		// Fail Test Cases. Fail if list is not empty.
		listOfResults = searchToolTester.searchByMajor("005");
		if (!listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
		listOfResults = searchToolTester.searchByMajor("CS999");
		if (!listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
		listOfResults = searchToolTester.searchByMajor("");
		if (!listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
	}

	@Test
	public void testSearchByName() {
		// Test case true if not empty.
		listOfResults = searchToolTester.searchByLastName("kevin");
		if (listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
		listOfResults = searchToolTester.searchByLastName("mark");
		if (listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
		listOfResults = searchToolTester.searchByLastName("bob");
		if (listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
		listOfResults = searchToolTester.searchByLastName("markZero");
		if (listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
		// Fail Test Cases. Fail if list is not empty.
		listOfResults = searchToolTester.searchByLastName("KEVIN");
		if (!listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
		listOfResults = searchToolTester.searchByLastName("kevin mark");
		if (!listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
		// This test checks if a user can be found if containing substring name
		listOfResults = searchToolTester.searchByLastName("mark");
		boolean doesResultExist = false;
		for (User user : listOfResults) {
			if (user.getLastName().equals("markZero")) {
				doesResultExist = true;
			}
		}

		if (doesResultExist == false) {
			throw new RuntimeException();
		}
	}

	@Test
	public void testSearchByCourse() {
		// Test case true if not empty.
		listOfResults = searchToolTester.searchByCourse("CS480");
		if (listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
		listOfResults = searchToolTester.searchByCourse("ENG101");
		if (listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
		listOfResults = searchToolTester.searchByCourse("CS128");
		if (listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
		listOfResults = searchToolTester.searchByCourse("PHYS131");
		if (listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
		// Fail Test Cases. Fail if list is not empty.
		listOfResults = searchToolTester.searchByCourse("");
		if (!listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
		listOfResults = searchToolTester.searchByCourse("001");
		if (!listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
		listOfResults = searchToolTester.searchByCourse("ABCDE");
		if (!listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
	}

	@Test
	public void testSearchByCommonCourses() {
		// Test case true if not empty.
		listOfResults = searchToolTester.searchByCommonCourses(listOfAllUsers.get(0));
		if (listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
		listOfResults = searchToolTester.searchByCommonCourses(listOfAllUsers.get(1));
		if (listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
		listOfResults = searchToolTester.searchByCommonCourses(listOfAllUsers.get(2));
		if (listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
		listOfResults = searchToolTester.searchByCommonCourses(listOfAllUsers.get(3));
		if (listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
		// Fail Test Cases. Fail if user5 has a common classmate.
		User user5 = new User("005", "loner", "lonley", "English");
		HashSet<String> courses5 = new HashSet<String>();
		courses5.add("ENG99");
		courses5.add("CS420");
		user5.setCourses(courses5);

		listOfResults = searchToolTester.searchByCommonCourses(user5);
		if (!listOfResults.isEmpty()) {
			throw new RuntimeException();
		}

		// User5 should now have a common classmate. After adding course ENG101.
		courses5.add("ENG101");
		user5.setCourses(courses5);
		listOfResults = searchToolTester.searchByCommonCourses(user5);
		if (listOfResults.isEmpty()) {
			throw new RuntimeException();
		}
	}
}
