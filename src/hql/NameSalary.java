package hql;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernateFirst.Employee;
import hibernateFirst.HibernateUtil;
/* SQL:select userName,usersalary from Employee where id=:inputId;
 *  how many rows? 1 row -> use uniqueResult()
 * how many columns? 2 columns (name, salaary)
 * what is the column datatype --> string + integer
 *  the return type of uniqueResult() method is Object[] array, where objec[0] 
 *  contains name object[1] contain ssalary */ 
public class NameSalary {
	public static void main(String[] args) {
		// get session obj
		Session sOj = HibernateUtil.getSessionFactory().openSession();
		int id = 2;
		// create query obj
		Query query = sOj.createQuery("select userName,usersalary from Employee where id=:inputId ");
		query.setParameter("inputId", id);
		Object[] data = (Object[])query.uniqueResult();
		String name = (String) data[0];
		// userName
		Integer sal = (Integer) data[1];
		// usersalary
		System.out.println(name);
		System.out.println(sal);
		// close sesion obj
		sOj.close();
	}
}
