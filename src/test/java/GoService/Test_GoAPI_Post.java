package GoService;

import PageManagement.GetPages;
import TestBase.BaseClass;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Test_GoAPI_Post extends BaseClass {


    PostGoAPI Go;
    public String baseUrl;
    public String basePath;
    public String url;



    @BeforeTest
    public void setupUrl()
    {
        baseUrl=prop.getProperty("GoAPIBaseUrl");
        basePath=prop.getProperty("GoAPIBasePath");
        url=baseUrl+basePath;

        Go=new PostGoAPI();

    }

    @Test
    public void TestResponse() throws IOException, ParseException {
        Response resp=Go.GetAPIResponse(url);
        resp.prettyPrint();
        Assert.assertTrue(resp.body().jsonPath().get("Success"));
    }



}
