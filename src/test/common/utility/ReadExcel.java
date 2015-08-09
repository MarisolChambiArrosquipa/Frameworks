package utility;
import java.io.File;
import java.io.FileInputStream;








import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import testWeb.RunTestSuites;


public class ReadExcel {
    public static Sheet ExcelWSheet;
    public static Row Row;
    public static Workbook ExcelWBook;
//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
public static Sheet setExcelFile(String path,String namefile,String sheetName) throws Exception {
       try {
    	 
    	   File file =    new File(path+"\\"+namefile);
		   
		    //Create an object of FileInputStream class to read excel file
		 
		    FileInputStream inputStream = new FileInputStream(file);
		 
		    Workbook workbook = null;
		 
		    //Find the file extension by spliting file name in substring and getting only extension name
		 
		    String fileExtensionName = namefile.substring(namefile.indexOf("."));
		 
		    //Check condition if the file is xlsx file
		 
		    if(fileExtensionName.equals(".xlsx")){
		 
		    //If it is xlsx file then create object of XSSFWorkbook class
		 
		    	workbook = new XSSFWorkbook(inputStream);
		 
		    }
		 
		    //Check condition if the file is xls file
		 
		    else if(fileExtensionName.equals(".xls")){
		 
		        //If it is xls file then create object of XSSFWorkbook class
		 
		    	workbook = new HSSFWorkbook(inputStream);
		 
		    }

    //return guru99Workbook;
    ExcelWSheet =  workbook.getSheet(sheetName);
           
           Log.info("Excel sheet opened");
          
       }

         catch (Exception e){
            throw (e);
        }
       return ExcelWSheet;
}
//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
public static String getCellData(int RowNum, int ColNum) throws Exception{
       try{
    	   Row row = ExcelWSheet.getRow(RowNum);
    	  String CellData= row.getCell(ColNum).getStringCellValue();
    	   
    	 // Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
         // String CellData = Cell.getStringCellValue();
          return CellData;
          }catch (Exception e){
            return"";
          }
}
public static String getCellData(int RowNum, int ColNum,Sheet sheet) throws Exception{
    try{
 	   Row row = sheet.getRow(RowNum);
 	  // System.out.println("excel file:"+row.getCell(0).getStringCellValue());
 	  String CellData= row.getCell(ColNum).getStringCellValue();
 	   
 	   return CellData;
       }catch (Exception e){
         return"error";
       }
}

public static int getRowContains(String sTestCaseName, int colNum) throws Exception{
	int i;
	try {
		int rowCount = ReadExcel.getRowUsed();
		for ( i=0 ; i<rowCount; i++){
			if  (ReadExcel.getCellData(i,colNum).equalsIgnoreCase(sTestCaseName)){
				break;
			}
		}
		return i;
			}catch (Exception e){
		Log.error("Class ExcelUtil | Method getRowContains | Exception desc : " + e.getMessage());
		throw(e);
		}
	}

public static int getRowContains(String sTestCaseName, int colNum,Sheet SheetName) throws Exception{
	int iRowNum=0;	
	try {
	    //ExcelWSheet = ExcelWBook.getSheet(SheetName);
		int rowCount = SheetName.getLastRowNum();
		for (; iRowNum<rowCount; iRowNum++){
			if  (getCellData(iRowNum,colNum).equalsIgnoreCase(sTestCaseName)){
				break;
			}
		}       			
	} catch (Exception e){
		Log.error("Class Utils | Method getRowContains | Exception desc : "+e.getMessage());
		
		}
	return iRowNum;
	}
public static int getRowUsed() throws Exception {
	try{
		int RowCount = ExcelWSheet.getLastRowNum();
		
		Log.info("Total number of Row used return as < " + RowCount + " >.");		
		return RowCount;
	}catch (Exception e){
		Log.error("Class ExcelUtil | Method getRowUsed | Exception desc : "+e.getMessage());
		System.out.println(e.getMessage());
		throw (e);
	}
	

}
	



public static Object [][]FillUpMatrix(String path,String file,String sheet) throws Exception
{
	//Object[][] nuevo;
	//String filePath = System.getProperty("user.dir")+"\\src\\test\\datasheet";
	  // System.out.println(filePath);
	    //Call read file method of the class to read data
	 
	    
	 
	 return llenar(setExcelFile(path,file,sheet));

}
private static Object[][] llenar(Sheet excelWSheet2) throws Exception {
	
	
	int columna = 0;
	int cFila=0;
	int rowCount = excelWSheet2.getLastRowNum();
	Row row=excelWSheet2.getRow(0);
	
//System.out.println("row"+rowCount + "columns:"+row);
	Object[][] tabArrays =new Object[rowCount][row.getLastCellNum()];

	for (int fila = 1; fila < rowCount+1; fila++) { 
		//recorremos las filas
		 row=excelWSheet2.getRow(fila);
		for ( columna = 0; columna < row.getLastCellNum(); columna++) { 
			//recorremos las columnas
		//	System.out.println(row.getCell(columna).getStringCellValue());
			tabArrays[cFila][columna]=row.getCell(columna).getStringCellValue();
			
			
			

			}
				cFila++;
				}
				return tabArrays;

	
}
public static String[] BuscarType(String sheet,int pos) throws Exception {
	
	Sheet loginSheet=setExcelFile(Constants.Path_TestData,Constants.File_TestData,sheet);
	Row row=loginSheet.getRow(pos);//la primer dato Constants.IdLogin
/*	System.out.println(row.getRowNum());//1
	System.out.println(row.getFirstCellNum());//0
	System.out.println(loginSheet.getFirstRowNum());//0
	System.out.println(loginSheet.getLastRowNum());//el numero de filas
	System.out.println(row.getLastCellNum());//numero de columnas4
	*/String[] element= new String[row.getLastCellNum()];
	 for(int i=0; i<row.getRowNum();i++)
	 {
		// int j;
		 for (int j=0;j<row.getLastCellNum();j++ )
		 {
			 
			element[j]=row.getCell(j).getStringCellValue();
			// System.out.println("elementoooo:"+element[j]);
		 }
	 }
	
	
	return element;
}
public static int CountRow(Sheet sheet) {
	int numberRows=0;
	try{
	numberRows= sheet.getLastRowNum();
	Log.info("se pudo leer eltotal de filas que tiene el excel");
	}
	catch(Exception e)
	{
	 RunTestSuites.result=false;
	 Log.error("No se puede leer la cantidad de columnas");
	}
	return numberRows;
	
}
public static int getTestStepsCount(Sheet sheetStepsInicio, String testName,int iniSteps) throws Exception {
	
	int result=iniSteps;
	for(int i=iniSteps;i<sheetStepsInicio.getLastRowNum();i++)
	{
		if(testName.equalsIgnoreCase(getCellData(i, Constants.ColumnTestCaseNameSteps, sheetStepsInicio)))
		{
			result=i;
		}
		else{
			break;
		}
		
		System.out.println("El resulado es:"+result);
	}
	return result;
}




}
