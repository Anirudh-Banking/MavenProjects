package AirIndiaPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PomModule.AirIndia;

public class AirIndiaSearchFlight1 {
	
	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Downloads\\softwere testing\\automation\\selenium\\chromedriver_win32\\chromedriver.exe");		
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
  	driver.get("https://www.airindia.in");
   	
   
  	AirIndia airIndia =new AirIndia(driver);
  	airIndia.sendSourceLocation();
  	airIndia.sendDestinationLocation();
  	airIndia.selectConsetionaryType();
  	airIndia.selectAdultDropDown();
  	airIndia.selectChildrenDropDown();
  	airIndia.selectInfantDropDown();
  	airIndia.clickDepartingDate();
  	airIndia.clickDeparting24Date();
  	airIndia.clickReturningDate();
  	airIndia.clickReturning30Date();
  	airIndia.clickSearchButton();
	

	String ActualTitle = driver.getTitle();
	String ActualURL   = driver.getCurrentUrl();

			
	String ExpectedTitle = "Air India";
	String ExpectedURL   = "https://www.airindia.in/";	
			
	if(ActualTitle.equals(ExpectedTitle) && ActualURL.equals(ExpectedURL) ) {
			
		System.out.println("Test Pass");
	}
	else 
	{
		System.out.println("Test Fail");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
