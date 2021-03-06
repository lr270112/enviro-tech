package test;

/**
 * Qiyuan Zhou
 * 5/3/15
 */


import static org.junit.Assert.*;
import model.Job;
import model.JobSchedule;

import org.junit.Test;
import org.junit.Before;



public class JobScheduleTest {

	private JobSchedule js;
	private ParkManager pm;

	@Before
	public void setUp() throws Exception {
		js = new JobSchedule();
	}

	@Test
	public void testAddMyJob() {

		Job job = new Job();
		js.addMyJob(job);

		assertNotNull(job);
	}

	@Test
	public void testAddVolunteerToJob() {

		Volunteer v = new Volunteer();
		Job job = new Job();
		js.addVolunteerToJob(v, job);
		assertNotNull(v);

		assertNotNull(job);
	}

	@Test
	public void testAddVolunteer() {

		Volunteer v = new Volunteer();
		js.addVolunteer(v);

		assertNotNull(v);
	}

	@Test
	public void testRemoveJob() {

		Job job = new Job();
		js.removeJob(job);

		assertNotNull(job);
	}

}


