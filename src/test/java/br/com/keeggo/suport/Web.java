package br.com.keeggo.suport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {

	private static WebDriver driver;

	public static WebDriver getDriver() {
		if(driver == null)
			createChromer();
		return driver;
	}
	
	public static void createChromer() {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void quitDriver() {
		if(driver != null)
			driver.quit();
		driver = null;
	}
}
