package GoService;

import GetPressReleases.GetPressReleases;
import TestBase.BaseClass;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_GoAPI_Post extends BaseClass {


    PostGoAPI Go;
    public String baseUrl;
    public String basePath;
    public String url;
    public String apikey;
    public String apisecret;
    public String xkey;

    @BeforeTest
    public void setupUrl()
    {
        baseUrl=prop.getProperty("GoAPIBaseUrl");
        basePath=prop.getProperty("GoAPIBasePath");

        apikey=prop.getProperty("Q4web_apikey");
        apisecret=prop.getProperty("Q4web_apisecret");
        xkey=prop.getProperty("GoAPIXKey");

        url=baseUrl+basePath;
        Go=new PostGoAPI();
    }

    @Test
    public void TestResponse() throws IOException, ParseException {
        Response resp=Go.GetAPIResponse(url,xkey,apikey,apisecret);
        resp.prettyPrint();
        Assert.assertTrue(resp.body().jsonPath().get("Success"));
    }




}
