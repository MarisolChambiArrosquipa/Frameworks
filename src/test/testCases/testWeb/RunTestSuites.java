package testWeb;


import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;


import setUpWeb.Utility;
import utility.Constants;
import utility.Log;
import utility.Operacion;
import utility.ReadExcel;

public class RunTestSuites  {
	
	
    public static WebDriver driver;
	public static boolean result=false;
	public static String testName;
	public static String[] Datos;
	public static Operacion keywordOperacion;
	
	@Test
	public void ExecutionTestCase(){
	try {
		//Sheet sheetDatos=ReadExcel.setExcelFile(Constants.Path_TestData, Constants.File_TestData, Constants.Sheet);
		//Datos=ReadExcel.BuscarType(Constants.Sheet);
		
		//System.out.println("tañasnio de los datos:"+Datos.length);		
		//System.out.println("taños datso:1:"+Datos[0]+"2:"+ Datos[1]+"3:"+Datos[2]);
		Sheet sheet=ReadExcel.setExcelFile(Constants.Path_TestData, Constants.File_TestData, Constants.SheetSuite);
		int TotalRownTestCases=ReadExcel.CountRow(sheet);
		String[] Keys;
		String containtNameTestCase="";
		String descripcionTestCase;
		String actionKeyword;
		String idTestName;
		for(int testname=1;testname<=TotalRownTestCases; testname++)
		{
			System.out.println(TotalRownTestCases);
			testName=ReadExcel.getCellData(testname, Constants.RowTNameColumn,sheet);
			System.out.println("nameTestTEST:"+testName);
	        String runTestCase=  ReadExcel.getCellData(testname, Constants.RowRunColumn,sheet);
	       // System.out.println("Run test caseTEST:"+runTestCase.toUpperCase());
	      // 
	        String	keys;
	        String	keysValue;
	        int i=0;
        	int j=0;
	        if(runTestCase.toUpperCase().equals("YES"))
	        {
	        	
	    		    	
	        	idTestName=Utility.getTestCaseNames(testName);
	        	Datos=RetornarObjetosDatos(idTestName);
	        	System.out.println("tañasnio de los datos:"+Datos.length);		
	    		System.out.println("taños datso:1:"+Datos[0]+"2:"+ Datos[1]+"3:"+Datos[2]);
	        	Keys=RetornarObjetosKeys(idTestName);//mis name= q
	        	//System.out.println("tañano de keys:"+Keys.length+ "primer elementos es:"+Keys[0]);
	        	Log.startTestCase(idTestName);
	        	Sheet sheetStepsInicio=ReadExcel.setExcelFile(Constants.Path_TestData, Constants.File_TestData, Constants.SheetSteps);
	        	int iniSteps=ReadExcel.getRowContains(testName,Constants.ColumnTestCaseNameSteps,sheetStepsInicio);
	        	
	        	//ReadExcel.getTestStepsCount();
	        	int lastStep = ReadExcel.getTestStepsCount(sheetStepsInicio, testName, iniSteps);
	        	///System.out.println(lastStep+":iniSteps:resulsssssss: testName:"+testName);
	        	
	        	for(;iniSteps<lastStep+1;iniSteps++)
	        	{
	        		containtNameTestCase=ReadExcel.getCellData(iniSteps,Constants.ColumnTestCaseNameSteps,sheetStepsInicio);
		        	descripcionTestCase=ReadExcel.getCellData(iniSteps,Constants.ColumnDescriptionSteps,sheetStepsInicio);
		        	actionKeyword=ReadExcel.getCellData(iniSteps,Constants.ColumnActionKeywordsSteps,sheetStepsInicio);
		        	Log.info(descripcionTestCase);
		        	//System.out.println(containtNameTestCase);
		        	//System.out.println(descripcionTestCase);
		        	//System.out.println(actionKeyword);
		        	
		        	if(actionKeyword.toUpperCase().equals("INPUT"))
		        	{
		        		System.out.println("tamaño es:"+(lastStep+1)+ ":iteracion es:"+iniSteps);
		        		//System.out.println("Primer elementos keys[]:"+Keys[i]+":segundo:"+Keys[i+1]+ ":estamos en la iteracion numero:"+iniSteps);
		        			System.out.println("tañano KEY:"+Keys.length+ ":iteracion:"+i+"i,j:"+j);
		        		    keys=Keys[i];
		        			keysValue=Keys[i+1];
		        			System.out.println("key:"+keys+ ":value:"+keysValue+ ":actionKeyword:"+actionKeyword.toUpperCase());
		        		   Operacion.ActionKeywords(actionKeyword,keys,keysValue,Datos[j]);
		        		j++;
		        	i=i+2;
		        	}
		        	else
		        	{
		        		if(actionKeyword.toUpperCase().equals("CLICK"))
		        		{
		        			 keys=Keys[i];
			        			keysValue=Keys[i+1];
			        			System.out.println("key:"+keys+ ":value:"+keysValue+ ":actionKeyword:"+actionKeyword.toUpperCase());
			        		   Operacion.ActionKeywords(actionKeyword,keys,keysValue,null);
			        		j++;
			        	i=i+2;
		        		}
		        		else
		        		{
		        			if(actionKeyword.toUpperCase().equals("NAVIGATE") ||  actionKeyword.toUpperCase().equals("OPENBROWSER"))
		        			{
		        				System.out.println("datoes:"+Datos[j]+ "iteracion es:"+iniSteps);
		        				Operacion.ActionKeywords(actionKeyword, null, null, Datos[j]);
			        			
			        			j++;
		        				
			        			System.out.println("iteracion es:"+iniSteps);
		        				
		        			}
		        			else
		        			{
		        				Operacion.ActionKeywords(actionKeyword, null, null,null);
		        				System.out.println("iteracion es:"+iniSteps);
		        			}
		        			}
		        	}
		        	}
	        }
		}	
	
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		//System.out.println("Error");
	}
		
		
	}

