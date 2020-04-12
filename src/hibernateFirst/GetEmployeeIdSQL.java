package hibernateFirst;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class GetEmployeeIdSQL {
	//2.Get by id
	//SELECT * FROM EMPLOYEEDETAILS WHERE userid = 11
	  
	public static void main(String[] args) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			String sql = "SELECT * FROM EmployeeDetails WHERE userid = :id";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Employee.class);
			query.setParameter("id", 1);
			Employee emp = (Employee)query.uniqueResult();
			System.out.println(emp);
			session.close();
		}
}
