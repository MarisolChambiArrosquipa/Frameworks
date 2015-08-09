package testWeb;



import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appWeb.Login;
import setUpWeb.BaseClass;
import setUpWeb.Utility;
import utility.Constants;
import utility.DataProviders;
import utility.FindElementsFrameWork;
import utility.Listener;
import utility.Log;
import utility.ReadExcel;
import utility.TypeElement;

@Listeners(value= Listener.class)
public class VerifyThatClickButtonGoogle {

	public WebDriver driver;
	private String stestCaseName;
	Navegar navegar;
	//private int iTestCaseRow;
	
	
	@BeforeMethod
	public void SetUp() throws Exception
	{
	    DOMConfigurator.configure("log4j.xml");//moverlooooo y llamarlo cuando para todos los testcase pero solo una vez
		stestCaseName=this.toString();
		stestCaseName=Utility.getTestCaseName(stestCaseName);
		Log.startTestCase(stestCaseName);
		
	}
	@DataProvider(name="FillElement")
	public Object[][] FillUpElement() throws Exception
	{
		
		return ReadExcel.FillUpMatrix(Constants.Path_TestData,Constants.File_TestData,Constants.Sheet);
		
						
	}
	

	@Test(dataProvider="FillElement")
	public void TestVerify(String search,String browser,String url) throws Exception
	{
		//try {
		System.out.println(search);
		System.out.println(browser);
		System.out.println(url);
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
			//navegar.Nave(search);
			//navegar.Click();
			//System.out.println(TypeElement.NAME.getValue());
			//WebElement element=FindElementsFrameWork.GetElement(TypeElement.NAME.getValue(),"q", driver);
			//element.sendKeys(search);
		}

			
}

	@AfterTest
	public void tearDown()
	{
		driver.close();
		Log.info("Termino la ejecucion del test");
		Log.endTestCase(stestCaseName);
	}
}