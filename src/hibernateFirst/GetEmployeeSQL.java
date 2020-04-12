package hibernateFirst;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class GetEmployeeSQL {
	//1.Get all employees
	//SELECT * FROM EMPLOYEEDETAILS

	public static void main(String[] args) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			String sql = "SELECT * FROM EmployeeDetails";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Employee.class);// USED BY Hiberante for mapping
			List<Employee> results = query.list();// db call and hiberante stores 
			//the db data inside the list
			System.out.println(results);
			session.close();
		}
}
