package testWeb;

import org.openqa.selenium.WebDriver;

import setUpWeb.BaseClass;
import utility.Constants;

public class SelectionData extends BaseClass {

	public SelectionData(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public static String GetSheet(String name)
	{
		String sheet = null;
		if(name.equals("Login"))
		{
			sheet=Constants.LoginSheet;
		}
		return sheet;
		
	}

	public static int GetRow(String name)
	{
		int position=0;
		if(name.equals("Login"))
		{
			position=Constants.IdLogin;
		}
		return position;
	
	}
	
	
}
