package actions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Base;

public class UserDetails extends Base {


	By userDetails = By.xpath("//*[@id='user-name']");
	By jobTitle = By.xpath("//span[@class='job-title']");
	By appsTools = By.xpath("//*[@id=\"appSlide-0\"]/a/h4/span");
	By email = By.xpath("//input[@type='email']");
	By next = By.xpath("//input[@type='submit']");
	By pwd = By.xpath("//input[@type='password']");
	By signin = By.xpath("//input[@type='submit']");
	By call = By.xpath("//*[@id=\"idDiv_SAOTCS_Proofs\"]/div[2]/div/div/div[2]");
	By yes = By.xpath("//input[@type='submit']");
	
	
	public void login() throws InterruptedException {

		logger = report.createTest("User Login");

		//To collect user details and print in console
		try {
			wait(10,email);
			driver.findElement(email).sendKeys(prop.getProperty("email"));
			driver.findElement(next).click();
			wait(10,pwd);
			driver.findElement(pwd).sendKeys(prop.getProperty("pwd"));
			driver.findElement(signin).click();
			wait(10,call);
			driver.findElement(call).click();
			wait(20,yes);
			driver.findElement(yes).click();
			reportPass("Login successful");
			Thread.sleep(3000);
			Screenshoot("Be.Cognizant");
			
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		
	}
	

	public void getUserDetails() throws InterruptedException {

		logger = report.createTest("Capture User Data");

		//To collect user details and print in console
		try {
			if (driver.getTitle().contains("Be.Cognizant"))
				// Pass
				reportPass("Page title contains Be.Cognizant");
			else
				// Fail
				reportFail("Page title doesn't contains Be.Cognizant");
			WebElement user = findElement(userDetails);
			WebElement job = findElement(jobTitle);
			System.out.println(user.getText());
			System.out.println("Job Title "+ "- " +job.getText());
			reportPass("User details collected successfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		
	}
	
	public String FirstAndLastLetters() 
	{
		
			logger = report.createTest("Getting last first and last chars");
			String username = driver.findElement(By.xpath("//p[@id='user-name']")).getText();
			//System.out.println(username);
			String usertest1= username.split(",")[1].trim().split("\\s")[0];
			System.out.println("FirstName - " +usertest1);
			char firstlet=usertest1.charAt(0);
			int n=usertest1.length();
			char lastlet=usertest1.charAt(n-1);
			char lastletcaps=Character.toUpperCase(lastlet);
			System.out.println("First letter = "+firstlet);
			System.out.println("Last letter = "+lastletcaps);
			String myStr = Character.toString(firstlet);
			String lastl = Character.toString(lastletcaps);
			String myStrF = myStr + lastl;
			//System.out.println(myStrF);
			reportPass("First and last chars returned successfully");
			return myStrF;
			

	}
	
	

}
