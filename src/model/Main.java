package model;

import java.text.ParseException;

public class Main {

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
	
