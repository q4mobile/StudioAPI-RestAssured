package WorkflowAPIs_STAGE;

import TestBase.BaseClass;
import WorkflowAPIs.GetWorkflows;
import WorkflowAPIs.Post_SubmitPublishReject;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_PostSubmit_STAGE extends BaseClass {

    public String baseUrl;
    public String basePath;
    public String url;
    public String apikey;
    public String apisecret;
    public String workflowbase;
    public String workflowUrl;
    Post_SubmitPublishReject submit;
    GetWorkflows GetWorkflow;

    @BeforeTest
    public void setupUrl()
    {
        baseUrl=prop.getProperty("BaseURL_stage");
        basePath=prop.getProperty("PostSubmitBasePath");
        url=baseUrl+basePath;

        workflowbase=prop.getProperty("GetWorkflowBasePath");
        apikey=prop.getProperty("Q4web_apikey_stage");
        apisecret=prop.getProperty("Q4web_apisecret_stage");
        url=baseUrl+basePath;
        workflowUrl=baseUrl+workflowbase;
        GetWorkflow=new GetWorkflows();
        submit=new Post_SubmitPublishReject();


    }

    @Test
    public void TestResponse()
    {
        Response resp_work=GetWorkflow.GetResponse(workflowUrl,2,apikey,apisecret);
        JSONObject input=submit.CreateBody(resp_work,"submitting workflow");

        Response resp=submit.GetResponse(url,input,apikey,apisecret);
        //resp.prettyPrint();
        Assert.assertEquals((int)resp.body().jsonPath().get("data.succeeded"),1);

    }



}
