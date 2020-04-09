package manytoMany;

public class Notes {
/*ManytoMany:	
---------------
  EX1: Pages , likes ,customer
  
  One customer can like multiple Pages   ( customer -> Pages   OneToMany)
  one Page can be liked by multiple customer .  ( page -> customer   OneToMany)
  
  ==> Relation between customer and pages is manytomany
  For manytomany we need three tables.
  
scenario:
---------------
Course
Student
1 course has many students
1 student can attend many courses.

DB design:
---------------
three tables
1.Course
2.Student
3.StudentCourceMap

Course
---------
courceId (PK)
courseName

Student
--------------
stuId (PK)
studentName
Description

StudentCourceMap
----------------
stuId (FK)  -> refers Student
courceId(FK) -> refers Course 

java design:
---------------
package: manytoMany

Write annotation
@ManyToMany   --> for any of the two entity classes...


explaination:
1.we have written @manytomany for student.java

@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)  // relationshop between student and course
	@JoinTable(name = "StudentCourceMap",   // 3rd table details
	joinColumns = { @JoinColumn(name = "stuId") },  // stuId column is refering from the student.java
	inverseJoinColumns = { @JoinColumn(name = "courceId") }) //courceId is referring to course.java
	private List<Cource> cources;  //as multple courses as attended, so keep as list
 * 
 */
}
