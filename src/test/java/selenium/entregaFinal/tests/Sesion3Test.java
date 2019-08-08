package selenium.entregaFinal.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import selenium.entregaFinal.pages.CheckOutPage;
import selenium.entregaFinal.pages.SearchResult;
import selenium.entregaFinal.pages.ShoppingCartPage;

@RunWith(JUnitParamsRunner.class)
public class Sesion3Test extends BaseTest{
	
	@Test
	@FileParameters("data/productsWishList.csv")
	public void checkOutTest(String product, String email, String password) {
		SearchResult search;
		homePage.searchProduct(product);
		search = homePage.clickSearchButton();
		String productExpected = search.getProductName();
		assertTrue("This Product is not correct: " + productExpected, productExpected.contains(product));

		search.addCartShopping();
		assertTrue("Alert: Do not have added Product. ", search.getAlertSuccessAddCart());

		ShoppingCartPage cart;
		cart = search.optionShoppingCart();

		assertTrue("This Product name is not correct:" + productExpected,
				cart.getProductNameCart().contains(productExpected));
		assertTrue("This Total Price is not correct: " + cart.getProductPriceCart(),
				cart.getProductPriceCart().contains(cart.getProductPriceCartTotal()));

		CheckOutPage check;
		check = cart.clickCheckOut();
		check.signUpCheckOut(email, password);
		removeBanner();
		check.clickPaymentAddressStep2();
		check.clickShippingAddressStep3();
		check.clickShippingMethodStep4();
		focusElementScroll("button-payment-method");
		waitElementNR("//*[@id='collapse-payment-method']/div/div[2]/div/input[1]");
		check.clickPaymentMethodStep5();
		check.clickConfirmOrderStep6();


	}
}
