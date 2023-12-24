package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;


public class AccountsPageTest extends BaseTest {
	
	

	@BeforeClass
	public void AccSetup() {
		accPage = login.performLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void AccountsPageTitleTest() {
		String ActTitle = accPage.getAccPageTitle();
		Assert.assertEquals(ActTitle, AppConstants.ACCOUNTS_PAGE_TITLE);
	}
	
	@Test
	public void isLogoutlinkexistTest() {
		Assert.assertTrue(accPage.LogoutLinkExist());
		
	}
	
	@Test
	public void accPageHeaderTest() {
		List<String> actHeaderlist = accPage.getAccountsHeaderList();
		System.out.println(actHeaderlist);
		Assert.assertEquals(actHeaderlist.size(), AppConstants.ACCOUNTS_PAGE_HEADERS_COUNT );
		
	}
	@Test
	public void accPageHeaders() {
		List<String> actHeaderlist = accPage.getAccountsHeaderList();
		System.out.println(actHeaderlist);
		Assert.assertEquals(actHeaderlist, AppConstants.ACCOUNTS_PAGE_HEADERS_LIST );
		
	}
	@Test
	public void Searchtest() {
		searchResultsPage=accPage.DoSearch("Macbook");
		productInfoPage=searchResultsPage.selectProduct("MacBook Pro");
		String actText=productInfoPage.HeaderVal();
		Assert.assertEquals(actText, "MacBook Pro");
	}
		 
}
