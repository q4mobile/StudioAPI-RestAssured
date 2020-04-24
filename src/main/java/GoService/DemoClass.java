package GoService;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;

public class DemoClass {

 /*@Test
    public void Demo()
 {
     JSONObject jo = new JSONObject();
     jo.put("workflowId", "339572b4-cec7-48e8-8c6e-6cfa43960342");
     jo.put("languageId", "1");

     JSONArray ja = new JSONArray();
     ja.add(jo);

     JSONArray ja1= new JSONArray();
     ja1.add(ja);

     JSONObject mainObj = new JSONObject();
     mainObj.put("comment","Submitting workflow");
     mainObj.put("workflows", ja);


     System.out.println("Total output is"+mainObj);

 }

    @Test
    public void Demo1()
    {
        //long time= System.currentTimeMillis();
        System.out.println("Current time is"+System.currentTimeMillis());
    }*/

    @Test
    public void Demo2() throws IOException {
        //long time= System.currentTimeMillis();
        JSONObject obj = new JSONObject();
        obj.put("OrganizationId","10F52933-D90E-40D4-9DF2-C0DC2F30F870");
        obj.put("FilterId","33e44f4c-0f6d-4e3e-b281-d066e8e1d3e2");

        FileWriter file = new FileWriter("src/main/java/GoService/Go.json");
        //File Writer creates a file in write mode at the given location
        file.write(obj.toJSONString());

    }

}
