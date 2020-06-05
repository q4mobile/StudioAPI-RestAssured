package PageManagement;

import TestBase.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class PutPage extends BaseClass {


     //Map<String,String> payload=new HashMap<>();


     public Response EditPage(String url,String apikey,String apisecret,String filepath)
    {

        File file=new File(filepath);
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
