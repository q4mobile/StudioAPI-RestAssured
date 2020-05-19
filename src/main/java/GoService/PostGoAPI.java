package GoService;

import GetPressReleases.GetPressReleases;
import TestBase.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Random;

public class PostGoAPI  {

    public int CreateID() {

        Random r = new Random();
        int num = 10000000 + (int) (r.nextFloat() * 90000000);
        return num;
    }


    public void SetBody() throws IOException, ParseException {

        Reader reader = new FileReader("src/main/java/Json/Go.json");
        JSONParser jsonParser = new JSONParser();
        JSONObject data = (JSONObject) jsonParser.parse(reader);

        JSONObject Parent=(JSONObject) data.get("Data");
        int ID=CreateID();

        Parent.put("Id",ID);
        String headline="Test GO API for id "+ID;


        Parent.put("Headline",headline);
        String date=java.time.LocalDateTime.now().toString();
        Parent.put("Date",java.time.LocalDateTime.now().toString());
        System.out.println(Parent.toString());
        FileWriter file = new FileWriter("src/main/java/Json/Go.json");
        file.write(data.toString());
        file.flush();

        //Response resp=GetAPIResponse(url);

    }

    public Response GetAPIResponse(String url,String xkey,String apikey,String apisecret) throws IOException, ParseException {

        SetBody();

        File file = new File("src/main/java/Json/Go.json");
        Response resp = RestAssured.
                given().
                auth().
                preemptive().basic(apikey, apisecret).
                header("X-Api-Key", xkey).
                header("Content-Type", "application/json").
                body(file).
                when().
                post(url);
        resp.prettyPrint();
        return resp;
    }


}




