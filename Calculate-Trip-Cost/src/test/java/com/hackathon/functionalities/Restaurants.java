package com.hackathon.functionalities;
/**
 * The class is defined to implement all the testcases under Restaurants scenario
 * @author Team Elite
 * Date:28/03/2022 
 */
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hackathon.Utilities.Base;
import com.hackathon.Utilities.ExcelData;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Restaurants extends Base {

	String[] location = new String[4];
	ExcelData read=new ExcelData();
	WebDriver wait;
	
	public void restaurantsTab(String r) throws Exception // Selecting resturants tab
	{
		Logger = reports.createTest("Resturants tab Verification");
		Logger.assignCategory("Regression Testing");

		driver.get(prop.getProperty("siteLink"));
		Thread.sleep(1000);
		snap("site");     // Taking screenshot
		Logger.log(Status.INFO, "TripAdvisor is opened...");

		List<WebElement> menu = driver.findElements(By.className(prop
				.getProperty("tab")));
		for (WebElement i : menu) {
			if (i.getText().equals(r))// Clicking resturants tab
				i.click();
		}                                   
		Logger.log(Status.INFO, "Selected restaurant tab successfully...");

		Thread.sleep(1000);
		snap("resturants");  // TakingScreenshots
	}

	public void enterPlace() throws Exception    // Passing city name to input field
	{
		Logger = reports.createTest("City Input Test Function");
		Logger.assignCategory("Regression Testing");

	
		driver.findElement(By.xpath(prop.getProperty("cityName"))).sendKeys(
				"Seoul south korea"); // Passing values to input field

		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("resturantClick"))));
		driver.findElement(By.xpath(prop.getProperty("resturantClick"))).click();

		Logger.log(Status.INFO, "City entered successfully...");

	}

	public void selectReservations() throws Exception //Selecting reservations under resturant features
	{
		Logger = reports.createTest("Reservation Functionality");
		Logger.assignCategory("Regression Testing");
																		
		String newURl = driver.getWindowHandle();
		driver.switchTo().window(newURl);

		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("reservations"))));
		driver.findElement(By.xpath(prop.getProperty("reservations"))).click();
		snap("reservations");// Taking screenshot

		Logger.log(Status.PASS, MarkupHelper.createLabel(
				"Reservation Functionality selected Successfully", ExtentColor.BLUE));
	}

	public void getResults() throws Exception // Transferring data to excel sheet
	{
		Logger = reports.createTest("Results display");


		                                                                
		Thread.sleep(1000);
		List<WebElement> list1 = driver.findElements(By.className(prop
				.getProperty("resturantsName")));
		for (int h = 0; h < 5; h++)
			System.out.println(list1.get(h).getText());  // Fetching list of restaurants available

		Logger.log(Status.INFO, "List of resturants fetched...");

		Logger.log(Status.PASS, MarkupHelper.createLabel(
				"Results displayed Successfully",
				ExtentColor.BLUE));

	}

}
