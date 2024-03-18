package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class HomePageTest extends BaseClass {
	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;

	/*@Test
	public void wishListTest() throws Throwable {
	
		indexPage = getIndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login("Mani@gmail.com", "Mani@123", homePage);
		boolean result = homePage.validateMyWishList();
		Assert.assertTrue(result);
	
	}*/

	@Test
	public void orderHistoryandDetailsTest() throws Throwable {
		indexPage = getIndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login("Mani@gmail.com", "Mani@123", homePage);
		boolean result = homePage.validateOrderHistory();
		Assert.assertTrue(result);
	}
}
