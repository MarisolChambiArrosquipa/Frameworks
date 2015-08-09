package setUpWeb;


import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;






import utility.Constants;
import utility.Log;
//import utility.ReadExcel;

public class Utility {
	
	public static WebDriver driver;
	public static WebDriver ChooseBrowser(String browser)
	{
		//try{
		
		browser= browser.toUpperCase().trim();
		//if(driver==null)
    	//{
    	
		if(browser.equals("CHROME"))
	    {
	    		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sol\\Desktop\\Project_Todo\\broswer\\chromedriver.exe");
	    		driver=new ChromeDriver();
	    		Log.info("start the webdriver :"+browser);
	    	
	    	
		}
		else if(browser.equals("MOZILLA"))
		{
			driver=new FirefoxDriver();
			Log.info("start the webdriver :"+browser);
		}
    		
		
		else if(browser.equals("IEXPLORE"))
		{
			System.setProperty("webdriver.ie.driver","C:\\Users\\Sol\\Desktop\\Project_Todo\\broswer\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
			Log.info("start the webdriver :"+browser);
		}
		//}
    	
		/*catch(Exception e)
		{
			e.getMessage();
		}*/
				
		return driver;
				
				
	}
	
	
 public static void waitForElement(WebElement element){
		 
		 WebDriverWait wait = new WebDriverWait(driver, 10);
	     wait.until(ExpectedConditions.elementToBeClickable(element));
	 	}

 
 ///////usar testcase para ponerlo en el reporte
 public static String getTestCaseName(String sTestCase)throws Exception{
		String value = sTestCase;
		try{
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");	
			value = value.substring(posi + 1);
			return value;
				}catch (Exception e){
			Log.error("Class Utils | Method getTestCaseName | Exception desc : "+e.getMessage());
			throw (e);
					}
			}
	
 //read el test case desde el excel
 public static String getTestCaseNames(String sTestCase)throws Exception{
		String value = sTestCase;
		try{
			int posi = value.indexOf("_");
			value = value.substring(0, posi);
			//posi = value.lastIndexOf(".");	
			//value = value.substring(posi + 1);
			return value;
				}catch (Exception e){
			Log.error("Class Utils | Method getTestCaseName | Exception desc : "+e.getMessage());
			throw (e);
					}
			}
	public static void ImplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	}
	
	
	
	public static void ExplicitWait(WebDriver driver,WebElement text)
	{
	  (new WebDriverWait(driver,60)).until(ExpectedConditions.elementToBeClickable(text));
	  
	}
}
