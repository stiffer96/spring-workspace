# spring-workspace
All course related files and projects (Udemy Spring and hibernate with spring boot )

Daily Logging :

+------------------------------------------------------------------------------------------------------------+
Day Wednesday : 27-Jan-2021 

	--> created spring-workspace repo on github
	--> added spring course projects to github ( commit - added course projects to github till section-14 )
	--> added hibernate validator 6.2 jar files to build path 7 jars ( for section 15 )
	--> added file
		--> Customer.java ( model )
		--> CustomerController.java ( Controller )
		--> customer-form.jsp ( view )
		--> customer-confirmation (view )
	--> section 15 completed.
	--> how to handle String input for Integer field? ( covered )
		->create src/resources/messages.properties file
		-> configure it in xml file check notebook for reference.
	-->Spring custom form validation
		-> own custom java annotation
			-> package com.jerry.springdemo.mvc.validation
	--> git commit messgage " section 15 ,16,17 completed-  Spring validations "
	--> End for the day : Time - 10:50 PM

+----------------------------------------------------------------------------------------------------------------+
Day Friday : 29-Jan-2021
	
	--> closed mvc project covered in section 15 ,16 ,17.
	--> created new project 'hibernate_demo' for hibernate project section 18
	--> Added all jars related to hibernate and mysql connector j
	--> Run first connection programme to database- successful
	--> git commit to main branch " section 18 completed - hibernate
			 (loaded all jars with mysql connector and first successful connection programme ) "

+----------------------------------------------------------------------------------------------------------------+
Day Saturday : 30-Jan-2021
	
	--> covered section 19 , 20 and 21 almost half 
	--> Saving objects to database through hibernate also learn cool things about auto_increment in primary keys.
		we can set auto_increment can be done from a paricular vale eg: below
		'ALTER TABLE student AUTO_INCREMENT=3000' - Now increment starts from 3000 value.
	--> Files created :- 
		--> Entity - Student.java
		--> App    - CreateStudentDemoApp and PrimaryKeyDemoApp
	--> git commit 'Learn objects mapping to database and primary keys'

+----------------------------------------------------------------------------------------------------------------+
Day Sunday : 31-Jan-2021
	
	--> today covered section 21 ,learned HQL ( hibernate query language )
	--> Performed CRUD operation with HQL.
	--> Files created:-
		--> ReadStudentDemo.java
		--> UpdateStudentDemo.java
		--> DeleteStudentDemo.java
	--> git commit " Performed CRUD operations with hibernate section 21 completed 

+----------------------------------------------------------------------------------------------------------------+
Day Monday : 01-Feb-2021

	--> created new project 'hibernate_practice_activity' for Practice activity #8 section 21
	--> performed all CRUD operation as learnt before.
	--> git commit "one more project hibernate_practice_activity completed from section 21 ".
	

+----------------------------------------------------------------------------------------------------------------+
Day Wednesday : 03-Feb-2021

	--> Completed section 22 hibernate advanced mapping and 23 @OneToOne mapping almost
	--> Learn unidirection  and bidirectional relationshib between tables
	--> Learnt what is cascading how it relate with its associate methods
	--> Created File :-
		--> Project hb-01-one-to-one-uni : for uni directional
			--> Instructor.java and InstructorDetail.java  ( Entities)
			--> CreateDemo.java and DeleteDemo.java ( apps ) 
		--> Project hb-01-one-to-one-bi : for bi directional
			--> Instructor.java and InstructorDetail.java  ( Entities)
			--> MainAppBidirectional ( app ) 
	--> git commit "Learnt @OneToOne mapping with hibernate and also Cascade relationships"
+----------------------------------------------------------------------------------------------------------------+
Day Thursday : 04-Feb-2021

	--> completed 23 section @OneToOne
	--> Learnt exception handling
		--> Files : Project - hb-01-one-to-one-bi , MainAppBidirectional.java
	--> Deleted Instructor without deleting instructor
	--> removed link between bi directional link
	--> Files : Project - hb-01-one-to-one , App - DeleteInstructorDetailDemo.java
	--> Started @OneToMany took overview
	--> git commit "Learnt Exception handling and removing link between Bidirection mapping"


+----------------------------------------------------------------------------------------------------------------+
Day Friday : 05-Feb-2021

	--> Completed 24 section @OneToMany mappings
	--> Learnt all CRUD operations related to one to many mapping
	--> Files :
		--> Project - hb-03-one-to-many-bi 
		--> Entity - Course.java (added) Apps- CreateCourseDemo, CreateInstructorDemo
	--> git commit "Learnt @OneToMany mapping and all CRUD operations "

+----------------------------------------------------------------------------------------------------------------+
Day Thursday : 18-Feb-2021

	--> Completed section 25th and 26th
	--> Learnt Lazy vs Eager Loading and One to Many Unidirectional mapping with hibernate
	--> also added database scripts which is used in projects ( Folder : Database Scripts )
	--> created two projects for same
	--> For one to manu uni , 
		-->Updated : Course.Java , created : Reviews.java ( One course can have many reviews )
	--> git commit "Learnt Lazy vs Eager Loading and One to Many Unidirectional mapping with hibernate , 
			added Database Scripts folder"
+----------------------------------------------------------------------------------------------------------------+
Day Friday : 19-Feb-2021

	--> Completed section 28th Hibernate @ManyToMany mapping
	--> In this section ,learnt student can have many courses and vice-versa
	--. Also learnt able Join table which connect both tables by storing their id's
	--> Use @JoinTable annotion for same in both classes
	--> Created all CRUD application for same
	--> Created project :  'hb-05-many-to-many' tables
	--> git commit "Learnt @ManyToMany mapping with Student and Course classes also about @JoinTable annotation."
+----------------------------------------------------------------------------------------------------------------+
Day Thursay : 04-Mar-2021

	--> created folder 'SpringJarFiles' to store required jar files for spring app
	--> created folder 'HibernateJarFiles' to store hibernate jar files
	--> store database script file in 'DatabaseScripts' folder of spring mvc web project
	--> create project 'web-customer-tracker' spring mvc web poject
	--> config the development environment for loaded all required jar files
	--> also tested the database connection with 'TestDbServlet.java'
	--> git commit " today setup a web project with spring hibernate and spring mvc ,
			loaded all jar files and config development environment, 
			also tested database connection, 
			created database 'web_customer_tracker' and cutomer table with some entries, 
			created new database user 'springstudent' with password spring 'student' also"
+----------------------------------------------------------------------------------------------------------------+