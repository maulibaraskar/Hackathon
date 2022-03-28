package com.hackathon.Tests;

/**
 * This code is defined to call all the functions in Restaurants.java
 * @author Team Elite
 * Date:28/04/2022 
 */
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hackathon.functionalities.Restaurants;

public class TS_Restaurants extends Main {

	public Restaurants restaurant;

	@BeforeTest
	public void TC_initiateCourse() {
		restaurant = new Restaurants();
	}

	@Test(priority = 21)
	public void TC_ResturantsTab() throws Exception {
		restaurant.restaurantsTab("Restaurants");

	}

	@Test(priority = 22)
	public void TC_EnterCity() throws Exception {
		restaurant.enterPlace();

	}

	@Test(priority = 23)
	public void TC_Reservations() throws Exception {
		restaurant.selectReservations();

	}

	@Test(priority = 24)
	public void TC_Results() throws Exception {
		restaurant.getResults();

	}
}
