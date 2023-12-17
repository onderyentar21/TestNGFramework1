package com.neotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class LoginPageElements extends CommonMethods {

	@FindBy(id = "txtUsername")
	public WebElement username;

	@FindBy(id = "txtPassword")
	public WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement loginButton;

	@FindBy(id = "txtPassword-error")
	public WebElement blankPasswordMessage;

	@FindBy(xpath = "//div[@class='toast-message']")
	public WebElement wrongCredentialsMessage;

	public LoginPageElements() {
		PageFactory.initElements(driver, this);
	}
	
	public void adminLogin() {
		sendText(username, ConfigsReader.getProperty("username"));
		sendText(password, ConfigsReader.getProperty("password"));
		click(loginButton);
	}

}
