package br.com.keeggo.logic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import br.com.keeggo.page.BasePage;
import br.com.keeggo.page.FormCadastraUsuarioPage;
import br.com.keeggo.utils.StoredActions;

public class CadastroUsuarioLogic extends BasePage{

	private FormCadastraUsuarioPage cadastrarUsuarioPage;
	private StoredActions action;
	
	public CadastroUsuarioLogic(WebDriver driver) {
		super(driver);
		cadastrarUsuarioPage = new FormCadastraUsuarioPage(driver);
		action = new StoredActions(driver);
	}

	public void preencheUserName(String userName) {
		action.elementIsVisible(cadastrarUsuarioPage.userName(), 30);
		action.send(cadastrarUsuarioPage.userName(), userName);
	}
	
	public void preencheEmail(String email) {
		action.send(cadastrarUsuarioPage.email(), email);
	}
	
	public void preenchePassword(String password) {
		action.send(cadastrarUsuarioPage.password(), password);
	}
	
	public void preencheConfirmPassword(String confirmPassword) {
		action.send(cadastrarUsuarioPage.confirmPassword(), confirmPassword);
	}
	
	public void preencheFirstName(String firstName) {
		action.send(cadastrarUsuarioPage.firstName(), firstName);
	}
	
	public void preencheLastName(String lastName) {
		action.send(cadastrarUsuarioPage.lastName(), lastName);
	}
	
	public void preenchePhoneNumber(String phoneNumber) {
		action.send(cadastrarUsuarioPage.phoneNumber(), phoneNumber);
	}
	
	public void preencheComboBoxCountry(String country) {
		Select select = new Select(cadastrarUsuarioPage.comboBoxCountry());
		select.selectByVisibleText(country);
	}
	
	public void preencheCity(String city) {
		action.send(cadastrarUsuarioPage.city(), city);
	}
	
	public void preencheAddress(String address) {
		action.send(cadastrarUsuarioPage.address(), address);
	}

	public void preencheState(String state) {
		action.send(cadastrarUsuarioPage.state(), state);
	}

	public void preenchePostalCode(String postalCode) {
		action.send(cadastrarUsuarioPage.postalCode(), postalCode);
	}

	public void aceitarTermo() {
		action.click(cadastrarUsuarioPage.aceitarTermo());
	}

	public void clicaBotaoRegistrar() {
		action.click(cadastrarUsuarioPage.botaoRegistrar());
	}

	public boolean validandoUsuarioExistente() {
		action.scrollDown();
		action.waitTime();
		String mensagem = action.getText(cadastrarUsuarioPage.validandoUsuarioExistente());
		if(mensagem.equalsIgnoreCase("User name already exists")) {
			return true;
		}
		return false;
	}
}
