package hibernateFirst;

import org.hibernate.Session;

public class SaveEmployee {
	//save the employee
	  public static void main(String[] args) {
			Session s = HibernateUtil.getSessionFactory().openSession();
			s.getTransaction().begin();
			//Transiant state
			Employee e = new Employee();
			e.setUserName("krishna1");
			e.setUsersalary(11111);
			
			s.save(e);	//state changes to persistance state. triggers insert query
			
			e.setUserName("krishna2");//change the obj value during persistenc state
			s.getTransaction().commit(); // one insert query + 1 update query 
			
			s.close();//state changes to detached
		}
}
