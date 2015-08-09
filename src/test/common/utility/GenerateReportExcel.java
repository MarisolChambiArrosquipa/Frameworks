package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GenerateReportExcel {
	private String path;
	private Document doc;
	private XSSFWorkbook book;
	private XSSFCellStyle fail;
	private XSSFCellStyle pass;
	private XSSFCellStyle label;
	private String desFileName;
	public GenerateReportExcel(String desFileName) throws ParserConfigurationException, SAXException, IOException
	{
		 path= GenerateReports.class.getClassLoader().getResource("./").getPath();
		path=path.replaceAll("dataDrivenTestFramework/bin", "dataDrivenTestFramework");// reduccionando a la capeta de test.output
		System.out.println(path+"test-output/testng-results.xml");
		File xmlFile=new File(path+"test-output/testng-results.xml");//dirrecion del archivoo 
		System.out.println(xmlFile.isFile() ); // si es archivo existe
		DocumentBuilderFactory fact= DocumentBuilderFactory.newInstance();
		DocumentBuilder build= fact.newDocumentBuilder();
		 doc=build.parse(xmlFile);
		doc.getDocumentElement().normalize();
		
		 book= new XSSFWorkbook();
		 fail=book.createCellStyle();
		 pass=book.createCellStyle();
		 label=book.createCellStyle();
		 
		 this.desFileName=desFileName;
		 GenerateFile();
		
	}
	public void GenerateFile() throws IOException
	{
		NodeList test_list= doc.getElementsByTagName("test");
		
		System.out.println("test_list.getLength()"+test_list.getLength());
	
		
		for(int i=0; i<test_list.getLength();i++){
			int r=0;
			Node test_node=test_list.item(i);
			String test_name=((Element) test_node).getAttribute("name");
			System.out.println("test name"+test_name);
			XSSFSheet sheet=book.createSheet(test_name);
			////////--------
			XSSFRow row_label = sheet.createRow(r++);
			XSSFCell cel_name_label=row_label.createCell(0);
			String name="TEST NAME";
			cel_name_label.setCellValue(name);
			XSSFCell cel_status_label=row_label.createCell(1);
			cel_status_label.setCellValue("STATUS");
			XSSFCell cel_exp_label = row_label.createCell(2);
			cel_exp_label.setCellValue("ERROR DETAIL");
			label.setFillForegroundColor(HSSFColor.GOLD.index);
			label.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
			cel_name_label.setCellStyle(label);
			cel_status_label.setCellStyle(label);
			cel_exp_label.setCellStyle(label);
			
			//------------
			NodeList class_list= ((Element)test_node).getElementsByTagName("class");
			System.out.println("class_list.getLength()"+class_list.getLength());
			for(int j=0;j<class_list.getLength(); j++){
				
				Node class_node=class_list.item(j);
				String class_name=((Element)class_node).getAttribute("name");
				System.out.println("class name"+class_name);
				NodeList test_method_list=((Element)class_node).getElementsByTagName("test-method");
				
				System.out.println("test_method_list.getLength()"+test_method_list.getLength());
			for(int k=0;k<test_method_list.getLength();k++){
					
				Node test_method_node= test_method_list.item(k);
				
				String test_method_status=((Element)test_method_node).getAttribute("status");
				String test_method_name=((Element)test_method_node).getAttribute("name");/////
				System.out.println("class methodstattsus:"+test_method_status+"testName:"+test_method_name);
				//define los color si el test falla o pasa
				fail.setFillForegroundColor(HSSFColor.RED.index);
				pass.setFillForegroundColor(HSSFColor.BRIGHT_GREEN.index);
	 
				fail.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
				pass.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);

				
				XSSFRow row = sheet.createRow(r++);
				XSSFCell cel_name=row.createCell(0);
				cel_name.setCellValue(class_name+"."+test_method_name);
				XSSFCell cel_status=row.createCell(1);
				cel_status.setCellValue(test_method_status);
				
				if("FAIL".equalsIgnoreCase(test_method_status))
				{
					cel_status.setCellStyle(fail);
				}
				else
				{
					cel_status.setCellStyle(pass);
				}
			XSSFCell cel_exp;
			String exp_message = "";
						
			System.out.println("condicion:"+"FAIL".equalsIgnoreCase(test_method_status));
			if("FAIL".equalsIgnoreCase(test_method_status))
			{
				// put the exception in report
				NodeList exp_list=((Element)test_method_node).getElementsByTagName("exception");
				Node  exp_node=exp_list.item(0);
				exp_message=((Element)exp_node).getAttribute("class");
				cel_exp=row.createCell(2);
				cel_exp.setCellValue(exp_message);
			//	GraficScreemShot(driver);
				
				//System.out.println("esxxecipnt:"+exp_message);	
			}
			
			}
				
			}
			
			
		}
		System.out.println(path+"report/"+desFileName);
		CreateWriteFile();
		

	}
	private void CreateWriteFile() throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(path+"report/"+desFileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book.write(fout);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fout.close();
		book.close();
	}
}
