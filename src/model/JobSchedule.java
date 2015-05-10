package model;

/**
 * Qiyuan Zhou
 * 5/3/15
 */


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


public class JobSchedule {

	private List<Job> listOfJobs;		// no more than 30 pending jobs
	private boolean isCompleted;
	private Date date;
	
	// Constructors
	// empty
	public JobSchedule () {
		
		listOfJobs = new LinkedList<Job>();
//		listOfVolunteers = new LinkedList<Volunteer>();
		isCompleted = false;
		date = new Date(System.currentTimeMillis());
	}

	// add a job to the list
	public boolean addMyJob(Job newJob) {
		
		Date tempDate = newJob.myJobStartingDate;
		// creates a boundary of 3 days away from current date
		Date leftBound = new Date(tempDate.getTime() - 3*1000*60*60*24);
		Date rightBound = new Date(tempDate.getTime() + 3*1000*60*60*24);
		int jobCount = 0;
		
		// 
		if (listOfJobs.size() > 4)
		{
			// iterate through the list to check if adding current job violates BR
			for (Job job: listOfJobs)
			{
				// think about all dates on x-axis
				if (job.myJobEndingDate.after(leftBound) && job.myJobStartingDate.before(rightBound))
				{
					jobCount++;
				}
			}
			
			// BR: Cannot have more than 5 jobs in consecutive 7-day period. 
			if (jobCount > 4)
			{
				System.out.println("They are already 5 jobs in this week.");
				return false;
			}
		}
		
		if (newJob instanceof Job) // check if a job is passed in
		{
			if (listOfJobs.size() <30)
				listOfJobs.add(newJob);
			else
			{
				System.out.println("The current pending jobs have reached a limit of 30.");
				return false;
			}
		}
		else
		{
			System.out.println("Not a job.");
			return false;
		}
		
		return true;
	}

	// 
	public static void addVolunteerToJob(Volunteer newVolunteer, Job currentJob) {

		//
		if (currentJob.myListOfVolunteer == null)
		{
			currentJob.addVolunteer(newVolunteer);
		}
		else
		{
			if (!currentJob.isFull())
				currentJob.addVolunteer(newVolunteer);
		}
//		else
//			return false;
//
//		return true;
	}
	
	// when a job has passed it's end date, it should be removed from the current list.
	public void checkPassedJob() {
		
		// order jobList and check one end
		// or
		// iterate through all jobs in jobList every time
		
		for (Job job : listOfJobs)
		{
			if (job.getEndDate().before(date))
			{
				removeJob(job);
			}
		}
		
//		return isCompleted;
	}


	// When a job is past, it should be removed from the pending job list.
	public boolean removeJob(Job currentJob) {

		// The deletion is done through UI, therefore, it should know which job
		// is to be deleted. Then the object is passed as a parameter to this method.
		if (listOfJobs.contains(currentJob))
		{
			listOfJobs.remove(currentJob);
		}


		// or we can iterate through the job list to find the current job and delete it. 
		/*
		Job temp = currentJob;
		Iterator i;
		for (i = listOfJobs.iterator(); i.hasNext();)
		{
			if ((Job) i.myJobID == temp.myJobID)
			{
				listOfJobs.remove(i);
				return true;
			}
		}
		 */

		return true;
	}

	public List<Volunteer> getMyVolunteeredJob(Job currentJob) {

		return currentJob.getListOfVolunteer();
	}

	public List<Job> getListOfJobs() {
		return listOfJobs;
	}

	public void setListOfJobs(List<Job> listOfJobs) {
		this.listOfJobs = listOfJobs;
	}

}
