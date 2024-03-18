package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass {
	private IndexPage indexPage;
	private SearchResultPage searchResultPage;

	@Test
	public void productAvailabilityTest() throws Throwable {
		indexPage = getIndexPage();
		searchResultPage = indexPage.searchProduct("t-shirt");
		boolean res = searchResultPage.isProductAvailable();
		Assert.assertTrue(res);

	}
}
