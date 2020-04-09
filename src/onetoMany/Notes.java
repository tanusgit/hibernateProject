package onetoMany;

public class Notes {
/*
 One to Many:
---------------
  
1 row in table1 is related to multiple tables in table2.
  
one customer can have multiple accounts..  
Relation from customer to account -> One to Many

Multiple accounts belongs to one account..  
Relation from account to customer ->Many to One
  
DB Design:
------------
  
   Customer                               
   ------------
   ID(PK)                               
   AGE                                     
   CUSTOMER NAME  
   
                                      
 Account
 ---------
 ID(PK)
 AccountName 
 Description> 
 CUSTID(FK)  --> refers the ID column of Customer table
 
 Annotations:
 
Customer.java: 
----------------------
  @OnetoMany            //relate the one to many relationship
  List<Accounts> acccunts;

Accounts.java:
---------------------
  @ManytoOne      //relate the many to one relationship
  @JoinColumn(name = "custId", nullable = false)  // for a foreign key
  Customer customer;
  
 */
}
