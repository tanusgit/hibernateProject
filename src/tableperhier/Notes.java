package tableperhier;

public class Notes {
/*
 * there is no relation between person object, student object and employee
 * object
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
  
-> table  per hierarchy    (InheritanceType.SINGLE_TABLE)
-> table per class          (InheritanceType.TABLE_PER_CLASS)
-> JOIN Table (normalization)   (InheritanceType.JOINED)

1.table  per hierarchy:
one table for all the inheritence classes.
person, student, employee info is saved in a single table.

tableName:PersonDetails1
columns: userid , name , age ,projid, deptid , semid, branchid

When Person is saved , then for columns projid, deptid , semid,
branchid is saved as null.
When Student is saved  ,  then for columns projid, deptid is saved as null.
When Employee is saved , then for columns  semid, branchid is saved as null.

The annotation
@DiscriminatorColumn(name = "type" , discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "person")
  
is required for the column "type" 
  type value will be either "person" , "employee" or "student6"
  
  Discriminatorcolumn means the column that specifies what 
  type of user/table/class
    
1. Get all employee
Select * from PersonDetails1 where type='employee'

2. Get all Persons
Select * from PersonDetails1 where type='person'

3. Get all students
Select * from PersonDetails1 where type='student'
------------------------------------------------------------------------------


Person
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
  
-> table  per hierarchy    (InheritanceType.SINGLE_TABLE)
-> table per class          (InheritanceType.TABLE_PER_CLASS)
-> JOIN Table (normalization)   (InheritanceType.JOINED)
  
1.table  per hierarchy:
one table for all the inheritence classes.
person, student, employee info is saved in a single table.
  
  
  
tableName:PersonDetails1
columns: userid , name , age ,projid, deptid , semid, branchid , type 


1. When Person is saved , then for columns projid, deptid , semid, branchid is saved as null.
2. When Student is saved  ,  then for columns projid, deptid is saved as null.
3. When Employee is saved , then for columns  semid, branchid is saved as null.
 
  
DiscriminatorColumn - meaning the column that specifies what type of type .  
The annotation
@DiscriminatorColumn(name = "type" , discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "person")
  
  
is required for the column "type" 
type value will be either "person" , "employee" or "student". 
  
1. Get all employee
Select * from PersonDetails1 where type='employee'

2. Get all Persons
Select * from PersonDetails1 where type='person'

3. Get all students
Select * from PersonDetails1 where type='student'

  
package: tableperhier


1.

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "PersonDetails1")// table name
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //inheritence type
@DiscriminatorColumn(name = "type" , discriminatorType = DiscriminatorType.STRING) //for column "Type" 
@DiscriminatorValue(value = "person") //for "Type" column value
public class Person { // parent class

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId")
	private int Id;

	@Column(name = "name", nullable = false, length = 30, unique = true)
	private String userName;

	@Column(name = "age")
	private int age;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}


2.
  
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "employee") //for "Type" column value
public class EmployeeDetails extends Person{
	
	@Column(name = "projId")
	private String projId;
	
	@Column(name = "deptId")
	private String deptId;

	public String getProjId() {
		return projId;
	}

	public void setProjId(String projId) {
		this.projId = projId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	
}


3.

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "student")//for "Type" column value
public class Student extends Person{

	@Column(name = "semId")
	private String semId;

	@Column(name = "branchId")
	private String branchId;

	public String getSemId() {
		return semId;
	}

	public void setSemId(String semId) {
		this.semId = semId;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

}


  

4.add entries in hibernate.cfg.xml
<mapping class="tableperhier.Person"/> 
	<mapping class="tableperhier.EmployeeDetails"/> 
	<mapping class="tableperhier.Student"/> 
	
  
  
  
 */
}
