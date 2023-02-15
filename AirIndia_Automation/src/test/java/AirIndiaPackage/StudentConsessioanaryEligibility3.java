package AirIndiaPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PomModule.AirIndia;
import PomModule.ConcesionaryFare;
import PomModule.SpecialOffersAirIndia;

public class StudentConsessioanaryEligibility3 {

	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Downloads\\softwere testing\\automation\\selenium\\chromedriver_win32\\chromedriver.exe");		
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
  	driver.get("https://www.airindia.in");
	
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
}
