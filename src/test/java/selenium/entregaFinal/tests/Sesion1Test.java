package selenium.entregaFinal.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import selenium.entregaFinal.pages.RegisterPage;

@RunWith(JUnitParamsRunner.class)
public class Sesion1Test extends BaseTest {

	@Test
	@FileParameters("data/accountRegister.csv")
	public void registerNewCustomerTest(String name, String lastname, String email, String tel, String fax,
			String company, String address1, String address2, String city, String postCode, String codeRegion,
			String codeState, String password, String passwordConfirm) {
		RegisterPage reg;
		homePage.clickOptionAccount();
		reg = homePage.clickOptionRegister();
		reg.fillFormPersonalDetails(name, lastname, email, tel, fax);
		reg.fillFormAddress(company, address1, address2, city, postCode);
		reg.fillFormAddressCountry(codeRegion);
		reg.fillFormAddressState(codeState);
		reg.fillFormPassword(password, passwordConfirm);
		reg.clickConfirm();
		WebElement alertMailExist = waitElement("/html/body/div[2]/div[1]");
		assertTrue(alertMailExist.isEnabled());

	}

}
