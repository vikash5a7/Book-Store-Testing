package com.bridgelabz.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	WebDriver ldriver;

	public AdminLoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id ="email")
	@CacheLookup
	WebElement email;
	
	@CacheLookup
	@FindBy(id="password")
	WebElement password;
	
	@CacheLookup
	@FindBy(className="login-button")
	WebElement btnUserLogin;
	
	@CacheLookup
	@FindBy(xpath="//span[contains(text(),'Login As Admin')]")
	WebElement btnAdmin; 
	
	@CacheLookup
	@FindBy(xpath="//mat-icon[contains(text(),'account_circle')]")
	WebElement dashBoarBoardMenuButton;
	
	
	@CacheLookup
	@FindBy(xpath="//button[@class='signout-button mat-button mat-button-base']")
	WebElement logoutBtn;
	
	
	@CacheLookup
	@FindBy(xpath="//span[contains(text(),'Login')]")
	WebElement loginBtnOfDashboard;
	public void setEmailAddress(String userEmail)
	{
		email.sendKeys(userEmail);
	}
	public void setPassword(String userPassword)
	{
		password.sendKeys(userPassword);
	}
	
	public void clickSubmit()
	{
		btnAdmin.click();
	}
	
	
	public boolean isEnableBtnAdminButton() {
		return btnAdmin.isEnabled();
	}
	
	public boolean isEnabledBtUserButton() {
		return btnUserLogin.isEnabled();
	}
	
	public void dashboardMenuButtonClick() {
		dashBoarBoardMenuButton.click();
	}
	public void clickOnLogoutBtn() {
		logoutBtn.click();
	}
	public void clickOnLoginButton() {
		loginBtnOfDashboard.click();
	}
}
