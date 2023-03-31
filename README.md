
Project Type :MAIN PROJECT

Project Title: ALL APPS AND TOOLS

-----------------------------------------------------------
-
----------------------------------------------------------



***************************  MAIN PROJECT ***********************************



Problem Statement:

	Listing and storing of all Apps and Tools when searched with first and last letter of the first name




Detailed Description: 

	
	1.Open url-> be.cognizant.com
	
	2.Login using cognizant credentials
	
	3.Verify the page title and fetch the user details
	
	4.Click on all apps and tools and verify the page title
        
	5.Click on the first and lest letter buttons of first name and store the results


Technology/Automation 


Tools used:

	1.Selenium Webdriver and it's concepts

	2.TestNG Framework and it's concepts

	3.Core Java Concepts

	4.Maven/Apache POI tools

	5.Extent Report/TestNG Report/Customized Report

	6.Cross Browser Testing Concepts

	7.Property file concepts
              




Browser Options:
	
	1.Chrome
	
	2.Firefox
	(The browser is mentioned in the config.properties,to run the various browser make changes in value field).




Structure Details:
	
	1.src/main/java:
		
		a) Base Package->Base.java
		
		b) actions Package->AppsTools.java, SeachAndListApps.java, UserDetails.java
		
		c) config Package->config.properties
		
		d) utils package->ExtentReportManager.java
	

	
	2.src/main/resources:
		
		No resources used
	
	

	3.src/test/java:
		
		a) TestSuites Package->TestCases.java
		
		b) TestNG.xml
	
	
	4.src/test/resources:
		
		No resources used
	

	5.Excel
		
		List_of_Apps.xlsx (contains the list of all Apps and Tools when searched with first and last letter of the first name)



Readme:It contains the problem statement and detailed explanation about project file.



Report:It contains the extent report for the automated project file.



Screenshot:It contains the screenshot taken during the execution of the program.	  
