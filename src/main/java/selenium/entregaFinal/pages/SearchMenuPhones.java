package selenium.entregaFinal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchMenuPhones extends BasePage {

	@FindBy(how = How.XPATH, using = "//*[@id='content']/div[2]/div[1]//h4/a")
	private WebElement lblProductName;

	public String getProductName() {
		return lblProductName.getText();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='content']/div[2]/div[1]/div/div[2]/div[1]/p[2]")
	private WebElement lblProductPrice;

	public String getProductPrice() {
		return lblProductPrice.getText();
	}

	/*
	 * Add Shopping Cart
	 */
	@FindBy(how = How.XPATH, using = "//*[@id='content']/div[2]/div[1]//div[2]/button[1]") 
	private WebElement buttonAddShopCart;

	public void addCartShopping() {
		buttonAddShopCart.click();
	}

	@FindBy(how = How.CSS, using = "body > div:nth-child(4) > div.alert.alert-success") 
	private WebElement alertSuccessCart;

	public WebElement getAlertSuccessAddCart() {
		return alertSuccessCart;
	}

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/a[2]")
	private WebElement optionShopppingCart;

	public ShoppingCartPage optionShoppingCart() {
		optionShopppingCart.click();
		return PageFactory.initElements(driver, ShoppingCartPage.class);
	}

	/*
	 * Add Wish List
	 */
	@FindBy(how = How.XPATH, using = "//*[@id='content']/div[2]/div[1]//div[2]/button[2]")
	private WebElement buttonAddwishList;

	public void addWishList() {
		buttonAddwishList.click();
	}

	@FindBy(how = How.CSS, using = "body > div:nth-child(4) > div.alert.alert-success") 
	private WebElement alertSuccessWishList;

	public String getAlertSuccessAddWishList() {
		return alertSuccessWishList.getText();
	}

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/a[1]")
	private WebElement login;
	
	public LoginPage signUp() {
		login.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	public SearchMenuPhones(WebDriver driver) {
		super(driver);
		if (!this.isLoaded()) {
			throw new IllegalStateException("This is not the Search Result Page");
		}
	}

	@Override
	public By getPageLoaderLocator() {
		return By.xpath("//h2[contains(text(),'Phones & PDAs')]");
	}

}
