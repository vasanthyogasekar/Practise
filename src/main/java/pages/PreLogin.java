package pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

import base.BaseFunctions;

public class PreLogin extends BaseFunctions {
	
private WebDriver driver=null;
	
	public PreLogin(WebDriver driver){
		super(driver);
		this.driver = driver;	
	}

	@AfterClass
	public void teardown() {
		driver.close();
	}
	
public void check_username_field() {
	assert is_present("//*[@id='txtUsername']");
}

public void check_password_field() {
	assert is_present("//*[@id='txtPassword']");
}
	
public void check_login_button() {
	assert is_present("//*[@id='btnLogin']");
}


}