	public void ExecuteKeywordTest(String actionKeyword, String keywork,String datkey, String data) {
		
			//Operacion.ActionKeywords(actionKeyword, keywork, datkey, data);
			
		  //System.out.println("actionKeyword:"+actionKeyword+ "keywork:"+keywork + "datkey:"+datkey+ "data:"+data);
			Operacion.ActionKeywords(actionKeyword, keywork, datkey, data);
		
		
		//if(actionKeyword.equalsIgnoreCase("OPENBROWSER") ||actionKeyword.equalsIgnoreCase("NAVIDATION"))
		
			//Operacion.ActionKeywords(actionKeyword, keywork, datkey, data);
			//keywordOperacion.ActionKeywords(actionKeyword, null, null, data);
		
		// TODO Auto-generated method stub
			
	}
	
	private String[] RetornarObjetosKeys(String runTestCase) {
		// TODO Auto-generated method stub
		String[]elementoPosicionKey=null;
	//System.out.println("Returna esot:"+runTestCase.toLowerCase());
		try{
		if(runTestCase.toUpperCase().equals("TESTREAD"))
		{
	
				elementoPosicionKey = ReadExcel.BuscarType(Constants.Prueba,1);
		}
		//UserAccount
		else if(runTestCase.toUpperCase().equals("USERACCOUNT"))
		{
				elementoPosicionKey = ReadExcel.BuscarType(Constants.Prueba,2);
		}
		}
		catch(Exception e){
			
			e.getMessage();
			
			
		}
		return elementoPosicionKey;
	}

	private String[] RetornarObjetosDatos(String runTestCase) {
		// TODO Auto-generated method stub
		String[]elementoPosicionKey=null;
	//System.out.println("Returna esot:"+runTestCase.toLowerCase());
		try{
		if(runTestCase.toUpperCase().equals("TESTREAD"))
		{
	
				elementoPosicionKey = ReadExcel.BuscarType(Constants.Sheet,1);
		}
		//UserAccount
		else if(runTestCase.toUpperCase().equals("USERACCOUNT"))
		{
				elementoPosicionKey = ReadExcel.BuscarType(Constants.Sheet,2);
		}
		}
		catch(Exception e){
			
			e.getMessage();
			
			
		}
		return elementoPosicionKey;
	}
	

}
