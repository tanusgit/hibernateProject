package hibernatePractice;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import org.hibernate.annotations.AccessType;

@Entity
@Table(name = "BookLists")
public class Novel {
	@GeneratedValue(strategy = GenerationType.AUTO)
	//we have to put the @Id annotation somewhere above the instance variable otherwise
	//it throws exception
	//there should not be any space between field name or column name so "Book name" is wrong
	//we have write "Bookname"
	@Column(name = "Bookname", nullable = true, length = 30)
	String name;
	
	
	@Id
	@Column(name = "Bookprice", nullable = false, length = 30, unique = true)
	Integer price;

	public Novel(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", price=" + price + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
