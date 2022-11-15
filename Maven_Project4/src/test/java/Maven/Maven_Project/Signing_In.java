package Maven.Maven_Project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Page_Object.Landing_Page;
import Page_Object.Login_Page;

import resources.base;

public class Signing_In extends base{
	
	@BeforeTest
	public void initailize() throws IOException {
		
		System.getProperty("webdriver.chrome.driver","C:\\chromedriver.exe"); 
		 driver= initialDriver();
		driver.get("https:secure.yatra.com/social/common/yatra/signin.htm");
	}
	@Test
	public void navigateToLogin() {
		Landing_Page l= new Landing_Page(driver);
		driver.manage().window().maximize();
		l.MyAccount().click();
		l.Login().click();
	}
	@Test
	public void basepagenavigation() throws IOException {
		
		Login_Page p= new Login_Page(driver);
		p.Emailid().sendKeys("abhishek.avi551@gmail.com");
		p.Continue_button().click();
		p.password().sendKeys("P@55word");
		p.getlogin().click();
		}	
	
	@AfterTest
//	public void finish() {
//		driver.close();
//	}
	
	@DataProvider
	public Object[][] getdata() {
		
		Object[][] data= new Object[2][2];
		data[0][0]= "nonrestricted@data.com";
		data[0][1]="1345";
		
		data[1][0]="restricted@data.com";
		data[1][1]="6789";
		return data;
	}
} 