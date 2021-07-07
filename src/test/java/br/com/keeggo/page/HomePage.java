package br.com.keeggo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public String url = "http://www.advantageonlineshopping.com/#/";
	
	public WebElement iconeUser() {
		return driver.findElement(By.id("menuUserLink"));
	}
	
	public WebElement userName() {
		return driver.findElement(By.name("username"));
	}
	
	public WebElement password() {
		return driver.findElement(By.name("password"));
	}
	
	public WebElement botaoEntrar() {
		return driver.findElement(By.id("sign_in_btnundefined"));
	}
	
	public WebElement createUsuario() {
		return driver.findElement(By.xpath("//*[@class='create-new-account ng-scope']"));
	}
	
	public WebElement validandoLoginNegativo() {
		return driver.findElement(By.id("signInResultMessage"));
	}
	
	public WebElement validandoUsuarioCriado() {
		return driver.findElement(By.xpath("//*[@id='menuUserLink']//span"));
	}
}
