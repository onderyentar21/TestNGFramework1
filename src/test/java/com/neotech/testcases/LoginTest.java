package com.neotech.testcases;

import static org.testng.Assert.assertEquals;

import java.awt.Desktop.Action;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.neotech.pages.DashboardPageElements;
import com.neotech.pages.LoginPageElements;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class LoginTest extends CommonMethods {

	@Test(groups = {"smoke","regression"})
	public void validLogin() {

		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();

		// send username
		sendText(login.username, ConfigsReader.getProperty("username"));
		wait(1);

		// send password
		sendText(login.password, ConfigsReader.getProperty("password"));
		wait(1);

		// click on login
		click(login.loginButton);
		// Or use jsClick or Action.click
		wait(1);

		// Verify account name
		String expected = "Jacqueline White";
		String actual = dashboard.accountName.getText();

		// Assertion
		Assert.assertEquals(actual, expected, "The account does NOT match!!!");
	}

	@Test(groups = "regression")
	public void emptyPasswordLogin() {

		LoginPageElements login = new LoginPageElements();
		// DashboardPageElements dashboard = new DashboardPageElements();

		// send username
		sendText(login.username, ConfigsReader.getProperty("username"));
		wait(1);

		// click on login
		click(login.loginButton);
		// Or use jsClick or Action.click
		wait(1);

		String expectedMessage = "Password cannot be empty";
		String actualMessage = login.blankPasswordMessage.getText();

		assertEquals(expectedMessage, actualMessage, "Error message does NOT match!");
	}

	@Test(groups = "regression")
	public void invalidPasswordLogin() {

		LoginPageElements login = new LoginPageElements();
		// DashboardPageElements dashboard = new DashboardPageElements();

		// send username
		sendText(login.username, ConfigsReader.getProperty("username"));
		wait(1);

		// send password
		sendText(login.password, "WrongPassword!");
		wait(1);

		// click on login
		click(login.loginButton);
		// Or use jsClick or Action.click
		//jsClick(login.loginButton);
		wait(1);

		// Lets fail the test on purpose by wrong message
		String expectedMessage = "Invalid Credentials - 2";
		String actualMessage = login.wrongCredentialsMessage.getText();

		Assert.assertEquals(expectedMessage, actualMessage, "Error messages DO NOT match!");
		
		
	}
}
