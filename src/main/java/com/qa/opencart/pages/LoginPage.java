package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {
	
	//1. Maintain private global level webdriver
	private WebDriver driver;
	
	private ElementUtil eleutil;
	
	
	//2.Maintain private By Locators
	private By EmailField = By.id("input-email");
	private By PassField = By.id("input-password");
	private By LoginBtn = By.xpath("//input[@value='Login']");
	private By ForgotPwdLink = By.linkText("Forgotten Password");
	private By Logo = By.cssSelector("img[title='naveenopencart']");
	private By registerLink = By.linkText("Register");
	
	//3. Page constructors
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(this.driver);
		
	}
	//4. Page Actions/ Page Methods
		@Step("gets the page title")
		public String getLoginPageTitle() {
		String title = eleutil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, AppConstants.SHORT_DEFAUTT_WAIT );
		System.out.println("login page title.."+title);
		return title;
		}
		
		public String getLoginPageUrl() {
		String url = eleutil.waitForURLContains(AppConstants.LOGIN_PAGE_URL_FRACTION, AppConstants.SHORT_DEFAUTT_WAIT );
		System.out.println("login page title.."+url);
		return url;
		}
		
		public boolean isForgotPwdLinkExist() {
			return eleutil.waitForVisibilityOfElement(ForgotPwdLink, AppConstants.SHORT_DEFAUTT_WAIT).isDisplayed();
		}
		
		public boolean isLogoExist() {
			return eleutil.waitForVisibilityOfElement(Logo, AppConstants.SHORT_DEFAUTT_WAIT).isDisplayed();
		}
		
		public AccountsPage performLogin(String Email, String password) {
			eleutil.waitForVisibilityOfElement(EmailField, AppConstants.MEDIUM_DEFAUTT_WAIT).sendKeys(Email);
			eleutil.doSendKeys(PassField,password );
			eleutil.doClick(LoginBtn);
			return new AccountsPage(driver);
		}
		
		public RegisterPage navigateToRegisterPage() {
			eleutil.waitForVisibilityOfElement(registerLink, AppConstants.MEDIUM_DEFAUTT_WAIT).click();
			return new RegisterPage(driver);
			
		}
		
		
	}
	
	

