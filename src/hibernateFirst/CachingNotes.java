package hibernateFirst;

public class CachingNotes{
/*
 * package caching;

public class Notes {
/*Caching:
-----------------
 Hibernate supports the caching mechanism.
adv:
-> faster response Time
-> Reduce load on database

-> applicable only for Read queries.
  
Cache -> is a area/memory fo temporary db storage.
Cache is managed by hibernate.  
  
without cache :
-------------
1.Any fetch call makes a call to DB

With Caching:
--------------
1.1st fetch from the   Cache 
2.If Found dont make the db call
3.If not Found make the db call.
  
Who will keep the data or delete the data from cache:  Hiberante  

Hibernate suppots two types of caching:
1.Level-1  (session obj level)
2.Level-2  (session factoy level)   , instaed we will use other external 
cache providers . EX: Redus, Nosql ...

  Level-1: By deafult hiberante  supports level1

//Ge Employee By Id
public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		System.out.println("*******SESSION1 OPNED********");
		int id = 46;

		System.out.println("****call load method ****");
		Employee emp = (Employee) session.load(Employee.class, id);
		// fetches from the database and keeps inside cache
		System.out.println(emp);

		System.out.println("****call load method ****");
		Employee emp1 = (Employee) session.load(Employee.class, id);
		// fetches from cache
		System.out.println(emp1);

		session.close();
    }

  
 * 
 */
}
