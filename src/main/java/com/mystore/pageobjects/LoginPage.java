package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass {
	@FindBy(id = "email")
	private WebElement userName;

	@FindBy(id = "passwd")
	private WebElement password;

	@FindBy(id = "SubmitLogin")
	private WebElement signInBtn;

	@FindBy(name = "email_create")
	private WebElement emailForNewAccount;

	@FindBy(name = "SubmitCreate")
	private WebElement createNewAccountBtn;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String uname, String pswd, HomePage homePage) throws InterruptedException {
		Action.scrollByVisibilityOfElement(driver, userName);
		Action.type(userName, uname);
		Action.type(password, pswd);
		Action.JSClick(driver, signInBtn);
		Thread.sleep(2000);
		homePage = new HomePage(driver);
		return homePage;
	}

	public AddressPage login(String uname, String pswd, AddressPage addressPage) throws InterruptedException {
		Action.scrollByVisibilityOfElement(driver, userName);
		Action.type(userName, uname);
		Action.type(password, pswd);
		Action.click(driver, signInBtn);
		Thread.sleep(2000);
		addressPage = new AddressPage();
		return addressPage;
	}

	public AccountCreationPage createNewAccount(String newEmail) throws Throwable {
		Action.type(emailForNewAccount, newEmail);
		Action.click(driver, createNewAccountBtn);
		return new AccountCreationPage();
	}
}
