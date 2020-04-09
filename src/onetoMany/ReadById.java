package onetoMany;

//read customer details and also the account info
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import hibernateFirst.HibernateUtil;

public class ReadById {
	public static void main(String[] args) {
		Session s1 = HibernateUtil.getSessionFactory().openSession();

		Customer c = (Customer) s1.load(Customer.class, 1);// hit db for fetching customer details
		System.out.println(c.getCustomerName());
		System.out.println(c.getAccounts());// hit db for fetching account details.
		s1.close();

		List<Accounts> accounts = c.getAccounts();
		for (Accounts acc : accounts) {
			System.out.println(acc);
		}
	}
}
