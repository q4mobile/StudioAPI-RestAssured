package WorkflowAPIs;

import TestBase.BaseClass;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_PostPublish extends BaseClass {
    public String baseUrl;
    public String basePath;
    public String url;
    Post_SubmitPublishReject Pub;

    @BeforeTest
    public void setupUrl()
    {
        baseUrl=prop.getProperty("BaseURL");
        basePath=prop.getProperty("PostPublishBasePath");
        url=baseUrl+basePath;

        Pub=new Post_SubmitPublishReject();

    }

    @Test
    public void TestResponse()
    {
        Response resp=Pub.GetResponse(url,16,"Publishing workflow");
        resp.prettyPrint();
        Assert.assertEquals((int)resp.body().jsonPath().get("data.succeeded"),1);

    }


}
