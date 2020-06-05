package PageManagement_test;

import PageManagement.GetPages;
import PageManagement.PutPage;
import TestBase.BaseClass;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class TestPutPage extends BaseClass {

    GetPages Newpage;
    public String baseUrl;
    public String basePath;
    public String url;
    public String workflowid;
    public String apikey;
    public String apisecret;
    public String filepath;
    //Map<String,String> respbody;
    PutPage pp;
    @BeforeTest
    public void setupUrl()
    {
        baseUrl=prop.getProperty("BaseURL");
        basePath=prop.getProperty("BasePath");
        filepath=prop.getProperty("pagefilepath_test");
        workflowid=prop.getProperty("workflowid_test");
        apikey=prop.getProperty("Q4web_apikey");
        apisecret=prop.getProperty("Q4web_apisecret");
        url=baseUrl+basePath+"/"+workflowid;

        Newpage=new GetPages();
        pp=new PutPage();

        //System.out.println("This Is BeforeTest method");

    }

    @Test
    public void TestChangePgTitle()
    {
        Response resp=pp.EditPage(url,apikey,apisecret,filepath);
        Assert.assertTrue(resp.body().jsonPath().get("success"));

    }

}
