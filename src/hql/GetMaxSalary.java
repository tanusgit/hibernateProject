package hql;
//SQL: SELECT max(salary) FROM EMPLOYEE 
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernateFirst.Employee;
import hibernateFirst.HibernateUtil;
public class GetMaxSalary {
	public static void main(String[] args) {
		  // get session obj
				Session sOj = HibernateUtil.getSessionFactory().openSession();

				// create query obj
				Query query = sOj.createQuery("select max(usersalary) from Employee");
				Integer maxSal = (Integer) query.uniqueResult();
				System.out.println(maxSal);

				// close sesion obj
				sOj.close();
		}

}
