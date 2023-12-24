package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class RegisterPage {
	
	private WebDriver driver;
	private ElementUtil eleutil;
	
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");

	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input[@type='radio']");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[position()=2]/input[@type='radio']");

	private By agreeCheckBox = By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");

	private By successMessg = By.cssSelector("div#content h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(this.driver);
	}	
	
	public boolean userRegisteration(String firstName, String lastName, String email, String telephone, String password,
			String subscribe) {
		
		eleutil.waitForVisibilityOfElement(this.firstName, AppConstants.MEDIUM_DEFAUTT_WAIT).sendKeys(firstName);
		eleutil.doSendKeys(this.lastName, lastName);
		eleutil.doSendKeys(this.email, email);
		eleutil.doSendKeys(this.telephone, telephone);
		eleutil.doSendKeys(this.password, password);
		eleutil.doSendKeys(this.confirmpassword, password);
		
		if(subscribe.equalsIgnoreCase("yes")) 
		{
			eleutil.doClick(subscribeYes);
		}
		else
		{
			eleutil.doClick(subscribeNo);
		}
		
		eleutil.doClick(agreeCheckBox);
		eleutil.doClick(continueButton);
		
		String Successmsg=eleutil.waitForVisibilityOfElement(successMessg, AppConstants.MEDIUM_DEFAUTT_WAIT).getText();
		
		System.out.println(Successmsg);
		
		if(Successmsg.contains(AppConstants.USER_REGISTER_SUCCESS_MESSG)) {
			eleutil.doClick(logoutLink);
			eleutil.doClick(registerLink);
			return true;
		}
		else {
			return false;
		}
		
		
		
		
		
	}	
}
