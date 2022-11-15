package Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landing_Page {

	public WebDriver driver;
	
	By depart= By.id("BE_flight_origin_city");
	By reach=By.id("BE_flight_arrival_city");
	By d_date=By.id("BE_flight_origin_date");
	By MyAcc= By.cssSelector(".dropdown-toggle");
	By login= By.cssSelector(".fl.log-in.pgLogIn.logIn");
	
	By title= By.cssSelector(".text-center>h2");
	By navigationtab=By.cssSelector(".nav.navbar-nav.navbar-right");
	By Current_month=By.xpath("//*[@class='active-month-holder']");
	By Departure_dates= By.xpath("//*[@id=\"month-scroll0\"]/div/div/table/tbody");
	
	public Landing_Page(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement MyAccount() {
		return driver.findElement(MyAcc);
	}
	public WebElement Login() {
		return driver.findElement(login);
	}

	public WebElement Origin() {
		return driver.findElement(depart);
	}
	public WebElement Arrival() {
		return driver.findElement(reach);
	}
	public WebElement Depart_Date() {
		return driver.findElement(d_date);
	}
	
	public WebElement gettitle() {
		return driver.findElement(title);
	}
	public WebElement navigatebar() {
		return driver.findElement(navigationtab);
	}
	public WebElement Active_month() {
		return driver.findElement(Current_month);
	}
	public WebElement dateofdepart() {
		return driver.findElement(Departure_dates);
		
	}
}
