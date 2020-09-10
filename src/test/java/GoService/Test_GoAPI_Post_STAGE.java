package GoService;

import GetPressReleases.GetPressReleases;
import TestBase.BaseClass;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_GoAPI_Post_STAGE extends BaseClass {


    PostGoAPI Go;
    public String baseUrl;
    public String basePath;
    public String url;


    public String apikey;
    public String apisecret;
    public String xkey;
    public String FID;


    @BeforeTest
    public void setupUrl()
    {
        baseUrl=prop.getProperty("GoAPIBaseUrl_stage");
        basePath=prop.getProperty("GoAPIBasePath");
        apikey=prop.getProperty("Q4web_apikey_stage");
        apisecret=prop.getProperty("Q4web_apisecret_stage");
        xkey=prop.getProperty("GetPRAPIKey_stage");
        FID=prop.getProperty("GoAPIFilterID_stage");


        url=baseUrl+basePath;
        Go=new PostGoAPI();

    }

    @Test
    public void TestResponse() throws IOException, ParseException {
        Response resp=Go.GetAPIResponse(url,xkey,apikey,apisecret,FID);
        resp.prettyPrint();
        Assert.assertTrue(resp.body().jsonPath().get("Success"));
    }





}
