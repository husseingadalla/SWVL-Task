package helper;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {

	public String DEVICE_NAME;
	public String PLATFORM_NAME;
	public String PLATFORMVERSION;
	public String APPPACKAGE;
	public String APPACTIVITY;

	public void JsonFileReader_capabilities() throws IOException, ParseException {
		String filepath = System.getProperty("user.dir") + "/TestData/capabilities.json";

		File srcFile = new File(filepath);
		JSONParser parser = new JSONParser();

		JSONArray jarray = (JSONArray) parser.parse(new FileReader(srcFile));

		for (Object jsonobj : jarray) {
			JSONObject capbilities = (JSONObject) jsonobj;

			DEVICE_NAME = (String) capbilities.get("DEVICE_NAME");
			PLATFORM_NAME = (String) capbilities.get("PLATFORM_NAME");
			APPPACKAGE = (String) capbilities.get("APPPACKAGE");
			APPACTIVITY = (String) capbilities.get("APPACTIVITY");

		}
	}

}