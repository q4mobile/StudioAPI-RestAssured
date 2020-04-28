package WorkflowAPI;

import TestBase.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetWorkflows extends BaseClass {

    String apikey=prop.getProperty("apikey");
    String apisecret=prop.getProperty("apisecret");

    public Response GetResponse(String url)
    {

        Response resp= RestAssured.
                       given().
                            auth().preemptive().basic(apikey,apisecret).
                            header("realm",prop.getProperty("realm")).
                            param("page",1).
                            param("pageSize",5).
                            param("statusld",16).
                            param("statusld",2).
                            param("bucketld",0).
                            param("groupld",0).
                       get(url);
        //resp.prettyPrint();
        return resp;


    }



}
