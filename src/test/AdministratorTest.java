package test;

import static org.junit.Assert.*;

import java.io.FileInputStream;

import model.Administrator;
import model.User;
import model.Volunteer;

import org.junit.Before;
import org.junit.Test;


/**
 * AdministratorTest is the JUnit test class for the Administrator class.
 */
public class AdministratorTest {
	
	/** The administrator instance to check. */
	private Administrator testAdministrator;
	
	/** The first name of the administrator instance. */
	private String firstName;
	
	/** The last name of the administrator instance. */
	private String lastName;
	
	/** The email of the administrator instance. */
	private String email;

	/**
	 * Sets the up the administrator instance.
	 */
	@Before
	public void setUp() {
		firstName = "James";
		lastName = "Smith";
		email = "jsmith@mygmail.com";
		testAdministrator = new Administrator(firstName, lastName, email);
	}

	/**
	 * Tests the administrator constructor with three String parameters.
	 */
	@Test
	public void testAdministrator() {
		// admin first name, last name, and email address must be equal to the one set in the setup
		assertEquals(testAdministrator.getFirstName(), firstName);
		assertEquals(testAdministrator.getLastName(), lastName);
		assertEquals(testAdministrator.getTitle(), email);
	}

	/**
	 * Tests the getVolunteer method.
	 */
	@Test
	public void testGetVolunteer() {
		// whatever user enters, return must be null since users list must be empty at this point
		Volunteer volunteer = testAdministrator.getVolunteer();
		assertNull(volunteer);
		
		// add a volunteer to the users list
		Volunteer volunteerToAdd = new Volunteer("John", "Johnson", "jjohnson@mygmail.com");
		User.userList.add(volunteerToAdd);
		
		// test with an existing volunteer
		System.out.println("(Please type 'Johnson' in the next question to pass the JUnit)");
		volunteer = testAdministrator.getVolunteer();
		assertEquals(volunteerToAdd, volunteer);
		
		// test with a non existing volunteer
		System.out.println("(Please type anything BUT 'Johnson' in the next question to pass the JUnit)");
		volunteer = testAdministrator.getVolunteer();
		assertNull(volunteer);
	}

	/**
	 * Tests the listVolunteers method.
	 */
	@Test
	public void testListVolunteers() {
		// since the method simply prints a list of volunteers, no need to check anything
		testAdministrator.listVolunteers();
	}

}

