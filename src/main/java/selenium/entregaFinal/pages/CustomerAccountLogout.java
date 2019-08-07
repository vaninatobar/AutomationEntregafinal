package selenium.entregaFinal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerAccountLogout extends BasePage{

	public CustomerAccountLogout(WebDriver driver) {
		super(driver);
		if(!this.isLoaded()) {
			throw new IllegalStateException("This is not the Customer Account Logout Page");
		}
	}

	@Override
	public By getPageLoaderLocator() {
		return By.xpath("//h1[contains(text(),'Account Logout')]");
	}
	

}
