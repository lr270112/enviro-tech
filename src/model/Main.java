package model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {

		Scanner scan = new Scanner(System.in);
		String firstName = "";
		String lastName = "";
		String title = "";

		System.out.println("Welcome to Urban Parks!");
		System.out.println("Enter Your First Name:");
		firstName = scan.nextLine();
		System.out.println("Enter Your Last Name:");
		lastName = scan.nextLine();
		
		User currentUser = new User(firstName, lastName, title);
		
		JobSchedule js = new JobSchedule();
		
		addJobs(currentUser, js);
		
//		need to create a loop until user inputs correct 
		System.out.println("Enter Your Title: (Administrator, Park Manager, or Volunteer)");

		title = scan.nextLine();

		//System.out.println("My name is " + firstName + " " + lastName + " and I am a/an " + title + ".");

//			need to create a loop until user inputs correct

		if(title.equalsIgnoreCase("volunteer")){

		volunteerOptions(scan, currentUser, js);

		}

		if(title.equalsIgnoreCase("park manager")){

		parkManagerOptions(scan, currentUser, js);

		}

		if(title.equalsIgnoreCase("administrator")){

		administratorOptions(scan, currentUser);

		}
		
		System.out.println("Thank you for using Urban Parks!");

//		if(title.equalsIgnoreCase("exit")){
//
	    scan.close();
//
//		}

//		else{
//
////		System.out.println("Try again");
//
//		title = scan.nextLine();
//
//		}


	}

	private static void volunteerOptions(Scanner scan, User user, JobSchedule js){
		System.out.println("v");
		System.out.println("Menu Options");
		
		int option = 0;
		
		System.out.println("1. View Upcoming Jobs");
		System.out.println("2. Sign Up For A Job");
		System.out.println("3. View My Jobs");
		System.out.println("4. Exit");
		
		if(scan.hasNextInt()){
			option = scan.nextInt();
			commandVolunteer(option, scan, user, js);
		} 
//		else{
////			System.out.println("Try Again");
//			scan.nextInt();
//		}
	}

	private static void parkManagerOptions(Scanner scan, User user, JobSchedule js) throws ParseException{
		System.out.println("p");
		
		System.out.println("Menu Options");
		
		int option = 0;
		
		System.out.println("1. View Upcoming Jobs");
		System.out.println("2. Submit New Job Request");
		System.out.println("3. View Volunteers Signup For Jobs");
		System.out.println("4. Exit");
		
		if(scan.hasNextInt()){
			option = scan.nextInt();
			commandParkManager(option, scan, user, js);
		} 
		else{
			System.out.println("Try Again");
			scan.nextInt();
		}
	}

	private static void administratorOptions(Scanner scan, User user){
		System.out.println("a");
		
		System.out.println("Menu Options");
		
		int option = 0;
		
		System.out.println("1. Search Volunteers");
		System.out.println("2. Exit");
		
		if(scan.hasNextInt()){
			option = scan.nextInt();
			commandAdministrator(option, scan, user);
		} 
		else{
			System.out.println("Try Again");
			scan.nextInt();
		}
	}
	
	private static void commandVolunteer(int option, Scanner scan, User user, JobSchedule js){

		Volunteer volunteer = new Volunteer(user.getFirstName(), user.getLastName(), user.getTitle());


		while(option != 4) {

			if(option == 1){

				System.out.println("Upcoming Jobs");


				js.viewUpcomingJobs();

			} else if(option == 2){

				System.out.println("Sign Up For A Job");

				System.out.println("Which Job Would You Like To Sign Up For?");

				System.out.println("Enter The Job Number:");

				int jobId = 0;

				jobId = scan.nextInt();
				Job thisJob = null;
				
				//Initialize Job???
				for (Job job : js.getListOfJobs())
				{
					if(jobId == job.getTheJobID())
					{
						thisJob = job;
					}
				}
				
				System.out.println("In Terms of Labor Are You A Light, Medium, Or Heavy Worker");

				String laborLevel = "";

				laborLevel = scan.next();

				
				if(volunteer.signUpforJob(thisJob, laborLevel)) {
					System.out.println("See You Then!");
				} 
				

			} else if(option == 3){

				System.out.println("My Jobs");

				for(int i = 0; i < volunteer.getMyJobList().size(); i++) {
					System.out.println(volunteer.getMyJobList().get(i).displaySignedUpJobsForVolunteer());
				}

			}
			else if(option == 4){

				scan.close();

			}
			System.out.println("1. View Upcoming Jobs");
			System.out.println("2. Sign Up For A Job");
			System.out.println("3. View My Jobs");
			System.out.println("4. Exit");
			
			option = scan.nextInt();
		}

		if(option == 4){

			scan.close();

		}

	}

	private static void commandParkManager(int option, Scanner scan, User user, JobSchedule js) throws ParseException{

		ParkManager pm = new ParkManager(user.getFirstName(), user.getLastName(), user.getTitle());
		Job job = null;
		String parkName = "";

		while(option != 4) {

			if(option == 1){
				
				scan.nextLine();

				System.out.println("Upcoming Jobs");

				System.out.println("Enter Your Parks Name: ");
				parkName = scan.nextLine();
				
				for(int i = 0; i < js.getListOfJobs().size(); i++){
					if(parkName.equals(js.getListOfJobs().get(i).getParkName())) {
						job = js.getListOfJobs().get(i);
						System.out.println(js.getListOfJobs().get(i));
					}
				}

			} else if(option == 2){

				System.out.println("Submit A New Job");
				Job temp = pm.createJob();
				if (temp != null)
				{
					js.addMyJob(temp);
					System.out.println("Create job done!");
				}
				else 
				{
					System.out.println("Create job failed because of violations to System Rules.");
				}

			} else if(option == 3){
				scan.nextLine();
				
				System.out.println("Volunteers Signed Up For Jobs In My Park");
				System.out.println("Enter Your Parks Name: ");
				parkName = scan.nextLine();
			
				for(int i = 0; i < js.getListOfJobs().size(); i++){
					if(parkName.equals(js.getListOfJobs().get(i).getParkName())) {
						job = js.getListOfJobs().get(i);
						System.out.println("Job ID: " + job.getTheJobID());
						System.out.println("List of Volunteers: ");
						System.out.println(job.getListOfVolunteer().size());
						for(int j = 0; j < job.getListOfVolunteer().size(); j++){
							System.out.println(job.getListOfVolunteer().get(j));
						}	
					}
				}
			}
			
			System.out.println("1. View Upcoming Jobs");
			System.out.println("2. Submit New Job Request");
			System.out.println("3. View Volunteers Signup For Jobs");
			System.out.println("4. Exit");

			option = scan.nextInt();

		}
		
		if(option == 4) {

			scan.close();

		}

	}

	private static void commandAdministrator(int option, Scanner scan, User user){

		Administrator ad = new Administrator(user.getFirstName(), user.getLastName(), user.getTitle());

		while(option != 2) {

			if(option == 1){

				System.out.println("Search Volunteers");

				ad.getVolunteer();

			}

			option = scan.nextInt();

		}

		if(option == 2){

			scan.close();

		}

	}
	
	/**
	 * 
	 * @param user
	 * @param js
	 * @throws ParseException
	 * 
	 * This method is only for demonstration purpose. Add 29 jobs to upcoming jobs.
	 */
	private static void addJobs(User user, JobSchedule js) throws ParseException {
		
		ParkManager pm = new ParkManager(user.getFirstName(), user.getLastName(), user.getTitle());
		
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date currentDate = new Date(System.currentTimeMillis());
		
		Job jobs;
		
		jobs = pm.createJob(0, "Woodland", "Ballard", 10, currentDate, 
				format.parse("05/15/2015"), format.parse("05/16/2015"), 5, 3, 2);
		
		js.addMyJob(jobs);
		addUsers(jobs, "Light");
		
		jobs = pm.createJob(1, "Olympia Park", "Washington", 12, 
				currentDate, format.parse("05/16/2015"), 
				format.parse("05/16/2015"), 6, 3, 3);
		js.addMyJob(jobs);
		
		jobs = pm.createJob(2, "Sunset Park", "Washington", 10, 
				currentDate, format.parse("05/22/2015"), 
				format.parse("05/22/2015"), 8, 1, 1);
		js.addMyJob(jobs);
		
		jobs = pm.createJob(3, "Sunrise Park", "Washington", 8, 
				currentDate, format.parse("06/13/2015"), 
				format.parse("06/13/2015"), 6, 1, 1);
		js.addMyJob(jobs);
		
		jobs = pm.createJob(4, "Sunrise Park", "Washington", 8, 
				currentDate, format.parse("06/15/2015"), 
				format.parse("06/15/2015"), 6, 1, 1);
		js.addMyJob(jobs);
		
		jobs = pm.createJob(5, "The Avenger's Park", "Washington", 20, 
				currentDate, format.parse("06/02/2015"), 
				format.parse("06/02/2015"), 12, 3, 5);
		js.addMyJob(jobs);
		
		jobs = pm.createJob(6, "The Avenger's Park", "Washington", 20, 
				currentDate, format.parse("06/18/2015"), 
				format.parse("06/19/2015"), 12, 3, 5);
		js.addMyJob(jobs);
		
		jobs = pm.createJob(7, "The Avenger's Park", "Washington", 20, 
				currentDate, format.parse("06/21/2015"), 
				format.parse("06/22/2015"), 12, 3, 5);
		js.addMyJob(jobs);
		
		jobs = pm.createJob(8, "Moutain Rainer Park", "Washington", 15, 
				currentDate, format.parse("06/27/2015"), 
				format.parse("06/27/2015"), 12, 3, 0);
		js.addMyJob(jobs);
		
		jobs = pm.createJob(9, "Moutain Rainer Park", "Washington", 8, 
				currentDate, format.parse("06/22/2015"), 
				format.parse("06/22/2015"), 3, 2, 3);
		js.addMyJob(jobs);
		
		jobs = pm.createJob(10, "Disney Park", "Washington", 8, 
				currentDate, format.parse("06/30/2015"), 
				format.parse("06/30/2015"), 5, 1, 2);
		js.addMyJob(jobs);
		
		jobs = pm.createJob(11, "Linkin Park", "Washington", 12, 
				currentDate, format.parse("06/28/2015"), 
				format.parse("06/28/2015"), 10, 2, 0);
		js.addMyJob(jobs);
		
		jobs = pm.createJob(12, "Tacoma Park", "Washington", 10, 
				currentDate, format.parse("06/02/2015"), 
				format.parse("06/02/2015"), 8, 1, 1);
		js.addMyJob(jobs);
		
		jobs = pm.createJob(13, "Washington State Park", "Washington", 7, 
				currentDate, format.parse("07/01/2015"), 
				format.parse("07/01/2015"), 3, 3, 1);
		js.addMyJob(jobs);	
				
		jobs = pm.createJob(14, "Washington State Park", "Washington", 12, 
				currentDate, format.parse("07/25/2015"), 
				format.parse("07/25/2015"), 8, 2, 2);
		js.addMyJob(jobs);
		
		jobs = pm.createJob(15, "Washington State Park", "Washington", 14, 
				currentDate, format.parse("07/29/2015"), 
				format.parse("07/29/2015"), 8, 4, 2);
		js.addMyJob(jobs);
		
		jobs = pm.createJob(16, "Seattle Central Park", "Washington", 6, 
				currentDate, format.parse("07/25/2015"), 
				format.parse("07/25/2015"), 4, 2, 0);
		js.addMyJob(jobs);
		
		jobs = pm.createJob(17, "Seattle Central Park", "Washington", 8, 
				currentDate, format.parse("07/11/2015"), 
				format.parse("07/11/2015"), 8, 0, 0);
		js.addMyJob(jobs);
		
		jobs = pm.createJob(18, "UWT Awesome Park", "Washington", 10, 
				currentDate, format.parse("07/12/2015"), 
				format.parse("07/12/2015"), 8, 1, 1);
		js.addMyJob(jobs);
		
		jobs = pm.createJob(19, "Jurassic Park", "Washington", 12, 
				currentDate, format.parse("07/05/2015"), 
				format.parse("07/05/2015"), 4, 4, 4);
		js.addMyJob(jobs);
		
		jobs = pm.createJob(20, "Why So Serious Park", "Washington", 9, 
				currentDate, format.parse("07/07/2015"), 
				format.parse("07/07/2015"), 3, 3, 3);
		js.addMyJob(jobs);
		
		jobs = pm.createJob(21, "Tahiti Park", "Washington", 18, 
				currentDate, format.parse("07/30/2015"), 
				format.parse("07/30/2015"), 10, 6, 2);
		js.addMyJob(jobs);
		
		jobs = pm.createJob(22, "Fiji Park", "Washington", 6, 
				currentDate, format.parse("07/16/2015"), 
				format.parse("07/16/2015"), 3, 3, 0);
		js.addMyJob(jobs);
		
		jobs = pm.createJob(23, "Inception Park", "Washington", 20, 
				currentDate, format.parse("07/22/2015"), 
				format.parse("07/22/2015"), 10, 6, 4);
		js.addMyJob(jobs);
		
		jobs = pm.createJob(24, "SeaHawk Park", "Washington", 14, 
				currentDate, format.parse("07/08/2015"), 
				format.parse("07/08/2015"), 10, 2, 2);
		js.addMyJob(jobs);
		
		jobs = pm.createJob(25, "Fun Park", "Washington", 6, 
				currentDate, format.parse("07/19/2015"), 
				format.parse("07/19/2015"), 3, 1, 1);
		js.addMyJob(jobs);
		
		jobs = pm.createJob(26, "Lakewood Tiny Park", "Washington", 4, 
				currentDate, format.parse("08/08/2015"), 
				format.parse("08/08/2015"), 4, 0, 0);
		js.addMyJob(jobs);
		
		jobs = pm.createJob(27, "Java Park", "Washington", 17, 
				currentDate, format.parse("08/05/2015"), 
				format.parse("08/05/2015"), 10, 4, 3);
		js.addMyJob(jobs);
		
		jobs = pm.createJob(28, "Team Envir-Tech Park", "Washington", 4, 
				currentDate, format.parse("08/06/2015"), 
				format.parse("08/06/2015"), 4, 0, 0);
		js.addMyJob(jobs);
		
		jobs = pm.createJob(29, "The Park Park", "Washington", 6, 
				currentDate, format.parse("08/10/2015"), 
				format.parse("08/10/2015"), 3, 1, 2);
		js.addMyJob(jobs);
		
	}
	
	/**
	 * This method is only for demonstration purpose. Add 2 volunteers and 1 administrator to the user list.
	 * 
	 * @param theJob
	 * @param grade
	 * 
	 */
	private static void addUsers(Job theJob, String grade){
		Volunteer user;
		user = new Volunteer("Leda", "Rezanejad", "Volunteer");
		user.signUpforJob(theJob, grade);
		User.userList.add(user);
		user = new Volunteer("Katie", "Alexander", "Volunteer");
		user.signUpforJob(theJob, grade);
		User.userList.add(user);
		user = new Volunteer("Qiyuan", "Zhou", "Adminitrator");
		User.userList.add(user);
	}
	
}
