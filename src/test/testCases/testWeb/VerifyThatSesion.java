package testWeb;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import setUpWeb.BaseClass;
import setUpWeb.Utility;
import utility.Constants;
import utility.DataProviders;
import utility.FindElementsFrameWork;
import utility.Log;
import utility.ReadExcel;
import utility.TypeElement;
import appWeb.Login;

public class VerifyThatSesion {

	public WebDriver driver;
	private String stestCaseName;
	//private int iTestCaseRow;
		
	@BeforeMethod
	public void SetUp() throws Exception
	{
	    DOMConfigurator.configure("log4j.xml");//moverlooooo y llamarlo cuando para todos los testcase pero solo una vez
		stestCaseName=this.toString();
		stestCaseName=Utility.getTestCaseName(stestCaseName);
		Log.startTestCase(stestCaseName);
		
	}
	
	@Test(dataProvider="FillElement")
	public void TestVerify(String username,String password,String address,String telefono,String data,String browser,String url) throws Exception
	{
		//try {
		
		driver=Utility.ChooseBrowser(browser);
		if(driver==null)
		{
			System.out.println("es igual a null");
			Log.info("el driver es null");
		}
		else{
			new BaseClass(driver,stestCaseName+"_"+browser);
			driver.get(url);
			Login loggin=new Login(driver);
	        loggin.StartLogin(username, password);
	        loggin.ClickButton();
	        
			
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
