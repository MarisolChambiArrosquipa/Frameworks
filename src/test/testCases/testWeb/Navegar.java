package testWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import setUpWeb.BaseClass;
import utility.Constants;
import utility.FindElementsFrameWork;
import utility.ReadExcel;

public class Navegar extends BaseClass {
//WebDriver driver;
	String[] elementoPosicionKey;
	public Navegar(WebDriver driver) {
		super(driver);
//this.driver=driver;
		// TODO Auto-generated constructor stub
	}
/*	
	//@SuppressWarnings("null")
	public void Nave(String naveg) throws Exception{
		
	
	elementoPosicionKey = ReadExcel.BuscarType(Constants.Prueba);
	if(elementoPosicionKey!=null)
	{
		String search=elementoPosicionKey[0];
		String valueSearch=elementoPosicionKey[1];
		String botonkey=elementoPosicionKey[2];
		String botonvalue=elementoPosicionKey[3];
		System.out.println(search);
		search=search.toUpperCase();
		botonkey=botonkey.toUpperCase();
		System.out.println("search:"+search + "valueSearch:"+valueSearch +"botonKey:"+botonkey+ "botonValie:"+botonvalue+ elementoPosicionKey[4]+elementoPosicionKey[5]+elementoPosicionKey[6]);
	    WebElement username=FindElementsFrameWork.GetElement(search, valueSearch, driver);
	    username.sendKeys(naveg);
	    //WebElement button=FindElementsFrameWork.GetElement(botonkey, botonvalue, driver);
		//button.click();
	
	}
	else{
		System.out.println("nulllll elemento"+elementoPosicionKey[0]);
	}
	}
	public void ClickButton()
	
	{if(elementoPosicionKey!=null)
	{
		String botonkey=elementoPosicionKey[2];
	    String botonvalue=elementoPosicionKey[3];
	    botonkey=botonkey.toUpperCase();
		
		WebElement button=FindElementsFrameWork.GetElement(botonkey, botonvalue, driver);
		button.click();
	}else{
		System.out.println("no hay selementossss");
	}
	}
	
	public void clickEnlace(String link)
	{
		String botonkey=elementoPosicionKey[4];
		//String botonvalue=elementoPosicionKey[5];
		WebElement button=FindElementsFrameWork.GetElement(botonkey, link, driver);
		button.click();
	}
	public void ClickButtonDownlad()
	{
		String botonkey=elementoPosicionKey[5];
		String botonvalue=elementoPosicionKey[6];
		WebElement button=FindElementsFrameWork.GetElement(botonkey, botonvalue, driver);
		button.click();
	}
/*	public  ClickButtonKey()
	{
		
	}
	public String ClickButtonValue()
	{
		
	}
	
	public String ValuegetSearch()
	{
		
	}
	
	
	public String getSearch()
	{
		
	}
	
*/


}
