package com.qspiders;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class FWLibrary {
	public static String scriptStatus;
		
	public WebDriver driver;
	public Logger logger;
	
/***********************Constructor***********************************************************/
	public FWLibrary(WebDriver driver)
	{
		this.driver=driver;
		logger = Logger.getLogger(this.getClass().getName());
	}
/***********************************method to find WebElement************************************/
	public boolean elementExist(String xpath)
	{  
		try
		{
		 driver.findElement(By.xpath(xpath));
		 logger.info("Element found with xpath:"+xpath);
		 return true;
		}
		catch(NoSuchElementException ex)
		{
			return false;
		}
	}
/************************method to verify title********************************************/	
	public void verifyTitle(String expectedTitle)
	{
		String actualTitle=driver.getTitle();
		if(actualTitle.equals(expectedTitle))
		{
			logger.info("Title is correct:"+expectedTitle);
		}
		else
		{  
			scriptStatus="FAIL";
			logger.error("FAIL:Title is not correct:Expected:"+expectedTitle+" Actual:"+actualTitle);
			
		}
	}
/*********************************method to verify WebElement html text*******************/	
	public void verifyText(String xpath,String expectedText)
	{ 
		if(elementExist(xpath))
		{
			String actualText=driver.findElement(By.xpath(xpath)).getText();
		 if(actualText.equalsIgnoreCase(expectedText))
		  {
			 logger.info("Text is correct:"+expectedText);
		  }
		  else
		  {
			 scriptStatus="FAIL";
			 logger.error("FAIL:Text is not correct:Expected:"+expectedText+" Actual:"+actualText);
		   }
		}
		else
		{ 
			scriptStatus="FAIL";
			logger.error("FAIL:verifyText();Element Not Found with the xpath:"+xpath );
		}
	}
/*****************************method to enter data into textbox*************************/	
	public void sendKeys(String xpath,String input)
	{
		
		if(elementExist(xpath))
		{
			driver.findElement(By.xpath(xpath)).sendKeys(input);
			logger.info("Entering \""+input+"\"");
		}
		else
		{
			scriptStatus="FAIL";
			logger.error("FAIL:sendKeys();Element Not Found with the xpath:"+xpath);
		}
	}
/********************************method to click WebElement******************************/
	public void click(String xpath)
	{
		
		if(elementExist(xpath))
		{
			driver.findElement(By.xpath(xpath)).click();
			
		}
		else
		{
			scriptStatus="FAIL";
			logger.error("FAIL:click(): Element Not Found with the xpath:"+xpath);
		}
	}
/***************************mehtod to clear data from textbox*************************/	
	  public void clearText(String xpath)
	  {
		  if(elementExist(xpath))
			{
				driver.findElement(By.xpath(xpath)).clear();
			}
			else
			{
				scriptStatus="FAIL";
				logger.error("FAIL:clearText();Element Not Found with the xpath:"+xpath);
			}
	  }
/*************************hard code wait method********************************************/
	public void waitForSeconds(String s)
	{
		try
		{  
		    int seconds = Integer.parseInt(s);
			Thread.sleep(1000 * seconds);
			 logger.info("Wait for "+ seconds + " seconds");
		}
		catch(InterruptedException ex)
		{
			logger.error("invalid input for: waitForSeconds ");
		}
	}
	
/***************************method to verify alert displayed or not**************************/
	public void checkAlertDisplayed()
	{
		try
		{
			driver.switchTo().alert();
			logger.info("Alert popup displayed: ");
		}
		catch(Exception ex)
		{
			scriptStatus="FAIL";
			logger.error("FAIL:checkAlertDisplayed();Alert popup not displayed: ");
		}
	}
/**************************method to handle alert popup**********************************/
	public void acceptAlertPopup()
	{
		try
		{
			driver.switchTo().alert().accept();
			logger.info("Alert popup accepted: ");
		}
		catch(Exception ex)
		{
			scriptStatus="FAIL";
			logger.error("FAIL:acceptAlertPopup();Accept Alert popup failed:");
		}
	}
/***********************method to dismiss alert popup**********************************/
	public void dismissAlertPopup()
	{
		try
		{
			driver.switchTo().alert().dismiss();
			logger.info("Alert popup dismissed: ");
		}
		catch(Exception ex)
		{
			scriptStatus="FAIL";
			logger.error("FAIL:dismissAlertPopup();dismiss Alert popup failed:");
		}
	}
/****************************method to verify WebElement present on the webpage*******************************/
	public void verifyElementPresent(String xpath)
	{
		if(elementExist(xpath))
		{
			
			 logger.info("Element found with xpath:"+xpath);
		}
		else
		{
			scriptStatus="FAIL";
			logger.error("Element not found with xpath:"+xpath);
		}
	}
	/****************************method to verify WebElement not present on the webpage*******************************/	
	public void verifyElementNotPresent(String xpath)
	{
		if(elementExist(xpath))
		{
			scriptStatus="FAIL";
			logger.error("Element found with xpath:"+xpath);
		}
		else
		{
			logger.info("Element not found with xpath:"+xpath);
		}
	}
	
}
