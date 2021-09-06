package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Driver;
import pages.PreLogin;

public class Test_LoginPage {
	
WebDriver driver;
PreLogin prelogin_Page;
	
Test_LoginPage(){
		Driver d = new Driver();
		driver = d.getDriver();		
		prelogin_Page = new PreLogin(driver);
	}

@BeforeClass
public void diverInitialization() {
	driver.get("https://opensource-demo.orangehrmlive.com/");
		
}

@Test(priority=1)
public void check_login_field() {
	prelogin_Page.check_username_field();
}

@Test(priority=2)
public void check_password_field() {
	prelogin_Page.check_password_field();
}

@Test(priority=0)
public void check_Login_button() {
	prelogin_Page.check_login_button();
}

@AfterClass
public void teardown() {
	driver.close();
}

}
