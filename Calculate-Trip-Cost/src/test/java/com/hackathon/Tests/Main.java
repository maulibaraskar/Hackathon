package com.hackathon.Tests;
/**
 * The class is defined to instantiate browser and quit browser 
 * @author Team Elite
 * Date:28/03/2022 
 */

//import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;

import com.hackathon.Utilities.Base;

public class Main extends Base {

	public static ExtentReports report;
	public static WebDriver driver;

	@BeforeSuite
	@Parameters("browser")
	public void startTest(String browser) // driver instantiate
	{
		// BasicConfigurator.configure();
		driver = getDriver(browser);

		openUrl();

	}

	@AfterSuite
	public void exitBrowser() // exit driver
	{

		quitBrowser();
	}

}
