package PageManagement;

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

    @BeforeTest
    public void setupUrl()
    {
        baseUrl=prop.getProperty("BaseURL");
        basePath=prop.getProperty("BasePath");
        url=baseUrl+basePath;

        page=new PostPage();
        //System.out.println("This Is BeforeTest method");

    }

    @Test
    public void TestInternalPage()
    {
        Response response=page.CreatePage(url,"Internal","null","null");
        //response.prettyPrint();
        Assert.assertTrue(response.body().jsonPath().get("success"));

    }
    @Test
    public void TestExternalPage()
    {

        Response response=page.CreatePage(url,"External","null",pageprop.getProperty("ExternalLink"));
        //response.prettyPrint();
        Assert.assertTrue(response.body().jsonPath().get("success"));

    }
    @Test
    public void TestExternalLink()
    {

        Response response=page.CreatePage(url,"External","null",pageprop.getProperty("InternalLink"));
        //response.prettyPrint();
        Assert.assertTrue(response.body().jsonPath().get("success"));

    }
}
