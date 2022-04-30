package putMethodRequest;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class PutRequestMethodAssert {
    @Test

    public void updateNewUse(){
        String putEndpoint = "https://reqres.in/api/users/2";
        //Pre-requisites
        RequestSpecification putRequestSpecification = RestAssured.given();
        putRequestSpecification.body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}");
        putRequestSpecification.header("content-type","application/json");
        //Configuration
        Response putResponse = putRequestSpecification.put(putEndpoint);
        System.out.println(putResponse.statusCode());
        //Assertion
        Assert.assertEquals(putResponse.statusCode(),200);
        System.out.println(putResponse.prettyPrint());

    }


}
