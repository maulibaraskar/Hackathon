package com.hackathon.Tests;
/**
 * This code is defined to call all the functions in Cruises.java
 * @author Team Elite
 * Date:28/03/2022 
 */

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.hackathon.functionalities.Cruises;

public class TS_Cruise extends Main {

	public Cruises cruise;

	@BeforeTest
	public void TC_initiateCourse() {
		cruise = new Cruises();
	}

	@Test(priority = 13)
	public void TC_ClickCruise() throws Exception {
		cruise.clickCruise();
	}

	@Test(priority = 14)
	public void TC_CruiseType() throws Exception {
		cruise.selectCruiseType();
	}

	@Test(priority = 15)
	public void TC_SelectCruiseVar() throws Exception {
		cruise.selectCruiseVar();
	}

	@Test(priority = 16)
	public void TC_ClickSub() throws Exception {
		cruise.clicksub();
	}

	@Test(priority = 17)
	public void TC_GetDetails() throws Exception {
		cruise.getDetails();
	}

}