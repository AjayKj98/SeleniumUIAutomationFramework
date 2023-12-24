package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil eleutil;
	
	private By HeaderValue = By.cssSelector("div#content h1");
	private By Imgcount = By.cssSelector("ul.thumbnails li");
	private By productMetaData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
	private By productPriceData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");
	
	//private Map<String, String> productMap = new HashMap<String, String>();
	//private Map<String, String> productMap = new LinkedHashMap<String, String>();
	private Map<String, String> productMap = new TreeMap<String, String>();
 
	
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(this.driver);
	}	
		
	public String HeaderVal() {
		String Acttext=eleutil.doElementGetText(HeaderValue);
		System.out.println(Acttext);
		return Acttext;
		
	}
		
	public int ProductImageCount() {
		int imgcount = eleutil.waitForVisibilityOfElements(Imgcount, AppConstants.MEDIUM_DEFAUTT_WAIT).size();
		System.out.println("for" +HeaderVal()+ "images count are"+imgcount);
		return imgcount;
		
	}
	
	private void getProductMetaData() {
		List<WebElement> metaDataList = eleutil.waitForVisibilityOfElements(productMetaData, AppConstants.MEDIUM_DEFAUTT_WAIT);
		for(WebElement e : metaDataList) {
			String metaData = e.getText();//Brand: Apple
			String metaKey = metaData.split(":")[0].trim();
			String metaVal = metaData.split(":")[1].trim();
			productMap.put(metaKey, metaVal);
		}
	}
	
	private void getPriceData() {
		List<WebElement> metaPriceList = eleutil.waitForVisibilityOfElements(productPriceData, AppConstants.MEDIUM_DEFAUTT_WAIT);
		String produtPrice=metaPriceList.get(0).getText();
		String productExTax=metaPriceList.get(1).getText().split(":")[1].trim();
		
		productMap.put("price", produtPrice);
		productMap.put("extax", productExTax);
	}
		
	public Map<String, String> ProductEntiredata() {
		productMap.put("header value", HeaderVal());
		getProductMetaData();
		getPriceData();
		System.out.println(productMap);
		return productMap;
	}
		  
		
}
	

	
	
	
	
		
	
	

