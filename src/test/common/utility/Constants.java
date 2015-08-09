package utility;

public class Constants {
	//columms of sheet
	/*
	public static int TestCaseName=0;
	public static int Username=1;
	public static int Password=2;
	public static int Browser=3;
	*/
	public static int Search=0;
	public static int Browser=1;
	public static int UrlPathS=2;
	//generate excel file
	//C:\Users\Sol\Desktop\Project_Todo\DataDrivenTestFramework\src\test\datasheet
	//C:\Users\Sol\Desktop\Project_Todo\dataDrivenTestFramework\src\test\datasheet
 // String filePath = 
	public static final String Path_TestData = System.getProperty("user.dir")+"\\src\\test\\datasheet";
  public static final String File_TestData = "informacion.xlsx";
	public static String Url="";
	///dataDrivenTestFramework/screenshots
	public static String Path_ScreenShot=System.getProperty("user.dir")+"\\screenshots";
	public static String  Path_WriteData="";
	public static String  Sheet="setup";
   //Row the keywords
	public static int IdLogin=1;//el primer dato
	public static int IdAccount=2;
	public static int IdHome=3;
	//sheets
	public static String Login="";
	public static String Account="";
	public static String Home="";
	
	/*public static int RowLogin=2;
	public static int KeywordUN=2;
	public static int ValueUN=3;
	public static int KeywordPassword=4;
	public static int ValuePassword=5;
	public static int KeywordButton=6;
	public static int ValueButton=7;
	
	*///prueba
	public static String LoginSheet="Login";
	public static String Prueba="prueba";
	//read the steps
	public static String SheetSteps="Steps";
	//read the test Case
	public static String SheetSuite="TestSuite"; 
	//read run test case
	public static int RowRunColumn=2;
	
	public static int RowTNameColumn=0;
	//Column steps
	public static int ColumnTestCaseNameSteps=0;
	public static int ColumnDescriptionSteps=1;
	public static int ColumnActionKeywordsSteps=2;
	public static int ColumnActionResult=3;

}

