package PageManagement;

import TestBase.BaseClass;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class TestPutPage extends BaseClass {

    GetPages Newpage;
    public String baseUrl;
    public String basePath;
    public String url;
    public String workflowid;
    Map<String,String> respbody;
    PutPage pp;
    @BeforeTest
    public void setupUrl()
    {
        baseUrl=prop.getProperty("BaseURL");
        basePath=prop.getProperty("BasePath");
        workflowid=prop.getProperty("workflowid");
        url=baseUrl+basePath+"/"+workflowid;

        Newpage=new GetPages();
        pp=new PutPage();

        //System.out.println("This Is BeforeTest method");

    }

    @Test
    public void TestChangePgTitle()
    {
        Response resp=pp.EditPage(url);
        Assert.assertTrue(resp.body().jsonPath().get("success"));

    }

}
