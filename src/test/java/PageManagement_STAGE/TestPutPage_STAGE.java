package PageManagement_STAGE;

import PageManagement.GetPages;
import PageManagement.PutPage;
import TestBase.BaseClass;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestPutPage_STAGE extends BaseClass {

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
        baseUrl=prop.getProperty("BaseURL_stage");
        basePath=prop.getProperty("BasePath");
        filepath=prop.getProperty("pagefilepath_stage");
        workflowid=prop.getProperty("workflowid_stage");
        apikey=prop.getProperty("Q4web_apikey_stage");
        apisecret=prop.getProperty("Q4web_apisecret_stage");
        url=baseUrl+basePath+"/"+workflowid;

        Newpage=new GetPages();
        pp=new PutPage();

        //System.out.println("This Is BeforeTest method");

    }

    @Test
    public void TestChangePgTitle() throws IOException, ParseException {
        Response resp=pp.EditPage(url,apikey,apisecret,filepath);
        Assert.assertTrue(resp.body().jsonPath().get("success"));

    }

}
