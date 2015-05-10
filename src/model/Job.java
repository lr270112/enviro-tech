package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Job {


	Integer myJobID;

	String myParkName;

	String myParkLocation;

	Integer myTotalVolunteers; 

	List<Volunteer> myListOfVolunteer;

	Date myCurrentDate;

	Date myJobStartingDate;

	Date myJobEndingDate;

	int myLightVolunteer;

	int myMediumVolunteer;

	int myHeavyVolunteer;

	int myMaxLightVolunteer;

	int myMaxMediumVolunteer;

	int myMaxHeavyVolunteer;

	public Job(String myParkName, String myParkLocation, Integer myTotalVolunteers,

			Date myJobStartingDate,Date myJobEndingDate, int myLightVolunteer, 

			int myMediumVolunteer, int myHeavyVolunteer) {

		super();

		this.myJobID = myJobID;

		this.myParkName = myParkName;

		this.myParkLocation = myParkLocation;

		this.myTotalVolunteers = myTotalVolunteers;

		this.myCurrentDate = myCurrentDate;

		this.myJobStartingDate = myJobStartingDate;

		this.myJobEndingDate = myJobEndingDate;

		this.myLightVolunteer = myLightVolunteer;

		this.myMediumVolunteer = myMediumVolunteer;

		this.myHeavyVolunteer = myHeavyVolunteer;

		this.myMaxLightVolunteer = myMaxLightVolunteer;

		this.myMaxMediumVolunteer = myMaxMediumVolunteer;

		this.myMaxHeavyVolunteer = myMaxHeavyVolunteer;
		
		myListOfVolunteer = new ArrayList<Volunteer>();

	}
	
	public Job() {
		
	}
	
	
	//Checks start date is within 90 days of job submission

	//and checks that start date is in the future

	public boolean checkDate(Date currentDate, Date startDate){

		int days = 0;

		long diff = startDate.getTime() - currentDate.getTime();

		long diffDays = diff / (24 * 60 * 60 * 1000) + 1; 

		days = (int) diffDays;

		if(days > 90 || days < 0){

			return false;

		}

		else{

			return true; 

		}

	}

	//Checks that start date and end date are within 2 days

	public boolean maxWorkDays(Date startDate, Date endDate){

		int days = 0;

		long diff = endDate.getTime() - startDate.getTime();

		long diffDays = diff / (24 * 60 * 60 * 1000) + 1; 

		days = (int) diffDays;

		if(days > 2){

			return false;

		}

		else{

			return true; 

		}

	}

	//Checks to see if the list of volunteers is full

	public boolean isFull(){

		if(myListOfVolunteer.size() < myTotalVolunteers){

			return false;

		}

		else{

			return true;

		}

	}

	public void addVolunteer(Volunteer newV){

		myListOfVolunteer.add(newV);

	}

	public String getParkName(){

		return myParkName;

	}

	public String getParkLocation(){

		return myParkLocation;

	}

	public Integer getTotalVolunteers(){

		return myTotalVolunteers;

	}

	public List<Volunteer> getListOfVolunteer(){

		return myListOfVolunteer;

	}

	public Date getStartDay(){

		return myJobStartingDate;

	}

	public Date getEndDate(){

		return myJobEndingDate;

	}

	public int getLight(){

		return myLightVolunteer;

	}

	public int getMedium(){

		return myMediumVolunteer;

	}

	public int getHeavy(){

		return myHeavyVolunteer;

	}


	public void setMyJobID(Integer myJobID) {

		this.myJobID = myJobID;

	}


	public void setMyParkName(String myParkName) {

		this.myParkName = myParkName;

	}


	public void setMyParkLocation(String myParkLocation) {

		this.myParkLocation = myParkLocation;

	}


	public void setMyTotalVolunteers(Integer myTotalVolunteers) {

		this.myTotalVolunteers = myTotalVolunteers;

	}


	public void setMyJobStartingDate(Date myJobStartingDate) {

		this.myJobStartingDate = myJobStartingDate;

	}


	public void setMyJobEndingDate(Date myJobEndingDate) {

		this.myJobEndingDate = myJobEndingDate;

	}


	public void setMyMediumVolunteer(int myMediumVolunteer) {

		this.myMediumVolunteer = myMediumVolunteer;

	}


	public void setMyMaxLightVolunteer(int myMaxLightVolunteer) {

		this.myMaxLightVolunteer = myMaxLightVolunteer;

	}


	public void setMyMaxMediumVolunteer(int myMaxMediumVolunteer) {

		this.myMaxMediumVolunteer = myMaxMediumVolunteer;

	}


	public void setMyMaxHeavyVolunteer(int myMaxHeavyVolunteer) {

		this.myMaxHeavyVolunteer = myMaxHeavyVolunteer;

	}

}