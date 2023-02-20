package parallerExcution;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import PomModule.AirIndia;
import PomModule.ConcesionaryFare;
import PomModule.FlightSchedule;
import PomModule.SpecialOffersAirIndia;
import Utils.Utility;
import base.Browser;

public class AirIndiaTestNG1 extends Browser {
	
	private WebDriver driver;
	private AirIndia airIndia;
	private FlightSchedule flightSchedule;
	private SpecialOffersAirIndia specialOffersAirIndia;
	private ConcesionaryFare concesionaryFare;
	private	String testID;
	
	private static ExtentTest test;
	private static ExtentHtmlReporter reporter;
@Parameters("browser123")
@BeforeTest
public void launchBrowser(String browser) {
	
	reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
	ExtentReports extend = new ExtentReports();
	extend.attachReporter(reporter);
	
	if(browser.equals("chrome")) {
        
		driver =openChromeBrowser();
		
	}	
	 if(browser.equals("Firefox")) {
		driver = openFirefoxBrowser();
		 
		}

		if(browser.equals("edge")) {
			
		driver = openEdgeBrowser();	
		}

		
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
}
@BeforeClass
public void creatPOMObject() {
	
	airIndia =new AirIndia(driver);
	flightSchedule = new FlightSchedule(driver);
	specialOffersAirIndia = new  SpecialOffersAirIndia(driver);
	 concesionaryFare = new ConcesionaryFare(driver);
	driver.get("https://www.airindia.in");
}
@BeforeMethod
public void beforeMethod() throws EncryptedDocumentException, IOException {

}
@Test 
public void AirIndiaSearchFlight1() throws EncryptedDocumentException, IOException  {
	testID = "101";
  	airIndia.sendSourceLocation(Utility.getDataFromExel("AirIndia", 1, 8));
  	airIndia.sendDestinationLocation(Utility.getDataFromExel("AirIndia", 2, 8));
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
	String expectedTitle= "Air India";
	String ActualURL   = driver.getCurrentUrl();
	String expectedURL = "https://www.airindia.in/";
	
		Assert.assertEquals(ActualTitle, expectedTitle);	
		Assert.assertEquals(ActualURL, expectedURL);	
}

@Test(priority =1)
public void FlightTimeTableCheck2() throws EncryptedDocumentException, IOException {
	testID = "102";
	airIndia.selectManage();
  	airIndia.selectFlightTimetable();
	
  
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
  //	flightSchedule.clickSubmitButton();
	
	String ActualTitle = driver.getTitle();
	String expectedTitle = "Flight Schedule";
	String ActualURL   = driver.getCurrentUrl();
	String expectedURL="https://www.airindia.in/flight-timetable.htm";
	Assert.assertEquals(ActualTitle, expectedTitle);
	Assert.assertEquals(ActualURL, expectedURL);

}
@Test (priority =2)
public void StudentConsessioanaryEligibility3() throws InterruptedException {
	testID = "103";
  	airIndia.selectOffers();
  	airIndia.selectDomesticSchemes();
  	Thread.sleep(2000);
  	specialOffersAirIndia.clickConcetionayFair();
  	
  	concesionaryFare.clickStudentConcetion();
  	concesionaryFare.printcells();
	
	String ActualTitle = driver.getTitle();
	String expectedTitle ="Student Concession - Air India";
	String ActualURL   = driver.getCurrentUrl();
	String expectedURL ="https://www.airindia.in/student-concession.htm";
	Assert.assertEquals(ActualTitle, expectedTitle);
	Assert.assertEquals(ActualURL, expectedURL);
}
@AfterMethod
public void afterMethod( ITestResult result) throws IOException {

	
	  if (ITestResult.FAILURE == result.getStatus()){
		  Utility.captureScreenshot(driver ,testID);
	  }
	
	
	
}
@AfterClass
public void afterClass() {


	
	airIndia =null;
	flightSchedule =null;
	specialOffersAirIndia =null;
	concesionaryFare =null;
}

@AfterTest
public void afterTest() {

	driver.quit();
	driver= null;
	System.gc();
	
}

































































}
