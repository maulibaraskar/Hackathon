package com.hackathon.functionalities;
/**
 * The class is defined to implement all the testcases under Restaurants scenario
 * @author Team Elite
 * Date:28/03/2022 
 */


import org.openqa.selenium.By;




import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import com.hackathon.Utilities.Base;
import com.hackathon.Utilities.ExcelData;

public class Cruises extends Base{
	
	public void clickCruise() throws Exception // Selecting cruise
	{
		Logger = reports.createTest("Cruise Option Verification");
		Logger.assignCategory("Functional Testing");

	
		driver.findElement(By.xpath(prop.getProperty("cruiseOption"))).click(); // Clicking cruise option
		Logger.log(Status.INFO, "Selected cruise option successfully...");

		Thread.sleep(1000);
		snap("Cruise tab");//Screenshot
	}

	public void selectCruiseType() throws Exception{
		                                                                    
		Logger = reports.createTest("Cruise Type Selection Functionality");
		Logger.assignCategory("Functional Testing");

		driver.findElement(By.id(prop.getProperty("dropMenu1"))).click(); //Clicking on 1st dropdown menu
		Logger.log(Status.INFO, "Clicked on 1st Drop down menu...");
		driver.findElement(By.xpath(prop.getProperty("option1"))).click();
		
		Logger.log(Status.INFO, "Selected cruise...");

		Thread.sleep(1000);
		snap("Cruise type");	// Taking screenshot
	}
	public void selectCruiseVar() throws Exception{	
		Logger = reports.createTest("Cruise Type Variant Functionality");
		Logger.assignCategory("Functional Testing");

	
		driver.findElement(By.xpath(prop.getProperty("dropMenu2"))).click();    // Clicking on 2nd drop
		driver.findElement(By.xpath(prop.getProperty("option2"))).click(); // Selecting cruise from drop down menu	
		Logger.log(Status.INFO, "Clicked on 2nd Drop down menu...");

		Thread.sleep(1000);
		snap("Cruise variant");// Taking
																			// screenshot
	}
	public void clicksub() throws Exception{
		Logger = reports.createTest("Search Button Functionality");
		Logger.assignCategory("Regression Testing");

		Thread.sleep(500);
		driver.findElement(By.xpath(prop.getProperty("search"))).click(); // Confirming values and applying it
		Logger.log(Status.INFO, "Clicked on search button...");

		Logger.log(Status.PASS, MarkupHelper.createLabel(
				"Cruise selection Functionality Successfull", ExtentColor.BLUE));

	}


	public void getDetails() throws Exception // Fetching cruise details
	{
		Logger = reports.createTest("Output data transfer Functionality");
  

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);  // Switching control to new window
		}

		String passenger = driver.findElement(
				By.xpath(prop.getProperty("details1"))).getText();   // Storing passenger details
		String[] list = passenger.split("\\|   ", 2);    // Separating passenger details
		Logger.log(Status.INFO, "Fetched passenger details...");

		String launched = driver.findElement(
				By.xpath(prop.getProperty("details2"))).getText();    // Storing launch details
		Logger.log(Status.INFO, "Fetched launch details...");
		System.out.println(list[0]+" "+list[1]+" "+launched);
		
		String lang[] = new String[3];
		for (int i = 0; i < 3; i++) {
			lang[i] = driver.findElement(By.xpath("//*[@id=\"ship_reviews\"]/div/div[2]/div/div[1]/div[1]/div[3]/ul/li["+ (i + 2) +"]/label/span[1]")).getText(); 
			System.out.println(lang[i]);        // Storing language details
			
			if(lang[i]==null) {                                                                 
				System.out.println("No languages found");                                      
				lang[i]="no";
				break;
			}                                          
			
		}

		Thread.sleep(1000);
		snap("Cruise details");// Taking screenshot
		ExcelData.writeExcelCruise(list, launched, lang); // Passing fetched data to excel
		Logger.log(Status.PASS, MarkupHelper.createLabel(
				"Output data transfer Functionality Successfull",
				ExtentColor.BLUE));
	}
	}

