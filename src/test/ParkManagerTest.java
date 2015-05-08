package test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class ParkManagerTest {
	
	private ParkManager parkManager;

	@Before
	public void setUp() throws Exception {
		parkManager = new ParkManager();
	}

	@Test
	public void testCreateJob() throws ParseException {
		Job job = parkManager.createJob();
		assertNotNull(job);
	}

	@Test
	public void testViewUpcomingJobs() {
		List<Job> upcomingJobs = parkManager.viewUpcomingJobs();
		assertNotNull(upcomingJobs);
	}

	@Test
	public void testViewJobVolunteers() {
		List<Volunteer> jobVolunteers = parkManager.viewJobVolunteers();
		assertNotNull(jobVolunteers);
	}

}

