package oneToOne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import hibernateFirst.HibernateUtil;
public class ReadbyId {
	/*Read by id 
    - create sf
    - create session obj
    - use load method to fetch the EmployeeWithAddress obj
    - EmployeeWithAddress internally has address obj also.
    - load method fetches the employee details + address 
    	details based on fetch configuration.
    - close session*/
    public static void main(String[] args) {
    	Session s = HibernateUtil.getSessionFactory().openSession();
		EmployeeWithAddress emp = (EmployeeWithAddress) 
				s.load(EmployeeWithAddress.class, 1);// 1st query
		System.out.println(emp);
		//if the code 	emp.getCurAddress() is called after 
		//closing the session then we will get 
		//org.hibernate.LazyInitializationException
		//emp.getCurAddress() -> makes a db call ; and db call
		//happen before closing the session.
		System.out.println(emp.getCurAddress());//2nd query
		s.close();
		System.out.println(emp);
		System.out.println(emp.getCurAddress());
	}
  
}
