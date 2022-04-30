package crudoperations;

import io.restassured.response.Response;
import io.restassured.*;
import org.junit.Test;

public class GetRequestMethod {
    //setting endpoint to a variable
    String getListEndpoint = "https://reqres.in/api/users?page=2";

    @Test

    public void validateGetdata(){
        //storing response
    Response r = RestAssured.get(getListEndpoint);
    //fetching status code
    System.out.println(r.getStatusCode());

    //fetch and display headers of gert method
        System.out.println("All response for headers"+ r.getHeader("Age"));
        //Fetch body content
       // System.out.println("Response"+r.asString());
        System.out.println("Response: " +r.prettyPrint());

    }

}
