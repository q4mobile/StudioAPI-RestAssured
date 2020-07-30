package PageManagement;

import TestBase.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PutPage extends BaseClass {


     //Map<String,String> payload=new HashMap<>();
    public void setJson(String filepath) throws IOException, ParseException {
        Random r = new Random();
        int num = 10 + (int) (r.nextFloat() * 90);

        // int num= (int) Math.random();
        String name="AutomationPage"+num;
        System.out.println("name is--"+name);

        Reader reader = new FileReader(filepath);
        JSONParser jsonParser = new JSONParser();
        JSONObject data = (JSONObject) jsonParser.parse(reader);
        data.put("Title",name);
        FileWriter file1 = new FileWriter(filepath);
        file1.write(data.toString());
        file1.flush();

    }


     public Response EditPage(String url,String apikey,String apisecret,String filepath) throws IOException, ParseException {

         setJson(filepath);
         File file=new File(filepath);
         Response resp= RestAssured.
                given().
                auth().
                preemptive().basic(apikey,apisecret).
                header("realm",prop.getProperty("realm")).
                header("Content-Type","application/json").
                body(file).
                when().
                put(url);
        resp.prettyPrint();


        return resp;
    }

}
