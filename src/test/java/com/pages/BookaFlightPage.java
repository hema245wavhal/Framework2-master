package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.base.BasePage;

public class BookaFlightPage extends BasePage {

	public BookaFlightPage() {
		
	}

	@FindBy(name = "passFirst0")
	public WebElement firstName;
	@FindBy(name = "passLast0")
	public WebElement lastName;
	@FindBy(name = "pass.0.meal")
	public WebElement meal_drpdwn;
	@FindBy(name = "creditCard")
	public WebElement cardType_drpdwn;
	@FindBy(name = "creditnumber")
	public WebElement number;
	@FindBy(name = "cc_exp_dt_mn")
	public WebElement exp_mn_drpdwn;
	@FindBy(name = "cc_exp_dt_yr")
	public WebElement exp_yr_drpdwn;
	@FindBy(name = "cc_frst_name")
	public WebElement ccFirstName;
	@FindBy(name = "cc_mid_name")
	public WebElement ccMidName;
	@FindBy(name = "cc_last_name")
	public WebElement ccLastName;
	@FindBy(name = "buyFlights")
	public WebElement securePurchase;

	public Select setMeal() {
		return new Select(meal_drpdwn);
	}

	public Select setCreditCardType() {
		return new Select(cardType_drpdwn);
	}

	public Select setCcExpMonth() {
		return new Select(exp_mn_drpdwn);
	}

	public Select setCcExpYear() {
		return new Select(exp_yr_drpdwn);
	}

}
