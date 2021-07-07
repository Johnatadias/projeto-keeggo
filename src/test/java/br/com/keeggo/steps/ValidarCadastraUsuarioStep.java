package br.com.keeggo.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import br.com.keeggo.logic.CadastroUsuarioLogic;
import br.com.keeggo.logic.HomeLogic;
import br.com.keeggo.suport.Web;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class ValidarCadastraUsuarioStep {

	private CadastroUsuarioLogic cadastroUsuarioLogic;
	private HomeLogic homeLogic;
	private String userName;
	
	public ValidarCadastraUsuarioStep() {
		cadastroUsuarioLogic = new CadastroUsuarioLogic(Web.getDriver());
		homeLogic = new HomeLogic(Web.getDriver());
	}
	
	@Dado("^que o usuario esteja no site$")
	public void que_o_usuario_esteja_na_plicacao() {
		homeLogic.acessarUrl();
	}

	@Quando("^clicar em no icone user$")
	public void clicar_em_no_icone_user() {
		homeLogic.clicaIconeUser();
	}

	@Quando("^clicar em create new account$")
	public void clicar_em_create_new_account() {
		homeLogic.clicaCreateUsuario();
	}

	@Quando("^preencher o campo username \"([^\"]*)\"$")
	public void preencher_o_campo_username(String userName) {
		this.userName = userName;
		cadastroUsuarioLogic.preencheUserName(this.userName);
	}

	@Quando("^preencher o campo email \"([^\"]*)\"$")
	public void preencher_o_campo_email(String email) {
		cadastroUsuarioLogic.preencheEmail(email);
	}

	@Quando("^preencher o campo password \"([^\"]*)\"$")
	public void preencher_o_campo_password(String password) {
		cadastroUsuarioLogic.preenchePassword(password);
	}

	@Quando("^preencher o campo confirm password \"([^\"]*)\"$")
	public void preencher_o_campo_confirm_password(String confirmPassword) {
		cadastroUsuarioLogic.preencheConfirmPassword(confirmPassword);
	}

	@Quando("^preencher o campo firt name \"([^\"]*)\"$")
	public void preencher_o_campo_firt_name(String firstName) {
		cadastroUsuarioLogic.preencheFirstName(firstName);
	}

	@Quando("^preencher o campo last name \"([^\"]*)\"$")
	public void preencher_o_campo_last_name(String lastName) {
		cadastroUsuarioLogic.preencheLastName(lastName);
	}

	@Quando("^preencher o campo phone number \"([^\"]*)\"$")
	public void preencher_o_campo_phone_number(String phoneNumber) {
		cadastroUsuarioLogic.preenchePhoneNumber(phoneNumber);
	}

	@Quando("^selecionar o pais \"([^\"]*)\" no campo country$")
	public void selecionar_o_pais_no_campo_country(String country) {
		cadastroUsuarioLogic.preencheComboBoxCountry(country);
	}

	@Quando("^preencher o campo city \"([^\"]*)\"$")
	public void preencher_o_campo_city(String city) {
		cadastroUsuarioLogic.preencheCity(city);
	}

	@Quando("^preencher o campo address \"([^\"]*)\"$")
	public void preencher_o_campo_address(String address) {
		cadastroUsuarioLogic.preencheAddress(address);
	}

	@Quando("^preencher o campo state \"([^\"]*)\"$")
	public void preencher_o_campo_state(String state) {
		cadastroUsuarioLogic.preencheState(state);
	}

	@Quando("^preencher o campo postal code \"([^\"]*)\"$")
	public void preencher_o_campo_postal_code(String postalCode) {
		cadastroUsuarioLogic.preenchePostalCode(postalCode);
	}

	@Quando("^aceitar os termos de uso$")
	public void aceitar_os_termos_de_uso() {
		cadastroUsuarioLogic.aceitarTermo();
	}

	@Quando("^clicar no botao register$")
	public void clicar_no_botao_register() {
		cadastroUsuarioLogic.clicaBotaoRegistrar();
	}
	
	@Entao("^usuario e cadastrado com sucesso$")
	public void usuario_ao_cadastrado_com_sucesso() {
		assertEquals(userName, homeLogic.validaUsuarioCriado());
	}
	
	@Entao("^usuario nao e cadastrado$")
	public void usuario_ao_notificado_com_uma_informacao() {
		assertTrue(cadastroUsuarioLogic.validandoUsuarioExistente());
	}
}
