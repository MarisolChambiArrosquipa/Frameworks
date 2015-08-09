package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ActionKeywords {
	
	 public static WebDriver driver;
	 public static String [] keywords;
	 public static String [] datos;  
	 public ActionKeywords(String name) throws Exception{
		 
		 switch(name)
		 {
		 
		// case "Login": keywords=ReadExcel.BuscarType(Constants.Prueba);//recuperrar los datos de keywords fila y datos  4 parametros de datos,;
		 case "CreateAccount"://lo mismo
		default: System.out.println("necesita definir en un excel file para poder lleer aqui");break;
		 }
		 
	 }
	 
	 
	 
	 
	 
	public static WebDriver openBrowser(String browser)
	{
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
	public void navegator(String url)
	{
		driver.get(url);
		//pedir de mi testcase
	}
	public void click(String elementkey,String elementValue)
	{
		WebElement element=FindElementsFrameWork.GetElement(elementkey,elementValue,driver);
		element.click();
		//leerlo de mi dato
	}
	public void closeBrowser(WebDriver Browser)
	{
		
		Browser.close();
		//errerlo de mi daro
	}
	//solo le pararemos 1 parametro a la case
	public  void input(String elementKey,String elementValue,String dato){
		//read de mi dato
		WebElement element=FindElementsFrameWork.GetElement(elementKey, elementValue, driver);
		element.sendKeys(dato);
	}
}
