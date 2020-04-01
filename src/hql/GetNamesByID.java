package hql;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernateFirst.Employee;
import hibernateFirst.HibernateUtil;
/*
 * 
SQL: SELECT NAME FROM EMPLOYEE WHERE ID=90
how many rows? 1 row     -> use uniqueResult()
how many columns? 1 column  (name)
what is the column datatype --> string
the return type of uniqueResult() method is integer

//get salary based on id
//get salary based on name
//get emp names whose salary >5000
//get employee name who has max salary
//get employee name who has min salary
 * 
 * //print minimum salary

//delete emp by id
//delete emp by name

//update name of employee based on id
//update salary of every employee; add 5000 for every employee

 */
public class GetNamesByID {
	public static void main(String[] args) {
		// get name for a given empid
		Session sessionObj = HibernateUtil.getSessionFactory().openSession();
		int id = 3;
		Query query = sessionObj.createQuery("select userName from Employee where Id=:inputEmpId");
		query.setParameter("inputEmpId", id);
		String userName = (String) query.uniqueResult();
		System.out.println(userName);
		sessionObj.close();
	}
}
