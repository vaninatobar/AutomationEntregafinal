package selenium.entregaFinal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchResult extends BasePage {

	@Override
	public By getPageLoaderLocator() {
		return By.xpath("//h2[contains(text(),'Products meeting the search criteria')]");
	}

	public SearchResult(WebDriver driver) {
		super(driver);
		if (!this.isLoaded()) {
			throw new IllegalStateException("This is not the Search Result Page");
		}
	}

	/*
	 * Find product
	 */
	@FindBy(how = How.XPATH, using = "//div[@class='caption']/h4/a")
	private WebElement lblProductName;

	@FindBy(how = How.XPATH, using = "/div[3]/div/div/div[2]/div[1]/p[2]/text()")  
	private WebElement lblProductPrice;

	public String getProductName() {
		return lblProductName.getText();
	}

	public String getProductPrice() {
		return lblProductPrice.getText();
	}

	/*
	 * Add Wish List
	 */
	@FindBy(how = How.XPATH, using = "//*[@id='content']/div[3]/div/div/div[2]/div[2]/button[2]")
	private WebElement buttonAddwishList;

	public void addWishList() {
		buttonAddwishList.click();
	}

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]")
	private WebElement alertSuccessWishList;
	 
	public boolean getAlertSuccessAddWishList() { 
		return alertSuccessWishList.isDisplayed();
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='wishlist-total']")
	private WebElement optionWishList;

	public WishListPage optionWishList() {
		optionWishList.click();
		return PageFactory.initElements(driver, WishListPage.class);
	}


	/*
	 * Add Shopping Cart
	 */

	@FindBy(how = How.XPATH, using = "//*[@id='content']/div[3]/div/div/div[2]/div[2]/button[1]")
	private WebElement buttonAddShopCart;

	public void addCartShopping() {
		buttonAddShopCart.click();
	}
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]")
	private WebElement alertSuccessAddCart;

	public boolean getAlertSuccessAddCart() {
		return alertSuccessAddCart.isDisplayed();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='top-links']/ul/li[4]/a/i")
	private WebElement optionShopppingCart;

	public ShoppingCartPage optionShoppingCart() {
		optionShopppingCart.click();
		return PageFactory.initElements(driver, ShoppingCartPage.class);
	}
	
	
	
	
}
