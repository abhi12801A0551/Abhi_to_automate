package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class base {

	public WebDriver driver;
	public Properties prop;
	public WebDriver initialDriver() throws IOException{
		
		 prop= new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\dell\\eclipse-workspace\\Maven_Project4\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		String browsername= prop.getProperty("browser");
				
		if(browsername.equals("chrome")) {
			System.getProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
			driver= new ChromeDriver();
		}else if(browsername.equals("Firefox")) {
			System.getProperty("webdriver.gecko.driver","C:\\Users\\dell\\Downloads\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browsername.equals("IE")) {
		driver=new FirefoxDriver();
	}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		}
	public void getScreenshotPath(String testMethodName) throws IOException {
		File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination= System.getProperty("user.dir")+"\\reports\\"+testMethodName+" .png";
		FileUtils.copyFile(file,new File(destination));
	}
	@DataProvider(name="gettest")
	public ArrayList getData(String testcasedata) throws IOException {
		ArrayList a=new ArrayList();
	  FileInputStream fis= new FileInputStream("C:\\Book1.xlsx");
	  XSSFWorkbook workbook= new XSSFWorkbook(fis);
	  int sheets =workbook.getNumberOfSheets();
	  for (int i=0; i<sheets; i++) {
		  
		  if(workbook.getSheetAt(i).equals("Testcase")) {
			  XSSFSheet sheet= workbook.getSheetAt(i);
		  
		  Iterator<Row>  rows= sheet.iterator();
		  Row firstrow= rows.next();
		  Iterator<org.apache.poi.ss.usermodel.Cell> ce=firstrow.cellIterator();
		  int k=0;
		  int column=0;
		  while(ce.hasNext()) {
			  org.apache.poi.ss.usermodel.Cell value= ce.next();
			  if(value.getStringCellValue().equalsIgnoreCase("FirstName")) {
				  
				  column=k;
			  }
			  k++;
		  }
		 
		  while(rows.hasNext()) {
			  Row r= rows.next();
			  if(r.getCell(column).getStringCellValue().equalsIgnoreCase("Abhishek")) {
				  Iterator<org.apache.poi.ss.usermodel.Cell> cv= r.cellIterator();
				  while(cv.hasNext()) {
					  Cell c= cv.next();
					  if(c.getCellType()==CellType.STRING) {
					  a.add(cv.next().getStringCellValue());
					  }else {
						  a.add(c.getNumericCellValue());
					  }
				  }
			  }
		  }
		  
	  }
	  }
	  return a;
	}
	
}
