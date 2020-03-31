package hibernateFirst;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class TestUpdate {
public static void main(String[] args) {
	/*
	 *get session factory
	 get session object
	 create entity object with data for existing table
	 get the transaction object
	 call session.update()
	 pass the entity object in the update()
	 commit transaction
	 close the session
	 
	 */
	
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		// 3.read inputs
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name::");
		String name = sc.next();

		System.out.println("Enter sal::");
		int sal = sc.nextInt();

		// create emp obj
		System.out.println("enter id");
		int id = sc.nextInt();

		Employee emp = new Employee(id, name, sal);

		// perform update operation
		session.getTransaction().begin();
		session.update(emp); 
		session.getTransaction().commit();
		session.close();
	}
}

