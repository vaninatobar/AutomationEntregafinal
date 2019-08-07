package selenium.entregaFinal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage extends BasePage {
	
	public RegisterPage(WebDriver driver) {
		super(driver);
		if(!this.isLoaded()) {
			throw new IllegalStateException("This is not the Register Page");
		}
	}

	@Override
	public By getPageLoaderLocator() {
		return By.xpath("//h1[contains(text(),'Register Account')]");
	}
	
	@FindBy (how = How.XPATH, using = "//*[@id='input-firstname']")
	private WebElement inputFirstName;
	
	@FindBy (how = How.XPATH, using = "//*[@id='input-lastname']")
	private WebElement inputLastName;
	
	@FindBy (how = How.XPATH, using = "//*[@id='input-email']")
	private WebElement inputEmail;
	
	@FindBy (how = How.XPATH, using = "//*[@id='input-telephone']")
	private WebElement inputTelephone;
	
	@FindBy (how = How.XPATH, using = "//*[@id='input-fax']")
	private WebElement inputFax;
	
	@FindBy (how = How.XPATH, using = "//*[@id='input-company']")
	private WebElement inputCompany;
	
	@FindBy (how = How.XPATH, using = "//*[@id='input-address-1']")
	private WebElement inputAddress1;
	
	@FindBy (how = How.XPATH, using = "//*[@id='input-address-2']")
	private WebElement inputAddress2;
	
	@FindBy (how = How.XPATH, using = "//*[@id='input-city']")
	private WebElement inputCity;
	
	@FindBy (how = How.XPATH, using = "//*[@id='input-postcode']")
	private WebElement inputPostCode;
		
	@FindBy (how = How.CSS, using = "#input-country")
	private WebElement selRegion;
		
	@FindBy (how = How.XPATH, using = "//*[@id='input-zone']")
	private WebElement selState;
	
	@FindBy (how = How.XPATH, using = "//*[@id='input-password']")
	private WebElement inputPassword;
	
	@FindBy (how = How.XPATH, using = "//*[@id='input-confirm']")
	private WebElement inputPasswordConfirm;
	
	@FindBy (how = How.CSS, using = "input[name='agree']")
	private WebElement checkAgree;

	@FindBy (how = How.CSS, using = "input[type='submit']")
	private WebElement buttonSubmit;
	
	@FindBy (how = How.CSS, using = "body > div:nth-child(4) > div.alert.alert-danger")
	private WebElement alertMessage;

	public void selectState(String zone) {
		driver.findElement(By.xpath("//*[@id='input-zone']/option[contains(.,'" + zone + "')]")).click();				
	}

	/*
	 *  Fill Form: Personal Details
	 */
	public void fillFormPersonalDetails(String name, String lastname, String email, String tel, String fax) {
		inputFirstName.sendKeys(name);
		inputLastName.sendKeys(lastname);		
		inputEmail.sendKeys(email);;
		inputTelephone.sendKeys(tel);;
		inputFax.sendKeys(fax);
	}
	
	/*
	 *  Fill Form: Address
	 */
	public void fillFormAddress(String company, String address1, String address2, String city, String postCode) {
		inputCompany.sendKeys(company);
		inputAddress1.sendKeys(address1);
		inputAddress2.sendKeys(address2);
		inputCity.sendKeys(city);
		inputPostCode.sendKeys(postCode);				
	}
	
	/*
	 *  Fill Form: Address (Country)
	 */
	public void fillFormAddressCountry(String codeRegion) {
		selRegion.click();
		selRegion.sendKeys(codeRegion);
	}
	
	/*
	 *  Fill Form: Address (Region / State)
	 */
	public void fillFormAddressState(String codeState) {
		selState.click();
		selectState(codeState);
	}

	/*
	 *  Fill Form: Password
	 */
	public void fillFormPassword(String password, String passwordConfirm) {
		inputPassword.sendKeys(password);
		inputPasswordConfirm.sendKeys(passwordConfirm);		
	}
	
	/*
	 * Fill Form: Confirm
	 */
	public void clickConfirm() {
		checkAgree.click();
		buttonSubmit.click();		
	}
		
	public WebElement getAlertMessage() {
		return alertMessage;
	}	
		
}
