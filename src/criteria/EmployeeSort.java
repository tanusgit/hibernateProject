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
public class EmployeeSort {
public static void main(String[] args) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	//input can be Id , userName , usersalary
	String orderParm = "usersalary";
	String orderBy = "desc";
	Criteria empCriteria = session.createCriteria(Employee.class);
	//empCriteria.add(Restrictions.between("usersalary", 5000, 10000));
	int minSal = 0;
	int maxSal = 0;
	
	if (minSal != 0 && maxSal != 0) {
		empCriteria.add(Restrictions.between("usersalary", minSal, maxSal));
	}

	if(!orderParm.equals(""))
	{
		if ("asc".equals(orderBy)) {
			empCriteria.addOrder(Order.asc(orderParm));
		} else if ("desc".equals(orderBy)) {
			empCriteria.addOrder(Order.desc(orderParm));
		}
	}
	List<Employee> employees = empCriteria.list();
	for(Employee e  : employees){
		System.out.println(e);
	}
	session.close();

	}
}

