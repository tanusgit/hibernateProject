package namedQuery;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import hibernateFirst.Employee;
import hibernateFirst.HibernateUtil;

public class NamedQueryAllNames {
	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		// Query listQuery = s.createQuery("select userName from Employee");
		Query listQuery = s.getNamedQuery("getEmpNames");
		List<String> names = (List<String>) listQuery.list();
		for (String name : names) {
			System.out.println(name);
		}
	}
}
