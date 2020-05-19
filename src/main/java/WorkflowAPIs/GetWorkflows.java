package WorkflowAPIs;

import TestBase.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetWorkflows extends BaseClass {


    public Response GetResponse(String url,int SID,String apikey,String apisecret)
    {

        Response resp= RestAssured.
                       given().
                            auth().preemptive().basic(apikey,apisecret).
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
