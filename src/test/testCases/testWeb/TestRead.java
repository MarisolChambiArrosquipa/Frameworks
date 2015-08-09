package testWeb;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import setUpWeb.BaseClass;
import setUpWeb.Utility;
import utility.DataProviders;
import utility.Log;
public class TestRead {

	public WebDriver driver;
	private String stestCaseName;
	private Navegar navegar;
	
	@BeforeTest
	public void Setup() throws Exception
	{
		DOMConfigurator.configure("log4j.xml");//moverlooooo y llamarlo cuando para todos los testcase pero solo una vez
		stestCaseName=this.toString();
		stestCaseName=Utility.getTestCaseName(stestCaseName);
		Log.startTestCase(stestCaseName);
	}
	
	
	@Test(dataProvider="FillElement" , dataProviderClass=DataProviders.class)
	public void Test(String search,String browser,String url) throws Exception
	{
		System.out.println(search);
		System.out.println(browser);
		System.out.println(url);
		//System.out.println(links);
       // Login loggin=new Login(driver);
        //loggin.StartLogin(search, browser);
        
		driver=Utility.ChooseBrowser(browser);
		if(driver==null)
		{
			System.out.println("es igual a null");
			Log.info("el driver es null");
		}
		else{
			driver.get(url);
			
			new BaseClass(driver,stestCaseName+"_"+browser);
			//System.out.println(TypeElement.NAME.getValue());
			//navegar=new Navegar(driver);
			//navegar.Nave(search);
			//navegar.ClickButton();
			//Utility.ImplicitWait(driver);
			//navegar.clickEnlace(links);
			//navegar.ClickButtonDownlad();
			//WebElement element=FindElementsFrameWork.GetElement(TypeElement.NAME.getValue(),"q", driver);
			//element.sendKeys(search);
		}


	}
	
	@AfterTest
	public void TearDown()
	{
		
	}
}
