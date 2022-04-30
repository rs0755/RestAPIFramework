package crudoperations;


import io.restassured.response.Response;
import io.restassured.*;
import org.junit.Test;
import org.testng.Assert;

import static io.netty.util.internal.SystemPropertyUtil.contains;

public class GetRequestMethodAssert {
    //setting endpoint to a variable
    String getListEndpoint = "https://reqres.in/api/users?page=2";

    @Test

    public void validateGetdata() {
        //storing response
        Response r = RestAssured.get(getListEndpoint);
        //fetching status code
        System.out.println(r.getStatusCode());
        //Assert the response
        Assert.assertEquals(r.getStatusCode(), 200);
        //fetch and display headers of gert method
        System.out.println("All response for headers" + r.getHeaders());
        //Assert header in response
        Assert.assertEquals(r.getHeader("Server"),"cloudflare");
        //Fetch body content
       // System.out.println("Response"+r.asString());
        System.out.println("Response: " + r.prettyPrint());
       // Assert.assertTrue(r.asString().contains("email"));
       //Assert.assertEquals(r.jsonPath().getString("data.first_name"),"Michael");

    }
}
