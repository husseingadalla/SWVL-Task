package tests;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.BeforeSuite;
import helper.JsonReader;

public class Base_Test {

	public static AppiumDriver<MobileElement> driver_test;
	DesiredCapabilities caps;
	URL url;
	public void set_desired_capabilities() throws IOException, ParseException {
		
		  JsonReader json_caps_obj = new JsonReader();
		  json_caps_obj.JsonFileReader_capabilities();
		  
		  caps=new DesiredCapabilities();
		  caps.setCapability("platformName",json_caps_obj.PLATFORM_NAME);
		  caps.setCapability("platformVersion",json_caps_obj.PLATFORMVERSION);
		  caps.setCapability("deviceName",json_caps_obj.DEVICE_NAME);
		  caps.setCapability("appPackage",json_caps_obj.APPPACKAGE);
		  caps.setCapability("appActivity",json_caps_obj.APPACTIVITY);
		  caps.setCapability("autoGrantPermissions", "true");
		  caps.setCapability("autoAcceptAlerts", "true");

	}

	@BeforeSuite
	public void startdriver() {
		try {
			set_desired_capabilities();
			url = new URL("http://127.0.0.1:4723/wd/hub");
			driver_test = new AppiumDriver<MobileElement>(url, caps);
			driver_test.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
