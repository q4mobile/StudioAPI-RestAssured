package GoService;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class DemoClass {

 @Test
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
    }



}
