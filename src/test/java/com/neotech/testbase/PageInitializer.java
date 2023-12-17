package com.neotech.testbase;

import com.neotech.pages.AddEmp;
import com.neotech.pages.DashboardPageElements;
import com.neotech.pages.EmployeeListPageElement;
import com.neotech.pages.LoginPageElements;
import com.neotech.pages.PersonDetailPageElelemnts;

public class PageInitializer extends BaseClass{

	public static LoginPageElements login;
	public static DashboardPageElements dashboard;
	public static AddEmp addEmp;
	public static PersonDetailPageElelemnts personDetail;
	public static EmployeeListPageElement employeeList;
	
	public static void initialize() {
		login = new LoginPageElements();
		dashboard = new DashboardPageElements();
		addEmp = new AddEmp();
		personDetail = new PersonDetailPageElelemnts();
		
	}
}
