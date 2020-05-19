package WorkflowAPIs;

import TestBase.BaseClass;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Post_SubmitPublishReject extends BaseClass {

    GetWorkflows workflow;

    public JSONObject CreateBody(Response resp,String comment)
    {


        String workflowid=resp.body().jsonPath().get("data[0].workflowId");
        System.out.println("workflowid is -->"+workflowid);


        JSONObject jo = new JSONObject();
        jo.put("workflowId", workflowid);
        jo.put("languageId", "1");

        JSONArray jarr = new JSONArray();
        jarr.add(jo);

        JSONArray jarr1= new JSONArray();
        jarr1.add(jarr);

        JSONObject mainObj = new JSONObject();
        mainObj.put("comment", comment);
        mainObj.put("workflows", jarr);

        //System.out.println(mainObj);

        return mainObj;
    }
    public Response GetResponse(String url,JSONObject body,String apikey,String apisecret)
    {


        Response resp= RestAssured.
                given().
                    auth().preemptive().basic(apikey,apisecret).
                    header("realm",prop.getProperty("realm")).
                    header("Content-Type","application/json").
                    body(body.toString()).
                when().
                    post(url);
        resp.prettyPrint();
        return resp;


    }


}
