package selenium.entregaFinal.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import selenium.entregaFinal.pages.AccountCustomerPage;
import selenium.entregaFinal.pages.CustomerAccountLogout;
import selenium.entregaFinal.pages.LoginPage;


@RunWith(JUnitParamsRunner.class)
public class Sesion2Test extends BaseTest {

	@Test
	@FileParameters("data/accounts.csv")
	public void loginTest(String email, String password) {
		LoginPage login;
		homePage.clickOptionAccount();
		login = homePage.clickOptionLogin();
		AccountCustomerPage account;
		account = login.signUp(email, password);
		homePage.clickOptionAccount();
		CustomerAccountLogout logout;
		logout = account.clickLogout();

	}

}
