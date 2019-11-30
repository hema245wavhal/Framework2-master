package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.BasePage;

public class WelcomePage extends BasePage {

	public WelcomePage() {
	
	}

	@FindBy(name = "userName")
	public WebElement txtUsername;

	@FindBy(name = "password")
	public WebElement txtPassword;

	@FindBy(name = "login")
	public WebElement btnLogin;

	public void signin(String username, String password) {
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		btnLogin.click();
	}

}
