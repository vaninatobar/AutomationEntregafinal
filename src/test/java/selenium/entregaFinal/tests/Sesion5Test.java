package selenium.entregaFinal.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import selenium.entregaFinal.pages.SearchResult;
import selenium.entregaFinal.pages.ShoppingCartPage;
;

@RunWith(JUnitParamsRunner.class)
public class Sesion5Test extends BaseTest {

	@Test
	@FileParameters("data/productRemove.csv")
	public void removeProductTest(String product) {
		SearchResult search;
		homePage.searchProduct(product);
		search = homePage.clickSearchButton();
		String resultExpected = search.getProductName();
		assertTrue("This Product is not correct: " + product, resultExpected.contains(product));
		search.addCartShopping();
		assertTrue("Alert: Do not have added Product. ", search.getAlertSuccessAddCart());
		ShoppingCartPage cart;
		cart = search.optionShoppingCart();
		cart.removeProductShoppingCart(product);
		WebElement e = waitElement("//p[contains(.,'Your shopping cart is empty!')]");
		assertTrue("The Shopping Cart is not empty: ",
				cart.checkEmptyShoppingCart().contains("Your shopping cart is empty!"));
	}
}
