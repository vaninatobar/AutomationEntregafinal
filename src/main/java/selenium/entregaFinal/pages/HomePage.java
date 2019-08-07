package selenium.entregaFinal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
	
	@Override
	public By getPageLoaderLocator() {
		return By.id("slideshow0");			
	}
		
	public HomePage(WebDriver driver) {
		super(driver);
		if(!this.isLoaded()) {
			throw new IllegalStateException("This is not the Abstracta Cart Home Page");
		}
	}
	
	/*
	 * Search a product by SearchBar
	 */
	@FindBy (how = How.XPATH, using = "//*[@id='search']//button")
	private WebElement btnSearch;
	
	@FindBy (how = How.XPATH, using = "//*[@id='search']/input")
	private WebElement inpSearch;	
	
	public void searchProduct(String product) {
		inpSearch.sendKeys(product);
	}	
		
	public SearchResult clickSearchButton() {
		btnSearch.click();
		return PageFactory.initElements(driver,SearchResult.class);
	}
	
	/*
	 * My Account
	 */
	@FindBy (how = How.XPATH, using = "//*[@id='top-links']/ul/li[2]/a")
	private WebElement optionAccount;
	
	@FindBy (how = How.XPATH, using = "//*[@id='top-links']/ul/li[2]/ul/li[2]/a")
	private WebElement optionLogin;
	
	@FindBy (how = How.XPATH, using = "//*[@id='top-links']/ul/li[2]/ul/li[1]/a")
	private WebElement optionRegister;
	
	public void clickOptionAccount() {
		optionAccount.click();
	}
	
	public LoginPage clickOptionLogin() {
		optionLogin.click();
		return PageFactory.initElements(driver,LoginPage.class);
	}
	
	public RegisterPage clickOptionRegister() {
		optionRegister.click();
		return PageFactory.initElements(driver,RegisterPage.class);
	}
	

}
