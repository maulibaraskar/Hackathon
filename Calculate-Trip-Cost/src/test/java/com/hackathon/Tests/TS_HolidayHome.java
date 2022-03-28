package com.hackathon.Tests;
/** 
 * This code is defined to call all the functions in HolidayHomes.java 
 * @author Team Elite
 * Date:28/04/2022 
 */

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hackathon.functionalities.HolidayHome;

public class TS_HolidayHome extends Main {

	public HolidayHome home;

	@BeforeTest
	public void TC_initiateHolidayHomes() {
		home = new HolidayHome();
	}

	@Test(priority = 1)
	public void TC_EnterCity() throws Exception {
		home.enterCity();
	}

	@Test(priority = 2)
	public void TC_VerifyCity() throws Exception {
		home.verifyCity();
	}

	@Test(priority = 3)
	public void TC_SelectCity() throws Exception {
		home.selectCity();
	}

	@Test(priority = 4)
	public void TC_ClickHolidayHomes() throws Exception {
		home.clickHolidayHomes();
	}

	@Test(priority = 5)
	public void TC_InDate() throws Exception {
		home.inDate();
	}

	@Test(priority = 6)
	public void TC_SelectCheckIn() throws Exception {
		home.selectDateCheckIn();
	}

	@Test(priority = 7)
	public void TC_SelectCheckOut() throws Exception {
		home.selectDateCheckOut();
	}

	@Test(priority = 8)
	public void TC_GuestOption() throws Exception {
		home.guestOption();
	}

	@Test(priority = 9)
	public void TC_ClickApply() throws Exception {
		home.clickApply();
	}

	@Test(priority = 10)
	public void TC_TravellerRating() throws Exception {
		home.travellerRating();
	}

	@Test(priority = 11)
	public void TC_Elevator() throws Exception {
		home.elevatorOption();
	}

	@Test(priority = 12)
	public void TC_PrintOutput() throws Exception {
		home.printOutput();
	}

}
