package utility;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//leer dato
	@DataProvider(name="FillElement")
	public static Object[][] FillUpElement() throws Exception
	{
		
		return ReadExcel.FillUpMatrix(Constants.Path_TestData,Constants.File_TestData,Constants.Sheet);
		
						
	}
	
	
	//solo necesitamos llamar  1 veces para q ejecutepara todas los usuarios
	@DataProvider(name="FillDato")
	public static Object[][] GetKeyword() throws Exception
	{
		return ReadExcel.FillUpMatrix(Constants.Path_TestData,Constants.File_TestData,Constants.Sheet);
	}
	//tb necesitamos  leer para crear cuentas otra dato provider
}
