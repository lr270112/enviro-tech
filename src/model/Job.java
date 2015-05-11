package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//make setters immutable

//TDD (Test Driven Development): 
//1. Write the code
//2. Run the test (it fails)
//3. Write just enough implementation code to pass the test
//4. Run all tests and debug until they all pass
//5. Refactor the code
//Assumptions
//1. Code is almost always kept stable
//2. Fix it now(do not write more code if there is a bug)
//3. If it can break write a test
//4. Predict code velocity
//5. Break the unit apart(If you have to do a sysout in the middle of your code you know that you need to split your code there)

public class Job {

	//Provide a list of options for the user every time they are asked what they want to do 
	
	//Check Dennis's AbstractUser for immutable 
	/**
	 * Park managers Job ID. 
	 */
	private int theJobID;
	
//	NEED JOB NAME
	private String theParkName; 
	private String theParkLocation; 
	private int totalVolunteers; 
	
	//List of people for a specific job
	//ParkManager should be able to find a list of volunteers for a specific job
	private List<Volunteer> lightVolunteers;
	private List<Volunteer> mediumVolunteers;
	private List<Volunteer> heavyVolunteers;
	
	private Date theCurrentDate;
	//Make sure the current date, start date and end date are not the same 
	private Date theJobStartingDate;
	private Date theJobEndingDate;
	private int currentLightVolunteers;
	private int currentMediumVolunteers;
	private int currentHeavyVolunteers;
	private int maxLightVolunteers;
	private int maxMediumVolunteers;
	private int maxHeavyVolunteers;
	
	public Job(final int jobID, final String parkName, final String parkLocation, final int theTotalVolunteers,
			final Date currentDate, final Date jobStartingDate, final Date jobEndingDate,  
			final int maxLightVolunteer, final int maxMediumVolunteer,
			final int maxHeavyVolunteer) {
		super();
		
		theJobID = jobID;
		theParkName = parkName;
		theParkLocation = parkLocation;
		totalVolunteers = theTotalVolunteers;
		
		lightVolunteers = new ArrayList<>();
		mediumVolunteers = new ArrayList<>();
		heavyVolunteers = new ArrayList<>();
		
		
		theCurrentDate = currentDate;
		theJobStartingDate = jobStartingDate;
		theJobEndingDate = jobEndingDate;
		
		currentLightVolunteers = 0;
		currentMediumVolunteers = 0;
		currentHeavyVolunteers = 0;
		
		maxLightVolunteers = maxLightVolunteer;
		maxMediumVolunteers = maxMediumVolunteer;
		maxHeavyVolunteers = maxHeavyVolunteer;
	}

	//Checks start date is within 90 days of job submission
	//and checks that start date is in the future
	public boolean checkDate(Date currentDate, Date startDate){
		int days = (int)((startDate.getTime() - currentDate.getTime())/(1000 * 60 * 60*24));
		
		if(days > 90){
			System.out.println("The start date is more than 90 days ahead of the current date.");
			return false;
		}
		else{
//			System.out.println("The dates are within 90 days of each other");
			return true; 
		}
	}
	
	//Checks that start date and end date are within 2 days
	//as well as checks if the dates are all the same
	public boolean maxWorkDays(Date currentDate, Date startDate, Date endDate){
		int days = 0;
		
		long diff = endDate.getTime() - startDate.getTime();
		long diffDays = diff / (24 * 60 * 60 * 1000) + 1; 
		days = (int) diffDays;
		if(days > 2){
			System.out.println("the start date and end date are not within 2 days of each other");
			return false;
		} else if(currentDate == startDate || currentDate == endDate){
			return false;
		}
		else{
//			System.out.println("the start date and end date are within 2 days of each other");
			return true; 
		}
	}
	
	//Checks to see if the list of volunteers is full
	//Dont need, check total volunteers with the total grades
	public boolean isFull(){
		if((getMaxHeavy() + getMaxLight() + getMaxMedium()) <= totalVolunteers){
//			System.out.println("the volunteer list is not full");
			return false;
		}
		else{
			System.out.println("the volunteer list is full");
			return true;
		}
	}
	
	public void addLight(Volunteer newV){
		if(currentLightVolunteers < maxLightVolunteers){
			lightVolunteers.add(newV);
			currentLightVolunteers++;
		}else {
			System.out.println("Sorry, we have reached the maximum amount of light volunteers.");
		}
	}
	
	public void addMedium(Volunteer newV){
		if(currentMediumVolunteers < maxMediumVolunteers){
			mediumVolunteers.add(newV);
			currentMediumVolunteers++;
		}else {
			System.out.println("Sorry, we have reached the maximum amount of medium volunteers.");
		}
	}
	
	public void addHeavy(Volunteer newV){
		if(currentHeavyVolunteers < maxHeavyVolunteers){
			heavyVolunteers.add(newV);
			currentHeavyVolunteers++;
		}else {
			System.out.println("Sorry, we have reached the maximum amount of heavy volunteers.");
		}
	}
	
	public boolean checkLight(){
		if(maxLightVolunteers > currentLightVolunteers){
			return true;
		}else {
			return false;
		}
	}
	
