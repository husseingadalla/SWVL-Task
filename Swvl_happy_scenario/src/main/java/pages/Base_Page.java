package pages;




import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;



public class Base_Page {

	protected AppiumDriver<MobileElement> driver_page;
	protected WebDriverWait driver_wait_page;
	
	public Base_Page(AppiumDriver<MobileElement> driver_) {
		this.driver_page=driver_;
		
	}	

}



