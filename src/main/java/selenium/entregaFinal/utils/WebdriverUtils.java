package selenium.entregaFinal.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class WebdriverUtils {
	
	public static boolean isElementPresent(WebDriver driver, final By locator) {		
		try{
			driver.findElement(locator);
			return true;
		}catch(NoSuchElementException e) {
			return false;
		}	
	}	
}
