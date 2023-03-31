package actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;

import Base.Base;

public class AppsTools extends Base {

	By appsTools = By.xpath("//*[@id=\"appSlide-0\"]/a/h4/span");

	public void clickAndVerifyAppsTools() {

		logger = report.createTest("Click and verify Apps & Tools");

		// Select the Apps & Tools link
		try {
			findElement(appsTools).click();
			Thread.sleep(3000);
			Screenshoot("Apps & Tools directory");
			reportPass("Apps & Tools Clicked Successfully");
			if (driver.getTitle().contains("Apps & Tools directory"))
				// Pass
				reportPass("Page title contains Apps & Tools directory");
			else
				// Fail
				reportFail("Page title doesn't contains Apps & Tools directory");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}

}
