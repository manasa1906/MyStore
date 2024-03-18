package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass {
	private IndexPage indexPage;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;

	@Test
	public void addToCartTest() throws Throwable {
		indexPage = getIndexPage();
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.clickBlue();
		addToCartPage.enterQuantity("3");
		addToCartPage.selectSize("L");
		addToCartPage.clickOnAddToCart();
		boolean res = addToCartPage.validateAddtoCart();
		Assert.assertTrue(res);
	}
}
