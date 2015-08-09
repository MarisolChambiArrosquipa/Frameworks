package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MovePositionElement {

	static WebDriver driver;
	public static void clickOnElement(WebElement mainelement, String element){
		 Actions action = new Actions(driver);
         action.moveToElement(mainelement).perform();
        	 
        	 action.moveToElement(driver.findElement(By.partialLinkText(element)));
        	 Log.info("Accessories link is found under Product Category");
        	 action.click();
             action.perform();
             Log.info("Click action is performed ");
        
	}
}
