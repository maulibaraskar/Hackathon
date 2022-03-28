package com.hackathon.Utilities;

/**
 * This class is defined to implement basic utilities like browser selection,screenshot
 * @author Team Elite
 * Date:28/03/2022 
 */
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Base {
	public static Properties prop = new Properties();
	public static ExtentReports reports = ExtentReport.getReportInstance();
	public static WebDriver driver;
	public static ExtentTest Logger;
	public static String browse;
	/*
	 * Creating constructor to initialize properties file
	 */

	public Base() {

		try {
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "\\Property\\xpaths.properties"); // Property file location
			prop.load(file); // Loading property file
		} catch (Exception e) {
			e.printStackTrace(); // Printing actual error message
		}
	}

	/*
	 * Method to open browser
	 */
	public static WebDriver getDriver(String browser) {

		System.out.println("Browser selected: " + browser);
		browse = browser;
		// open chrome browser
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			Logger = reports.createTest("Chrome Initiated Successfully");
			Logger.log(Status.PASS, "Chrome Initiated");
			reports.flush();
		}

		// open firefox browser
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
			Logger = reports.createTest("Firefox Initiated Successfully");
			Logger.log(Status.PASS, "Firefox Initiated");
			driver = new FirefoxDriver();

		}

		// Maximize window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// Invoking implicit wait
		return driver;
	}

	public void openUrl() {

		driver.get("https://www.tripadvisor.in/");

	}

	public void waitElementClickable(String elementXpath) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
	}

	/*
	 * Take Screenshot
	 */
	public String snap(String fileName) {

		// Creating a screenshot driver and storing in scrFile temporarily.
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Now you can do whatever you need to do with it, for example copy somewhere
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/Screenshots/" + fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String destination = System.getProperty("user.dir") + "/Screenshots/" + fileName;
		return destination;
	}

	/*
	 * Closing browser
	 */
	public void quitBrowser() {
		reports.flush();
		System.out.println("closing");

		driver.quit();
	}
}