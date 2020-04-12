package jointable;

public class Notes {
/*
 * Inheritence Join table:
------------------------------
  
3 tables and tables are related/associated.
3 Java classes 
  
  
DB table design:
--------------------
 table: Person3
 columns : id(PK) , name ,age
 
 table: Student2
 columns : id(FK refers Person3) , stuid, branchid
 
 
 table: employee2
 columns : id(FK refers Person3) , projid, deptid
 
 
 
 
 
 
Java Design:
-----------------
package : jointable 
  
@Entity
@Table(name = "Person3")
@Inheritance(strategy = InheritanceType.JOINED)// specify inheritence type 
public class Person3 {

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





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity  
@Table(name = "Employee3")
@PrimaryKeyJoinColumn(name="ID") // relate the pk and fk between Employee and Person 
public class Employee3 extends Person3{ 
 
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
	
	
  
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity  
@Table(name = "Student3")
@PrimaryKeyJoinColumn(name="ID")
public class Student3 extends Person3{ // relate the pk and fk between Student and Person 

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
  
  
  
3.add entries in hiberante.cfg.xml:
  -------------------------------------------------
   
		<mapping class="jointable.Person3"/> 
        <mapping class="jointable.Employee3"/> 
        <mapping class="jointable.Student3"/> 
            


    
then run the TestConnection.java to create the table
Then check in the database if it is created

 */
}
