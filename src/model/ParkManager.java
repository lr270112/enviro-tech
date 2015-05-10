package model;

/**
 * 
 * Ankit
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class ParkManager extends User {
	
	private Scanner keyboard;
	
//	private List<Park> myManagedParks;
	
	public ParkManager(String fname, String lname, String email) {
		super(fname, lname, email);
		keyboard = new Scanner(System.in);
//		myManagedParks = new ArrayList<>();
	}
	
	public Job createJob() throws ParseException {
		// Park manager types 'new job'

		// ask for park name
		System.out.print("Enter Park Name: ");
		String parkName = keyboard.nextLine().trim();
		
		// ask for park location
		System.out.print("Enter Location Name: ");
		String parkLocation = keyboard.nextLine().trim();
		
		// total volunteer
		System.out.print("Enter total Number of Volunteers: ");
		int numTotalVolunteers = keyboard.nextInt();
		keyboard.nextLine();
		
		// ask for number of light volunteer slots
		System.out.print("Enter Number of Light Volunteers: ");
		int numLightVolunteers = keyboard.nextInt();
		keyboard.nextLine();
		
		// ask for number of medium volunteer slots
		System.out.print("Enter Number of Medium Volunteers: ");
		int numMediumVolunteers = keyboard.nextInt();
		keyboard.nextLine();
		
		// ask for number of heavy volunteer slots
		System.out.print("Enter Number of Heavy Volunteers: ");
		int numHeavyVolunteers = keyboard.nextInt();
		keyboard.nextLine();
		
		// format for date
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		// ask for start date
		System.out.print("Enter Start Date (mm/dd/yyyy): ");
		Date startDate = dateFormat.parse(keyboard.nextLine().trim());
		
		// ask for end date
		System.out.print("Enter End Date (mm/dd/yyyy): ");
		Date endDate = dateFormat.parse(keyboard.nextLine().trim());
		
		// create new Job
		Job job = new Job(parkName, parkLocation, numTotalVolunteers,
				startDate, endDate, 
				numLightVolunteers, 
				numMediumVolunteers, 
				numHeavyVolunteers);
		
		System.out.println("create job done!");
		
		return job;
	}
	
	public Job createJob(String n, String l, int tl, String s, String e, int lt, int med, int hea) throws ParseException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date start;
		Date end;
		Job job;
		
		
		start = dateFormat.parse(s);
		end = dateFormat.parse(e);


		job = new Job(n, l, tl, start, end, lt, med, hea);

		return job;
	}
	
	public List<Job> viewUpcomingJobs(List<Job> jobList) {
		// Park manager types 'view jobs'
		
		// get upcoming jobs
		List<Job> upcomingJobs = jobList;
		
		// output each job
		for (Job job : upcomingJobs) {
			System.out.println(job);
		}
		
		return upcomingJobs;
	}
	
	public List<Volunteer> viewJobVolunteers(Job myParksJob) {
		// Park manager types 'get job's volunteers'
		
		// ask for job id
//		System.out.print("Enter Job ID: ");
//		String jobId = keyboard.nextLine().trim();
		
		// get list of volunteers
		List<Volunteer> volunteers = myParksJob.myListOfVolunteer;
		
		// output each volunteer
		if (volunteers != null)
		{
			for (Volunteer volunteer : volunteers) {
				System.out.println(volunteer.getFristName() + " " + volunteer.getLastName());
			}
		}
		else
		{
			System.out.println("No one sign up yet!");
		}
		return volunteers;
	}

}