package selenium.entregaFinal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessCheckOut extends BasePage {

	public SuccessCheckOut(WebDriver driver) {
		super(driver);
		if(!this.isLoaded()) {
			throw new IllegalStateException("This is not the Success CheckOut Page");
		}
	}

	@Override
	public By getPageLoaderLocator() {
		return By.xpath("//h1[contains(text(),'Your order has been placed!')]");
	}

}
