package AirIndiaPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PomModule.AirIndia;
import PomModule.LowCostAirlineInIndia;

public class AirIndiaExpress5 {

	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Downloads\\softwere testing\\automation\\selenium\\chromedriver_win32\\chromedriver.exe");		
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
  	driver.get("https://www.airindia.in");
	
  	AirIndia airIndia  =new AirIndia(driver);
  	airIndia.clickAirIndiaExpress();
	
  	LowCostAirlineInIndia lowCostAirlineInIndia  =new LowCostAirlineInIndia(driver);
  	lowCostAirlineInIndia.selectDepartureAiport();
  	lowCostAirlineInIndia.selectArrivalAiport();
  	lowCostAirlineInIndia.sendAdult();
  	lowCostAirlineInIndia.clickOneWay();
  	lowCostAirlineInIndia.clickBook();
	Thread.sleep(2000);
  	driver.navigate().back();

	String ActualTitle = driver.getTitle();
	String ActualURL   = driver.getCurrentUrl();

			
	String ExpectedTitle = "Low Cost Airline In India | Book Cheap Flight Tickets Online";
	String ExpectedURL   = "https://www.airindiaexpress.in/en";
			
	if(ActualTitle.equals(ExpectedTitle) && ActualURL.equals(ExpectedURL) ) {
			
		System.out.println("Test Pass");
	}
	else 
	{
		System.out.println("Test Fail");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
