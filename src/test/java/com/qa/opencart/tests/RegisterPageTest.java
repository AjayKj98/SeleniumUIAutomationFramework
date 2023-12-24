package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest {
	
	@BeforeClass
	public void Regsetup() {
		registerPage =login.navigateToRegisterPage();
	}
	
	public String getRandomEmailID() {
		return "testautomation"+System.currentTimeMillis()+"@opencart.com";
	}
	
	//@DataProvider
	//public Object[][] getuserRegData() {
		//return new Object[][] {
			//{ "Rahul", "yadav", "9876543233", "test@123", "yes" },
			//{ "Karishma", "automation","9876544434", "test@123", "no" },
		//	{ "Jyothi", "auto","9876522234", "test@123", "yes" }
		//};
	//}
	
	
	@DataProvider
	public Object[][] getUserRegTestExcelData() {
		Object regData[][]=ExcelUtil.getTestData(AppConstants.REGISTER_DATA_SHEET_NAME);
		return regData;
	}
	
	
	
	@Test(dataProvider="getUserRegTestExcelData")
	public void userRegSetup(String firstName, String lastName, String telephone, String password, String subscribe) {
		
	boolean isRegDone =	registerPage.userRegisteration(firstName, lastName,getRandomEmailID(), telephone, password, subscribe);
		Assert.assertTrue(isRegDone);
	}

}
