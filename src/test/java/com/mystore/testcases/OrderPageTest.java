package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass {
	private IndexPage indexPage;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;
	private OrderPage orderPage;

	@Test
	public void verifyTotalPrice() throws Throwable {

		indexPage = getIndexPage();
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		orderPage = addToCartPage.clickOnCheckOut();
		Double unitPrice = orderPage.getUnitPrice();
		Double totalPrice = orderPage.getTotalPrice();
		Double totalExpectedPrice = (unitPrice * 2) + 2;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
	}
}
