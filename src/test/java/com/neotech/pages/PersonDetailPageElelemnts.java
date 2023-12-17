package com.neotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.utils.CommonMethods;



public  class PersonDetailPageElelemnts extends CommonMethods {
	
	@FindBy(id = "pimPersonalDetailsForm")
	public WebElement personalDetailForm;
	
	@FindBy(id = "employeeId")
	public WebElement employeeId;
	
	
	public PersonDetailPageElelemnts() {
		PageFactory.initElements(driver, this);
	}

}
