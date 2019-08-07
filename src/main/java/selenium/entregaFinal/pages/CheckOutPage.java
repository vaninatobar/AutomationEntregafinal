package selenium.entregaFinal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class CheckOutPage extends BasePage {

	public CheckOutPage(WebDriver driver) {
		super(driver);
		if(!this.isLoaded()) {
			throw new IllegalStateException("This is not the CheckOut Page");
		}
	}

	@Override
	public By getPageLoaderLocator() {
		return By.xpath("//h1[contains(text(),'Checkout')]"); 
	}

	/*
	 * Step 1: Checkout Option
	 */	
	@FindBy (how = How.XPATH, using = "//*[@id='input-email']")
	private WebElement inputEmail;
	
	@FindBy (how = How.XPATH, using = "//*[@id='input-password']")
	private WebElement inputPasword;
	
	@FindBy (how = How.XPATH, using = "//*[@id='button-login']")
	private WebElement buttonLogin;

	public CheckOutPage signUpCheckOut(String email, String password) {
		inputEmail.sendKeys(email);
		inputPasword.sendKeys(password);
		buttonLogin.click();
		return PageFactory.initElements(driver,CheckOutPage.class);
	}
	
	/*
	 * Step 2: Billing Details 
	 */
	@FindBy (how = How.XPATH, using = "//*[@id='button-payment-address']")
	private WebElement buttonPaymentAddress;	
	
	public void clickPaymentAddressStep2() {
		buttonPaymentAddress.click();
	}
	
	/*
	 * Step 3: Delivery Details 
	 */
	@FindBy (how = How.XPATH, using = "//*[@id='button-shipping-address']")
	private WebElement buttonShippingAddress;	
	
	public void clickShippingAddressStep3() {
		buttonShippingAddress.click();
	}
	
	/*
	 * Step 4: Delivery Method
	 */
	@FindBy (how = How.XPATH, using = "//*[@id='button-shipping-method']")
	private WebElement buttonShippingMethod;	
	
	public void clickShippingMethodStep4() {
		buttonShippingMethod.click();
	}
		
	/*
	 * Step 5: Payment Method 
	 */
	@FindBy (how = How.CSS, using = "input[name='agree']") 
	private WebElement checkPaymentMethod;	
	
	@FindBy (how = How.XPATH, using = "//*[@id='button-payment-method']")
	private WebElement buttonPaymentMethod;	
	
	public void clickPaymentMethodStep5(){	
		
		checkPaymentMethod.click();
		buttonPaymentMethod.click();
	}
	
	/*
	 * Step 6: Confirm Order
	 */
	@FindBy (how = How.XPATH, using = "//*[@id='button-confirm']")
	private WebElement buttonConfirmOrder;	
	
	public SuccessCheckOut clickConfirmOrderStep6() {
		buttonConfirmOrder.click();
		return PageFactory.initElements(driver,SuccessCheckOut.class);
	}

	//*[@id="collapse-checkout-confirm"]/div/div[1]/table/tbody/tr/td[1]/a produc
	
	//*[@id="collapse-checkout-confirm"]/div/div[1]/table/tbody/tr/td[3] cant
	
	//*[@id="collapse-checkout-confirm"]/div/div[1]/table/tbody/tr/td[4] unit
	
	//*[@id="collapse-checkout-confirm"]/div/div[1]/table/tbody/tr/td[5] total
	//*[@id="button-confirm"]
	

}
