package json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class JSON_Test {

	@Test
	public static void readDataFromJSONFile() {
		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
		String filePath = "D:\\JavaPractice\\Maven_Framework\\src\\json\\test.json";
		try (FileReader reader = new FileReader(filePath)) {
			// Read JSON file
			Object obj = jsonParser.parse(reader);
			JSONObject jobj = (JSONObject) obj;
			JSONObject stu = (JSONObject) jobj.get("naresh");
			System.out.println(stu.toJSONString());

			String stuName = (String) stu.get("firstName");
			System.out.println(stuName);
			String stuLName = (String) stu.get("lastName");
			System.out.println(stuLName);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassCastException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (ParseException e) {

		}
	}
	@Test
	public void writeDataIntoJSON() {
		JSONObject naresh = new JSONObject();
		naresh.put("name", "Naresh");
		naresh.put("gender","Male");
		naresh.put("age", "26");
		
		JSONObject nareshdetails= new JSONObject();
		nareshdetails.put("naresh", naresh);
		
		JSONObject uday = new JSONObject();
		uday.put("name", "Uday");
		uday.put("gender","Male");
		uday.put("age", "26");
		JSONObject udaydetails= new JSONObject();
		nareshdetails.put("uday", uday);
		
		JSONObject reddy = new JSONObject();
		reddy.put("name", "reddy");
		reddy.put("gender","Male");
		reddy.put("age", "26");
		JSONObject reddydetails= new JSONObject();
		nareshdetails.put("reddy", reddy);
		
		JSONArray stu = new JSONArray();
		stu.add(nareshdetails);
		stu.add(udaydetails);
		stu.add(reddydetails);
		
		
		String filePath = "D:\\JavaPractice\\Maven_Framework\\src\\json\\test1.json";
		try(FileWriter file = new FileWriter(filePath)){
			file.write(stu.toString());
	
			file.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
