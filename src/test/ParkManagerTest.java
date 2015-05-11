package test;

import static org.junit.Assert.*;
import model.Job;
import model.ParkManager;
import model.Volunteer;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * ParkManagerTest is the JUnit test class for the ParkManager class.
 */
public class ParkManagerTest {
	
	/** The test park manager. */
	private ParkManager testParkManager;
	
	/** The first name of the park manager instance. */
	private String firstName;
	
	/** The last name of the park manager instance. */
	private String lastName;
	
	/** The email of the park manager instance. */
	private String email;

	/**
	 * Sets the up the park manager instance.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		firstName = "James";
		lastName = "Smith";
		email = "jsmith@myoffice.com";
		testParkManager = new ParkManager(firstName, lastName, email);
	}

	/**
	 * Tests the ParkManager constructor with three string parameters.
	 */
	@Test
	public void testParkManager() {
		// park manager's first name, last name, and email address must be equal to the one set in the setup
		assertEquals(testParkManager.getFirstName(), firstName);
		assertEquals(testParkManager.getLastName(), lastName);
		assertEquals(testParkManager.getTitle(), email);
	}

	/**
	 * Tests the createJob method with no parameters.
	 *
	 * @throws ParseException the parse exception when user enters an invalid date
	 */
	@Test
	public void testCreateJob() throws ParseException {
		// returned job must not be null
		Job jobCreated = testParkManager.createJob();
		assertNotNull(jobCreated);
	}

	/**
	 * Tests the createJob method with parameters.
	 */
	@Test
	public void testCreateJobStringStringIntStringStringIntIntInt() {
		Job jobCreated = null;
		
		// test with valid dates
		try {
			// returned job must not be null
			jobCreated = testParkManager.createJob();
			assertNotNull(jobCreated);
		} catch (ParseException e) {
			fail("Dates must have been valid.");
		}

		// test with invalid start date
		jobCreated = null;
		try {
			// returned job must be null
			jobCreated = testParkManager.createJob();
			fail("Start date must have been invalid.");
		} catch (ParseException e) {
			assertNull(jobCreated);
		}
		
		// test with invalid end date
		jobCreated = null;
		try {
			// returned job must be null
			jobCreated = testParkManager.createJob();
			fail("End date must have been invalid.");
		} catch (ParseException e) {
			assertNull(jobCreated);
		}
	}

	/**
	 * Tests the viewUpcomingJobs method.
	 */
	@Test
	public void testViewUpcomingJobs() {
		// test with empty jobs list
		List<Job> jobs = new ArrayList<>();
		List<Job> returnedJob = testParkManager.viewUpcomingJobs(jobs);
		assertTrue(returnedJob.isEmpty());
		
		// test with jobs list with a few jobs
		jobs = new ArrayList<>();
		jobs.add(new Job(1, "park1", "park1loc", 5, new Date(), new Date(), new Date(), 1, 2, 2));
		jobs.add(new Job(2, "park2", "park2loc", 5, new Date(), new Date(), new Date(), 1, 2, 2));
		jobs.add(new Job(3, "park3", "park3loc", 5, new Date(), new Date(), new Date(), 1, 2, 2));
		returnedJob = testParkManager.viewUpcomingJobs(jobs);
		assertEquals(jobs, returnedJob);
	}

	/**
	 * Tests the viewJobVolunteers method.
	 */
	@Test
	public void testViewJobVolunteers() {
		// test with a job with no volunteers yet
		Job job = new Job(1, "park1", "park1loc", 5, new Date(), new Date(), new Date(), 1, 2, 2);
		List<Volunteer> returnedVolunteers = testParkManager.viewJobVolunteers(job);
		assertTrue(returnedVolunteers.isEmpty());

		// test with a job with a few volunteers
		Volunteer volunteer1 = new Volunteer("Anthony", "Martin", "amartin@gmail.com");
		Volunteer volunteer2 = new Volunteer("Elizabeth", "Adams", "eadams@gmail.com");
		Volunteer volunteer3 = new Volunteer("Mary", "Clark", "mclark@gmail.com");
		job.addLight(volunteer1);
		job.addMedium(volunteer2);
		job.addHeavy(volunteer3);
		returnedVolunteers = testParkManager.viewJobVolunteers(job);
		assertEquals(3, returnedVolunteers.size());
		assertTrue(returnedVolunteers.contains(volunteer1));
		assertTrue(returnedVolunteers.contains(volunteer2));
		assertTrue(returnedVolunteers.contains(volunteer3));
	}

}


