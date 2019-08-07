package selenium.entregaFinal.pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import selenium.entregaFinal.utils.Constants;
import selenium.entregaFinal.utils.WebdriverUtils;


public abstract class BasePage {
	
	public static WebDriver driver;
	
	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
		driver.manage().timeouts().implicitlyWait(Constants.PAGELOADTIMEOUT,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public final boolean isLoaded() {
		return WebdriverUtils.isElementPresent(BasePage.driver, this.getPageLoaderLocator());
	}
	
	public abstract By getPageLoaderLocator(); 	
	

	}
