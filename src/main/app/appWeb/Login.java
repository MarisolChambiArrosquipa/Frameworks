package appWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import setUpWeb.BaseClass;
import utility.Constants;
import utility.FindElementsFrameWork;
import utility.ReadExcel;
import utility.TypeElement;

public class Login extends BaseClass{

	public Object[] elementoPosicionKey;
	//public String[] elementosValues;
	
	public Login(WebDriver driver) {
		super(driver);
		
	}

	public void StartLogin(String name,String passwrod ) throws Exception
	{
		
		//elementoPosicionKey=ReadExcel.BuscarType(Constants.LoginSheet);
		//if(elementoPosicionKey!=null)
		//{
		//WebElement username=FindElementsFrameWork.GetElement(GetName(), GetValueName(), driver);
		//username.sendKeys(name);
		//WebElement passwords=FindElementsFrameWork.GetElement(GetPassword(), GetValuePassword(), driver);
		//passwords.sendKeys(passwrod);
		//}
		//keyword  buscar esos valores en el excel y pedir su otro campo que diga de que tipo es
		//una clas que devuelva el tipos
	}
	

	public void ClickButton()
	{
		if(GetValueButton()!=null)
		{
			//WebElement button=FindElementsFrameWork.GetElement(GetButton(), GetValueButton(), driver);
			//button.click();
		}
	}
	public TypeElement GetName()
	{
		return (TypeElement) elementoPosicionKey[0];
	}
	public TypeElement GetPassword()
	{
		return (TypeElement) elementoPosicionKey[2];
	}
	public TypeElement GetButton()
	{
		return (TypeElement) elementoPosicionKey[4];
	}
	public String GetValueName()
	{
		return (String) elementoPosicionKey[1];
	}
	public String GetValuePassword()
	{
		return (String) elementoPosicionKey[3];
	}
	public String GetValueButton()
	{
		return (String) elementoPosicionKey[5];
	}

}
