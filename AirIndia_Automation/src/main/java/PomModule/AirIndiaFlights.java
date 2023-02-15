package PomModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AirIndiaFlights {

	@FindBy (xpath ="//input[@id='tpl3_cell-bound-0-ff-0-flight-1']")
	private WebElement selectTime;
	
	@FindBy (xpath ="//input[@id='tpl3_cell-bound-1-ff-0-flight-0']")
	private WebElement selectTime2;
	
	@FindBy (xpath ="//input[@id='tpl3_cell-bound-2-ff-0-flight-0']")
	private WebElement selectTime3;
	
	@FindBy (xpath ="//span[text()='continue']")
	private WebElement continues;
	
	public AirIndiaFlights (WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	 
    public void clickSelectTime() {
    	selectTime.click(); 
    } 
    public void clickSelectTime2() {
    	selectTime2.click(); 
    } 
    public void clickSelectTime3() {
    	selectTime3.click(); 
    } 
    public void clickContinues() {
    	continues.click(); 
    } 
  
}
