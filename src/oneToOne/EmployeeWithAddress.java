package oneToOne;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeeWithAddress")
public class EmployeeWithAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "userName")
	private String name;

	@Column(name = "age")
	private int age;
//for foreign key we added OneToOne
	// cascade - is a table behaviour when two tbales are related.
	//  cascade (impact on the child table when row is inserted/updated/deleted in parent table)
	//  child table :AddressDetails
	//  parent table : EmployeeWithAddress
	//cascade=CasecadeType.All means parent and child class would be updated automatically
	
	//@OneToOne(cascade=CascadeType.ALL,fetch= FetchType.LAZY) //type of relation
	  @OneToOne(fetch= FetchType.LAZY) //type of relation
	@JoinColumn(name = "curAddId")//column name
	// use the dependet obj  as instance variable.
	private AddressDetails curAddress;
	
	@Override
	public String toString() {
		return "EmployeeWithAddress [id=" + id + ", name=" + name + ", age=" + age ;
	}

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

	public AddressDetails getCurAddress() {
		return curAddress;
	}

	public void setCurAddress(AddressDetails curAddress) {
		this.curAddress = curAddress;
	}
}
