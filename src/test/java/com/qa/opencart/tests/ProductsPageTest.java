package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductsPageTest extends BaseTest {
	
	@BeforeClass
	public void AccSetup() {
		accPage = login.performLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@DataProvider
	public Object[][] getSearchData() {
		return new Object[][] {
			{"MacBook", "MacBook Pro", 4},
			{"MacBook", "MacBook Air", 4},
			{"iMac", "iMac", 3},
			{"Samsung", "Samsung SyncMaster 941BW", 1},
			
		};
			
}
	
	@Test(dataProvider = "getSearchData")
	public void proImageCountTest(String searchKey, String productNam, int imageCount) {
	searchResultsPage =	accPage.DoSearch(searchKey);
	productInfoPage= searchResultsPage.selectProduct(productNam);
	Assert.assertEquals(productInfoPage.ProductImageCount(), imageCount);
	}
	
	@Test
	public void productInfoTest() {
		searchResultsPage =	accPage.DoSearch("MacBook");
		productInfoPage= searchResultsPage.selectProduct("MacBook Pro");
		Map<String, String> productMap =productInfoPage.ProductEntiredata(); //Product Code: Product 18

		
		softAssert.assertEquals(productMap.get("Brand"), "Apple");
		softAssert.assertEquals(productMap.get("Product Code"), "Product 18");
		softAssert.assertEquals(productMap.get("Reward Points"), "800");
		softAssert.assertEquals(productMap.get("Availability"), "In Stock");
		softAssert.assertEquals(productMap.get("price"), "$2,000.00");
		softAssert.assertEquals(productMap.get("extax"), "$2,000.00");
		
		softAssert.assertAll();
		
		
	}
	
	
	
	

}
