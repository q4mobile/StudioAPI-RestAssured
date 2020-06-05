package GetPressReleases;

import TestBase.BaseClass;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_GetPRReleaseswithAPIkey_STAGE extends BaseClass {


    public String baseUrl;
    public String basePath;
    public String url;
    public String apikey;
    public String xapikey;
    public String apisecret;
    GetPressReleases PR;

    @BeforeTest
    public void setupUrl()
    {
        baseUrl=prop.getProperty("BaseURL_stage");
        basePath=prop.getProperty("GetPRBasePath");
        apikey= prop.getProperty("Q4web_apikey_stage");
        apisecret=prop.getProperty("Q4web_apisecret_stage");
        xapikey=prop.getProperty("GetPRAPIKey1_stage");
        url=baseUrl+basePath;

        PR=new GetPressReleases();

    }

    @Test
    public void TestResponse()
    {
        Response resp=PR.GetResponse(url,xapikey,apikey,apisecret);
        Assert.assertTrue(resp.body().jsonPath().get("success"));

    }



}
