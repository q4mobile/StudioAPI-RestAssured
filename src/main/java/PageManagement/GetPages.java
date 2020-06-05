package PageManagement;

import TestBase.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.HashMap;
import java.util.Map;


public class GetPages extends BaseClass {


    public WebDriver driver;
    //public PageEdit pageedit;


    public Response GetAllPages(String url,String apikey, String apisecret)  {

        /* Method 1:
        RequestSpecBuilder builder = new RequestSpecBuilder();
        var requestSpec = builder.build();
        RequestSpecification Request = RestAssured.given().spec(requestSpec);
        /*Response response= RestAssured
                .given().
                        headers("Authorization", "Bearer Token"+"eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJFbWFpbCI6InZpYmhha0BxNHdlYnN5c3RlbXMuY29tIiwiU3ViZG9tYWluIjoic3BvdGlmeTIwMThpcG8iLCJBY3Rpb25zIjoiMjE0NzQ4MzY0NyIsImV4cCI6MTU4NDU2NDg3OS4wLCJpYXQiOjE1ODQ1NTc2NzkuMCwiaXNzIjoiaHR0cHM6Ly9zcG90aWZ5MjAxOGlwby5zMS53ZWIuZGV2LnE0aW5jLmNvbS9hZG1pbi9sb2dpbi5hc3B4IiwiYXVkIjoiaHR0cHM6Ly9zcG90aWZ5MjAxOGlwby5zdHVkaW8uZGV2LnE0aW5jLmNvbSJ9.DRm_yXhyj5imAqgyXRYImKb2cYPXVmiH-BFEpZnNF7Q")
                .when()
                .get("https://studio.web.dev.q4api.com/pages/en");
        Request.header(new Header("Authorization", "Bearer " +"eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJFbWFpbCI6InZpYmhha0BxNHdlYnN5c3RlbXMuY29tIiwiU3ViZG9tYWluIjoic3BvdGlmeTIwMThpcG8iLCJBY3Rpb25zIjoiMjE0NzQ4MzY0NyIsImV4cCI6MTU4NDU2NDg3OS4wLCJpYXQiOjE1ODQ1NTc2NzkuMCwiaXNzIjoiaHR0cHM6Ly9zcG90aWZ5MjAxOGlwby5zMS53ZWIuZGV2LnE0aW5jLmNvbS9hZG1pbi9sb2dpbi5hc3B4IiwiYXVkIjoiaHR0cHM6Ly9zcG90aWZ5MjAxOGlwby5zdHVkaW8uZGV2LnE0aW5jLmNvbSJ9.DRm_yXhyj5imAqgyXRYImKb2cYPXVmiH-BFEpZnNF7Q" ));
         Response resp=Request.get(new URI("https://studio.web.dev.q4api.com/pages/en"));*/

        //method2
        Response resp= RestAssured
                .given()
                    .auth().preemptive().basic(apikey,apisecret)
                    .header("realm",prop.getProperty("realm"))
                .when()
                    .get(url);
        resp.prettyPrint();

        return resp;

    }
   /* public String VerifyEditUrl(String url) {

        //Collecting response from API
        Response resp = GetAllPages(url);

        //Parse response to get edit url link
        String editurl = resp.body().jsonPath().getString("data.editUrl");



        // Here UI part starts
        //Setting url on browser
        pageedit=SetUrl(editurl);

        //redirecting to Login Page
        pageedit=new PageEdit(driver);

        //Page title from editurl
        String title=pageedit.GetPageTitle();
        //driver.close();
        return title;
    }
    public PageEdit SetUrl(String url){
        //Initializing wedriver
        driver=new ChromeDriver();
        driver.get(url);

        return pageedit;
    }

    public Map<String,String> ParseResponse(String url){

        Response resp = GetAllPages(url);

       Map<String,String> respbody=new HashMap<>();

       String seoName=resp.body().jsonPath().getString("data.seoName");
       respbody.put("seoName",seoName);

       String seopath=resp.body().jsonPath().getString("data.seoPath");
       respbody.put("seoPath",seopath);

       String PageTitle=resp.body().jsonPath().getString("data.pageTitle");
       respbody.put("pageTitle",PageTitle);

       String PageType=resp.body().jsonPath().getString("data.pageType");
       respbody.put("pageType",PageType);

       String layoutid=resp.body().jsonPath().getString("data.layoutDefinitionWorkflowId");
       respbody.put("layoutDefinitionWorkflowId",layoutid);

       String title=resp.body().jsonPath().getString("data.title");
       respbody.put("title",title);

       String status=resp.body().jsonPath().getString("data.status");
       respbody.put("status",status);

       String editurl=resp.body().jsonPath().getString("data.editUrl");
       respbody.put("editUrl",editurl);

       String parentworkid=resp.body().jsonPath().getString("data.parentWorkflowId");
       respbody.put("parentWorkflowId",parentworkid);
       //System.out.println(parentworkid);


       return respbody;


    }*/

}
