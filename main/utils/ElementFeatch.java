package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import TestPackage1.BaseTest;

public class ElementFeatch {
	
	public WebElement getWebElement(String identifierType,String identifilerValue)
	{
		
		switch(identifierType) {
		case "ID":
			return BaseTest.driver.findElement(By.id(identifilerValue));
		case "TAGNAME":
			return BaseTest.driver.findElement(By.tagName(identifilerValue));
		case "CLASSNAME":
			return BaseTest.driver.findElement(By.className(identifilerValue));
		case "CSS":
			return BaseTest.driver.findElement(By.cssSelector(identifilerValue));
		case "XPATH":
			return BaseTest.driver.findElement(By.xpath(identifilerValue));
		default:
			return null;
		}
		
		
	}
	
	
	
	public List<WebElement> getListWebElements(String identifierType,String identifilerValue)
	{
		
		switch(identifierType) {
		case "ID":
			return BaseTest.driver.findElements(By.id(identifilerValue));
		
		case "TAGNAME":
			return BaseTest.driver.findElements(By.tagName(identifilerValue));
			
		case "CLASSNAME":
			return BaseTest.driver.findElements(By.className(identifilerValue));
			
			
		case "CSS":
			return BaseTest.driver.findElements(By.cssSelector(identifilerValue));
			
			
		case "XPATH":
			return BaseTest.driver.findElements(By.xpath(identifilerValue));
			
		default:
			return null;
		}
		
		
	}
	

}
