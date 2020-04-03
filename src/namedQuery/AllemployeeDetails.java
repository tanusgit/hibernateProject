package namedQuery;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import hibernateFirst.Employee;
import hibernateFirst.HibernateUtil;

public class AllemployeeDetails {
	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();

		// Query listEmps = s.createQuery(" from Employee");
		Query listEmps = s.getNamedQuery("getALLEmps");
		List<Employee> emps = (List<Employee>) listEmps.list();
		for (Employee emp : emps) {
			System.out.println(emp);
		}
		s.close();
	}
}
