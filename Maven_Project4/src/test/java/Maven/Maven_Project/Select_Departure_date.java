package Maven.Maven_Project;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page_Object.Landing_Page;
import resources.base;

public class Select_Departure_date extends base {
	
	@BeforeTest
	public void initailize() throws IOException {
		
		System.getProperty("webdriver.chrome.driver","C:\\chromedriver.exe"); 
		 driver= initialDriver();
		driver.get("https://www.yatra.com/");
	}
	

	@Test(priority=3)
	public void Date() throws IOException, InterruptedException {
		
		Landing_Page l= new Landing_Page(driver);
		l.Depart_Date().click();
		
		List<WebElement> monthofdepart= driver.findElements(By.xpath("//*[@id='monthWrapper']/div"));
		WebElement monthtitle= driver.findElement(By.xpath("//*[@id='month-scroll1']/div/div[@class='month-title']"));
		
		String Active_month= l.Active_month().getText();
		
		if(Active_month.equalsIgnoreCase("December' 22")){
			
			System.out.println("Failed");
			
			List<WebElement> monthlist1= driver.findElements(By.xpath("//*[@id='monthWrapper']/div/div/div[@class='day-container']/table/tbody/tr/td"));
			
			for(WebElement orgdate: monthlist1) {
				
			String t_date= orgdate.getText();
			
			System.out.println(t_date);
			
				if(t_date.contains("25")) {
					 
					orgdate.click();
					
				break;
		
				} 
			}}else {
				
				monthtitle.click();
				
					if(Active_month.equals("December' 22")) {
						
						List<WebElement> monthlist2= driver.findElements(By.xpath("//*[@id='monthWrapper']/div/div/div[@class='day-container']/table/tbody/tr/td"));
						
						for(WebElement orgdate: monthlist2) {
							
							String t_date= orgdate.getText();
							
							System.out.println(t_date);
							
								if(t_date.contains("12")) {
									 
									orgdate.click();
									
								break;
						
								
							}
						
					}
								
			} else {
					Actions a = new Actions(driver);
					a.sendKeys(Keys.PAGE_DOWN).build().perform();
			}
					}
}
}
