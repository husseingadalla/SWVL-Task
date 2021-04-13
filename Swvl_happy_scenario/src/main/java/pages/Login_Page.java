package pages;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Login_Page extends Base_Page {

	public Login_Page(AppiumDriver<MobileElement> driver_) {
		super(driver_);
		this.driver_page = driver_;
	}

	MobileElement EnterYourPhone_input_field;
	String EnterYourphone_input_field_locator = "io.swvl.customer:id/hint";

	MobileElement dismiss_suggested_phone_number;
	String dismiss_suggested_phone_number_locator = "com.google.android.gms:id/cancel";

	MobileElement country_select_dropdown;
	String country_selsct_dropdown_locator = "io.swvl.customer:id/arrow_image_view";

	MobileElement Search_country_input;
	String search_country_input_locator = "io.swvl.customer:id/search_et";

	MobileElement select_country;
	String select_country_locator = "io.swvl.customer:id/country_name_text_view";

	MobileElement phone_edit_text_box;
	String phone_edit_text_box_locator = "io.swvl.customer:id/phone_edit_text";

	MobileElement next_btn;
	String next_btn_locator = "io.swvl.customer:id/next_btn";

	MobileElement password_txt_box;
	String password_txt_box_locator = "io.swvl.customer:id/password_edit_text";

	public void login_with_telephone_number(String phone_no, String password) {
		driver_page.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		EnterYourPhone_input_field = driver_page.findElementById(EnterYourphone_input_field_locator);
		Generic_methods.click_element(EnterYourPhone_input_field);

		driver_page.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		dismiss_suggested_phone_number = driver_page.findElementById(dismiss_suggested_phone_number_locator);
		Generic_methods.click_element(dismiss_suggested_phone_number);

		driver_page.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		country_select_dropdown = driver_page.findElementById(country_selsct_dropdown_locator);
		Generic_methods.click_element(country_select_dropdown);

		driver_page.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Search_country_input = driver_page.findElementById(search_country_input_locator);
		Generic_methods.click_element(Search_country_input);
		Generic_methods.write_text_box(Search_country_input, "Egypt");

		driver_page.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		select_country = driver_page.findElementById(select_country_locator);
		Generic_methods.click_element(select_country);

		driver_page.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		phone_edit_text_box = driver_page.findElementById(phone_edit_text_box_locator);
		Generic_methods.click_element(phone_edit_text_box);
		Generic_methods.write_text_box(phone_edit_text_box, phone_no);

		driver_page.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		next_btn = driver_page.findElementById(next_btn_locator);
		Generic_methods.click_element(next_btn);

		driver_page.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		password_txt_box = driver_page.findElementById(password_txt_box_locator);
		Generic_methods.click_element(password_txt_box);
		Generic_methods.write_text_box(password_txt_box, password);
		Generic_methods.click_element(next_btn);

	}

	public boolean validate_login_success() {

		Generic_methods.explicit_wait_for_seconds_invisibility(driver_page, driver_wait_page, 30, password_txt_box);
		Home_page homeobj = new Home_page(driver_page);
		boolean result = homeobj.validate_home_page_open();
		return result;
	}

}
