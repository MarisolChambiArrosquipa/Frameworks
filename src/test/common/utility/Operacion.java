package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import setUpWeb.BaseClass;
import setUpWeb.Utility;

public class Operacion extends BaseClass{

	public Operacion(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//	public static WebDriver driver;
	
	public static void ActionKeywords(String operacion,String keywork,String datkey,String data){
		
		System.out.println(operacion.toUpperCase()+ ":Key:"+keywork+ ":dtokey:"+datkey+":dato:"+data);
		operacion=operacion.toUpperCase().trim();
		
		switch(operacion){
		
		case "OPENBROWSER": driver=OpenBrowser(data);break;
		case "NAVIGATE":Navigate(data);Utility.ImplicitWait(driver);break;
		case "INPUT":Input(keywork,datkey,data);Utility.ImplicitWait(driver);break;
		case "CLICK": Click(keywork,datkey);Utility.ImplicitWait(driver);break;
		case "CLOSEBROWSER": CloseBrowser();break;

		}
		
		
	}

	private static void CloseBrowser() {
		driver.close();
		driver = null;		
	}

	private static void Click(String keywork, String datkey) {
		
		System.out.println(keywork+  ":DAtosClickssss:"+datkey);
		//Utility.ImplicitWait(driver);
		WebElement button=FindElementsFrameWork.GetElement(keywork.toUpperCase(), datkey, driver);
		if(button==null)
		{
			System.out.println("No recupero elementos");
			
		}else{
			Utility.ExplicitWait(driver, button);
			button.click();
		}
		
		// TODO Auto-generated method stub
		
	}

	private static void Input(String keywork, String datkey, String data) {
		// TODO Auto-generated method stub
		
		WebElement input=FindElementsFrameWork.GetElement(keywork, datkey, driver);
		
		
		
		
			Utility.ImplicitWait(driver);
			//Utility.ExplicitWait(driver, input);
			input.sendKeys(data);
		
		
		
	}

	private static void Navigate(String data) {
		
		// TODO Auto-generated method stub
		
		driver.get(data);
		Utility.ImplicitWait(driver);
	}

	private static WebDriver OpenBrowser(String browser) {
		// TODO Auto-generated method stub
		
		browser= browser.toUpperCase().trim();
		if(driver!=null)
    	{
			return driver;
    	}
		
		if(browser.equals("CHROME"))
	    {
	    		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sol\\Desktop\\Project_Todo\\broswer\\chromedriver.exe");
	    		driver=new ChromeDriver();
	    		Utility.ImplicitWait(driver);
	    		
	    		Log.info("start the webdriver :"+browser);
	    	
	    	
		}
		else if(browser.equals("MOZILLA"))
		{
			driver=new FirefoxDriver();
			Utility.ImplicitWait(driver);
			
			Log.info("start the webdriver :"+browser);
		}
    		
		
		else if(browser.equals("IEXPLORE"))
		{
			System.setProperty("webdriver.ie.driver","C:\\Users\\Sol\\Desktop\\Project_Todo\\broswer\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
			Utility.ImplicitWait(driver);
			
			Log.info("start the webdriver :"+browser);
		}
		//}
    	
		/*catch(Exception e)
		{
			e.getMessage();
		}*/
				
		return driver;
	
	}

}
