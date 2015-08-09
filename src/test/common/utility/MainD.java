package utility;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class MainD {

	WebDriver driver;
	@BeforeTest
	public void Setup()
	{
			
		try {
			driver= new FirefoxDriver();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void Test()
	{
		try {
			
			driver.get("https://www.google.com.bo");
			WebElement ele=FindElementsFrameWork.GetElement(TypeElement.NAME.getValue(),"q",driver);
			ele.sendKeys("hola");

		}
		catch(NoSuchElementException see)
		{
			see.getMessage();
		}
		catch (Exception e) {
			e.getMessage();
		}
	}

	
}
