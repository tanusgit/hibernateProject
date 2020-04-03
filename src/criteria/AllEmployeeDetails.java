package criteria;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernateFirst.Employee;
import hibernateFirst.HibernateUtil;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class AllEmployeeDetails {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();

		//Session s = HibernateUtil.getSessionFactory().openSession();
		Criteria empCriteria = s.createCriteria(Employee.class);
		List<Employee> employees = empCriteria.list();
		for (Employee e : employees) {
			System.out.println(e);
		}
		s.close();
	}

}
