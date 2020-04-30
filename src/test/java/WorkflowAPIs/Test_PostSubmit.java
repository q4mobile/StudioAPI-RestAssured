package WorkflowAPIs;

import TestBase.BaseClass;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_PostSubmit extends BaseClass {

    public String baseUrl;
    public String basePath;
    public String url;
    Post_SubmitPublishReject Psub;

    @BeforeTest
    public void setupUrl()
    {
        baseUrl=prop.getProperty("BaseURL");
        basePath=prop.getProperty("PostSubmitBasePath");
        url=baseUrl+basePath;

        Psub=new Post_SubmitPublishReject();

    }

    @Test
    public void TestResponse()
    {
        Response resp=Psub.GetResponse(url,2,"submitting workflow");
        resp.prettyPrint();
        Assert.assertEquals((int)resp.body().jsonPath().get("data.succeeded"),1);

    }




}
