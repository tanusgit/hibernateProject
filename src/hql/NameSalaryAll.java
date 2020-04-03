package hql;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernateFirst.Employee;
import hibernateFirst.HibernateUtil;
/* SQL: select userName,usersalary from Employee
how many rows? multi row -> use list()
how many columns in every row? 2 columns (name, salaary)
what is the column datatype --> string + integer
the return type of list() method is List of Object[] array, 
every row is converted to Object[] where objec[0] contains name object[1] 
contain salary */ 
public class NameSalaryAll {
	public static void main(String[] args) {
		// get session obj
		Session sOj = HibernateUtil.getSessionFactory().openSession(); 
		// create query obj 
		Query query = sOj .createQuery("select userName,usersalary from Employee"); 
		List<Object[]> list = (List<Object[]>) query.list();
		for (Object[] data : list) 
		{ String name = (String) data[0]; 
		// userName 
		Integer sal = (Integer) data[1];
		// usersalary 
		System.out.println(name + " - " + sal); }
		// close sesion obj 
		sOj.close();
		}
	}

