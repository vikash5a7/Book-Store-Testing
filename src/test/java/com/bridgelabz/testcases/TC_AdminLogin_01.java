package com.bridgelabz.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bridgelabz.pageObjects.AdminLoginPage;
import com.bridgelabz.utitlities.Util;

public class TC_AdminLogin_01 extends BaseClass {

	@Test
	public void validatetingWithValidCridential() throws InterruptedException, IOException {
		logger.info("********* Login with valid cridential *************");
		logger.info("email and password is setting from properties files");
		adminLogin(username, password);
	}

	@Test
	public void validatetingWithInValidCridential() throws InterruptedException, IOException {
		logger.info("********* Login with InValid cridential *************");
		String UserEmmail = Util.randomestring(10) + "@gmail.com";
		String Userpassword = Util.randomestring(9);
		adminLogin(UserEmmail, Userpassword);
	}
	
	@Test
	public void validatetingWithInValidEmail() throws InterruptedException, IOException {
		logger.info("********* Login with valid Email But Invalid password *************");
		String UserEmmail = username;
		String Userpassword = Util.randomestring(12);
		adminLogin(UserEmmail, Userpassword);
	}

	@Test
	public void validatetingWithValidEmailButInvalidPassword() throws InterruptedException, IOException {
		logger.info("********* Login with InValid Email but valid password *************");
		String UserEmmail = Util.randomestring(500)+"@gmail.com";
		String Userpassword = Util.randomestring(12);
		adminLogin(UserEmmail, Userpassword);
	}
	
	@Test
	public void validatetingWithIvalidFormatedOfEmailAndPassword() throws InterruptedException, IOException {
		logger.info("********* Login with InValid Formate Email and password *************");
		String UserEmmail = null;
		String Userpassword = null;
		adminLogin(UserEmmail, Userpassword);
	}

	public void adminLogin(String userEmail, String userPassword) throws InterruptedException, IOException {
		String captureScreenSortName = "RegistraionFailed" + Util.randomeNum(4);
		AdminLoginPage adminLogin = new AdminLoginPage(driver);
		logger.info("Email---" + userEmail + "password====" + userPassword);
		logger.info("********* starting TC_AdminLogin_01 *************");
		driver.get(baseURL + "login");
		adminLogin.setEmailAddress(userEmail);
		logger.info("User email entered " + userEmail);
		adminLogin.setPassword(userPassword);
		logger.info("User password entered " + userPassword);
		if (adminLogin.isEnableBtnAdminButton()) {
			adminLogin.clickSubmit();
			Thread.sleep(5000);
			String expectedTitle = "#Seller-Home";
			String actualTitle = driver.getTitle();
			if (expectedTitle.equals(actualTitle)) {
				logger.info("test case Passed....");
				Assert.assertTrue(true);
				adminLogin.dashboardMenuButtonClick();
				adminLogin.clickOnLogoutBtn();
				adminLogin.dashboardMenuButtonClick();
				adminLogin.clickOnLoginButton();
				Thread.sleep(3000);
			} else {
				logger.info("test case failed....");
				captureScreen(driver, captureScreenSortName);
				logger.info("Capture Screen sort name is" + captureScreenSortName);
				Assert.assertTrue(false);
			}
		} else {
			logger.info("test case failed....");
			captureScreen(driver, captureScreenSortName);
			logger.info("Capture Screen sort name is" + captureScreenSortName);
			Assert.assertTrue(false);
		
		}
		Thread.sleep(2000);
	}
}
