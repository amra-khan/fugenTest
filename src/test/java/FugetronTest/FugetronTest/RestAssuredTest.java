package FugetronTest.FugetronTest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class RestAssuredTest {
    String baseUrl1 = "https://reqres.in/api/users/2";
    String baseUrl2= "https://reqres.in/api/users";

    
    @Test
    public void getRequest() {
    
       Response response = RestAssured.get(baseUrl1);
       Assert.assertEquals(response.statusCode(), 200);
    
    
    }
    
    @Test
    public void postRequest() {
    	RequestSpecification request = RestAssured.given();
       
       
       JSONObject requestParam = new JSONObject(); 
       requestParam.put("name", "Amra");
       requestParam.put("job", "tester");
       
   	   request.body(requestParam.toJSONString());

       Response response = request.post(baseUrl2);
       Assert.assertEquals(response.statusCode(), 201);

    
    }
    


}
