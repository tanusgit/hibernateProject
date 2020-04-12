package tableperclass;
/*
 * 1.create sf
2.create session
3.create persn obj with data
4.create employee obj with data
5.create student obj with data
6.save person    -> 1 row in Person2
7.save employee   -> 1 row in Employee2 
8.save student   -> 1 row in Student2
 */
import org.hibernate.Session;

import hibernateFirst.HibernateUtil;

public class Insert {

	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.getTransaction().begin();
		Person2 p = new Person2();
		p.setAge(23);
		p.setUserName("per2");
//cannot save 2 employee at the same time thats why commented s.save(p)
//as it is already there and name must be unique as the person class defined
//that way
	//	s.save(p);
		
		Person2 p1 = new Person2();
		p1.setAge(24);
		p1.setUserName("per3");

		s.save(p1);

		Employee2 emp = new Employee2();
		emp.setAge(24);
		emp.setUserName("emp2");
		emp.setProjId("pro123");
		emp.setDeptId("dept11");

		//s.save(emp);

		Student2 st = new Student2();
		st.setAge(25);
		st.setUserName("stu2");
		st.setBranchId("csc");
		st.setSemId("4");

	//	s.save(st);

		s.getTransaction().commit();
		s.close();

	}
}
