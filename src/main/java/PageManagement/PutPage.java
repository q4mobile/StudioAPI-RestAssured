package PageManagement;

import TestBase.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class PutPage extends BaseClass {
     String apikey=prop.getProperty("apikey");
     String apisecret=prop.getProperty("apisecret");

     Map<String,String> payload=new HashMap<>();


     public Response EditPage(String url)
    {

        File file=new File("src/main/java/Json/page.json");
        Response resp= RestAssured.
                given().
                auth().
                preemptive().basic(apikey,apisecret).
                header("realm",prop.getProperty("realm")).
                header("Content-Type","application/json").
                body(file).
                when().
                put(url);
        resp.prettyPrint();
        return resp;
    }

}
