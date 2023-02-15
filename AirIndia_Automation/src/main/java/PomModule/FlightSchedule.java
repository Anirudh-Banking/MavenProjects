package PomModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightSchedule {

	@FindBy (xpath = "(//ins[@class='iCheck-helper'])[1]")
	private WebElement oneWaybutton;
	

	@FindBy (xpath = "//input[@id='txtFromDate']")
	private WebElement fromDate;
	

	@FindBy (xpath = "//input[@id='txtFromLocation']")
	private WebElement fromSrc;
	

	@FindBy (xpath = "//input[@id='txtToLocation']")
	private WebElement toDesti;
	

	@FindBy (xpath = "//button[@onclick='Page_ClientValidateReset();return false;']")
	private WebElement resetButton;
	

	@FindBy (xpath ="(//ins[@class='iCheck-helper'])[2]")
	private WebElement roadTripButton;
	

	@FindBy (xpath ="//input[@id='txtToDate']")
	private WebElement toDate;
	

	@FindBy (xpath = "//input[@id='btnFlightTimeTable']")
	private WebElement submitButton;
	
	
	
	
	public FlightSchedule (WebDriver driver) {
		
		PageFactory.initElements(driver,this);

	}
	
	
	public void clickOneWaybutton(){
		oneWaybutton.click();
	}
	public void sendFromDate(){
		fromDate.sendKeys("25/02/2023");
	}
	public void sendFromSrc(){
		fromSrc.sendKeys("Mumbai, Chhatrapati Shivaji International Airport, BOM, India");
	}
	public void sendtToDesti(){
		toDesti.sendKeys("Delhi, Indira Gandhi International Airport, DEL, India");
	}
	public void clickResetButton(){
		resetButton.click();
	}
	public void clickRoadTripButton(){
		roadTripButton.click();
	}
	public void sendToDate(){
		toDate.sendKeys("26/02/2023");
	}
	public void clickSubmitButton(){
		submitButton.click();
	}

	
}
