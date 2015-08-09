package setUpWeb;
/*
import java.io.File;

import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Workbook;

import utility.Constants;

public class Read {
	  public static HSSFSheet sheet;
	   // private static HSSFWorkbook ExcelWBook;
	    public static HSSFCell Cell;
	    public static HSSFRow Row;
	    public static Workbook wookbook;
	public static Object [][]FillUpMatrix()
	{
		Object [][]nuevo;
		try{//C:\Users\Sol\Documents\maven\my-app\src\main\java\testsuites	
			String url=Constants.Path_TestData+Constants.File_TestData;
			wookbook=GenerateFileBase.CreateFileExcel(Constants.File_TestData,Constants.Path_TestData);
			sheet = workbook.getSheet("d");
			//ExcelWSheet =(HSSFSheet) ExcelWBook.getSheet(0); //Seleccionamos la hoja que vamos a leer
			nuevo=new Object[ExcelWSheet.getRow()-1][ExcelWSheet.getColumns()];
			
					 nuevo=llenar(ExcelWSheet);
					}
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}

					return nuevo;
						}
	private static Object[][] llenar(HSSFSheet excelWSheet2) {
		int columna = 0;
		int cFila=0;
		Sheet sheet=(Sheet) ExcelWBook.getSheetAt(0);
		
		Object[][] tabArrays =new Object[sheet.getRows()-1][sheet.getColumns()];

		for (int fila = 1; fila < sheet.getRows(); fila++) { 
			//recorremos las filas
			for ( columna = 0; columna < sheet.getColumns(); columna++) { 
				//recorremos las columnas
				
				tabArrays[cFila][columna]=sheet.getCell(columna, fila).getContents();

				}
					cFila++;
					}
					return tabArrays;

	}
}
}
*/