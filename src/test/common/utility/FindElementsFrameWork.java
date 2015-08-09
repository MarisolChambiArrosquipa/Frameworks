package utility;

import org.apache.james.mime4j.field.ParsedField;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ById;

public class FindElementsFrameWork {

	static WebDriver driver;
	
	
	public static WebElement GetElement(String type,String Nameelement, WebDriver drivers)
	{
		driver=drivers;
		WebElement element=null;
		type=type.toUpperCase();	
		if(type.equals(TypeElement.ID.getValue()))
		{
			element=driver.findElement(By.id(Nameelement));
			
		}else if(type.equals(TypeElement.NAME.getValue()))
		{
			element=driver.findElement(By.name(Nameelement));
		}else if(type.equals(TypeElement.XPATH.getValue()))
		{
			element=driver.findElement(By.xpath(Nameelement));
		}
		else if(type.equals(TypeElement.LINKTEXT.getValue()))
		{
			element=driver.findElement(By.linkText(Nameelement));
		}
		else if(type.equals(TypeElement.CSSSELECTOR.getValue()))
		{
			element=driver.findElement(By.cssSelector(Nameelement));
		}
		else if(type.equals(TypeElement.TAGNAME.getValue()))
		{
			element=driver.findElement(By.tagName(Nameelement));
		}
		else if(type.equals(TypeElement.PARTIALLINKTEXT.getValue()))
		{
			element=driver.findElement(By.partialLinkText(Nameelement));
		}
		else if(type.equals(TypeElement.CLASSNAME.getValue()))
		{
			element=driver.findElement(By.className(Nameelement));
		}
		else if(type.equals(TypeElement.BYCLASSNAME.getValue()))
		{
			element=driver.findElement(ByClassName.className(Nameelement));
		}
		else if(type.equals(TypeElement.BYCSSSELECTOR.getValue()))
		{
			element=driver.findElement(By.ByCssSelector.cssSelector(Nameelement));
		}
		else if(type.equals(TypeElement.BYID.getValue()))
		{
			element=driver.findElement(ById.id(Nameelement));
		}
		else if(type.equals(TypeElement.BYLINKTEXT.getValue()))
		{
			element=driver.findElement(ByLinkText.linkText(Nameelement));
		}
		else if(type.equals(TypeElement.BYNAME.getValue()))
		{
			element=driver.findElement(ByName.name(Nameelement));
		}
		else if(type.equals(TypeElement.BYTAGNAME.getValue()))
		{
			element=driver.findElement(ByTagName.tagName(Nameelement));	
		}
		else if(type.equals(TypeElement.BYXPATH.getClass()))
		{
			element=driver.findElement(ByXPath.xpath(Nameelement));	
		}
		
		return element;
		
	}
	
}
