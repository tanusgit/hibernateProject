package hibernateFirst;

import org.hibernate.Session;

public class Save2Employee {
	public static void main(String[] args) {
		//transcations on the detached obj
		Session s1 = HibernateUtil.getSessionFactory().openSession();
		Employee e = new Employee();
		s1.getTransaction().begin();
		e.setUserName("krishna7");
		s1.saveOrUpdate(e);//state wil change to persistence
		e.setUserName("krishna8");
		s1.getTransaction().commit();
		s1.close();//state changes to detached
	}
	
	  
}
