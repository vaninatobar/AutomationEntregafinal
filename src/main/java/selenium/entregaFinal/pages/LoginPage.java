package selenium.entregaFinal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	
	 public LoginPage(WebDriver driver) {
			super(driver);
			if(!this.isLoaded()) {
				throw new IllegalStateException("This is not the Login Page");
			}
		}

		@Override
		public By getPageLoaderLocator() {
			return By.xpath("//h2[contains(text(),'Returning Customer')]");
		}
		
	@FindBy (how = How.XPATH, using = "//*[@id='input-email']")
	private WebElement inputEmail;
	
	@FindBy (how = How.XPATH, using = "//*[@id='input-password']")
	private WebElement inputPasword;
	
	@FindBy (how = How.XPATH, using = "//*[@id='content']/div/div[2]/div/form/input")
	private WebElement buttonLogin;
	
	public AccountCustomerPage signUp(String email, String password) {
		inputEmail.sendKeys(email);
		inputPasword.sendKeys(password);
		buttonLogin.click();
		return PageFactory.initElements(driver, AccountCustomerPage.class);
	}	
	
	
    	
}
