package AirIndiaPackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PomModule.AirIndia;
import PomModule.FlightSchedule;
import Utils.Utility;

public class FlightTimeTableCheck2 {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Downloads\\softwere testing\\automation\\selenium\\chromedriver_win32\\chromedriver.exe");		
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
  	driver.get("https://www.airindia.in");
	
	
  	AirIndia airIndia =new AirIndia (driver);
  	airIndia.selectManage();
  	airIndia.selectFlightTimetable();
	
  	FlightSchedule flightSchedule = new FlightSchedule(driver);
  	flightSchedule.clickOneWaybutton();
  	flightSchedule.sendFromDate();
  	flightSchedule.sendFromSrc(Utility.getDataFromExel("AirIndia", 4, 8));
  	flightSchedule.sendtToDesti(Utility.getDataFromExel("AirIndia", 5, 8));
  	flightSchedule.clickResetButton();
  	
  	flightSchedule.clickRoadTripButton();
  	flightSchedule.sendFromDate();
  	flightSchedule.sendToDate();
  	flightSchedule.sendFromSrc(Utility.getDataFromExel("AirIndia", 4, 8));
  	flightSchedule.sendtToDesti(Utility.getDataFromExel("AirIndia", 5, 8));
  	flightSchedule.clickSubmitButton();
	

	String ActualTitle = driver.getTitle();
	String ActualURL   = driver.getCurrentUrl();

			
	String ExpectedTitle = "Flight Schedule";
	String ExpectedURL   = "https://www.airindia.in/flight-timetable.htm";	
			
	if(ActualTitle.equals(ExpectedTitle) && ActualURL.equals(ExpectedURL) ) {
			
		System.out.println("Test Pass");
	}
	else 
	{
		System.out.println("Test Fail");
	}

	
	
	
	
	
	
	
	
	}
}
