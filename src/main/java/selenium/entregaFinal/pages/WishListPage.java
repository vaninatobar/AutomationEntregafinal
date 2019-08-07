package selenium.entregaFinal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class WishListPage extends BasePage {	
		
	public WishListPage(WebDriver driver) {
		super(driver);
		if(!this.isLoaded()) {
			throw new IllegalStateException("This is not the Wish List Page");
		}
	}

	@Override
	public By getPageLoaderLocator() {
		return By.xpath("//h2[contains(text(),'My Wish List')]");
	}
	

	/*
	 * Select Saved Product
	 */
	private By SearchSavedProduct(String product) {
		  return By.xpath("//*[@id='content']/div[1]/table/tbody/tr[contains(.,'" + product +"')]");
		}
	
	public boolean getSavedProduct(String product) {
		return driver.findElement(SearchSavedProduct(product)).isDisplayed();
	}
	
}
