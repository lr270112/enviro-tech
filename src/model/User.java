package model;

import java.util.ArrayList;
import java.util.List;



/**
 * @author Katie Alexander
 *
 */
public class User {
	
	public static List<User> userList = new ArrayList<>();
	

	/**First name of the user.**/
	private String myFirstName;
	
	/**Last name of the user.**/
	private String myLastName;
	
	/**The user's title.**/
	private String myTitle;
	
	public User(String theFirstName, String theLastName, String title) {
		
		myFirstName = theFirstName;
		myLastName = theLastName;
		myTitle = title;
	}
	
	/**Returns the user's last name.**/
	public String getLastName() {
		
		return myLastName;
	}
	
	public String getFirstName() { 
		return myFirstName;
	}
	
	/**Returns the user's e-mail.**/
	public String getTitle() {
		
		return myTitle;
	}
	
}