package TestNGPack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PomModule.AirIndia;
import PomModule.LowCostAirlineInIndia;
import PomModule.MulticityStopover;
import Utils.Utility;

public class TestClassTestNG2 {
	private WebDriver driver;
 private ArrayList<String> addr;
 
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
	public void MulticityTravling4() throws EncryptedDocumentException, IOException {
		System.out.println("test1");

	  	AirIndia airIndia  =new AirIndia(driver);
	  	airIndia.clickMultiCity();
	  	
		 addr = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(addr.get(1));
		 
		 MulticityStopover multicityStopover   = new MulticityStopover(driver);
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
			String ExpectedTitle = "Multicity Stopover";
			String ExpectedURL   = "https://www.airindia.in/multicity.htm";
					
			if(ActualTitle.equals(ExpectedTitle) && ActualURL.equals(ExpectedURL) ) {
					
				System.out.println("Test Pass");
			}
			else 
			{
				System.out.println("Test Fail");
			}
	}
	@Test(priority= 1)
	public void AirIndiaExpress5 () throws InterruptedException {
	
		System.out.println("test2");

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
	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
		

		 addr = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(addr.get(0));
		 
	}
	@AfterClass
	public void afterClass() {
		System.out.println("AfterClass");
		driver.quit();
	}
}
