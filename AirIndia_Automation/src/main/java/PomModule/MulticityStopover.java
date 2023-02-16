package PomModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MulticityStopover {

	@FindBy (xpath = "//input[@id='ContentPlaceHolder1_MultiCityFlexParam_listView_txtFrom_0']")
	private WebElement fromPune;
	
	
	@FindBy (xpath = "(//input[contains(@id,'MultiCityFlexParam_listView_txtTo_0')])[1]")
	private WebElement toMumbai;
	

	@FindBy (xpath ="(//input[contains(@id,'MultiCityFlexParam_listView_txtDepart_0')])[1]")
	private WebElement firstDate;
	
	@FindBy (xpath ="//input[@id='ContentPlaceHolder1_MultiCityFlexParam_listView_txtTo_1']")
	private WebElement toDelhi;
	

	@FindBy (xpath ="//input[@id='ContentPlaceHolder1_MultiCityFlexParam_listView_txtTo_2']")
	private WebElement toPune;
	
	@FindBy (xpath ="//select[@id='ContentPlaceHolder1_MultiCityFlexParam_ddlAdult']")
	private WebElement adult;
	
	@FindBy (xpath ="//select[@id='ContentPlaceHolder1_MultiCityFlexParam_ddlChildren']")
	private WebElement children;
	
	@FindBy (xpath ="//select[@id='ContentPlaceHolder1_MultiCityFlexParam_ddlInfants']")
	private WebElement infant;
	
	@FindBy (xpath ="//select[@id='ContentPlaceHolder1_MultiCityFlexParam_ddlCommercialFareFamily']")
	private WebElement cabin;
	
	@FindBy (xpath ="//input[@value='Search Flight']")
	private WebElement search;
	
	public MulticityStopover (WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	
	public void sendFromPune(String froPune){
		 fromPune.sendKeys(froPune);
	}
	
	public void sendToMumbai(String tMumbai) {
		 toMumbai.sendKeys(tMumbai);
		 }

	public void sendFirstDate() {
		 firstDate.sendKeys("31/01/2023");	
		 }

	public void sendToDelhi(String tDelhi) {
		toDelhi.sendKeys( tDelhi);	
		}

	public void sendToPune(String tPune) {
		 toPune.sendKeys( tPune);	
		 }
	
	public void selectAdult() {
		 Select s = new Select(adult);
		 s.selectByValue("4");		 
	}			
      public void selectChildren() {
    	  Select e = new Select(children);
    		 e.selectByValue("1");		 
				
	}
      public void selectInfant() {
    	  Select l= new Select(infant);
    		 l.selectByValue("1");				 
				
	}
      public void selectCabin() {
    	  Select le= new Select(cabin);
    		 le.selectByValue("2");		 
      }
      
      public void clickSearch() {
    	  search.click(); 
      }
      
   
      }

