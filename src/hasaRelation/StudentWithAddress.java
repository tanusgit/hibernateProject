package hasaRelation;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "StudentWithAddress")
public class StudentWithAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "userName")
	private String name;

	@Column(name = "age")
	private int age;

	@Column(name = "branch")
	private String branch;

	@Embedded
	private Address curAddress;

	
	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
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

	public Address getCurAddress() {
		return curAddress;
	}

	public void setCurAddress(Address curAddress) {
		this.curAddress = curAddress;
	}
	
	public void displayStudentInfo(){
		System.out.println(id);
		System.out.println(name);
		System.out.println(age);
		System.out.println(branch);
	}

	 
}