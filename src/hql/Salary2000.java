package hql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import hibernateFirst.HibernateUtil;
import hibernatePractice.Employee;

public class Salary2000 {
	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(Employee.class);
		cr.add(Restrictions.gt("salary", 2000));
		List results = cr.list();
		for (Object n : results) {
			System.out.println(n);
		}
		s.close();
	}
}
