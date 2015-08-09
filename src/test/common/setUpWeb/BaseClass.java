package setUpWeb;

import org.openqa.selenium.WebDriver;

import setUpWeb.BaseClass;

public class BaseClass {
	public static WebDriver driver;
	public static String nameTestCase;
	
	public  BaseClass(WebDriver driver,String name){
		BaseClass.driver = driver;
		nameTestCase=name;
	}
	public  BaseClass(WebDriver driver){
		BaseClass.driver = driver;
		
	}

}
