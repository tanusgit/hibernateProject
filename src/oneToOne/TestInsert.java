package oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestInsert {
	/* 1.Approach1 with cascade @OneToOne(cascade=CascadeType.ALL,fetch= FetchType.LAZY)  in  EmployeeWithAddress
	    - create sf
	    - create session obj
	    - create emp and address objs
	    - keep addres sobj inside emp obj
	    - save only emp object using transaction obj.  
	    ( 1 row created in EmployeeWithAddress table and one row 
	    is created in AddressDetails tab;e)*/
	  public static void main(String[] args) {
	  
	 //create session factory
			SessionFactory sf = 	 new Configuration().configure().buildSessionFactory();

			//create session obj
			Session s = sf.openSession();
			
			// create address obj with data
			AddressDetails add = new AddressDetails();
			add.setCity("Hyd");
			add.setCountry("INDIA");
			add.setPin(123456);
			add.setState("TS1");
			add.setStreetNo("YUSAF GUDA12");
			
		 	// create emp obj with data
			EmployeeWithAddress emp = new EmployeeWithAddress();
			emp.setAge(34);
			emp.setName("krishna kumar12");

			// keep address obj inside emp
			emp.setCurAddress(add);

			//save employee obj
			s.getTransaction().begin();
			s.save(emp);  //1 row created in employee table  + 1 row is inserted in address table
			s.getTransaction().commit();

			s.close();
		
	  }
}
