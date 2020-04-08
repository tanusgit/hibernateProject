package oneToOne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class TestInsertWithoutCascade {
	/*2.Approach2 without cascade  ( save seperatrely) 
    - create sf
    - create session obj
    - create emp and address objs
    - save the address obj using transaction obj.
    (1 row is created in AddressDetails table)
    - keep addres sobj inside emp obj
    - save  emp object using transaction obj.    
    ( 1 row created in EmployeeWithAddress table     )
   */
   public static void main(String[] args) {

		//create session factory
		SessionFactory sf = 	 new Configuration().configure().buildSessionFactory();

		//create session obj
		Session s = sf.openSession();
		
		// create address obj with data
		AddressDetails add = new AddressDetails();
		add.setCity("Hyd");
		add.setCountry("IN");
		add.setPin(12345);
		add.setState("TS");
		add.setStreetNo("YUSAF GUDA");
		
		// save the address obj
		s.getTransaction().begin();
		s.save(add);
		s.getTransaction().commit();

		// create emp obj with data
		EmployeeWithAddress emp = new EmployeeWithAddress();
		emp.setAge(34);
		emp.setName("krishna kumar");

		// keep address obj inside emp
		emp.setCurAddress(add);

		//save employee obj
		s.getTransaction().begin();
		s.save(emp);
		s.getTransaction().commit();

		s.close();
 }
   
}
