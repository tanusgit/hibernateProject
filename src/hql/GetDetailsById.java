package hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernateFirst.Employee;
import hibernateFirst.HibernateUtil;

public class GetDetailsById {
	/*
	public static void main(String[] args) {
		// get name for a given empid
		Session sessionObj = HibernateUtil.getSessionFactory().openSession();
		Query query = sessionObj.createQuery(" from Employee where Id=4");
		Employee emp = (Employee) query.uniqueResult();
		System.out.println(emp);
		sessionObj.close();

	}
}
*/
//approach 2

public static void main(String[] args) {
	  
	// get name for a given empid
			Session sessionObj = HibernateUtil.getSessionFactory().openSession();
			int id = 2;
			Query query = sessionObj
					.createQuery(" from Employee where Id=:inputEmpId");
			//replacing inputEmpId with id
			//inputEmpId can be anything, it is just a place holder
			query.setParameter("inputEmpId", id);
			Employee emp = (Employee) query.uniqueResult();
			System.out.println(emp);
			sessionObj.close();
	  
	  
	}
}