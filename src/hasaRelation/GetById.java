package hasaRelation;

import org.hibernate.Session;

import hibernateFirst.HibernateUtil;

public class GetById {
	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();

		PersonWithAddress person = (PersonWithAddress)s.load(PersonWithAddress.class, 1);
		System.out.println(person);
		
		Address curAddress = person.getCurAddress();
		curAddress.displayAddress();
		s.close();
	}
}
