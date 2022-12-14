package Maven.Maven_Project;

import java.util.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.apache.poi.ss.usermodel.DateUtil;
import org.bouncycastle.asn1.dvcs.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page_Object.Landing_Page;
import resources.base;

@Test
public class Location_From_To extends base {

	@BeforeTest
	public void initailize() throws IOException {
		
		System.getProperty("webdriver.chrome.driver","C:\\chromedriver.exe"); 
		 driver= initialDriver();
		driver.get("https://www.yatra.com/");
	}
	
	@Test(priority=1)
	public void Depart_From() throws IOException, InterruptedException {
		Landing_Page l= new Landing_Page(driver);
		l.Origin().click();
		l.Origin().clear();
		l.Origin().sendKeys("BANG");
		Thread.sleep(3000);
		List<WebElement> ele= driver.findElements(By.xpath("//div[@class='viewport']/div/div/li"));
		for(WebElement option: ele) {
			
			String Depart_From= option.getText();
			
			if (Depart_From.contains("Bangalore")) {
	    		
	    		option.click();
	    		break;
}	
}
	
	}
	
	@Test(priority=2)
	public void Reach_To() throws IOException, InterruptedException { 
		Landing_Page l= new Landing_Page(driver);
		l.Arrival().click();
		l.Arrival().clear();
		l.Arrival().sendKeys("NAG");
		Thread.sleep(3000);
		List<WebElement> ele1= driver.findElements(By.xpath("//div[@class='viewport']/div/div/li"));
		
		for(WebElement option1: ele1) {
			
			String Going_to= option1.getText();
			
			if (Going_to.contains("Nagpur")) {
	    		
	    		option1.click();
	    		break;

}
			}
		
}

		}		
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollBy(0, 500)", l.ScrollTo());
//		boolean d_month= driver.findElement(By.xpath("//div[@class='active-month-holder']")).getText().equalsIgnoreCase("August' 21");
//		 ((JavascriptExecutor) driver).executeScript("window.scrollIntoView()",d_month);
		
