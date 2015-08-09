package utility;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.Row;
public class WriteExcel 
{
	private static HSSFSheet ExcelWSheet;
	private static HSSFCell Cell;
    private static HSSFRow Row;
    private static Workbook ExcelWBook;
    public static void WriteExcelFile(String path,String nameFile)
    {
    	for(int i=1; i<12; i++)
    	{
    		
    	}
    }
	@SuppressWarnings("static-access")
	public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception    {
	       try{
	          Row  = ExcelWSheet.getRow(RowNum);
	        Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
	        if (Cell == null) {
	            Cell = Row.createCell(ColNum);
	            Cell.setCellValue(Result);
	            } else {
	                Cell.setCellValue(Result);
	            }
	// Constant variables Test Data path and Test Data file name
	              FileOutputStream fileOut = new FileOutputStream(Constants.Path_TestData + Constants.File_TestData);
	              ExcelWBook.write(fileOut);
	              fileOut.flush();
	            fileOut.close();
	            }catch(Exception e){
	                throw (e);
	        }
	    }


}
