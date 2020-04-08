package oneToOne;

public class Notes {
/*
 * One Employee has One Address.
  Employee info is in "EmployeeWithAddress"
  Address info is stored in "AddressDetails"
    
    
  
  1.Db design:
					Table1 :EmployeeWithAddress
          columns: id(PK) , username, age, currAddrId(FK refer to id column of  AddressDetails table) 
          
          Table2 :AddressDetails
          columns: id(PK) , streetNo, city, state , country , pin 
          
  cascade (impact on the child table when row is inserted/updated/deleted in parent table)
  child table :AddressDetails
  parent table : EmployeeWithAddress
  
 Cascade is for insert, update and delete and fetch is only for reading data 
  
@OneToOne(cascade=CascadeType.ALL,fetch= FetchType.LAZY)
fetch is applicable for only select


Fetch Types:
-----------
  fetch= FetchType.LAZY    ->fetch only the parent details; dont fetch the child 
  details. 
  ex: fetch the employee details without address.
  fetch= FetchType.EAGER   -> fetch both the parent and child details in a single 
  db call. 
  ex: fetch the employee + address detials in a single call.
          
          
          
 most of the cases it is preferred to use  FetchType.LAZY.
                                
  1. Requirement : fetch only employee details:
  if  fetch= FetchType.EAGER => we are fetching both emp + address details. 
  but considering only employee details.(performacne + memory i)
 
   2. Requirement : fetch employee details + address details : 
   (use  fetch= FetchType.EAGER or fetch= FetchType.LAZY)
  if  fetch= FetchType.EAGER => we are fetching both emp + address details. 
  but considering only employee details.(perf  + memory issue)
  
  3. ALways fetch employee + address details  (use  fetch= FetchType.EAGER)
  
                                
  if fetch= FetchType.EAGER :
--------------------------------------
       EmployeeWithAddress emp = (EmployeeWithAddress) 
		s.load(EmployeeWithAddress.class, 1);
> fetches both employee details + address details.                                                       
                                
----------------------------------------------------
 if fetch= FetchType.EAGER :
--------------------------------------
       EmployeeWithAddress emp = (EmployeeWithAddress) 
				s.load(EmployeeWithAddress.class, 1);      -> fetches both employee details + address details.                           
  select employeewi0_.id as id1_1_1_, employeewi0_.age as age2_1_1_, employeewi0_.curAddId as curAddId4_1_1_, employeewi0_.userName as userName3_1_1_, addressdet1_.id as id1_0_0_, addressdet1_.city as city2_0_0_, addressdet1_.country as country3_0_0_, addressdet1_.pin as pin4_0_0_, addressdet1_.state as state5_0_0_, addressdet1_.streetNo as streetNo6_0_0_ 
  from EmployeeWithAddress employeewi0_ left outer join AddressDetails addressdet1_ 
  on employeewi0_.curAddId=addressdet1_.id where employeewi0_.id=?
  
  if fetch= FetchType.LAZY :
--------------------------------------
       	EmployeeWithAddress emp = (EmployeeWithAddress) 
				s.load(EmployeeWithAddress.class, 1);// 1st query fetches the employee details 
		System.out.println(emp);
		System.out.println(emp.getCurAddress());//2nd query is called that fetches the address details.

1st query:
select employeewi0_.id as id1_1_0_, employeewi0_.age as age2_1_0_, employeewi0_.curAddId as curAddId4_1_0_, employeewi0_.userName as userName3_1_0_ 
from EmployeeWithAddress employeewi0_ where employeewi0_.id=?

2nd query:  
select addressdet0_.id as id1_0_0_, addressdet0_.city as city2_0_0_, addressdet0_.country as country3_0_0_, addressdet0_.pin as pin4_0_0_, addressdet0_.state as state5_0_0_, addressdet0_.streetNo as streetNo6_0_0_ 
from AddressDetails addressdet0_ where addressdet0_.id=?Hibernate: select addressdet0_.id as id1_0_0_, addressdet0_.city as city2_0_0_, addressdet0_.country as country3_0_0_, addressdet0_.pin as pin4_0_0_, addressdet0_.state as state5_0_0_, addressdet0_.streetNo as streetNo6_0_0_ from AddressDetails addressdet0_ where addressdet0_.id=?
 
                                
                                         
 */
}
