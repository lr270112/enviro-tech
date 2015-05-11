package model;

/**
 
/**
 * Qiyuan Zhou
 * 5/3/15
 */


import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class JobSchedule {

	private List<Job> listOfJobs;		// no more than 30 pending jobs
	private boolean isCompleted;
	private Date date;
	
	/**
	 * Constructors
	 * 
	 * Initialize variables
	 */
	public JobSchedule () {
		
		listOfJobs = new LinkedList<Job>();
		isCompleted = false;
		date = new Date(System.currentTimeMillis());
		
	}

	/**
	 * 
	 * @param newJob
	 * @return
	 * 
	 * Pass in a Job instance and add it to the job list. Also performs check on 2 Business Rules.
	 * BR 1: A job may not be added if the total number of pending jobs is currently 30.
	 * BR 2: A job may not be added if the total number of pending jobs during that week 
	 *       (3 days on either side of the job days) is currently 5.
	 */
	public void addMyJob(Job newJob) {
		
		Date tempDate = newJob.getStartDay();
		// creates a boundary of 3 days away from the current date
		Date leftBound = new Date(tempDate.getTime() - 3*1000*60*60*24);
		Date rightBound = new Date(tempDate.getTime() + 3*1000*60*60*24);
		int jobCount = 0;
				
		if (newJob instanceof Job) // check if a job is passed in
		{
			// Check BR 1: Cannot have more than 30 jobs.
			if (listOfJobs.size() <30)
			{
				// Check BR 2: Cannot have more than 5 jobs in consecutive 7-day period. 
				if (listOfJobs.size() > 4)
				{
					// iterate through the list 
					// Compare all upcoming jobs in the list to the new job.
					// If a job is within 3 days of the new job, jobCount increase by 1.
					for (Job job: listOfJobs)
					{
						// think about all dates on x-axis
						if (job.getEndDate().after(leftBound) && job.getStartDay().before(rightBound))
						{
							jobCount++;
						}
					}
					
					// If there are already 5 jobs within 3 days of the date an new job
					// is about to be created, deny the creation.
					if (jobCount > 4)
					{
						System.out.println("They are already 5 jobs in this week.");
					}
					else // pass BR 2 check, add the job
						listOfJobs.add(newJob);
				}
				else // If the total number of jobs is less than 4, no need to check BR 2. Simply add the job.
					listOfJobs.add(newJob);
			}
			else
			{
				System.out.println("The current pending jobs have reached a limit of 30.");
			}
		}
		else
		{
			System.out.println("Not a job.");
		}
		
	}

	/**
	 * 
	 * @param newVolunteer
	 * @param currentJob
	 * @param grade
	 * 
	 * Pass in a Volunteer instance, a Job instance, and a grade string.
	 * Sign the volunteer up for the job he wants to, add the volunteer to the list
	 * where each job keeps track of whom signed up. 
	 * 
	 */
	public static void addVolunteerToJob(Volunteer newVolunteer, Job currentJob, String grade) {

		// when the list is empty, add the first volunteer
		if (currentJob.getListOfVolunteer() == null)
		{
			if (grade.equals("Light"))
				currentJob.addLight(newVolunteer);
			else if (grade.equals("Medium"))
				currentJob.addMedium(newVolunteer);
			else
				currentJob.addHeavy(newVolunteer);
		}
		else
		{
			// when the list is not full, sign volunteer up 
			if (!currentJob.isFull())
			{
				if (grade.equals("Light"))
					currentJob.addLight(newVolunteer);
				else if (grade.equals("Medium"))
					currentJob.addMedium(newVolunteer);
				else
					currentJob.addHeavy(newVolunteer);
			}
			else
			{
				System.out.println("The job you are trying to sign up for is full.");
			}
				
		}
		
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
	}


	// When a job is past, it should be removed from the pending job list.
	public boolean removeJob(Job currentJob) {

		// The deletion is done through UI, therefore, it should know which job
		// is to be deleted. Then the object is passed as a parameter to this method.
		if (listOfJobs.contains(currentJob))
		{
			listOfJobs.remove(currentJob);
		}

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
	
	/**Prints out the upcoming jobs that the volunteer can sign up for.**/
	public void viewUpcomingJobs() {
		
		for(Job job : getListOfJobs()) {
			//Print information about each job 
			System.out.println(job.displayAllJobsForVolunteer());
		}
	}
}

