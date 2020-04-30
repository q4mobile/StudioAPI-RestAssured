package WorkflowAPIs;

import TestBase.BaseClass;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_PostReject extends BaseClass {

    public String baseUrl;
    public String basePath;
    public String url;
    Post_SubmitPublishReject reject;

    @BeforeTest
    public void setupUrl()
    {
        baseUrl=prop.getProperty("BaseURL");
        basePath=prop.getProperty("PostRejectBasePath");
        url=baseUrl+basePath;

        reject=new Post_SubmitPublishReject();

    }

    @Test
    public void TestResponse()
    {
        Response resp=reject.GetResponse(url,16,"Rejecting workflow");
        resp.prettyPrint();
        Assert.assertEquals((int)resp.body().jsonPath().get("data.succeeded"),1);

    }




}
