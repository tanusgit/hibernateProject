package criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernateFirst.Employee;

public class Notes {
/*
 * we need criteria because there are 2 types of requirements.
 * requirements:
 * 1. query will not change for the same page , same query on the same page 
 * 2. query will change for the same page based on the input, different queries on the same 
 * page
 * For the requirement no 1 we can use hql always as query is static, all inputs
 * are mandatory
 * 
 * For the requirement no 2 use criteria as query is dynamic , all inputs are optional
 * 
 * example for requirement no 1:
 * search by id,  search by name,  search by salary, update, 
 * change password, delete by id, delete by name
 * 
 * example for requirement no 2:
 * query is generated  based on inputs, and inputs are optioanl.
 * 1.Search products 
   [filter by brand, price, color, gender, size, discount]
   [filter by brand, price, color , gender ,size , discount]
   filter by brand -> select * from product where brand ='hrx'
   filter by brand, price ->select * from product where brand ='hrx' and price <20000
   filter by brand, price, color ->select * from product where brand ='hrx' and price <20000 and color ='red'
   filter by brand, price, color , size ->select * from product where brand ='hrx' and price <20000 and color ='red' and size='38'
  2. search buses:
		mandatory : from and to + date
    optioanl:
       [1.bus type ac/non-ac
        2.pickup area 
        3.drop area
        4.sleeper / semi-sleeper
       ]

//criteria is mostly for select  dynamic queries

1. sessions fac
2.session
3.Create criteria obj
4.apply the restriction/filter
5.for multi rows call list()
  for single row call uniqueresult()
    
6.close session    



-----------------------------------------------------------

public static void main(String[] args) {
		//Session s = HibernateUtil.getSessionFactory().openSession();
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Criteria cr = s.createCriteria(Employee.class);
		//cr.add(Restrictions.eq("usersalary", 5000));
		// To get records having salary more than 2000
		//cr.add(Restrictions.gt("usersalary", 2000));

		// To get records having salary less than 2000
		//cr.add(Restrictions.lt("usersalary", 9000));

		// To get records having fistName starting with zara
		//cr.add(Restrictions.like("userName", "Andrew%"));

		// Case sensitive form of the above restriction.
		//cr.add(Restrictions.ilike("userName", "andrew%"));

		// To get records having salary in between 1000 and 2000
		//cr.add(Restrictions.between("usersalary", 5000, 10000));

		// To check if the given property is null
		//cr.add(Restrictions.isNull("usersalary"));

		// To check if the given property is not null
		//cr.add(Restrictions.isNotNull("usersalary"));

		// To check if the given property is empty
		//cr.add(Restrictions.isEmpty("usersalary"));

		// To check if the given property is not empty
		//cr.add(Restrictions.isNotEmpty("usersalary"));
		//List<Employee> employees = cr.list();
		//-----------------------------------------------------//
		//another part of logical expression
		//Criterion salary = Restrictions.gt("usersalary", 2000);
		//Criterion name = Restrictions.ilike("userName","andrew%");
		
		
		// To get records matching with OR conditions
		//LogicalExpression orExp = Restrictions.or(salary, name);
		//cr.add( orExp );

		// To get records matching with AND conditions
		//LogicalExpression andExp = Restrictions.and(salary, name);
		//cr.add( andExp );
		//----------------------------------------------//
		//This method takes an integer that represents
		//the first row in your result set, starting with row 0.
		//cr.setFirstResult(1);
		//This method tells Hibernate to retrieve a fixed number maxResults of objects.
		//cr.setMaxResults(5);
		//------------------------------------------------------//
		//to sort the results: 
		//The Criteria API provides the org.hibernate.criterion.Order class to sort
		//your result set
		//in either ascending or descending order, according to one of your object's 
		//properties.
		// To sort records in descening order
		//cr.addOrder(Order.desc("usersalary"));

		// To sort records in ascending order
		//cr.addOrder(Order.asc("usersalary"));
		
		//-----------------------------------------------------------------//
		//The Criteria API provides the org.hibernate.criterion.Projections class,
		//which can be used to get average, maximum, or minimum of the property values.
		//The Projections class is similar to the Restrictions class, in that it
		//provides several static factory methods for obtaining Projection instances.

		// To get total row count.
		//cr.setProjection(Projections.rowCount());

		// To get average of a property.
		//cr.setProjection(Projections.avg("usersalary"));

		// To get distinct count of a property.
		//cr.setProjection(Projections.countDistinct("userName"));

		// To get maximum of a property.
		//cr.setProjection(Projections.max("usersalary"));

		// To get minimum of a property.
		//cr.setProjection(Projections.min("usersalary"));

		// To get sum of a property.
		//cr.setProjection(Projections.sum("usersalary"));
		 
		 
		 //name = 'krishna' or name is null 
		  * 
		  cr.add(Restrictions.eqOrIsNull("userName","Tanu")); 
		
		List res = cr.list();
		for (Object n : res) {
			System.out.println(n);
		}
		s.close();
		
		
		---------------------------------------------------
		import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

//orderby ,username, minsal, max sal are optional
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String name="";
		String salOrderBy = "";
		String userNameLike="testuser7";
		int minSal=5575;
		int maxSal=6000;

		Criteria empCriteria = session.createCriteria(Employee.class);

		if("asc".equals(salOrderBy) ){
			empCriteria.addOrder(Order.asc("usersalary"));
		}else if("desc".equals(salOrderBy) ){
			empCriteria.addOrder(Order.desc("usersalary"));
		}
		
		if(userNameLike!=null  && !userNameLike.equals("") ){
			empCriteria.add(Restrictions.like("userName", "%"+userNameLike+"%"));
		}
		
		if(name!=null  && !name.equals("") ){
			empCriteria.add(Restrictions.eq("userName", name));
		}
		
		if (minSal != 0 && maxSal!=0) {
			empCriteria.add(Restrictions.between("usersalary", minSal, maxSal));
		}
		List<Employee> employees = empCriteria.list();
		for(Employee e  : employees){
			System.out.println(e);
		}
		session.close();
	}
	
	---------------------------------
	empCriteria.addOrder(Order.asc("usersalary")); 
	//name = 'krishna' empCriteria.add(Restrictions.eq("userName", "krishna"));
	 *  // name like '%kumar%' 
	 *  empCriteria.add(Restrictions.like("userName", "kumar")); 
	 *  // salaryInfo between (5000, 10000) 
	 *  empCriteria.add(Restrictions.between("usersalary",5000 , 10000));
	 *   //name = 'krishna' or name is null 
	 *   empCriteria.add(Restrictions.eqOrIsNull("userName","krishna")); 
	 *   //Id = 2000 
	 *   empCriteria.add(Restrictions.idEq("2000")); 
	 *   List<Employee> list = empCriteria.list(); 
	 *   System.out.println(list.size()); 
	 *   for (Employee e : list) 
	 *   { System.out.println(e); } 
	 *   s.close(); } 
	 *   
	 *   
	 *   //salaryInfo > 10000
		empCriteria.add(Restrictions.gt("usersalary", 10000));
		
		//salaryInfo >= 10000
		empCriteria.add(Restrictions.ge("usersalary", 10000));
		
		//salaryInfo < 10000
		empCriteria.add(Restrictions.lt("usersalary", 10000));
		
		//salaryInfo <= 10000
		empCriteria.add(Restrictions.le("usersalary", 10000));
		
		//Join conditions 
		//name = 'krishna'
		Criterion nameCondition = Restrictions.like("userName","krishna");

		//salaryInfo < 5000
		Criterion salaryCondition = Restrictions.lt("usersalary", 5000);
		
		//name = 'krishna' or  salaryInfo < 5000
		LogicalExpression joinOr = Restrictions.or(salaryCondition, nameCondition);
		empCriteria.add( joinOr );

		//name = 'krishna' and  salaryInfo < 5000
		LogicalExpression joinAnd = Restrictions.and(salaryCondition, nameCondition);
		empCriteria.add( joinAnd );

 //Projections : meant to include selected columns in the response
		//get paricular column
		empCriteria.setProjection(Projections.property("userName"));  
		
		empCriteria.add(Restrictions.in("userName", 
				Arrays.asList("krishna", "ram", "ramesh")))
	    .add(Restrictions.lt("usersalary", 5000))
	    .add(Restrictions.gt("usersalary", 10000))
	    .add(Restrictions.eqOrIsNull("userName", "krishna"))
	    .add(Restrictions.idEq("2000"))
	    .list();
	    -------------------------------------------------------------
	    
	    
	    
	    
	    -------------------------------------------------------------
	    public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Criteria empCriteria = s.createCriteria(Employee.class);

		//order by salaryinfo
		empCriteria.addOrder(Order.asc("usersalary"));

		//name = 'krishna'
		empCriteria.add(Restrictions.eq("userName", "krishna"));

		// name like '%kumar%'
		empCriteria.add(Restrictions.like("userName", "%kumar%"));

		// salaryInfo between (5000, 10000)
		empCriteria.add(Restrictions.between("usersalary", 5000, 10000));

		// name = 'krishna' or name is null
		empCriteria.add(Restrictions.eqOrIsNull("userName", "krishna"));

		// Id = 2000
		empCriteria.add(Restrictions.idEq("2000"));

		// name = 'krishna' or name = 'ram' or name = 'ramesh'
		empCriteria.add(Restrictions.in("userName", 
				Arrays.asList("krishna", "ram", "ramesh")));
		
		//name = ''
		empCriteria.add(Restrictions.isEmpty("userName"));
		
		//name != ''
		empCriteria.add(Restrictions.isNotEmpty("userName"));

		// name is NULL
		empCriteria.add(Restrictions.isNull("userName"));
		
		//name is NOT NULL
		empCriteria.add(Restrictions.isNotNull("userName"));
		
		//salaryInfo > 10000
		empCriteria.add(Restrictions.gt("usersalary", 10000));
		
		//salaryInfo >= 10000
		empCriteria.add(Restrictions.ge("usersalary", 10000));
		
		//salaryInfo < 10000
		empCriteria.add(Restrictions.lt("usersalary", 10000));
		
		//salaryInfo <= 10000
		empCriteria.add(Restrictions.le("usersalary", 10000));
  
  
		//Join conditions 
		//name = 'krishna'
		Criterion nameCondition = Restrictions.like("userName","krishna");

		//salaryInfo < 5000
		Criterion salaryCondition = Restrictions.lt("usersalary", 5000);
		
		//name = 'krishna' or  salaryInfo < 5000
		LogicalExpression joinOr = Restrictions.or(salaryCondition, nameCondition);
		empCriteria.add( joinOr );

		//name = 'krishna' and  salaryInfo < 5000
		LogicalExpression joinAnd = Restrictions.and(salaryCondition, nameCondition);
		empCriteria.add( joinAnd );

		
  
    //Projections : meant to include selected columns in the response
		//get paricular column
		empCriteria.setProjection(Projections.property("userName"));  
  
  			
		// To get maximum usersalary.
		empCriteria.setProjection(Projections.max("usersalary"));

		// To get minimum usersalary
		empCriteria.setProjection(Projections.min("usersalary"));

		// To get sum of usersalary
		empCriteria.setProjection(Projections.sum("usersalary"));
  
  // To get average usersalary
		empCriteria.setProjection(Projections.avg("usersalary"));
		
		// To get total count
		empCriteria.setProjection(Projections.rowCount());

  // join conditions 
		empCriteria.add(Restrictions.in("userName", 
				Arrays.asList("krishna", "ram", "ramesh")))
	    .add(Restrictions.lt("usersalary", 5000))
	    .add(Restrictions.gt("usersalary", 10000))
	    .add(Restrictions.eqOrIsNull("userName", "krishna"))
	    .add(Restrictions.idEq("2000"));
	    
		
		List<Employee> list = empCriteria.list();
		System.out.println(list.size());
		for (Employee e : list) {
			System.out.println(e);
		}
		s.close();
	}

  */
}
