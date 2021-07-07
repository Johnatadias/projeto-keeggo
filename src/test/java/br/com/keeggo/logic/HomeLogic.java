package br.com.keeggo.logic;

import org.openqa.selenium.WebDriver;

import br.com.keeggo.page.BasePage;
import br.com.keeggo.page.HomePage;
import br.com.keeggo.utils.StoredActions;

public class HomeLogic extends BasePage{

	private HomePage homePage;
	private StoredActions action;
	
	public HomeLogic(WebDriver driver) {
		super(driver);
		homePage = new HomePage(driver);
		action = new StoredActions(driver);
	}
	
	public void acessarUrl() {
		action.getUrl(homePage.url);
	}

	public void clicaIconeUser() {
		action.elementIsVisible(homePage.iconeUser(), 30);
		action.click(homePage.iconeUser());;
	}
	
	public void preencheUserName(String userName) {
		action.elementIsVisible(homePage.userName(), 30);
		action.send(homePage.userName(), userName);;
	}
	
	public void preenchePassword(String password) {
		action.send(homePage.password(), password);;
	}
	
	public void clicaBotaoEntrar() {
		action.waitTime();
		action.click(homePage.botaoEntrar());;
	}
	
	public void clicaCreateUsuario() {
		action.elementIsVisible(homePage.createUsuario(), 30);
		action.teclaEnter(homePage.createUsuario());
	}
	
	public String validaUsuarioCriado() {
		action.elementIsVisible(homePage.validandoUsuarioCriado(), 30);
		return action.getText(homePage.validandoUsuarioCriado());
	}
	
	public boolean validaLoginNegativo() {
		action.waitTime();
		String mensagemLogin = action.getText(homePage.validandoLoginNegativo());
		if(mensagemLogin.equalsIgnoreCase("Incorrect user name or password.")){
			return true;
		}
		return false;
	}
}
