package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;

public class Generic_methods {
	
	public static void explicit_wait_for_seconds_visibility(WebDriver driver,WebDriverWait wait_driver,int sec,WebElement element) {
		
		wait_driver = new WebDriverWait(driver, sec);
		wait_driver.until(ExpectedConditions.visibilityOf(element));
		//wait_driver.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element));
		wait_driver.until(ExpectedConditions.elementToBeClickable(element));
		}
	
public static void explicit_wait_for_seconds_element_clickable(WebDriver driver,WebDriverWait wait_driver,int sec,WebElement element) {
		
		wait_driver = new WebDriverWait(driver, sec);
		wait_driver.until(ExpectedConditions.elementToBeClickable(element));
		}

public static void explicit_wait_element_stale(WebDriver driver,WebDriverWait wait_driver,int sec,WebElement element) {
	
	wait_driver = new WebDriverWait(driver, sec);
	wait_driver.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));
	}


	
	public static boolean stale_element_handler_click(MobileElement element) {
		
		boolean result = false;
	    int attempts = 0;
	    while(attempts < 10) {
	        try {
	            element.click();
	            result = true;
	            break;
	        } 
	        catch(org.openqa.selenium.StaleElementReferenceException e) {
	        	attempts++;
	        }
	       
	    }
	    return result;
	}
	
public static void explicit_wait_for_seconds_invisibility(WebDriver driver,WebDriverWait wait_driver,int sec,WebElement element) {
		
		wait_driver = new WebDriverWait(driver, sec);
		wait_driver.until(ExpectedConditions.invisibilityOf(element));
		
		}

public static boolean Check_element_is_present(WebElement element) {
try {
element.isDisplayed();
return true;

} catch (org.openqa.selenium.NoSuchElementException e) {

	return false;

}
}
	public static void click_element(WebElement enterYourPhone_input_field) {
		enterYourPhone_input_field.click();
	}
	
	public static void write_text_box(WebElement enterYourPhone_input_field,String text) {
		enterYourPhone_input_field.sendKeys(text);
	}
	
	public static void sleep_till_stale_element_refresh() {
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}


