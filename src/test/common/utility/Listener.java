package utility;

import java.io.File;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;


import setUpWeb.BaseClass;
@Listeners(value= Listener.class)
//@Listeners(value= Listener.class)
public class Listener implements ITestListener, IInvokedMethodListener {

	public void onFinish(ITestContext arg0) {
		Reporter.log("Completed executing........ test " + arg0.getName(), true);
	}

	public void onStart(ITestContext arg0) {
		Reporter.log("About to begin executing test " + arg0.getName(), true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
		
	}
   
	public void onTestFailure(ITestResult arg0) {
try{		
		File file=new File("");
		Reporter.setCurrentTestResult(arg0);
		String name=arg0.getClass().getName();
		
System.out.println(file.getAbsolutePath());
Reporter.log(file.getAbsolutePath());
Reporter.log("Screenshot saved at"+ file.getAbsolutePath()+"\\reports\\"+arg0.getName()+".jpg");
Reporter.log("<a href='../"+arg0.getClass().getName()+".jpg' <img src='../"+arg0.getName()+".jpg' hight='100' width='100' /> </a>");
Reporter.log("el driver esssss:" +BaseClass.driver   + "name es:"+ name   +" or es asi:" +arg0.getClass().getName());

takeScreenshot(BaseClass.driver,BaseClass.nameTestCase);

} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		//takeScreenshot(this);
      printTestResults(arg0);
		
	}
	public static void takeScreenshot(WebDriver driver, String testCaseName) throws Exception
	 {
		 try{
			
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(Constants.Path_ScreenShot+"\\" + testCaseName +".jpg"));	
			} catch (Exception e){
				Log.error(" Method takeScreenshot | Exception occured while capturing ScreenShot : "+e.getMessage());
				throw new Exception();
			}
	 }

	private void printTestResults(ITestResult result) {
		Reporter.log("TestName = " + result.getTestName(), true);
		Reporter.log("Test Method resides in " + result.getTestClass().getName(), true);
		if (result.getParameters().length != 0) {
			String params = null;
			for (Object parameter : result.getParameters()) {
				params += parameter.toString() + ",";
			}
			Reporter.log("Test Method had the following parameters : " + params, true);
		}
		String status = null;
		switch (result.getStatus()) {
		case ITestResult.SUCCESS:
			status = "Pass";
			break;
		case ITestResult.FAILURE:
			status = "Failed";
			break;
		case ITestResult.SKIP:
			status = "Skipped";
		}
		Reporter.log("Test Status: " + status, true);
	}

	public void onTestSkipped(ITestResult arg0) {
		printTestResults(arg0);
	}

	public void onTestStart(ITestResult arg0) {
	}

	public void onTestSuccess(ITestResult arg0) {
		printTestResults(arg0);
	}

	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		String textMsg = "Completed executing " + returnMethodName(arg0.getTestMethod());
		Reporter.log(textMsg, true);

	}

	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		String textMsg = "About to begin executing " + returnMethodName(arg0.getTestMethod());
		Reporter.log(textMsg, true);
	}

	private String returnMethodName(ITestNGMethod method) {
		return method.getRealClass().getSimpleName() + "." + method.getMethodName();
	}
	
}


