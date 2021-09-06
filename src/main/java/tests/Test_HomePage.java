package tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.management.relation.Role;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;

public class Test_HomePage {
//	private Properties properties;
	HomePage hm;
//	private final String propertyFilePath= "config.properties";

	WebDriver driver;	
	
	Test_HomePage(){
		Driver d = new Driver();
		driver = d.getDriver();	
		hm = new HomePage(driver);
	}
	
	
////	@Test
//	public void ConfigFileReader(){
//		FileReader reader;
//		try {
//			reader = new FileReader(propertyFilePath);
//			properties = new Properties();
//			try {
//				properties.load(reader);
//				System.out.println(properties.getProperty("URL"));
//				reader.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
//		}		
//	}
	
	@BeforeClass
	public void diverInitialization() {
		driver.get("https://opensource-demo.orangehrmlive.com/");	
		hm.login();
	}
	
	@AfterClass
	public void teardown() {
		driver.close();
	}
	
	@Test
	public void check_title() {
		System.out.println(driver.getTitle());
		assert driver.getTitle().contains("OrangeHRM");
	}
	
	@Test
	public void check_notificacation_icon() {
		assert hm.is_present("//*[@id='notification']");		
	}
	
	@Test
	public void check_LeaveType_Items() {
		hm.navigate_to_userManagement();
		List <String>userRoles = hm.get_userRole_items("//*[@id='searchSystemUser_userType']");
		System.out.println(userRoles);
		List <String> statuses = hm.get_userRoleStatus_items("//*[@id='searchSystemUser_status']");
		System.out.println(statuses);
		System.out.println(hm.get_duplicates(userRoles, statuses));
		
		
		int[] arr = {2,3,4,4,5};
		List<Integer> dup = new ArrayList();
		List<Integer> nondup = new ArrayList();;
		
//		System.out.println(original);
		
		for (int i=0 ; i<arr.length;i++) {
			for (int j=i+1 ; j<arr.length;j++) {
				
				if(arr[i]==arr[j]) {
					dup.add(arr[i]);
					break;
				}				
				}
			
		}
		
		
		Map<String,List<Integer>> d = new HashMap<String,List<Integer>>();	
		d.put("duplicate", dup);
		System.out.println(d);
		
		
		
		
		Map<String,List<String>> m = new HashMap<String,List<String>>();
		m.put("roles", userRoles);
		m.put("statuses", statuses);
		
		System.out.println(m);
		
		
		
	}
	
	


}
