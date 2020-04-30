package GetPressReleases;

import TestBase.BaseClass;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_GetPRReleaseswithAPIkey extends BaseClass {


    public String baseUrl;
    public String basePath;
    public String url;
    GetPressReleases PR;

    @BeforeTest
    public void setupUrl()
    {
        baseUrl=prop.getProperty("BaseURL");
        basePath=prop.getProperty("GetPRBasePath");
        url=baseUrl+basePath;

        PR=new GetPressReleases();

    }

    @Test
    public void TestResponse()
    {
        Response resp=PR.GetResponse(url);
        Assert.assertTrue(resp.body().jsonPath().get("success"));

    }



}
