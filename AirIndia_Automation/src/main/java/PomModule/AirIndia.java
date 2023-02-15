package PomModule;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AirIndia {
 
	
	
	
	private Actions act;
	
	@FindBy (xpath ="//input[@name='from']")
	private WebElement sourceLocation; 
	
	@FindBy (xpath = "//input[@name='to']")
	private WebElement destinationLocation;
	
	@FindBy (xpath = "//select[@id='concessionaryType1']")
	private WebElement consetionaryType;
	
	@FindBy (xpath = "//select[@id='ddladult1']")
	private WebElement adultDropDown;
	
	@FindBy (xpath = "//select[@id='ddlchildren1']")
	private WebElement childrenDropDown;
	
	@FindBy (xpath = "//select[@id='ddlinfants1']")
	private WebElement infantDropDown;
	
	@FindBy (xpath = "//input[@title='Departing']")
	private WebElement departingDate;
	
	@FindBy (xpath = "(//a[text()='24'])[1]")
	private WebElement departing24Date;
	
	@FindBy (xpath = "//input[@name='_retdateeu1']")
	private WebElement returningDate;
	
	@FindBy (xpath = "//a[text()='30']")
	private WebElement returning30Date;

	@FindBy (xpath = "//input[@id='btnbooking']")
	private WebElement searchButton;
	
	@FindBy (xpath ="(//a[text()='Manage'])[2]")
	private WebElement manage;
	
	@FindBy (xpath = "(//a[text()='Flight Schedule'])[2]")
	private WebElement flightTimetable;
	
	
	@FindBy (xpath = "(//a[text()='Offers'])[2]")
	private WebElement offers;
	
	
	@FindBy (xpath = "(//a[text()='Domestic Schemes'])[2]")
	private WebElement domesticSchemes;
	

	@FindBy (xpath = "//a[contains(text(),'Multi City')]")
	private WebElement multicity;
	
	@FindBy (xpath = "//a[text()='Air India Express']")
	private WebElement airIndiaExpress;
	
	public AirIndia (WebDriver driver) {
		
		PageFactory.initElements(driver,this);
		
		act = new Actions(driver);
	}
	
	
	public void sendSourceLocation(){
		sourceLocation.sendKeys("Mumbai, Chhatrapati Shivaji International Airport, BOM, India, IN");
	}
	
	public void sendDestinationLocation() {
		destinationLocation.sendKeys("Delhi, Indira Gandhi International Airport, DEL, India, IN");
	}
	
	public void selectConsetionaryType() {
		Select a = new Select(consetionaryType);
		a.selectByValue("Student");
	}

	public void selectAdultDropDown() {
		Select a = new Select(adultDropDown);
		a.selectByValue("5");
	}

	public void selectChildrenDropDown() {
		Select a = new Select(childrenDropDown);
		a.selectByValue("4");
	}

	public void selectInfantDropDown() {
		Select a = new Select(infantDropDown);
		a.selectByValue("2");
	}

	public void clickDepartingDate() {
		departingDate.click();
	}
	
	public void clickDeparting24Date() {
		departing24Date.click();
	}
	public void clickReturningDate() {
		returningDate.click();
	}
	
	public void clickReturning30Date() {
		returning30Date.click();
	}
	
	
	public void clickSearchButton() {
		searchButton.click();
	}
	
	
	public void selectManage() {
		act.moveToElement(manage).click().build().perform();
	}
	
	public void selectFlightTimetable() {
act.moveToElement(flightTimetable).click().build().perform();
		}
	
	public void selectOffers() {
		act.moveToElement(offers).click().build().perform();
	}
	public void selectDomesticSchemes() {
	act.moveToElement(domesticSchemes).click().build().perform();
	}
	
	public void clickMultiCity() {
		multicity.click();
	}
	public void clickAirIndiaExpress() {
		airIndiaExpress.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
