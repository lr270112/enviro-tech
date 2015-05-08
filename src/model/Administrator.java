package model;

//Ankit

import java.util.List;
import java.util.Scanner;


public class Administrator extends User {
	
	private Scanner keyboard;
	
	public Administrator() {
		keyboard = new Scanner(System.in);
	}

	public Volunteer getVolunteer() {
		// Administrator types 'check'
		
		// ask for last name of volunteer
		System.out.print("Enter volunteer's last name: ");
		String lastName = keyboard.nextLine().trim();

		// get volunteer
		Volunteer volunteer = Schedule.getVolunteerByLastName(lastName);
		
		// output volunteer data
		System.out.println(volunteer);
		
		return volunteer;
	}
	
	public List<Volunteer> listVolunteers() {
		// Administrator types 'list all volunteers'

		// get all volunteers
		List<Volunteer> allVolunteers = Schedule.getAllVolunteers();
		
		// output each volunteer
		for (Volunteer volunteer : allVolunteers) {
			System.out.println(volunteer);
		}
		
		return allVolunteers;
	}
	
}
