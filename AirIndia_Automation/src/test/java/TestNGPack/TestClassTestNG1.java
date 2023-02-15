package TestNGPack;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PomModule.AirIndia;
import PomModule.ConcesionaryFare;
import PomModule.FlightSchedule;

import PomModule.SpecialOffersAirIndia;

public class TestClassTestNG1 {

	private WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("@BeforeClass");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Downloads\\softwere testing\\automation\\selenium\\chromedriver_win32\\chromedriver.exe");		
		 driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod");
	  	driver.get("https://www.airindia.in");
	  	
	}
	
	@Test 
	public void AirIndiaSearchFlight1() {
		System.out.println("Test");

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
	
	@Test(priority =1)
	public void FlightTimeTableCheck2() {
		System.out.println("test2");

	  	AirIndia airIndia =new AirIndia (driver);
	  	airIndia.selectManage();
	  	airIndia.selectFlightTimetable();
		
	  	FlightSchedule flightSchedule = new FlightSchedule(driver);
	  	flightSchedule.clickOneWaybutton();
	  	flightSchedule.sendFromDate();
	  	flightSchedule.sendFromSrc();
	  	flightSchedule.sendtToDesti();
	  	flightSchedule.clickResetButton();
	  	
	  	flightSchedule.clickRoadTripButton();
	  	flightSchedule.sendFromDate();
	  	flightSchedule.sendToDate();
	  	flightSchedule.sendFromSrc();
	  	flightSchedule.sendtToDesti();
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
	
	@Test (priority =2)
	public void StudentConsessioanaryEligibility3() {
		System.out.println("test3");

	  	AirIndia airIndia  =new AirIndia(driver);
	  	airIndia.selectOffers();
	  	airIndia.selectDomesticSchemes();
		
	  	
	  	SpecialOffersAirIndia specialOffersAirIndia = new  SpecialOffersAirIndia(driver);
	  			specialOffersAirIndia.clickConcetionayFair();
	  			
	  	ConcesionaryFare concesionaryFare = new ConcesionaryFare(driver);
	  	concesionaryFare.clickStudentConcetion();
	  	concesionaryFare.printcells();
		
		

		String ActualTitle = driver.getTitle();
		String ActualURL   = driver.getCurrentUrl();

				
		String ExpectedTitle = "Student Concession - Air India";
		String ExpectedURL   = "https://www.airindia.in/student-concession.htm";	
				
		if(ActualTitle.equals(ExpectedTitle) && ActualURL.equals(ExpectedURL) ) {
				
			System.out.println("Test Pass");
		}
		else 
		{
			System.out.println("Test Fail");
		}
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
		
	}
	@AfterClass
	public void afterClass() {
		System.out.println("AfterClass");
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
