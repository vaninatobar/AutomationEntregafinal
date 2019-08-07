package selenium.entregaFinal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BasePage {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		if (!this.isLoaded()) {
			throw new IllegalStateException("This is not the Shopping Cart Page");
		}
	}

	@Override
	public By getPageLoaderLocator() {
		return By.xpath("//h1[contains(text(),'Shopping Cart')]");
	}

	/*
	 * Shopping Cart List
	 */
	@FindBy(how = How.XPATH, using = "//*[@id='content']/form/div/table/tbody/tr/td[2]/a")
	private WebElement lblProductNameCart;

	public String getProductNameCart() {
		return lblProductNameCart.getText();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='content']/form/div/table/tbody/tr/td[6]")
	private WebElement lblProductPriceCart;

	public String getProductPriceCart() {
		return lblProductPriceCart.getText();
	}

	/*
	 * CheckOut
	 */
	@FindBy(how = How.XPATH, using = "//*[@id='content']/div[2]//tbody/tr[4]/td[2]")
	private WebElement lblProductPriceCartTotal;

	public String getProductPriceCartTotal() {
		return lblProductPriceCartTotal.getText();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='top-links']/ul/li[5]/a")
	private WebElement buttonCheckOut;

	public CheckOutPage clickCheckOut() {
		buttonCheckOut.click();
		return PageFactory.initElements(driver, CheckOutPage.class);
	}

	/*
	 * Shopping Cart Remove Product
	 */
	public void removeProductShoppingCart(String product) {
		driver.findElement(By.xpath("//tbody/tr[contains(.,'" + product + "')]/td[4]//button[2]")).click();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='content']/p[contains(.,'Your shopping cart is empty!')]")
	private WebElement emptyShoppingCart;

	public String checkEmptyShoppingCart() {
		return emptyShoppingCart.getText();
	}

}
