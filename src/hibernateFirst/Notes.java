package hibernateFirst;

public class Notes {
/*
 * hibernate is a open source framework.

Framework: external library that contains the pre-written code for 
the solutions for most of the common problems in the project.
Hibernate is available in the form of jar files.
In a java project we need to import the hibernate jar files.
  
Advantages :
- Hibernate is ORM frameowork.
  ORM : Object(JAVA) Relational(DATABASE) Mapping.
  For every table there is a java class.
  
  database:  
  Table : Visitor
  table columns: id, name,city, salary
  row : contains data
  
  java:
  class: Visitor
  instance variables: id, name,city, salary
  object : contains data
  
- save : object is converted to row
  read : row are converted to java objects.
  JDBC logic :
 					if(rs.next()){
					//get columns for every row
					int id = rs.getInt("id");
					String name = rs.getString("name");
          			String city = rs.getString("city");
					int salary = rs.getInt("salary");
					System.out.println(id +", " + name +", "+salary);
				} 
				
	Using hibernate we don't have to write code for every columns like above
	
	
- convert row to java obj(mapping logic) in jdbc developer has to take care. write 60 lines 
- convert row to java obj(mapping logic) in hibernate, the framewrok will to take care , 
	write 1 line of code.
	
-change the table name/change column name/add new column/rename column:
in jdbc: the impact is huge 
in hibernate : the change is only in one place.
  
migrating the database . ex: oracle to mysql
in jdbc the change is very complex.
in hibernate the change is required in a single place. ex:change the dialect property 
in hiberante.xml   
  
re-usability, modularity , avoid code repetition , loosely coupled, faster development.    

 Hibernate has its own query language, i.e hibernate query language which
 is database independent. 
schema generation/table generationm cna be automatically using hibernate.
-Hibernate supports relationships like One-To-Many,One-To-One, Many-To-Many-to-Many,
 Many-To-One.
 
  Hibernate supports Inheritance, Associations, Collections
  
  - In jdbc all exceptions are checked exceptions,  in hiberante we have unchecked exceptions,
   so no need to take care of exception handling.
   
   - In hibernate most of the cases developer doesn't not need to write the SQL queries,
the queries are auto generated by hiberante.

Hibernate supports caching mechanism , performance is improved + load on the database
is reduced.

 pagination implementation is simplified.
 
 Lazy-Loading : The lazy-loading concept fetches only the necessary
 object that is required for the execution of an application.
 
 setup:
-----------
1.create project and import the hibernate jars
2.create the hibernate.xml (for configuration)
  - db configuration (username, password, connection string)
  - hib configuration( entity classes , )
3.create the entity classes.
   (for every table there isa java class. that java class is termed as entity class)
   
   Table : VisitorDetails
  table columns: id, name,city, salary
  row : contains data
  
  java:
  use annotation insdie the entity class.
    
  @Entity
  @Table(name = "VisitorDetails")  // table name , Vistor class is associated with 
  VisitorDetails table.
  //table is class
  public class Visitor{
  @Column(name="id") //db column name
    private int myId;
    
    @Column(name="name") //db column name
    private String myName;
    
    @Column(name="city") //db column name
    private String myCity;
    
    @Column(name="salary") //db column name
    private int userSalary;
    
    setters and getters
  }
  
  Objects we need from hibernate:
--------------------------------
  1.sessionFactory
  2.session object  (to execute the insert/update/delete/read queries)
  3.transaction (required only for insert/update/delete)
  4.Query (used for update/delete/read queries)
  5.Criteria (used for read queries)
  
  
 */
}
