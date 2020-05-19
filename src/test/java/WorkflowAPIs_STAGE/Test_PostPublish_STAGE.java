package WorkflowAPIs_STAGE;

import TestBase.BaseClass;
import WorkflowAPIs.GetWorkflows;
import WorkflowAPIs.Post_SubmitPublishReject;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_PostPublish_STAGE extends BaseClass {
    public String baseUrl;
    public String basePath;
    public String url;
    public String workflowbase;
    public String workflowUrl;
    public String apikey;
    public String apisecret;

    Post_SubmitPublishReject Pub;
    GetWorkflows getwf;

    @BeforeTest
    public void setupUrl()
    {
        baseUrl=prop.getProperty("BaseURL_stage");
        basePath=prop.getProperty("PostPublishBasePath");
        workflowbase=prop.getProperty("GetWorkflowBasePath");
        apikey=prop.getProperty("Q4web_apikey_stage");
        apisecret=prop.getProperty("Q4web_apisecret_stage");
        url=baseUrl+basePath;
        workflowUrl=baseUrl+workflowbase;

        Pub=new Post_SubmitPublishReject();
        getwf=new GetWorkflows();
    }

    @Test
    public void TestResponse()
    {
        Response resp_work=getwf.GetResponse(workflowUrl,16,apikey,apisecret);
        JSONObject input=Pub.CreateBody(resp_work,"Publishing workflow");

        Response resp=Pub.GetResponse(url,input,apikey,apisecret);
        //resp.prettyPrint();
        Assert.assertEquals((int)resp.body().jsonPath().get("data.succeeded"),1);

    }


}
