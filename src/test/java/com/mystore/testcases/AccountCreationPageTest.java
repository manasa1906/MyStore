package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class AccountCreationPageTest extends BaseClass {
	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;
	private AccountCreationPage accountCreationPage;

	@Test
	public void createAccountPageTest() throws Throwable {
		indexPage = getIndexPage();
		loginPage = indexPage.clickOnSignIn();
		accountCreationPage = loginPage.createNewAccount("mani1@gmail.com");
		boolean res = accountCreationPage.validateAcountCreatePage();
		Assert.assertTrue(res);
	}

}
