package com.testsuite_datadriven;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.FindaFlightPage;
import com.pages.WelcomePage;

public class TestCase_DataDriventTesting extends BaseClass {

	WelcomePage wp;
	FindaFlightPage ff;
	
	

	@Test(dataProvider = "getData")
	public void Logintest(String myusername, String mypassword) {
	wp=new WelcomePage();
	ff=new FindaFlightPage();
	wp.signin(myusername, mypassword);
	}
	
}
