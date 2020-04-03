package namedQuery;

public class Notes {
/*
 * Instead of writing the queries in many places we can write the queries in once place.
 * And we can use them everywhere. It is a part of Hql only.
 * we have to write the named queries in the entity class.
 * namedquery contains 2 elements : query name, query value
 * query name is a string and query value is hql query
 * we need the query object
 * steps:
 * 1. write the named query for the entity class
 * every @namedtQuery contains query name + query value(HQL)
 * 2.Create sf
	3.Create session
	4.create query obj using the namedQuery name
	5.insert/up	date/delete  --> executeUpdate
	select --> single row call uniqueResult()
  	for multi rows -> list()
 * 
 * @NamedQueries(
		value =
{
 @NamedQuery(name ="getEmpNames",query = "select userName from Employee"),
 @NamedQuery(name ="getALLEmps",query = "from Employee"),
 @NamedQuery(name ="empSal",query = "select usersalary from Employee")
}
)
@Entity
@Table(name = "EmployeeDetails")
public class Employee {
  
}
 * 
 */
}
