package PageManagement;

import TestBase.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;



import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PostPage extends BaseClass {
     String apikey=prop.getProperty("apikey");
     String apisecret=prop.getProperty("apisecret");

     public static Map<String,String> page=page=new HashMap<>();


     public Response CreatePage(String url,String PageType,String bucket,String exturl)
    {


        page.put("seoName",pageprop.getProperty("seoName")+System.currentTimeMillis());
        page.put("PageTitle", pageprop.getProperty("PageTitle"));
        page.put("seoPath", pageprop.getProperty("seoPath"));
        page.put("Title", pageprop.getProperty("Title"));
        page.put("layoutDefinitionWorkflowId", pageprop.getProperty("layoutDefinitionWorkflowId"));
        page.put("openInNewWindow", "true");
        page.put("hasContent","true");
        page.put("showInNav","true");
        page.put("navLevel","1");
        page.put("openInNewWindow","true");
        page.put("parentWorkflowId", pageprop.getProperty("parentWorkflowId"));
        page.put("pageType", PageType);
        page.put("ExternalUrl", exturl);
        page.put("languageId", "1");
        page.put("active", "true");
        page.put("bucket", bucket);
        Response resp= RestAssured.
                      given().
                          auth().
                          preemptive().basic(apikey,apisecret).
                          header("realm",prop.getProperty("realm")).
                          header("Content-Type","application/json").
                          body(page).
                      when().
                           post(url);

       resp.prettyPrint();
       return resp;


    }


}
