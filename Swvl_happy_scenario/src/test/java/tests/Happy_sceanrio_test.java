package tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import helper.jsonReader_login;
import junit.framework.Assert;
import pages.Choose_Date_time_page;
import pages.Home_page;
import pages.Login_Page;

public class Happy_sceanrio_test extends Base_Test {

	Login_Page login_obj;
	Home_page home_obj;

	Choose_Date_time_page choose_date_obj;

	@Test
	public void UserCanLogin() throws IOException, ParseException {

		jsonReader_login jsonobj = new jsonReader_login();
		jsonobj.JsonFileReader_capabilities();
		login_obj = new Login_Page(driver_test);
		login_obj.login_with_telephone_number(jsonobj.phone_number, jsonobj.password);
		boolean login_succes = login_obj.validate_login_success();

		home_obj = new Home_page(driver_test);
		boolean home = home_obj.validate_home_page_open();
		home_obj.add_pickup_destination_location();

		choose_date_obj = new Choose_Date_time_page(driver_test);
		choose_date_obj.select_date("After_Tomorrow");
		boolean booking_success = choose_date_obj.select_trip();

		Assert.assertEquals(login_succes, true);
		Assert.assertEquals(home, true);
		Assert.assertEquals(booking_success, true);
	}

}
