package model;

import java.text.ParseException;

public class main {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		
		
		JobSchedule js = new JobSchedule();
		
		
		ParkManager pm = new ParkManager("a", "b", "c");
		User.userList.add(pm);
		
		Job j1 = pm.createJob("park","wa", 5 , "06/02/2015", "06/02/2015", 3,1,1);
		js.addMyJob(j1);
		
		Job j2 = pm.createJob("park2","wa", 5 , "06/03/2015", "06/03/2015", 3,1,1);
		js.addMyJob(j2);
		
		Volunteer vo = new Volunteer("aa", "bb", "cc");
		User.userList.add(vo);
		
		vo.signUpforJob(j1);
//		vo.addJobToMyList(j1);
		vo.viewMySignedUpJobs();
		vo.viewUpcomingJobs(js.getListOfJobs());
		
		pm.viewJobVolunteers(j1);
		pm.viewUpcomingJobs(js.getListOfJobs());
		
		System.out.println("Admin:");
		Administrator admin = new Administrator("aaa", "bbb", "ccc");
		User.userList.add(admin);
		
		admin.listVolunteers();
		admin.getVolunteer();
		
	}
}
		

		
		//
//		Scanner scan = new Scanner(System.in);
//		String email, fname, lname;
//		System.out.println("Welcome to XXX. Please choose from the manu: \n1) existing user\n2) new user");
//		switch (scan.nextInt())
//		{
//		case 1:
//			
//			// open local files and retrieve userList
//		
//			System.out.print("Enter your email: ");
//			email = scan.nextLine();
//			
//			User existingUser;
//			
//			for (User u : User.userList)
//			{
//				if (u.getEmail() == email)
//				{
//					existingUser = u;
//				}
//			}
//			
//			
//			
//			break;
//		
//		case 2:
//		
//			System.out.print("Who are you? Please choose from the manu: \n1) Park Manager\n2) Administrator\n3) Volunteer");
//			switch (scan.nextInt())
//			{
//			case 1:
//				System.out.print("Enter your email address: ");
//				email = scan.nextLine();
//				System.out.print("Enter your first name: ");
//				fname = scan.next();
//				System.out.print("Enter your last name: ");
//				lname = scan.next();
//				ParkManager p1 = new ParkManager(fname, lname, email);
//				
//				User.userList.add(p1);
//				
//				break;
//			case 2:
//				System.out.print("Enter your email address: ");
//				email = scan.nextLine();
//				System.out.print("Enter your first name: ");
//				fname = scan.next();
//				System.out.print("Enter your last name: ");
//				lname = scan.next();
//				Administrator a1 = new Administrator(fname, lname, email);
//				
//				User.userList.add(a1);
//				
//				break;
//			case 3:
//				System.out.print("Enter your email address: ");
//				email = scan.nextLine();
//				System.out.print("Enter your first name: ");
//				fname = scan.next();
//				System.out.print("Enter your last name: ");
//				lname = scan.next();
//				Volunteer v1 = new Volunteer(fname,lname, email);
//				
//				User.userList.add(v1);
//				
//				break;
//			}
//			
//			// store the userList locally
//			
//			break;
//		
//		}
		
		
//		
//		
//	}
//
//}
