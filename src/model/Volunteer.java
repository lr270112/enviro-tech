package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author Katie Alexander
 *
 */
public class Volunteer extends User {
		
	/**List of jobs the volunteer is signed up for.**/
	private List<Job> myJobList;
	
	/**Constructor for the Volunteer class.
	 * 
	 * @param theFirstName 
	 * @param theLastName 
	 * @param theTitle 
	 **/
	public Volunteer(String theFirstName, String theLastName, String theTitle) {
		super(theFirstName, theLastName, theTitle);
		myJobList = new ArrayList<Job>();
	}
	
	/**Signs the volunteer up for a specified job.**/
	public boolean signUpforJob(Job newJob, String grade) {
		
		Date today = new Date();
		
		//boolean added = true;
		
		//For each job in myJobSchedule
		//Check that you aren't signing up for a job on the same day.
		for(int i = 0; i < myJobList.size(); i++) {
			//If the starting date of the new job equals the starting date of a job already signed up for
			if(newJob.getStartDay().equals(myJobList.get(i).getStartDay()) || 
				newJob.getStartDay().equals(myJobList.get(i).getEndDate())) {
				//Return false and do not sign up for that job
				System.out.println("Sorry you have already signed up for a job on this day");
				return false;
				
			} else if(!checkGrade(newJob, grade)) { //Check if the specified grade is full
				System.out.println("Sorry there are too many volunteers for this labor level");
				return false;
				
			} else if(!newJob.checkDate(today, newJob.getStartDay())) { //Check if the date is past
				//myJobSchedule.removeJob(newJob);
				System.out.println("Sorry this job date has passed");
				return false;
				
			}
		}
		
		switch(grade) {
		case ("Light"):
			newJob.addLight(this);
		break;
		case ("Medium"):
			newJob.addMedium(this);
		break;
		case ("Heavy"):
			newJob.addHeavy(this);
		break;

			// TODO
		}
		
		//Add this volunteer to the specified job.
//		newJob.getListOfVolunteer();
		JobSchedule.addVolunteerToJob(this, newJob, grade);
		
		//Add this job to the volunteers list of jobs
		addJobToMyList(newJob);
		
		return true;
	}
	
	private boolean checkGrade(Job newJob, String grade) {
		
		boolean check = false;
		
		switch(grade) {
			case ("Light"): 
				check = newJob.checkLight();
				break; 
			case ("Medium"): 
				check = newJob.checkMedium();
				break; 
			case ("Heavy"): 
				check = newJob.checkHeavy();
				break; 
		}
		
		return check;
	}
	
	/**Adds a job to the volunteer's myJobList.**/
	public void addJobToMyList(Job newJob) {
		
		myJobList.add(newJob);
	}

	public List<Job> getMyJobList() {
		return myJobList;
	}
	
	public String toString() {
		String str = "";
		str = getFirstName() + ", " + getLastName();
		
		return str;
		
	}
		
}



