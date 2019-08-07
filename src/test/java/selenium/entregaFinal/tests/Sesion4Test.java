package selenium.entregaFinal.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import selenium.entregaFinal.pages.AccountCustomerPage;
import selenium.entregaFinal.pages.LoginPage;
import selenium.entregaFinal.pages.SearchResult;
import selenium.entregaFinal.pages.WishListPage;


@RunWith(JUnitParamsRunner.class)
public class Sesion4Test extends BaseTest{
		
	@Test
	@FileParameters("data/productsWishList.csv")
	public void addWishListTest(String product, String email, String password)  {	
		SearchResult search;
		homePage.searchProduct(product);
		search = homePage.clickSearchButton();
		String productExpected = search.getProductName();
		assertTrue("This Product is not correct: " + productExpected, productExpected.contains(product));
		search.addWishList();
		assertTrue("Alert: Do not have added Product to wish List. ", search.getAlertSuccessAddWishList());		
		LoginPage login;
		homePage.clickOptionAccount();
		login = homePage.clickOptionLogin();			
		AccountCustomerPage account;
		account = login.signUp(email,password);
		WishListPage list;
		list = search.optionWishList();		
		assertTrue(list.getSavedProduct(product));			
	
	}
}
