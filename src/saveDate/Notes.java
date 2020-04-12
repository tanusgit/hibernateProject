package saveDate;

public class Notes {
/*
 * 

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.Session;

import com.dao.HibernateUtil;

import java.sql.Blob;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "Activities")
public class Activities {
 

	@Temporal(TemporalType.DATE)
	@Column(name = "createdDate")
	private java.util.Date dateCol;

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Calendar createDate;
  
  
  @Column(name = "content")
	@Lob
	private Blob content;// store file ex: image, pdf , doc



	public java.util.Date getDateCol() {
		return dateCol;
	}


	public void setDateCol(java.util.Date dateCol) {
		this.dateCol = dateCol;
	}


	public Calendar getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Calendar createDate) {
		this.createDate = createDate;
	}


}


public static void main(String[] args) {
		Activities p = new Activities();
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		p.setCreateDate(Calendar.getInstance());
		p.setDateCol(new Date());
		s.save(p);
		s.getTransaction().commit();
		s.close();
	}
	---------------------------------------------------------------------
Hibernate States or  Entity obj states:
-------------------------------------------
-> Transient
-> Persistent
-> Detached


Employee is a Entity class.

Transient:
------------------
-> create new obj for Entity class then we term the state as transient state.
  ex: Employee e = new Employee()
  
  Persistent:
---------------------
  -> if the session is associated with the entity obj , then the state changes 
  from transient to persistence..
   -> while in session if the object is changed then the row will be changed. 
   
    ex:
     session.save(e); // use for create
     session.saveOrUpdate(e); // use for create or update
     session.persist(e);
     session.merge(e);
         
	the following methods retuns the enity objs in persistece state:
   	Employee e1 = session.get(Employee.class, 23); // e1 is in pers state
    Employee e2 = session.load(Employee.class, 23); // e2 is in pers state
  
    List<Employee> emps= query.list(); //all emps are in pers state
    Employee e3 = query.uniqueResult(); // e3 is in pers state

    List<Employee> emps=criteria.list();/all emps are in pers state
    Employee e4 = criteria.uniqueResult(); // e4 is in pers state
    
    Detached:
--------------
  > if the entity obj is no longer associated with session , then the state 
  changes from persistenc to detached.
   ex:
     session.close()
     session.clear()
       
  how to convert entity obj in detached state to Persistent state:      
-------------------------------------------------------------------
        
  session2.update(e)
  session2.merge(e)
  session2.saveOrUpdate(e)
    

    
 */
}
