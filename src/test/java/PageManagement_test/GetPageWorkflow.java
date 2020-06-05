package PageManagement_test;

import PageManagement.GetPages;
import TestBase.BaseClass;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class GetPageWorkflow extends BaseClass {

    GetPages pages;
    public String baseUrl;
    public String basePath;
    public String url;
    public String workflowid;
    public String apikey;
    public String apisecret;
   // Map<String,String> respdata;

    @BeforeTest
    public void setupUrl()
    {
        baseUrl=prop.getProperty("BaseURL");
        basePath=prop.getProperty("BasePath");
        apikey=prop.getProperty("Q4web_apikey");
        apisecret=prop.getProperty("Q4web_apisecret");
        workflowid=prop.getProperty("workflowid_test");
        url=baseUrl+basePath+"/"+workflowid;

        pages=new GetPages();
        //respdata=new HashMap<>();


    }
    @Test()
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
    /*@Test(dependsOnMethods = "TestResponse")
    public void TestEditUrl()
    {

        respdata=pages.ParseResponse(url);
        String PgTitleAPI=respdata.get("title");

        String PgTitleUI=pages.VerifyEditUrl(url);
        Assert.assertEquals(PgTitleAPI,PgTitleUI);


    }*/

}
