package hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernateFirst.HibernateUtil;

public class GetEmployeeSalary {
	public static void main(String[] args) {

		// get all employees in table
		Session sessionObj = HibernateUtil.getSessionFactory().openSession();
		// create query objecet
		Query query = sessionObj.createQuery("select usersalary from Employee");

		// call list() method as we need to retrieve multiple rows
		// hibernate converts every row to employee object
		// every employee obj is added to the arrylist.
		List<Integer> salaries = query.list();

		// use for loop to show all emps
		for (Integer salary : salaries) {
			System.out.println(salary);
		}

		// close session
		sessionObj.close();

	}
}
