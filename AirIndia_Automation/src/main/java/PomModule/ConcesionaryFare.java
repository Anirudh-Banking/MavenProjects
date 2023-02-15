package PomModule;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConcesionaryFare {
  
     
    
     
	@FindBy (xpath = "//a[text()='Student Concession']")
	private WebElement studentConcetion;
	

	@FindBy (xpath = "(//table[@class='tableData'])")
	private List<WebElement> cells;
	

	public ConcesionaryFare (WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	
	public void clickStudentConcetion(){
		studentConcetion.click();
	}

	public void printcells(){
		
	    int noOfCells =cells.size();
	    System.out.println(noOfCells);

	    for(int i = 0;  i<noOfCells; i++)
	       {
	    	WebElement c = cells.get(i);
	    	System.out.println(c.getText());
			 
	       }
	}
}
