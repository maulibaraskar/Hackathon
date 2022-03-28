package com.hackathon.Tests;

/** 
 * This code is defined to call all the functions in HolidayHomes.java 
 * @author Team Elite
 * Date:28/03/2022 
 */
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hackathon.functionalities.HolidayHome;

public class TS_HolidayHomesInvalid extends Main {
	public HolidayHome home;

	@BeforeTest
	public void TC_initiateHolidayHomesInvalid() {
		home = new HolidayHome();
	}

	@Test(priority = 18)
	public void TC_Negative1() throws Exception {
		home.NegOne();
	}

	@Test(priority = 19)
	public void TC_Negative2() throws Exception {
		home.NegTwo("wqweweq");
	}

	@Test(priority = 20)
	public void TC_Negative3() throws Exception {
		home.NegThree("nairobi");
	}
}