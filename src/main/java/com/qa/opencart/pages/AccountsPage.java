package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	
		private WebDriver driver;
		private ElementUtil eleutil;
		
		private By logoutLink = By.linkText("Logout");
		private By Headers = By.cssSelector("#content>h2");
		private By  searchField = By.xpath("//input[@name='search']");
		private By searchIcon = By.xpath("(//button[@type='button'])[4]");
		public String getAccPageTitle() {
			String title = eleutil.waitForTitleIs(AppConstants.ACCOUNTS_PAGE_TITLE, AppConstants.MEDIUM_DEFAUTT_WAIT );
			System.out.println("Acc page title.."+title);
			return title;
			}
		
		public AccountsPage(WebDriver driver) {
			this.driver = driver;
			eleutil = new ElementUtil(this.driver);
		}
		
		public boolean LogoutLinkExist() {
			return eleutil.waitForVisibilityOfElement(logoutLink, AppConstants.MEDIUM_DEFAUTT_WAIT).isDisplayed();
		}
		public void logout() {
			if(LogoutLinkExist()) {
				eleutil.doClick(logoutLink);
			}
		}
		
		public List<String> getAccountsHeaderList() {
		List <WebElement> headerlist =eleutil.waitForVisibilityOfElements(Headers, AppConstants.MEDIUM_DEFAUTT_WAIT);
		List<String> headerlistvalues = new ArrayList<String>();
		for(WebElement e: headerlist) {
			String text = e.getText();
			headerlistvalues.add(text);	
		}
		return headerlistvalues;
		} 
		
		public SearchResultsPage DoSearch(String searchKey) {
			eleutil.waitForVisibilityOfElement(searchField, AppConstants.MEDIUM_DEFAUTT_WAIT).clear();
			eleutil.waitForVisibilityOfElement(searchField, AppConstants.MEDIUM_DEFAUTT_WAIT).sendKeys(searchKey);
			eleutil.doClick(searchIcon);
			return new SearchResultsPage(driver);
		}
		
		
		
		
}

