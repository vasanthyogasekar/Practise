package base;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class BaseFunctions {

	public WebDriver driver=null;

	
	public BaseFunctions(WebDriver driver){
		this.driver = driver;	
	}
			
public void click(String element) {
	driver.findElement(By.xpath(element)).click();		
	}

public String get_title() {
	String title = driver.getTitle();
	return title;
	}

public void type(String element, String text_to_enter) {
	WebElement webelement = driver.findElement(By.xpath(element));
	webelement.click();
	webelement.sendKeys(text_to_enter);	
}

public boolean is_present(String element) {
	WebElement web_element = driver.findElement(By.xpath(element));
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOf(web_element));
	return web_element.findElement(By.xpath(element)).isDisplayed();
}

public boolean check_contains(String text_to_check, String contains_text) {
	return text_to_check.contains(contains_text) ? true : false;
}

public void move_over(String element) {
	WebElement wb = driver.findElement(By.xpath(element));
	Actions actions = new Actions(driver);
	actions.moveToElement(wb).perform();
}

public void select_item(String dropDown_weblement, String item_to_select) {
	WebElement webelement = driver.findElement(By.xpath(dropDown_weblement));
	Select objSelect =new Select(webelement);
	objSelect.selectByVisibleText(item_to_select);
}

public List get_list_items(String dropDown_weblement) {
	WebElement webelement = driver.findElement(By.xpath(dropDown_weblement));
	Select objSelect =new Select(webelement);
	return objSelect.getOptions();
}

public List<String> get_duplicates(List<String> a, List<String> b) {
	List<String> dup = new ArrayList<String>();
	for(String role : a) {
		for (String status : b) {
			if (role.equals(status)){
				dup.add(role);			
			}
		}
	}
	return dup;
	
}


}
