package model;



/**
 * Qiyuan Zhou
 * 5/3/15
 */


import java.util.Iterator;
import java.util.List;


public class JobSchedule {

	final int MAXNUMOFJOBS = 30;

	private List<Job> listOfJobs;		// no more than 30 pending jobs
	private List<Job> currentWeekJobs;		// no more than 5 jobs per week
	private List<Volunteer> listOfVolunteers;		// knows a list of volunteers who sign up for a job

	// Constructors
	// empty
	public JobSchedule () {

	}

	// add a job to the list
	public boolean addMyJob(Job newJob) {

		if (newJob instanceof Job)
		{
			if (listOfJobs.size() < MAXNUMOFJOBS)
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
	public boolean addVolunteerToJob(Volunteer newVolunteer, Job currentJob) {

		//
		if (!currentJob.isFull())
			currentJob.addVolunteer(newVolunteer);
		else
			return false;

		return true;
	}

	public boolean addVolunteer(Volunteer newVolunteer) {

		// There is no BR that limits the number of volunteers per job.
		if (!listOfVolunteers.contains(newVolunteer))
		{
			listOfVolunteers.add(newVolunteer);
			System.out.println("Volunteer added.");
		}

		return true;
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
