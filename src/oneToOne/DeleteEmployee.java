package oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernateFirst.Employee;
import hibernateFirst.HibernateUtil;
//not working
public class DeleteEmployee {
	public static void main(String[] args) {
		SessionFactory sF = HibernateUtil.getSessionFactory();
		Session s = sF.openSession();
		EmployeeWithAddress emp = new EmployeeWithAddress();
		emp.setId(2);
		
		
		s.getTransaction().begin();
		s.delete(emp);  //1 row created in employee table  + 1 row is inserted in address table
		s.getTransaction().commit();
		s.close();
		System.out.println(emp);
	}

}
