package model;

/**
 * @author Katie Alexander
 *
 */
public class User {

	/**First name of the user.**/
	private String myFirstName;
	
	/**Last name of the user.**/
	private String myLastName;
	
	/**The user's e-mail address.**/
	private String myEmail;
	
	public User(String theFirstName, String theLastName, String theEmail) {
		
		myFirstName = theFirstName;
		myLastName = theLastName;
		myEmail = theEmail;
	}
	
	/**Returns the user's last name.**/
	public String getLastName() {
		
		return myLastName;
	}
	
	/**Returns the user's e-mail.**/
	public String getEmail() {
		
		return myEmail;
	}
}
