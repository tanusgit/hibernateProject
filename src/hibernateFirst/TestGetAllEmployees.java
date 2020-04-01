package hibernateFirst;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class TestGetAllEmployees {
	public static void main(String[] args) {

		// get all employees in table
		Session sessionObj = HibernateUtil.getSessionFactory().openSession();
		// create query objecet
		Query query = sessionObj.createQuery("from Employee");

		// call list() method as we need to retrieve multiple rows
		// hibernate converts every row to employee object
		// every employee obj is added to the arrylist.
		List<Employee> list = query.list();

		// use for loop to show all emps
		for (Employee e : list) {
			System.out.println(e);
		}

		// close session
		sessionObj.close();

	}
}
