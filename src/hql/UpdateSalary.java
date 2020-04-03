package hql;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernateFirst.Employee;
import hibernateFirst.HibernateUtil;
public class UpdateSalary {
	public static void main(String[] args) {
		Session  sObj = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = sObj.getTransaction();
		
		transaction.begin();
		Query  q = sObj.createQuery("update Employee set usersalary=usersalary+5000 ");
		int res = q.executeUpdate();
		transaction.commit();
		
		
		if(res >=1){
			System.out.println("update succesful");
		}else{
			System.out.println("update fail");
		}
		sObj.close();
	}

}
