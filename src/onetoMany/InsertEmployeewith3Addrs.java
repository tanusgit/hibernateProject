package onetoMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import hibernateFirst.HibernateUtil;
public class InsertEmployeewith3Addrs {
/*1.Insert with cascade: (1 customer with 3 accounts)
---------------------------------------------
1.session factory
2.session
3.create customer obj with data
4.create 3 accounts objs with data
5.keep all the accounts objs inside the customer obj
6.save customer obj     -----> 1 row is inserted in customer table and 3 rows are inserted in accounts table.
7.close session.
 * 
 */
	public static void main(String[] args) {
	 	// cascade value is all, persist
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.getTransaction().begin();

    //create customer obj
		Customer cust1 = new Customer("John", 25);
  
   //create 3 accounts objs
		Accounts a1 = new Accounts("savings", "John savings desc", cust1);
		Accounts a2 = new Accounts("current", "John vcurrent desc", cust1);
		Accounts a3 = new Accounts("loan", "John loan desc", cust1);

		//add accounts inside customer
		List<Accounts> accounts = new ArrayList<Accounts>();
		accounts.add(a1);
		accounts.add(a2);
		accounts.add(a3);
		cust1.setAccounts(accounts);
  
   // save customer obj
		s.save(cust1); //-----> 1 row is inserted in customer table and 3 rows are inserted in accounts table.

		s.getTransaction().commit();
		s.close();
	} 
}
