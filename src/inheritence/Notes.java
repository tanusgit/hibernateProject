package inheritence;

public class Notes {
/*
 * Person
id,name,age

Student
id,name,age,branch,sem

Employee
id,name,age,deptId,projId


We will define Person as parent class
and Student +Employee are child classes extending Person



public class Person {

 	private int Id;
 	private String userName;
 	private int age;
  
  }
  


 public class EmployeeDetails extends Person{
	private String projId;
	private String deptId;
  
 }



public class Student extends Person{
 	private String semId;
 	private String branchId;

}


Inheritence:
--------------
  
-> table  per hierarchy
-> table per class
-> JOIN Table (normalization)

1.table  per hierarchy:
one table for all the inheritence classes.
person, student, employee info is saved in a single table.

tableName:PersonDetails1
columns: userid , name , age ,projid, deptid , semid, branchid

When Person is saved , then for columns projid, deptid , semid,
branchid is saved as null.
When Student is saved  ,  then for columns projid, deptid is saved as null.
When Employee is saved , then for columns  semid, branchid is saved as null.

 */
}
