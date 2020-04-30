package GetPressReleases;

import TestBase.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetPressReleases extends BaseClass {


    public Response GetResponse(String url)
    {

        Response resp= RestAssured.
                given().
                     auth().preemptive().basic(prop.getProperty("apikey"),prop.getProperty("apisecret")).
                     header("realm",prop.getProperty("realm")).
                     header("x-api-key",prop.getProperty("GetPRAPIKey")).
                     param("page",1).
                     param("pageSize",400).
                     param("IncludeAttachments","true").
                     param("IncludeMediaFiles","true").
                     param("profile","published").
                when().
                    get(url);
        resp.prettyPrint();
        return resp;


    }



}
