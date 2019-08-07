
package selenium.entregaFinal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AccountCustomerPage extends BasePage{
	
	public AccountCustomerPage(WebDriver driver) {
		super(driver);
		if(!this.isLoaded()) {
			throw new IllegalStateException("This is not the Customer Account Page");
		}
	}
	@Override
	public By getPageLoaderLocator() {
		return By.xpath("//h2[contains(text(),'My Account')]");
	}

	/*
	 * Logout
	 */		
	@FindBy (how = How.XPATH, using = "//*[@id='top-links']/ul/li[2]/ul/li[5]/a")
	private WebElement optionLoguout;
	
	public CustomerAccountLogout clickLogout() {
		optionLoguout.click();
		return PageFactory.initElements(driver,CustomerAccountLogout.class);
	}
	
}
