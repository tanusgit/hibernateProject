package hibernatePractice;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import hibernateFirst.HibernateUtil;


public class SomQeueries {
public static void main(String[] args) {
	//print2000Salary();
	Session s = HibernateUtil.getSessionFactory().openSession();
	Criteria cr = s.createCriteria(EmployeeNamedQuery.class);
	cr.add(Restrictions.eq("salary", 2000));
	List results = cr.list();
	for(Object n : results) {
		System.out.println(n);
	}
}

public static void print2000Salary() {
	Session s = HibernateUtil.getSessionFactory().openSession();
	Criteria cr = s.createCriteria(EmployeeNamedQuery.class);
	cr.add(Restrictions.eq("salary", 2000));
	List results = cr.list();
	for(Object n : results) {
		System.out.println(n);
	}
}
}
