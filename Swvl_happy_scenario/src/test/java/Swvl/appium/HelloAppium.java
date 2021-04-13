package Swvl.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;

public class HelloAppium {
	
	@Test
	
	public void openApplication() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName","Android");
		caps.setCapability("platformVersion","11");
		caps.setCapability("deviceName","sdk_gphone_x86");
		caps.setCapability("appPackage","io.swvl.customer");
		caps.setCapability("appActivity", "io.swvl.customer.features.LaunchScreenActivity");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		 WebElement x = driver.findElementById("io.swvl.customer:id/hint");
		 
		 x.click();
		 
	}
	

}
