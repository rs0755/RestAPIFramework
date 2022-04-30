package requestchaining;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;

public class RequestChainingGet2Post {
    String applicationurl= "https://reqres.in/api/users?page=2";
    String email = "ruchi.singh@reqres.in";
    String first_name ="Ruchi";
    String last_name ="Singh";
    String avatar ="https://reqres.in/img/faces/8-image.jpg";

    @Test
    public void addandValidateUser(){
        //Send post requst
        //============================================================
        RequestSpecification postRequest = RestAssured.given();
        postRequest.body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}");
        postRequest.header("content-type","application/json");

        Response postResponse = postRequest.post(applicationurl + "api/users");
        System.out.println("Post Request Response:");
        System.out.println("============================================");

        //Fetch id from response using JSON Path
        String userId= postResponse.jsonPath().getString("users");

        Response getResponse = RestAssured.get(applicationurl + "api/users"+ userId);
        System.out.println(getResponse.getStatusCode());
        System.out.println(getResponse.prettyPrint());

    }
}
