package br.com.keeggo.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import br.com.keeggo.logic.HomeLogic;
import br.com.keeggo.suport.Web;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class ValidarLoginStep {

	private HomeLogic homeLogic;
	private String userName;
	
	public ValidarLoginStep() {
		homeLogic = new HomeLogic(Web.getDriver());
	}

	@Quando("^clicar no icone user$")
	public void clicarNoIconeUser() throws Throwable {
		homeLogic.clicaIconeUser();
	}
	
	@Quando("^preencher o username \"([^\"]*)\"$")
	public void preencherOcampoUsername(String userName) {
		this.userName = userName;
		homeLogic.preencheUserName(this.userName);
	}

	@Quando("^preencher o password \"([^\"]*)\"$")
	public void preencherOcampoPassword(String password) {
		homeLogic.preenchePassword(password);
	}

	@Quando("^clicar no botao entrar$")
	public void clicarNoBotaoEntrar() throws Throwable {
		homeLogic.clicaBotaoEntrar();
	}

	@Entao("^usuario e logado com sucesso$")
	public void usuarioELogadoComSucesso() throws Throwable {
		assertEquals(userName, homeLogic.validaUsuarioCriado());
	}

	@Entao("^usuario nao deve ser logado$")
	public void usuarioNaoDeveSerLogado() throws Throwable {
		assertTrue(homeLogic.validaLoginNegativo());
	}
}
