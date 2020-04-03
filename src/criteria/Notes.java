package criteria;

public class Notes {
/*
 * we need criteria because there are 2 types of requirements.
 * requirements:
 * 1. query will not change for the same page , same query on the same page 
 * 2. query will change for the same page based on the input, different queries on the same 
 * page
 * For the requirement no 1 we can use hql always as query is static, all inputs
 * are mandatory
 * 
 * For the requirement no 2 use criteria as query is dynamic , all inputs are optional
 * 
 * example for requirement no 1:
 * search by id,  search by name,  search by salary, update, 
 * change password, delete by id, delete by name
 * 
 * example for requirement no 2:
 * query is generated  based on inputs, and inputs are optioanl.
 * 1.Search products 
   [filter by brand, price, color, gender, size, discount]
   [filter by brand, price, color , gender ,size , discount]
   filter by brand -> select * from product where brand ='hrx'
   filter by brand, price ->select * from product where brand ='hrx' and price <20000
   filter by brand, price, color ->select * from product where brand ='hrx' and price <20000 and color ='red'
   filter by brand, price, color , size ->select * from product where brand ='hrx' and price <20000 and color ='red' and size='38'
  2. search buses:
		mandatory : from and to + date
    optioanl:
       [1.bus type ac/non-ac
        2.pickup area 
        3.drop area
        4.sleeper / semi-sleeper
       ]

//criteria is mostly for select  dynamic queries

1. sessions fac
2.session
3.Create criteria obj
4.apply the restriction/filter
5.for multi rows call list()
  for single row call uniqueresult()
    
6.close session    


  */
}
