package hibernateFirst;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
public class GetEmployeebyId {
/*
 * 	get session factory
	 get session object
	 create entity object with data for existing table
	Employee emp = (Employee) session.get(Employee.class, 1); // 1 is the primary key 
	OR
	Employee emp = (Employee) session.load(Employee.class, 2); // 2 is the primary key 
	 close the session
 */
	public static void main(String[] args) {
		// 1 +2 
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
	
		//take input
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id::");
		int id =sc.nextInt();

		//approach 1get employee whose primary key id value = id
		Employee emp = (Employee) session.load(Employee.class, id);
		
		if(emp==null){
    System.out.println("invalid id");
  }else{
  System.out.println(emp);  
  }
		//approach 2
		//get() will only work on the primary key
		Employee emp1 = (Employee) session.get(Employee.class, id);
		System.out.println(emp1);
		
		session.close();
}
	
}
