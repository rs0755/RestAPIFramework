package postmethod;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostRequestMethodAssert {
    String postEndpoint = "https://reqres.in/api/users";

    @Test

    public void addNewUse(){
        //Pre-requisite
        RequestSpecification postRequest = RestAssured.given();
        postRequest.body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}");
        postRequest.header("content-type","application/json");

        Response postResponse = postRequest.post(postEndpoint);
        System.out.println(postResponse.statusCode());
        Assert.assertEquals(postResponse.statusCode(),201);
        System.out.println(postResponse.prettyPrint());
    }

}
