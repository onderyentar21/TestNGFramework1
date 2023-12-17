package com.neotech.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.pages.AddEmp;
import com.neotech.pages.DashboardPageElements;
import com.neotech.pages.LoginPageElements;
import com.neotech.pages.PersonDetailPageElelemnts;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ExcelUtility;

public class AddEmployeTest extends CommonMethods{
	@Test(dataProvider = "ExcelData",groups = {"addEmployee","regression"})
	
	public void addEmployee(String firstName, String lastName, String userName, String password) {
		LoginPageElements loginPage = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();
		AddEmp addEmployeePage = new AddEmp();
		PersonDetailPageElelemnts personalDetailsPage = new PersonDetailPageElelemnts();
		

		// Log information in the test report
	//	test.info("Test Data: " + firstName + " " + lastName);

		// Log information in the console
		System.out.println("Test Data: " + firstName + " " + lastName);

		// Login
		test.info("Logging in...");
		loginPage.adminLogin();

		// Wait for 1 second
		wait(1);

		// Navigate to PIM and Add Employee
		dashboard.PIM.click();
		dashboard.addEmployeeLink.click();

		// Wait for 1 second
		wait(1);

		// Enter new employee info
		sendText(addEmployeePage.firstName, firstName);
		sendText(addEmployeePage.lastName, lastName);

		// For verification, get the employee ID
		String employeeId = addEmployeePage.employeeId.getAttribute("value");

		// Select location from the dropdown
		selectDropdown(addEmployeePage.location, "Canadian Regional HQ");

		// Wait for 1 second
		wait(1);

		// Toggle the login details section
		jsClick(addEmployeePage.loginDetailsToggle);

		// Wait for 1 second
		wait(1);

		// Provide credentials: username and password
		sendText(addEmployeePage.username, userName);
		sendText(addEmployeePage.password, password);
		sendText(addEmployeePage.confirmPassword, password);

		// Wait for 1 second
		wait(1);

		// Click the Save button
		click(addEmployeePage.saveButton);

		// Wait for 1 second
		wait(1);

		// Wait for the personal details form to become visible
		waitForVisibility(personalDetailsPage.personalDetailForm);

		// Validation
		test.info("Validating the new employee");
		String actualEmployeeId = personalDetailsPage.employeeId.getAttribute("value");

		// Assert that the actual employee ID matches the expected employee ID
		Assert.assertEquals(actualEmployeeId, employeeId, "Employee IDs do NOT match!");
		jsClick(null);

		
		
	}
	@DataProvider(name = "ExcelData")
	public Object[][] creatData(){
		String path = System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\Excel.xlsx";
		return ExcelUtility.excelIntoArray(path, "Employee");
	}

}
