package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class SearchResultsPage {

	private WebDriver driver;
	private ElementUtil eleutil;
	
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(this.driver);
	}	
	
	public ProductInfoPage selectProduct(String productname) {
		eleutil.waitForVisibilityOfElement(By.linkText(productname), AppConstants.MEDIUM_DEFAUTT_WAIT).click();
		return new ProductInfoPage(driver);
		
	}
	
}
