package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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
	
	/**Constructor for the Volunteer class.
	 * 
	 * @param theFirstName 
	 * @param theLastName 
	 * @param theEmail 
	 **/
	public Volunteer(String theFirstName, String theLastName, String theEmail) {
		super(theFirstName, theLastName, theEmail);
		myJobList = new ArrayList<Job>();
	}
	
	/**Signs the volunteer up for a specified job.**/
	public boolean signUpforJob(Job newJob, String grade) {
		
		Date today = new Date();
		
		//boolean added = true;
		
		//For each job in myJobSchedule
		for(int i = 0; i < myJobList.size(); i++) {
			//If the starting date of the new job equals the starting date of a job already signed up for
			if(newJob.myJobStartingDate == myJobList.get(i).myJobStartingDate || 
				newJob.myJobStartingDate == myJobList.get(i).myJobEndingDate) {
				//Return false and do not sign up for that job
				return false;
				
			} else if(!checkGrade(newJob, grade)) { //Check if the specified grade is full
				
				return false;
				
			} else if(!newJob.checkDate(today, newJob.myJobStartingDate)) { //Check if the date is past
				myJobSchedule.removeJob(newJob);
				return false;
				
			}
		}
		
		//Add this volunteer to the specified job.
		myJobSchedule.addVolunteerToJob(this, newJob);
		
		//Add this job to the volunteers list of jobs
		addJobToMyList(newJob);
		
		return true;
	}
	
	public boolean checkGrade(Job newJob, String grade) {
		
		boolean check = false;
		
		switch(grade) {
			case ("Light"): 
				if((newJob.myMaxLightVolunteer - newJob.getLight()) > 0) {
					check = true;
					newJob.myLightVolunteer++;
				}
				break; 
			case ("Medium"): 
				if((newJob.myMaxMediumVolunteer - newJob.getLight()) > 0) {
					check = true;
					newJob.myMediumVolunteer++;
			}
			break; 
			case ("Heavy"): 
				if((newJob.myMaxHeavyVolunteer - newJob.getLight()) > 0) {
					check = true;
					newJob.myHeavyVolunteer++;
				}
				break; 
		}
		
		return check;
	}
	
	/**Adds a job to the volunteer's myJobList.**/
	public void addJobToMyList(Job newJob) {
		
		myJobList.add(newJob);
	}
	
	/**Prints out the upcoming jobs that the volunteer can sign up for.**/
	public void viewUpcomingJobs() {
		
		for(int i = 0; i < myJobSchedule.getListOfJobs().size(); i++) {
			//Print information about each job 
			myJobSchedule.getListOfJobs().get(i).toString();
		}
	}
	
	/**Prints out the upcoming jobs that the volunteer has signed up for.**/
	public void viewMySignedUpJobs() {
		
		for(int i = 0; i < myJobList.size(); i++) {
			//Print information about each job 
			myJobList.get(i).toString();
		}
	}
}

