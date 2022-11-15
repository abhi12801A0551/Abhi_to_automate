package Page_Object;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Login_Page {

public WebDriver driver;
	
	By email_mob= By.xpath("//input[@name='login-input']");
	By password= By.cssSelector("[type='password']");
	By Cont_button= By.xpath("//button[@id='login-continue-btn']");
	By login=By.xpath("//button[@id='login-submit-btn']");
	
	
	
	public Login_Page(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
//WebDriverWait w= new WebDriverWait(driver, 30);
//WebElement element= w.until(ExpectedConditions.visibilityOfElementLocated(email_mob));
	
public WebElement Emailid() {
	return driver.findElement(email_mob);
}
public WebElement password() {
	return driver.findElement(password);
}
public WebElement getlogin() {
	return driver.findElement(login);
}
public WebElement Continue_button() {
	return driver.findElement(Cont_button);
}
}