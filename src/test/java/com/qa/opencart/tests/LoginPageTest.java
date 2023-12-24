 package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginPageTest extends BaseTest {
	@Description("Page title test")
	@Severity(SeverityLevel.MINOR)
	@Test(priority=1)
	public void LoginPageTitleTest() {
		String ActTitle = login.getLoginPageTitle();
		Assert.assertEquals(ActTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void LoginPageURLTest() {
		String Acturl = login.getLoginPageUrl();
		Assert.assertTrue(Acturl.contains(AppConstants.LOGIN_PAGE_URL_FRACTION));
	}
	
	@Test(priority=3)
	public void ForgotPwdLinkExistTest() {
		Assert.assertTrue(login.isForgotPwdLinkExist());
	}
	
	@Test(priority=4)
	public void isLogoExistTest() {
		Assert.assertTrue(login.isLogoExist());
	}
	
	@Test(priority=5)
	public void performLoginTest() {
		accPage=login.performLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(accPage.LogoutLinkExist());
	}
	
	
	
}
