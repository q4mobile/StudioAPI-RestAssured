package WorkflowAPIs;

import TestBase.BaseClass;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_workflows extends BaseClass {


    public String baseUrl;
    public String basePath;
    public String url;
    public String apikey;
    public String apisecret;
    GetWorkflows Getwflow;

    @BeforeTest
    public void setupUrl()
    {
        baseUrl=prop.getProperty("BaseURL");
        basePath=prop.getProperty("GetWorkflowBasePath");
        apikey=prop.getProperty("Q4web_apikey");
        apisecret=prop.getProperty("Q4web_apisecret");
        url=baseUrl+basePath;
        Getwflow=new GetWorkflows();

    }

    @Test
    public void TestResponse()
    {
        Response resp=Getwflow.GetResponse(url,2,apikey,apisecret);
        Assert.assertTrue(resp.body().jsonPath().get("success"));

    }

}
