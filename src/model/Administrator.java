package model;

/**
 * 
 * Ankit
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hamcrest.core.IsInstanceOf;


public class Administrator extends User {
	
	private Scanner keyboard;
	
	public Administrator(String fname, String lname, String email) {
		super(fname, lname, email);
		keyboard = new Scanner(System.in);
	}

	public Volunteer getVolunteer() {
		// Administrator types 'check'
		
		// ask for last name of volunteer
		System.out.print("Enter volunteer's last name: ");
		String lastName = keyboard.nextLine().trim();

		boolean found = false;
		
		Volunteer volunteer = null;
		
		// get volunteer
		for (User user : userList)
		{
			if (user instanceof Volunteer)
			{
//				System.out.println("This is a volunteer.");
//				System.out.println(user.getLastName());
//				System.out.println("You entered " + lastName);
				if (user.getLastName().equals(lastName))	
				{
					found = true;
					volunteer = (Volunteer) user;
				}
			}
		}
		
		
		// output volunteer data
		if (found)
			System.out.println(volunteer);
		else
			System.out.println("No such volunteer");
		
		return volunteer;
	}
	
	public void listVolunteers() {
		// Administrator types 'list all volunteers'
		
		// get all volunteers
//		ArrayList<User> allUsers = userList;
		
		// output each volunteer
		for (User user : userList) {
			if (user instanceof Volunteer)
				System.out.println((Volunteer) user);
		}
		
//		return allVolunteers;
	}
	
}