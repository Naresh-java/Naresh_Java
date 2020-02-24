package restassured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class RestAssuredExam {
	@Test(priority = 1,enabled = true)
	public void testResponseCode() {
		//Response response = RestAssured.get("http://ergast.com/api/f1/drivers.json");
		int stCode = get("http://localhost:3000/posts").getStatusCode();
		System.out.println("Status Code : " + stCode);
		Assert.assertEquals(stCode, 200);
	}
	@Test(priority = 2,enabled = true)
	public void testBody() {
		//Response response = RestAssured.get("http://ergast.com/api/f1/drivers.json");
		String body = get("http://localhost:3000/posts").asString();
		System.out.println("Response Body : "+body);
		//System.out.println("Response Time : "+get("http://ergast.com/api/f1/drivers").getTime());
	}
	@Test(priority = 3,enabled = false)
	public void testPost() {
		  RequestSpecification request = given();
		  request.header("Content-Type","application/json");
		  JSONObject json = new JSONObject();
		  json.put("id", "11");
		  json.put("title", "Naresh");
		  json.put("author", "Naresh");
		  request.body(json.toString());
		  Response response =request.post("http://localhost:3000/posts");
		  Assert.assertEquals(response.getStatusCode(), 201);
	}
	@Test(priority = 4,enabled = false)
	public void testDelete() {
		RequestSpecification request = given();
		Response response =request.delete("http://localhost:3000/posts/11");
		  Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	@Test(priority = 5,enabled = false)
	public void testPut() {
		 RequestSpecification request = given();
		  request.header("Content-Type","application/json");
		  JSONObject json = new JSONObject();
		  json.put("id", "11");
		  json.put("title", "Naresh-Json");
		  json.put("author", "Naresh - Json");
		  request.body(json.toString());
		  Response response =request.put("http://localhost:3000/posts/11");
		  Assert.assertEquals(response.getStatusCode(), 200);
	}

}
