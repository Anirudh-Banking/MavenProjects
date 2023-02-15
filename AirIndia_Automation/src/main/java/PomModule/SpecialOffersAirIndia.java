package PomModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpecialOffersAirIndia {
	
	@FindBy (xpath = "(//a[text()='Concessionary Fare'])[1]")
	private WebElement concetionayFair;
	
	public SpecialOffersAirIndia (WebDriver driver) {
		
		PageFactory.initElements(driver,this);

	}
	
	
	public void clickConcetionayFair(){
		concetionayFair.click();
		
	}
	
}
