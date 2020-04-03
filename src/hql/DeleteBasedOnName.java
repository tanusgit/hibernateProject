package hql;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernateFirst.Employee;
import hibernateFirst.HibernateUtil;

public class DeleteBasedOnName {
	public static void main(String[] args) {
		Session sObj = HibernateUtil.getSessionFactory().openSession();
		String name = "Lina";
		Transaction transaction = sObj.getTransaction();
		transaction.begin();
		Query q = sObj.createQuery("delete from Employee where userName=:myName");
		q.setParameter("myName", name);
		int res = q.executeUpdate();
		transaction.commit();
		if (res >= 1) {
			System.out.println("delete succesful");
		} else {
			System.out.println("delet fail");
		}
		sObj.close();
	}
}

