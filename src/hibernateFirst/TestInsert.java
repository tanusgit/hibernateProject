package hibernateFirst;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TestInsert {
	public static void main(String[] args) {
//create the session factory
//create session object
//create entity object
//open transaction
//call the session.save() by passing entity object as an argument
//commit the transaction
//close the session

			// 1.create sf obj
			SessionFactory sf = HibernateUtil.getSessionFactory();

			// 2.crate session obj
			Session sessionObj = sf.openSession();

			// 3.read inputs
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter name::");
			String name = sc.next();

			System.out.println("Enter sal::");
			int sal = sc.nextInt();

			// 4.create entity obj with data
			Employee empObj = new Employee();
			empObj.setUserName(name);
			empObj.setUsersalary(sal);

			// open txn
			// 5.create transaction obj
			Transaction transaction = sessionObj.getTransaction();
			transaction.begin();
			sessionObj.save(empObj);
			transaction.commit();

			//6.close session
			System.out.println("data saved");
			sessionObj.close();

		}
	}

