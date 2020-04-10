package hasaRelation;

public class Notes {
/*
 * Table: PersonWithAddress
Columns: id , userName , age, , city , state ,country ,pin


Java:
Earlier : 1 entity classs
Problem: Address in used for deifferent models like Person, Employee, Student , Order.
Solution : we need seperate class for Address.
  
Now:
Create Two class for on table
1.PersonWithAddress.java
2.Address.java

has-a relationship


PersonWithAddress.java:
----------------------------------
  
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PersonWithAddress")
public class PersonWithAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "userName")
	private String name;

	@Column(name = "age")
	private int age;

	@Embedded
	private Address curAddress;
	
 	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getCurAddress() {
		return curAddress;
	}

	public void setCurAddress(Address curAddress) {
		this.curAddress = curAddress;
	}

	@Override
	public String toString() {
		return "PersonWithAddress [id=" + id + ", name=" + name + ", age=" + age + ", curAddress=" + curAddress + "]";
	}

 
	
}



Address.java:
--------------------

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column(name = "streetNo")
	private String streetNo;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "pin")
	private int pin;

	public void displayAddress(){
		System.out.println(streetNo);
		System.out.println(city);
		System.out.println(pin);
		System.out.println(country);
	}
	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

}




1. PersonWithAddress.java
( - is a entity class
 - Use 
 @Entity
@Table(name = "PersonWithAddress")
 before class name

)
  

  @Embedded
	private Address curAddress;
	
2. Address.java:
- is not a entity class
-Use @Embeddable before the class name:

@Embeddable 
public class Address {

}
@Embeddable
public class Address {

  
  
  2. Add entry for PersonWithAddress
    <mapping class="hasa.PersonWithAddress"/>
 */
}
