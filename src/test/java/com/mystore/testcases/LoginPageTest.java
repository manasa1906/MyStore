package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class LoginPageTest extends BaseClass {
	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;

	@Test
	public void loginTest() throws Throwable {
		indexPage = getIndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login("Mani@gmail.com", "Mani@123", homePage);
		String actualURL = homePage.getCurrURL();
		String expectedURL = "http://www.automationpractice.pl/index.php?controller=my-account";
		Assert.assertEquals(actualURL, expectedURL);

	}
}
