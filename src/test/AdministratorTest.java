package test;

//Ankit

import static org.junit.Assert.*;

import java.util.List;

import model.Administrator;

import org.junit.Before;
import org.junit.Test;


public class AdministratorTest {
	
	private Administrator administrator;

	@Before
	public void setUp() throws Exception {
		administrator = new Administrator();
	}

	@Test
	public void testGetVolunteer() {
		Volunteer volunteer = administrator.getVolunteer();
		assertNotNull(volunteer);
	}

	@Test
	public void testListVolunteers() {
		List<Volunteer> allVolunteers = administrator.listVolunteers();
		assertNotNull(allVolunteers);
	}

}
