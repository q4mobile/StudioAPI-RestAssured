package GetPressReleases;

import TestBase.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetPressReleases extends BaseClass {

    public Response GetResponse(String url,String xapikey,String apikey,String apisecret)
    {

         Response resp= RestAssured.
                given().
                     auth().preemptive().basic(apikey,apisecret).
                     header("realm",prop.getProperty("realm")).
                     header("x-api-key",xapikey).
                     header("Content-Type","application/json; charset=utf-8").
                     param("page",1).
                     param("pageSize",1).
                     param("IncludeAttachments","true").
                     param("IncludeMediaFiles","true").
                     param("profile","published").
                when().
                    get(url);
        resp.prettyPrint();
        return resp;


    }



}
