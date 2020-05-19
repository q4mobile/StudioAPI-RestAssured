package WorkflowAPIs_STAGE;

import TestBase.BaseClass;
import WorkflowAPIs.GetWorkflows;
import WorkflowAPIs.Post_SubmitPublishReject;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_PostReject_STAGE extends BaseClass {

    public String baseUrl;
    public String basePath;
    public String url;
    public String apikey;
    public String apisecret;
    public String workflowbase;
    public String workflowUrl;
    Post_SubmitPublishReject reject;
    GetWorkflows GetWorkflow;
    @BeforeTest
    public void setupUrl()
    {
        baseUrl=prop.getProperty("BaseURL_stage");
        basePath=prop.getProperty("PostRejectBasePath");
        workflowbase=prop.getProperty("GetWorkflowBasePath");
        apikey=prop.getProperty("Q4web_apikey_stage");
        apisecret=prop.getProperty("Q4web_apisecret_stage");
        url=baseUrl+basePath;
        workflowUrl=baseUrl+workflowbase;
        GetWorkflow=new GetWorkflows();
        reject=new Post_SubmitPublishReject();

    }

    @Test
    public void TestResponse()
    {
        Response resp_work=GetWorkflow.GetResponse(workflowUrl,16,apikey,apisecret);
        JSONObject input=reject.CreateBody(resp_work,"Rejecting workflow");

        Response resp=reject.GetResponse(url,input,apikey,apisecret);
        //resp.prettyPrint();
        Assert.assertEquals((int)resp.body().jsonPath().get("data.succeeded"),1);

    }




}
