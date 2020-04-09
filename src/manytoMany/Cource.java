package manytoMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import hibernateFirst.HibernateUtil;
import java.io.Serializable;
@Entity
@Table(name = "Cource")
public class Cource implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "courceId")
	private int courceId;

	@Column(name = "courceName", nullable = false)
	private String courceName;

/*	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "StudentCourceMap", 
	joinColumns = { @JoinColumn(name = "courceId") }, 
	inverseJoinColumns = { @JoinColumn(name = "stuId") })
	private List<Student> students;

*/	public int getCourceId() {
		return courceId;
	}

	public void setCourceId(int courceId) {
		this.courceId = courceId;
	}

	public String getCourceName() {
		return courceName;
	}

	public void setCourceName(String courceName) {
		this.courceName = courceName;
	}

	public Cource(String courceName) {
		super();
		this.courceName = courceName;
	}
}

