package parallerExcution;

import java.io.IOException;
import java.util.ArrayList;
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

import PomModule.AirIndia;
import PomModule.LowCostAirlineInIndia;
import PomModule.MulticityStopover;
import Utils.Utility;
import base.Browser;

public class AirIndiaTestNG2  extends Browser {

	private WebDriver driver;
	private ArrayList<String> addr;
	private AirIndia airIndia;
	private MulticityStopover multicityStopover;
	private  LowCostAirlineInIndia lowCostAirlineInIndia;
	String testID ;
	
@Parameters("browser123")
@BeforeTest
public void launchBrowser(String browser) {
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
public void creatPOMObjects() {
	 airIndia  =new AirIndia(driver);
	 multicityStopover   = new MulticityStopover(driver);
	 lowCostAirlineInIndia  =new LowCostAirlineInIndia(driver);
		driver.get("https://www.airindia.in");
}
@BeforeMethod
public void beforeMethod() {

}
@Test 
public void MulticityTravling4() throws EncryptedDocumentException, IOException  {
	testID = "104";
	airIndia.clickMultiCity();
  	
	 addr = new ArrayList<String>(driver.getWindowHandles());
	 driver.switchTo().window(addr.get(1));
	 
	
	 multicityStopover.sendFromPune(Utility.getDataFromExel("AirIndia", 11, 8));
	 multicityStopover.sendToMumbai(Utility.getDataFromExel("AirIndia", 12, 8));
	 multicityStopover.sendFirstDate();
	 multicityStopover.sendToDelhi(Utility.getDataFromExel("AirIndia", 13, 8));
	 multicityStopover.sendToPune(Utility.getDataFromExel("AirIndia", 11, 8));
	 multicityStopover.selectAdult();
	 multicityStopover.selectChildren();
	 multicityStopover.selectInfant();
	 multicityStopover.selectCabin();
	 multicityStopover.clickSearch();
	driver.navigate().back();

		String ActualTitle = driver.getTitle();
		String ActualURL   = driver.getCurrentUrl();	
		String expectedTitle = "Multicity Stopover";
		String expectedURL   = "https://www.airindia.in/multicity.htm";
		Assert.assertEquals(ActualTitle, expectedTitle);	
		Assert.assertEquals(ActualURL, expectedURL);		
	
}
@Test(priority= 1)
public void AirIndiaExpress5 () throws InterruptedException {
	testID = "105";

  	
  	airIndia.clickAirIndiaExpress();
  	lowCostAirlineInIndia.selectDepartureAiport();
  	lowCostAirlineInIndia.selectArrivalAiport();
  	lowCostAirlineInIndia.sendAdult();
  	lowCostAirlineInIndia.clickOneWay();
  	lowCostAirlineInIndia.clickBook();
	Thread.sleep(2000);
  	driver.navigate().back();

	String ActualTitle = driver.getTitle();
	String ActualURL   = driver.getCurrentUrl();

			
	String expectedTitle = "Low Cost Airline In India | Book Cheap Flight Tickets Online";
	String expectedURL   = "https://www.airindiaexpress.in/en";
	Assert.assertEquals(ActualTitle, expectedTitle);	
	Assert.assertEquals(ActualURL, expectedURL);		

	
	
}
@AfterMethod
public void afterMethod( ITestResult result) throws IOException {
	
	if (ITestResult.FAILURE == result.getStatus()){
		  Utility.captureScreenshot(  driver ,testID);
	}
	addr = new ArrayList<String>(driver.getWindowHandles());
	 driver.switchTo().window(addr.get(0));
	 
}
@AfterClass
public void afterClass() {

	 airIndia  =null;
	 multicityStopover   = null;
	 lowCostAirlineInIndia  =null;
	
}

@AfterTest
public void afterTest() {
	driver.quit();
	driver= null;
	System.gc();
	
}

	
	

	
	
	}
