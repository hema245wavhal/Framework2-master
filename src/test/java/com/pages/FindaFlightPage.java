package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.base.BasePage;

public class FindaFlightPage extends BasePage {

	public FindaFlightPage() {
	
	}

	@FindBy(xpath = "//input[@value='oneway']")
	public WebElement oneway_rdbtn;
	@FindBy(name = "passCount")
	public WebElement psgrCount;
	@FindBy(name = "fromPort")
	public WebElement DeprtFrom;
	@FindBy(name = "fromMonth")
	public WebElement onMonth;
	@FindBy(name = "fromDay")
	public WebElement onDay;
	@FindBy(name = "toPort")
	public WebElement arrvIn;
	@FindBy(name = "toMonth")
	public WebElement toMonth;
	@FindBy(name = "toDay")
	public WebElement toDay;
	@FindBy(xpath = "//input[@value='Business']")
	public WebElement srvClass_rdbtn;
	@FindBy(name = "airline")
	public WebElement airLine_drpdwn;
	@FindBy(name = "findFlights")
	public WebElement Continue;
	@FindBy(linkText = "SIGN-OFF")
	public WebElement signoff;

	public void chooseTripType() {
		oneway_rdbtn.click();
	}

	public Select setPassengersCount() {
		return new Select(psgrCount);
	}

	public Select setFromPort() {
		return new Select(DeprtFrom);
	}

	public Select setOnMonth() {
		return new Select(onMonth);
	}

	public Select setOnDay() {
		return new Select(onDay);
	}

	public Select setArrivalPort() {
		return new Select(arrvIn);
	}

	public Select setToMonth() {
		return new Select(toMonth);
	}

	public Select setToDay() {
		return new Select(toDay);
	}

	public void chooseServiceType() {
		srvClass_rdbtn.click();
	}

	public Select selectAirLine() {
		return new Select(airLine_drpdwn);
	}

	public void Continue() {
		Continue.click();
	}

	public void isElementPresent() {

	}

}
