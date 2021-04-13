package helper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonReader_login {
	

	 public String phone_number;
	 public String password;


public void JsonFileReader_capabilities() throws IOException, ParseException {
String filepath =System.getProperty("user.dir")+"/TestData/login_data.json";

File srcFile = new File(filepath);
JSONParser parser = new JSONParser();

JSONArray jarray =(JSONArray)parser.parse(new FileReader(srcFile));

for(Object jsonobj:jarray)
{
JSONObject credentials =(JSONObject) jsonobj;

phone_number = (String) credentials.get("phone_no");
password =(String) credentials.get("pass");




}
}

}


