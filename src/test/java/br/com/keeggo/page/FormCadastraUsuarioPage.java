package br.com.keeggo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormCadastraUsuarioPage extends BasePage {

	public FormCadastraUsuarioPage(WebDriver driver) {
		super(driver);
	}

	public WebElement userName() {
		return driver.findElement(By.name("usernameRegisterPage"));
	}

	public WebElement email() {
		return driver.findElement(By.name("emailRegisterPage"));
	}

	public WebElement password() {
		return driver.findElement(By.name("passwordRegisterPage"));
	}

	public WebElement confirmPassword() {
		return driver.findElement(By.name("confirm_passwordRegisterPage"));
	}

	public WebElement firstName() {
		return driver.findElement(By.name("first_nameRegisterPage"));
	}

	public WebElement lastName() {
		return driver.findElement(By.name("last_nameRegisterPage"));
	}

	public WebElement phoneNumber() {
		return driver.findElement(By.name("phone_numberRegisterPage"));
	}

	public WebElement comboBoxCountry() {
		return driver.findElement(By.name("countryListboxRegisterPage"));
	}

	public WebElement city() {
		return driver.findElement(By.name("cityRegisterPage"));
	}

	public WebElement address() {
		return driver.findElement(By.name("addressRegisterPage"));
	}

	public WebElement state() {
		return driver.findElement(By.name("state_/_province_/_regionRegisterPage"));
	}

	public WebElement postalCode() {
		return driver.findElement(By.name("postal_codeRegisterPage"));
	}

	public WebElement aceitarTermo() {
		return driver.findElement(By.name("i_agree"));
	}

	public WebElement botaoRegistrar() {
		return driver.findElement(By.id("register_btnundefined"));
	}

	public WebElement validandoUsuarioExistente() {
		return driver.findElement(By.xpath("//*[@id='registerPage']/article/sec-form/div[2]/label[1]"));
	}
}
