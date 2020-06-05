package PageManagement_test;

import PageManagement.PostPage;
import TestBase.BaseClass;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestPostPage extends BaseClass {

    PostPage page;
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

        page=new PostPage();
        //System.out.println("This Is BeforeTest method");

    }

    @Test
    public void TestInternalPage()
    {
        Response response=page.CreatePage(url,"Internal","Automation_regression","null",apikey,apisecret);
        //response.prettyPrint();
        Assert.assertTrue(response.body().jsonPath().get("success"));

    }
    @Test
    public void TestExternalPage()
    {

        Response response=page.CreatePage(url,"External","Automation_regression",pageprop.getProperty("ExternalLink"),apikey,apisecret);
        //response.prettyPrint();
        Assert.assertTrue(response.body().jsonPath().get("success"));

    }
    @Test
    public void TestExternalLink()
    {

        Response response=page.CreatePage(url,"External","Automation_regression",pageprop.getProperty("InternalLink"),apikey,apisecret);
        //response.prettyPrint();
        Assert.assertTrue(response.body().jsonPath().get("success"));

    }
}
