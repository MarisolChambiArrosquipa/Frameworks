package testWeb;

import org.openqa.selenium.WebDriver;

import setUpWeb.BaseClass;
import utility.Constants;
import utility.ReadExcel;

public class Login extends BaseClass {

	private String[]elementoPosicionKey;
	public Login(WebDriver driver) throws Exception {
		super(driver);
		//elementoPosicionKey = ReadExcel.BuscarType(Constants.IdLogin);
		// TODO Auto-generated constructor stub
	}
	
	public void LoginUser(String username,String password) throws Exception
	{
		/*elementoPosicionKey = ReadExcel.BuscarType(Constants.Prueba);
		if(elementoPosicionKey!=null)
		{
			
		}*/
		
	}
	public void clickLoginButton()
	{
		
	}
	

}
