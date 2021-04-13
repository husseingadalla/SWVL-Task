package pages;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Choose_Date_time_page extends Base_Page {

	public Choose_Date_time_page(AppiumDriver<MobileElement> driver_) {
		super(driver_);
		this.driver_page =driver_;
	}

	MobileElement selected_date;
	String selected_date_locator = "(//*[@resource-id='io.swvl.customer:id/date_btn'])";
	
	MobileElement selected_trip;
	String selected_trip_locator ="(//*[@resource-id='io.swvl.customer:id/fixed_trip_view'])";
	
	MobileElement Book_btn;
	String book_btn_locator="io.swvl.customer:id/book_tv";
	
	MobileElement success_booking_msg;
	String success_booking_msg_locator ="//*[contains(@text,'Trip Successfully')]";
	
	
	public void select_date(String week_day) {
		int day_index=0;
		if (week_day.equals("Today")) {
			day_index=1;
		}
		else if (week_day.equals("Tomorrow")) {
			
			day_index =2;
		}
		else if (week_day.equals("After_Tomorrow")) {
			day_index=3;
		}
		
		selected_date=driver_page.findElementByXPath(selected_date_locator+"["+day_index+"]");
		Generic_methods.explicit_wait_for_seconds_visibility(driver_page, driver_wait_page, 10, selected_date);
		Generic_methods.click_element(selected_date);
		driver_page.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	
	public boolean select_trip() {
		
		int trip_index=1;
		boolean fully_booked_flag =true;
		boolean booking_success =false;
		while (fully_booked_flag==true) {
			selected_trip = driver_page.findElementByXPath(selected_trip_locator+"["+trip_index+"]");
			Generic_methods.explicit_wait_for_seconds_visibility(driver_page, driver_wait_page, 10, selected_trip);
			try {
				Generic_methods.click_element(selected_trip);
				Book_btn=driver_page.findElementById(book_btn_locator);
				Generic_methods.explicit_wait_for_seconds_visibility(driver_page, driver_wait_page, 10, Book_btn);
				Generic_methods.click_element(Book_btn);
				
				success_booking_msg=driver_page.findElementByXPath(success_booking_msg_locator);
				Generic_methods.explicit_wait_for_seconds_visibility(driver_page, driver_wait_page, 10, success_booking_msg);
				Generic_methods.click_element(success_booking_msg);
				booking_success=true;
				fully_booked_flag=false;
				
				
			} catch (org.openqa.selenium.TimeoutException e) {
				trip_index++;
				fully_booked_flag=true;
			}
		
		}
		return booking_success;
	}
	
}
