package hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernateFirst.HibernateUtil;

public class GetAllEmployeeNames {
	public static void main(String[] args) {

		// get all employees in table
		Session sessionObj = HibernateUtil.getSessionFactory().openSession();
		// create query objecet
		Query query = sessionObj.createQuery("select userName from Employee");

		// call list() method as we need to retrieve multiple rows
		// hibernate converts every row to employee object
		// every employee obj is added to the arrylist.
		List<String> names = query.list();

		// use for loop to show all emps
		for (String name : names) {
			System.out.println(name);
		}

		// close session
		sessionObj.close();

	}
}
