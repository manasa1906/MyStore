package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	private static WebDriver driver;

	@FindBy(xpath = "//a[@class='login']")
	private WebElement signInBtn;

	@FindBy(xpath = "//img[@class='logo img-responsive']")
	private WebElement myStoreLogo;

	@FindBy(id = "search_query_top")
	private WebElement searchProductBox;

	@FindBy(name = "submit_search")
	private WebElement searchButton;

	public IndexPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public LoginPage clickOnSignIn() throws Throwable {
		Action.fluentWait(driver, signInBtn, 10);
		Action.click(driver, signInBtn);
		return new LoginPage(driver);
	}

	public boolean validateLogo() throws Throwable {
		return Action.isDisplayed(driver, myStoreLogo);
	}

	public String getMyStoreTitle() {
		String myStoreTitel = (driver.getTitle());
		return myStoreTitel;
	}

	public SearchResultPage searchProduct(String productName) throws Throwable {
		Action.type(searchProductBox, productName);
		Action.scrollByVisibilityOfElement(driver, searchButton);
		Action.click(driver, searchButton);
		Thread.sleep(3000);
		return new SearchResultPage();
	}

	public void navigateToUrl() {
		driver.get("http://www.automationpractice.pl/index.php?");
	}
}