package PomModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LowCostAirlineInIndia {

	@FindBy (xpath = "//select[@id='departureCityDrop']")
	private WebElement departureAiport;
	
	@FindBy (xpath = "//select[@id='arrivalCityDrop']")
	private WebElement arrivalAiport;

	@FindBy (xpath = "//select[@id='adults']")
	private WebElement adult;

	@FindBy (xpath = "//label[@for='rdOneway']")
	private WebElement oneWay;
	
	@FindBy (xpath = "//button[@value='BOOK']")
	private WebElement book;
	
	public LowCostAirlineInIndia (WebDriver driver) {
		
		PageFactory.initElements(driver,this);

	}
	
	
	public void selectDepartureAiport(){
		Select s= new Select(departureAiport);
		 s.selectByValue("BOM");
		}
	public void selectArrivalAiport(){
		 Select se= new Select(arrivalAiport);
			se.selectByValue("PNQ");
	}	
	public void sendAdult(){
		 adult.sendKeys("2");
		 }	
	
	public void clickOneWay(){
		 oneWay.click();	
		 }
	public void clickBook(){
		 book.click();
	}
}
