package WorkflowAPIs_STAGE;

import TestBase.BaseClass;
import WorkflowAPIs.GetWorkflows;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_workflows_STAGE extends BaseClass {


    public String baseUrl;
    public String basePath;
    public String apikey;
    public String apisecret;
    public String url;
    GetWorkflows Getwflow;

    @BeforeTest
    public void setupUrl()
    {
        baseUrl=prop.getProperty("BaseURL_stage");
        basePath=prop.getProperty("GetWorkflowBasePath");
        apikey=prop.getProperty("Q4web_apikey_stage");
        apisecret=prop.getProperty("Q4web_apisecret_stage");
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
