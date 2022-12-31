package com.baseclass.maven;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Baseclass_Demo {
	
	public static WebDriver driver;

	public static WebDriver browserlaunch(String browsername) {
		if (browsername.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\DELL\\eclipse-workspace\\Selenium_Project1\\Driver\\chromedriver.exe");

			driver = new ChromeDriver();
			
		}else if (browsername.equalsIgnoreCase("firefox")) {
			
		
			
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\DELL\\eclipse-workspace\\Selenium_Project1\\Driver\\chromedriver.exe");
			
			driver = new FirefoxDriver();

			
		}
		return driver;
		
	}
	
	public static  void url(String url) {
		
		driver.get(url);
		
	}
	public static String get_Title() {

		String title = driver.getTitle();
		return title;
	}
	
	public static  String get_Currenturl() {

		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	public static  void popup(String types) {

		if (types.equalsIgnoreCase("accept")) {
			
			driver.switchTo().alert().accept();
			
		} else if (types.equalsIgnoreCase("dismiss")) {
			
			driver.switchTo().alert().dismiss();
			
		}
	
	}
	
	public static  void manage(String value) {
		
		if (value.equalsIgnoreCase("maximize")) {
			
			driver.manage().window().maximize();
			
		} else if (value.equalsIgnoreCase("minimize")) {
			driver.manage().window().minimize();
			
		}else if (value.equalsIgnoreCase("fullscreen")) {
			driver.manage().window().fullscreen();
			
		}
		

	}
  
	public static  void navigete_Url(String navto) {
		
		driver.navigate().to(navto);	
	}
	
	public static void navigate(String values) {
		
		if (values.equalsIgnoreCase("back")) {
			
			driver.navigate().back();
			
		} else if (values.equalsIgnoreCase("forward")) {
			
			driver.navigate().forward();
			
		} else if (values.equalsIgnoreCase("refresh")) {
			driver.navigate().refresh();
			
		}

}
	
	public static void close() {
		
		driver.close();

	}
	
	public static  void sendkeys(WebElement element, String data) {
		
		element.sendKeys(data);
				
	}
	
	public static void screenshot(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\DELL\\eclipse-workspace\\Project_Maven\\Screenshot\\"+name+".png");
		FileUtils.copyFile(src, des);
		
	}
	public static void click(WebElement element) {
		element.click();

	}

	public static void clear(WebElement element) {
		element.clear();
	}

	public static void implicity_Wait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}


	public static void dropdown_Index(WebElement element, int index) {

		Select s = new Select(element);
		s.selectByIndex(index);

	}

	public static void dropdown_Text(WebElement element, String Text) {
		Select s = new Select(element);
		s.deselectByVisibleText(Text);
	}

	public static void dropdown_Value(WebElement element, String name) {

		Select s = new Select(element);
		s.selectByValue(name);
	}

}



