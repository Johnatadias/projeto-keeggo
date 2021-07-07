package br.com.keeggo.utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StoredActions {

	private WebDriver driver;
	private JavascriptExecutor js;
	
	public StoredActions(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getUrl(String url) {
		driver.get(url);
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public void send(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public void teclaEnter(WebElement element) {
		element.sendKeys(Keys.ENTER);
	}
	
	public void waitTime() {
		js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");
	}
	
	public void scrollDown() {
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,200)", "");
	}
	
	public Boolean elementIsVisible(WebElement element, Integer seconds) {
		try {
			return this.waitForElementToBeClickable(element, seconds) != null;
		} catch (NoSuchElementException e) {
			System.out.println("Elemento nao visivel (NoSuchElementException).");
			return false;
		} catch (StaleElementReferenceException e) {
			System.out.println("Elemento nao visivel (StaleElementReferenceException).");
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public Boolean elementIsVisible(WebElement element) {
		try {
			return this.fluentlyWaitUtilVisibility(element) != null;
		} catch (NoSuchElementException e) {
			System.out.println("Elemento nao visivel (NoSuchElementException).");
			return false;
		} catch (StaleElementReferenceException e) {
			System.out.println("Elemento nao visivel (StaleElementReferenceException).");
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private WebElement waitForElementToBeClickable(WebElement element, int seconds) {
		return new WebDriverWait(driver, seconds) //
				.ignoring(StaleElementReferenceException.class) //
				.ignoring(NoSuchElementException.class) //
				.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	private WebElement fluentlyWaitUtilVisibility(WebElement element) {
		return (new FluentWait<WebDriver>(driver)) //
				.withTimeout(Duration.ofSeconds(10)) //
				.pollingEvery(Duration.ofSeconds(10)) //
				.ignoring(StaleElementReferenceException.class) //
				.until(ExpectedConditions.visibilityOf(element)); 
	}
}
