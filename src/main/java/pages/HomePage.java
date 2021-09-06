package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseFunctions;

public class HomePage extends BaseFunctions {
	
private WebDriver driver=null;
	
public HomePage(WebDriver driver){
		super(driver);
		this.driver = driver;	
	}

public void login() {
	type("//*[@id='txtUsername']", "admin");
	type("//*[@id='txtPassword']", "admin123");
	click("//*[@id='btnLogin']");	
}

public void navigate_to_userManagement() {
	super.move_over("//*[@id='menu_admin_viewAdminModule']");
	super.move_over("//*[@id='menu_admin_UserManagement']");
//	super.move_over("//*[@id='menu_leave_addLeaveEntitlement']");
	super.click("//*[@id='menu_admin_viewSystemUsers']");
	
}

public List get_userRole_items(String weblement) {
	List<WebElement> li = super.get_list_items(weblement);
	List<String> userRoles = new ArrayList();
	for(WebElement e : li) {
		System.out.println(e.getText());
		userRoles.add(e.getText());
	}
	return userRoles;
}

public List get_userRoleStatus_items(String webelement) {

	List<WebElement> li = super.get_list_items(webelement);
	List<String> status = new ArrayList();
	for(WebElement e : li) {
		System.out.println(e.getText());
		status.add(e.getText());
	}
	return status;
}


}
