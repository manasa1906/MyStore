package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass {
	IndexPage indexPage;

	@Test
	public void verifyLogo() throws Throwable {
		indexPage = getIndexPage();
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
	}

	@Test
	public void verifyTitle() {
		indexPage = getIndexPage();
		String title = indexPage.getMyStoreTitle();
		Assert.assertEquals(title, "My Shop");
	}

}
