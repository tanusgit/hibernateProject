package hibernateFirst;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernateFirst.Employee;

public class GetEmployeeCache {

	// Ge Employee By Id
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		System.out.println("*******SESSION1 OPNED********");
		int id = 46;

		System.out.println("****call load method ****");
		Employee emp = (Employee) session.load(Employee.class, id);
		// fetches from the database and keeps inside cache
		System.out.println(emp);

		System.out.println("****call load method ****");
		Employee emp1 = (Employee) session.load(Employee.class, id);
		// fetches from cache
		System.out.println(emp1);

		session.close();// Cache is cleared

		System.out.println("*******SESSION1 CLOSED********");
		Session session2 = sf.openSession();

		System.out.println("*******SESSION2 OPNED********");

		System.out.println("****call load method ****");
		Employee emp3 = (Employee) session2.load(Employee.class, id); // cache is populated , db all
		System.out.println(emp3);

		System.out.println("****call load method ****");
		Employee emp4 = (Employee) session2.load(Employee.class, id);// no db call , get from cache
		System.out.println(emp4);

		session2.close(); // Cache is cleared
		System.out.println("*******SESSION2 CLOSED********");

	}

}
