package hql;

import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernateFirst.Employee;
import hibernateFirst.HibernateUtil;

public class InsertEmployee {
	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter name");
		String name = sc.next();
		//no need to take id as an input as id is auto generated in the Employee class
		//System.out.println("enter id");
		//int id = sc.nextInt();
		System.out.println("enter salary"); 
		int salary = sc.nextInt();
		
		Employee m = new Employee();
		//m.setId(id);
		m.setUserName(name);
		m.setUsersalary(salary);
		
		Transaction transaction = s.getTransaction();
		transaction.begin();
		s.save(m);
		
		transaction.commit();
		
		s.close();
	
	}
	

}
