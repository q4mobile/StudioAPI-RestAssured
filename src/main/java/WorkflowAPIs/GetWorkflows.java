package WorkflowAPIs;

import TestBase.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetWorkflows extends BaseClass {


    public Response GetResponse(String url,int SID)
    {

        Response resp= RestAssured.
                       given().
                            auth().preemptive().basic(prop.getProperty("apikey"),prop.getProperty("apisecret")).
                            header("realm",prop.getProperty("realm")).
                            param("page",1).
                            param("pageSize",1).
                            param("statusId",SID).
                            param("bucketld",0).
                            param("groupld",0).
                       when().
                            get(url);
        //resp.prettyPrint();
        return resp;


    }



}
