package actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Base;

public class SearchAndListApps extends Base {


	//By searchicon = By.xpath("//span[@class='icomoon-search2 ng-animate-disabled']");
	By applist = By.xpath("//span[@class='apps-and-tools__card__title ellipsis ng-binding']");
	
	File fos=new File(".\\Excel\\List_of_Apps.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook();


	public void searchListApps(char txt, int l) throws InterruptedException, IOException {

		logger = report.createTest("Searching");
		
		int c=0;
		String x=null;
		String y=null;
		
		// Search the apps & tools
				try {
					
					WebElement letter = findElement(By.xpath("//button[normalize-space()='"+txt+"']"));
					letter.click();
					Thread.sleep(2000);
					Screenshoot("App results with "+txt);
					
					reportPass("'"+txt+"'"+" Button clicked Successfully");
				} catch (Exception e) {
					reportFail(e.getMessage());
				}
				
		
		try {
				System.out.println("*************************************************************");
				System.out.println("      List of all apps and tools when searched with "+txt);
				System.out.println("*************************************************************");
				List<WebElement> listApps = driver.findElements(applist);
				System.out.println("Total Apps found - "+listApps.size());
				for (int i = 0; i < listApps.size(); i++) {
						System.out.println(listApps.get(i).getText());
				}
				if(l==0) {
					x="List of Apps found with First letter of First Name - "+txt;
					y="List of Apps with First letter";
				}
				else {
					x="List of Apps found with Last letter of First Name - "+txt;
					y="List of Apps with Last letter";
				}
				
				XSSFSheet sheet = workbook.createSheet(y);
				sheet.createRow(0).createCell(c).setCellValue(x);
				sheet.autoSizeColumn(c);
				
				for(int r=0; r<listApps.size(); r++) {
					sheet.createRow(r+1).createCell(c).setCellValue(listApps.get(r).getText());
					sheet.autoSizeColumn(c);
				}
				
				try {
					FileOutputStream outstream=new FileOutputStream(fos);
					workbook.write(outstream);
					outstream.close();
					}
					catch(Exception e){
					e.printStackTrace();
					}
				 reportPass("All Apps&Tools are displayed and stored Successfully");
				}
				
			   
		 catch (Exception e) {
			reportFail(e.getMessage());
		}
		
	}

}
