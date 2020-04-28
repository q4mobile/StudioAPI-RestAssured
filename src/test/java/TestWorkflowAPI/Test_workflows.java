package TestWorkflowAPI;

import GoService.PostGoAPI;
import TestBase.BaseClass;
import WorkflowAPI.GetWorkflows;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_workflows extends BaseClass {


    public String baseUrl;
    public String basePath;
    public String url;
    GetWorkflows Getwflow;

    @BeforeTest
    public void setupUrl()
    {
        baseUrl=prop.getProperty("BaseURL");
        basePath=prop.getProperty("GetWorkflowBasePath");
        url=baseUrl+basePath;

        Getwflow=new GetWorkflows();

    }

    @Test
    public void TestResponse()
    {
        Response resp=Getwflow.GetResponse(url);
        Assert.assertTrue(resp.body().jsonPath().get("success"));

    }

}