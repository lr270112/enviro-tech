package test;
import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.Job;

import org.junit.Before;
import org.junit.Test;

//Author Leda Rezanejad

public class JobTest {

	private Job job;
	
	@Before
	public void setUp() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
		Date current = format.parse("05/03/2015");
		Date starting = format.parse("06/04/2015");
		Date ending = format.parse("06/05/2015");
		job = new Job(12345, "woodland", "seattle", 10, current, starting, ending, 2, 3, 6, 4, 3, 7);
	}
	
	@Test
	public void testCheckDate() throws Exception {
		boolean ans = true;
		boolean val;
		
		SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
		Date current = format.parse("05/03/2015");
		Date starting = format.parse("11/09/2015");
		
		val = job.checkDate(current, starting);
		
		assertEquals(ans,val);
		
	}
	
	@Test
	public void testMaxWorkDays() throws Exception{
		boolean ans = true;
		boolean val;
		
		SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
		Date starting = format.parse("05/06/2015");
		Date ending = format.parse("05/07/2015");
		
		val = job.maxWorkDays(starting, ending);
		
		assertEquals(ans,val);
	}

	@Test
	public void testIsFull() throws Exception{
		boolean ans = true;
		boolean val;
		
		List<Volunteer> v = job.getListOfVolunteer();
		
		
		val = job.isFull(v);
		
		assertEquals(ans,val);
	}
	
	
}