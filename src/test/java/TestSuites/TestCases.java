package TestSuites;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Base;
import actions.AppsTools;
import actions.SearchAndListApps;
import actions.UserDetails;

public class TestCases extends Base {

	UserDetails hn = new UserDetails();
	AppsTools tc = new AppsTools();
	SearchAndListApps ca = new SearchAndListApps();

	@BeforeTest
	public void invokeBrowser() {
		logger = report.createTest("Executing Test Cases");

		hn.invokeBrowser();
		reportPass("Browser is Invoked");
	}

	@Test(priority = 1)
	public void userDetails() throws InterruptedException {

		hn.openURL("websiteURLKey");
		//Thread.sleep(50000);
		reportPass("URL is Opened");
		hn.login();
		hn.getUserDetails();
		reportPass("UserData is collected");
	}

	@Test(priority = 2)
	public void appsTools() {
		tc.clickAndVerifyAppsTools(); 
		reportPass("Test successful");
	}

	@Test(priority = 3, dataProvider = "data-provider")
	public void searchAndListApps(char ftxt, int k) throws InterruptedException, IOException {
		ca.searchListApps(ftxt,k);
		reportPass("Clicked corresponding character button successfully");
	}
	
	@DataProvider(name = "data-provider")
	public Object[][] getData() {
		String inputs = hn.FirstAndLastLetters();
		char ch1 = inputs.charAt(0);
		char ch2 = inputs.charAt(1);
		return new Object[][] {
			{ch1,0},
			{ch2,1}
		};
	}
	

	@AfterTest
	public void closeBrowser() {
		ca.endReport();
		ca.closeBrowser();
	}

}
