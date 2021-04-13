package pages;

import java.util.concurrent.TimeUnit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class Home_page extends Base_Page {

	public Home_page(AppiumDriver<MobileElement> driver_) {
		super(driver_);
		this.driver_page = driver_;
	}

	MobileElement Main_menu;
	String Main_menu_locator = "io.swvl.customer:id/menu_iv";

	MobileElement where_from;
	String where_from_locator = "io.swvl.customer:id/where_from";

	MobileElement pickup_input;
	String pickup_input_locator = "io.swvl.customer:id/pickup_input";

	MobileElement where_to_input;
	String where_to_input_locator = "io.swvl.customer:id/drop_off_input";

	MobileElement suggested_location_pickup;
	String suggested_location_pickup_locator = "(//*[contains(@text,'Dokki Police Station')])[1]//parent::*";

	MobileElement suggested_location_drop_off;
	String suggested_location_drop_off_locator = "(//*[contains(@text,'Maadi Grand Mall')])[1]//parent::*";

	public boolean validate_home_page_open() {
		Main_menu = driver_page.findElementById(Main_menu_locator);
		Generic_methods.explicit_wait_for_seconds_visibility(driver_page, driver_wait_page, 30, Main_menu);
		boolean result = Generic_methods.Check_element_is_present(Main_menu);
		return result;
	}

	public void add_pickup_destination_location() {

		where_from = driver_page.findElementById(where_from_locator);
		Generic_methods.click_element(where_from);
		driver_page.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		pickup_input = driver_page.findElementById(pickup_input_locator);
		Generic_methods.write_text_box(pickup_input, "Dokki");
		driver_page.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver_page.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Generic_methods.sleep_till_stale_element_refresh();

		suggested_location_pickup = driver_page.findElementByXPath(suggested_location_pickup_locator);
		Generic_methods.click_element(pickup_input);
		Generic_methods.explicit_wait_for_seconds_visibility(driver_page, driver_wait_page, 60,
				suggested_location_pickup);
		Generic_methods.explicit_wait_for_seconds_element_clickable(driver_page, driver_wait_page, 30,
				suggested_location_pickup);
		Generic_methods.click_element(suggested_location_pickup);

		where_to_input = driver_page.findElementById(where_to_input_locator);
		Generic_methods.click_element(where_to_input);
		Generic_methods.write_text_box(where_to_input, "Maadi");
		Generic_methods.sleep_till_stale_element_refresh();

		suggested_location_drop_off = driver_page.findElementByXPath(suggested_location_drop_off_locator);
		driver_page.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Generic_methods.explicit_wait_for_seconds_visibility(driver_page, driver_wait_page, 15,
				suggested_location_drop_off);
		Generic_methods.explicit_wait_for_seconds_element_clickable(driver_page, driver_wait_page, 30,
				suggested_location_drop_off);
		Generic_methods.click_element(suggested_location_drop_off);

		driver_page.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

}