	public boolean checkMedium(){
		if((maxMediumVolunteers - currentMediumVolunteers) > 0){
			return true;
		}else {
			return false;
		}
	}
	
	public boolean checkHeavy(){
		if((maxHeavyVolunteers - currentHeavyVolunteers) > 0){
			return true;
		}else {
			return false;
		}
	}
	
	/*public void addVolunteer(Volunteer newV, String grade){
		if (!isFull()) {
			theListOfVolunteer.add(newV);
		}
	}*/
	
	public String getParkName(){
		return theParkName;
	}
	
	public int getTheJobID() {
		return theJobID;
	}

	public String getParkLocation(){
		return theParkLocation;
	}
	
	public int getTotalVolunteers(){
		return totalVolunteers;
	}
	
	public List<Volunteer> getListOfVolunteer(){
		List<Volunteer> volunteers = new ArrayList<>();
		volunteers.addAll(lightVolunteers);
		volunteers.addAll(mediumVolunteers);
		volunteers.addAll(heavyVolunteers);
		return volunteers;
	}
	
	public Date getStartDay(){
		return theJobStartingDate;
	}
	
	public Date getEndDate(){
		return theJobEndingDate;
	}
	
	public int getLight(){
		return currentLightVolunteers;
	}
	
	public int getMedium(){
		return currentMediumVolunteers;
	}
	
	public int getHeavy(){
		return currentHeavyVolunteers;
	}

	public int getMaxLight(){
		return maxLightVolunteers;
	}
	
	public int getMaxMedium(){
		return maxMediumVolunteers;
	}
	
	public int getMaxHeavy(){
		return maxHeavyVolunteers;
	}
	
	public void setJobID(int theJobID) {
		this.theJobID = theJobID;
	}

	public void setParkName(String myParkName) {
		this.theParkName = myParkName;
	}

	public void setParkLocation(String myParkLocation) {
		this.theParkLocation = myParkLocation;
	}

	public void setTotalVolunteers(Integer myTotalVolunteers) {
		this.totalVolunteers = myTotalVolunteers;
	}

	public void setJobStartingDate(Date myJobStartingDate) {
		this.theJobStartingDate = myJobStartingDate;
	}

	public void setJobEndingDate(Date myJobEndingDate) {
		this.theJobEndingDate = myJobEndingDate;
	}


	@Override
	public String toString() {
		
		return "Job [theJobID=" + theJobID + ", theParkName=" + theParkName
				+ ", theParkLocation=" + theParkLocation + ", totalVolunteers="
				+ totalVolunteers + ", theListOfVolunteer="
				+ getListOfVolunteer() + ", theCurrentDate=" + theCurrentDate
				+ ", theJobStartingDate=" + theJobStartingDate
				+ ", theJobEndingDate=" + theJobEndingDate
				+ ", currentLightVolunteers=" + currentLightVolunteers
				+ ", currentMediumVolunteers=" + currentMediumVolunteers
				+ ", currentHeavyVolunteers=" + currentHeavyVolunteers
				+ ", maxLightVolunteers=" + maxLightVolunteers
				+ ", maxMediumVolunteers=" + maxMediumVolunteers
				+ ", maxHeavyVolunteers=" + maxHeavyVolunteers + "]";
	}
	
	public String displayAllJobsForVolunteer () {
		
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		String tempStart = format.format(theJobStartingDate);
		String tempEnd = format.format(theJobEndingDate);
		
		return "Job ID: " + theJobID + ", Park Name: " + theParkName
				+ ", Location: " + theParkLocation + ", Starting Date: " + tempStart
				+ ", Ending Date: " + tempEnd + ", Total Volunteers Needed: "
				+ totalVolunteers 
				+ ", current Light Volunteers: " + currentLightVolunteers
				+ ", current Medium Volunteers: " + currentMediumVolunteers
				+ ", current Heavy Volunteers: " + currentHeavyVolunteers
				+ ", max Light Volunteers: " + maxLightVolunteers
				+ ", max Medium Volunteers: " + maxMediumVolunteers
				+ ", max Heavy Volunteers: " + maxHeavyVolunteers;
	}
	
	public String displaySignedUpJobsForVolunteer() {
		
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		String tempStart = format.format(theJobStartingDate);
		String tempEnd = format.format(theJobEndingDate);
		
		return "Job ID: " + theJobID + ", Park Name: " + theParkName
				+ ", Location: " + theParkLocation 
				+ ", Starting Date: " + tempStart
				+ ", Ending Date: " + tempEnd;
				
	}

	public int getMaxLightVolunteers() {
		return maxLightVolunteers;
	}

	public void setMaxLightVolunteers(int maxLightVolunteers) {
		this.maxLightVolunteers = maxLightVolunteers;
	}

	public int getMaxMediumVolunteers() {
		return maxMediumVolunteers;
	}

	public void setMaxMediumVolunteers(int maxMediumVolunteers) {
		this.maxMediumVolunteers = maxMediumVolunteers;
	}

	public int getMaxHeavyVolunteers() {
		return maxHeavyVolunteers;
	}

	public void setMaxHeavyVolunteers(int maxHeavyVolunteers) {
		this.maxHeavyVolunteers = maxHeavyVolunteers;
	}
	
	
	
}
