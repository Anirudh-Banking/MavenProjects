package AirIndiaPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PomModule.AirIndia;

import PomModule.MulticityStopover;
import Utils.Utility;

public class MulticityTravling4 {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Downloads\\softwere testing\\automation\\selenium\\chromedriver_win32\\chromedriver.exe");		
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
  	driver.get("https://www.airindia.in");
	
  	AirIndia airIndia  =new AirIndia(driver);
  	airIndia.clickMultiCity();
	
  	 
	 ArrayList<String>addr = new ArrayList<String>(driver.getWindowHandles());
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
	 
	// Thread.sleep(25000);
	
	// AirIndiaFlights airIndiaFlights = new AirIndiaFlights(driver);
	// airIndiaFlights.clickSelectTime();
	// airIndiaFlights.clickSelectTime2();
	// airIndiaFlights.clickSelectTime3();
	// airIndiaFlights.clickContinues();
	

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
}
