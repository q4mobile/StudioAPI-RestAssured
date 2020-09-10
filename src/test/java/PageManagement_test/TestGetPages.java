package PageManagement_test;

import PageManagement.GetPages;
import TestBase.BaseClass;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class TestGetPages extends BaseClass {

    GetPages pages;
    public String baseUrl;
    public String basePath;
    public String url;
    public String apikey;
    public String apisecret;

    @BeforeTest
    public void setupUrl()
    {
        baseUrl=prop.getProperty("BaseURL");
        basePath=prop.getProperty("BasePath");
        apikey=prop.getProperty("Q4web_apikey");
        apisecret=prop.getProperty("Q4web_apisecret");
        url=baseUrl+basePath;

        pages=new GetPages();
    }
    @Test
    public void TestResponse()
    {
        Response response=pages.GetAllPages(url,apikey,apisecret);
        //response.prettyPrint();
        Assert.assertTrue(response.body().jsonPath().get("success"));

    }
    @Test
    public void TestStatusCode()
    {
        Response response=pages.GetAllPages(url,apikey,apisecret);
        Assert.assertEquals(200,response.getStatusCode());

    }

}
