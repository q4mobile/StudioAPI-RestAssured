package PageManagement;

import TestBase.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class PageEdit extends BaseClass {

 private static final int WaitTime=60000;
 public WebDriver driver;

 @FindBy(id="txtUserName")
    WebElement username;
 @FindBy(id="txtPassword")
    WebElement password;
 @FindBy(id="btnSubmit")
    WebElement loginbutton;
 @FindBy(id="txtSectionTitle")
 WebElement titletext;

 public PageEdit(WebDriver pagedriver){
     this.driver=pagedriver;
     PageFactory.initElements(pagedriver,this);
 }

    public String GetPageTitle() {

        username.sendKeys(prop.getProperty("username"));
        password.sendKeys(prop.getProperty("pass"));
        loginbutton.click();

        driver.manage().timeouts().implicitlyWait(WaitTime, TimeUnit.MILLISECONDS);
        String PageTitle = titletext.getAttribute("value");

        driver.close();
        return PageTitle;
    }
}
