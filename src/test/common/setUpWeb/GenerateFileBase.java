package setUpWeb;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

 
import org.apache.poi.ss.usermodel.Workbook;
 
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GenerateFileBase {
	
	
	public static void CreateFolder(String namefile, String path)
	{
		File dir=new File(path+"/"+namefile);
		dir.mkdirs();
		System.out.println(dir.getAbsolutePath());
	}
	
	public static void main(String[]aarg )
	{
		//GenerateFileBase base=new GenerateFileBase();
		//GenerateFileBase.createFolder("ejemplo", "C:/Users/Sol/Desktop/Project_Todo/dataDrivenTestFramework");
		
	}
	public static Workbook CreateFileExcel(String namefile,String path) throws IOException
	{
		   File file =    new File(path+"\\"+namefile);
		   
		    //Create an object of FileInputStream class to read excel file
		 
		    FileInputStream inputStream = new FileInputStream(file);
		 
		    Workbook guru99Workbook = null;
		 
		    //Find the file extension by spliting file name in substring and getting only extension name
		 
		    String fileExtensionName = namefile.substring(namefile.indexOf("."));
		 
		    //Check condition if the file is xlsx file
		 
		    if(fileExtensionName.equals(".xlsx")){
		 
		    //If it is xlsx file then create object of XSSFWorkbook class
		 
		    guru99Workbook = new XSSFWorkbook(inputStream);
		 
		    }
		 
		    //Check condition if the file is xls file
		 
		    else if(fileExtensionName.equals(".xls")){
		 
		        //If it is xls file then create object of XSSFWorkbook class
		 
		        guru99Workbook = new HSSFWorkbook(inputStream);
		 
		    }
		 
		//return ExcelWBook;
		//return null;
		return guru99Workbook;
	}

}
