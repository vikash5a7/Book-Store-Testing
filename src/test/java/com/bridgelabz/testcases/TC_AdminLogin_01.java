package com.bridgelabz.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bridgelabz.pageObjects.AdminLoginPage;

public class TC_AdminLogin_01 extends BaseClass {

	@Test
	public void adminLogin() throws InterruptedException {

		AdminLoginPage adminLogin = new AdminLoginPage(driver);
		logger.info("Email---" + username + "password====" + password);
		logger.info("********* starting TC_LoginDDT_001 *************");

		driver.get(baseURL + "login");

		adminLogin.setEmailAddress(username);
		logger.info("User email entered " + username);

		adminLogin.setPassword(password);
		logger.info("User password entered " + password);

		Thread.sleep(2000);
		if (adminLogin.isEnableBtnAdminButton()) {
			adminLogin.clickSubmit();
			Thread.sleep(5000);
			String expectedTitle = "#Seller-Home";
			String actualTitle = driver.getTitle();
			if (expectedTitle.equals(actualTitle)) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		} else {
			Assert.assertTrue(false);
		}
	}
}
