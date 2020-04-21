package TestBase;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    public Properties prop;
    public Properties pageprop;


    public BaseClass() {


        FileInputStream ip;
        FileInputStream ip1;
        try {
            prop=new Properties();
            pageprop=new Properties();
            //=new Properties();
            File file=new File("src/main/java/Properties/config.properties");
            ip = new FileInputStream(file);

            File file1= new File("src/main/java/Properties/PageConfig.properties");
            ip1=new FileInputStream(file1);

            prop.load(ip);
            pageprop.load(ip1);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }




}
