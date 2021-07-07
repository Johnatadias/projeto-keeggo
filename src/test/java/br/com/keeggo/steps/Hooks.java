package br.com.keeggo.steps;

import java.io.IOException;

import com.cucumber.listener.Reporter;

import br.com.keeggo.suport.Web;
import br.com.keeggo.utils.Screenshot;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	@Before
	public void inicializa() {
		Web.createChromer();
	}
	
	@After
	public void finaliza(Scenario cenario) throws IOException {
		String screenPath = Screenshot.gerarScreenShot(Web.getDriver(), cenario.getName());
		Reporter.addScreenCaptureFromPath(screenPath);
		Web.quitDriver();
	}
}
