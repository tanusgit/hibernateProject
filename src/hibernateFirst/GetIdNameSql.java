package hibernateFirst;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class GetIdNameSql {
	// 3.Get id,name from employe

	// SELECT userid,name FROM EMPLOYEEDETAILS

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String sql = "SELECT userid,name FROM EmployeeDetails";
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List rows = query.list();

		for (Object object : rows) {
			Map row = (Map) object;
			System.out.print("USERID : " + row.get("userId"));
			System.out.println(" , NAME : " + row.get("name"));
		}
		session.close();
	}
}
