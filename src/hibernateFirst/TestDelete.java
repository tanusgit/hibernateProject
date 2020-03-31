package hibernateFirst;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
public class TestDelete {
/*delete is for deleting the row
 * get session factory
	 get session object
	 create entity object with data for existing table
	 get the transaction object by calling transaction().begin() on the session object
	 call session object.delete()
	 pass the entity object in the delete()
	 commit transaction
	 close the session
 * 
 */
	public static void main(String[] args) {
		SessionFactory sF = HibernateUtil.getSessionFactory();
		Session s = sF.openSession();

		// create emp obj
		//delete and update only happen based on the id
		String name = "xyz";
		int id = 1;
		Employee emp = new Employee(id, name);
		
		//perform update operation
		s.getTransaction().begin();
		s.delete(emp);// update only if it is chnaged
		s.getTransaction().commit();
		s.close();
	
	}
}
