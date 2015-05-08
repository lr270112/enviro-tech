package model;

import java.util.ArrayList;
import java.util.List;

//import JobSchedule class

/**
 * 
 */

/**
 * @author Katie Alexander
 *
 */
public class Volunteer extends User {
	
	//Check that you aren't signing up for a job on the same day

	/**Instance of the JobSchedule class.**/
	private JobSchedule myJobSchedule;
	
	/**List of jobs the volunteer is signed up for.**/
	private List<Job> myJobList;
	
	/**Constructor for the Volunteer class.**/
	public Volunteer() {
		myJobList = new ArrayList<Job>();
	}
	
	/**Signs the volunteer up for a specified job.**/
	public boolean signUpforJob(Job newJob) {
		
		//boolean added = true;
		
		//For each job in myJobSchedule
		for(int i = 0; i < myJobSchedule.listOfJobs.size(); i++) {
			//If the starting date of the new job equals the starting date of a job already signed up for
			if(newJob.myJobStartingDate == myJobSchedule.listOfJobs[i].myJobStartingDate) {
				//Return false and do not sign up for that job
				return false;
			}
		}
		
		//Add this volunteer to the specified job.
		myJobSchedule.addVolunteerToJob(this ,newJob);
		
		//Add this job to the volunteers list of jobs
		addJobToMyList(newJob);
		
		return true;
	}
	
	/**Adds a job to the volunteer's myJobList.**/
	public void addJobToMyList(Job newJob) {
		
		myJobList.add(newJob);
	}
	
	/**Prints out the upcoming jobs that the volunteer can sign up for.**/
	public void viewUpcomingJobs() {
		
		for(int i = 0; i < myJobSchedule.listOfJobs.size(); i++) {
			//Print information about each job 
		}
	}
	
	/**Prints out the upcoming jobs that the volunteer has signed up for.**/
	public void viewMySignedUpJobs() {
		
		for(int i = 0; i < myJobList.size(); i++) {
			//Print information about each job 
			
		}
	}
}
