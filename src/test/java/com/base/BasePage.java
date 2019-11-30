package com.base;

import org.openqa.selenium.support.PageFactory;

public class BasePage {

	public BasePage() {
		PageFactory.initElements(DriverInit.Driver, this);
	}

}
