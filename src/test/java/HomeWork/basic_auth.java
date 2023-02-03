package HomeWork;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class basic_auth {

    WebDriver driver;

    @AfterMethod
    void cleanUp() {
        driver.quit();
    }




    @BeforeMethod
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public <user> void basicAuth() {
        driver.get("https://the-internet.herokuapp.com/basic_auth");

          final String user = "admin" ;
          final String password = "admin";




        WebElement text = driver.findElement(By.xpath("//p[contains(text(), 'Congratulations!')]"));
        Assert.assertEquals(text.getText(), "Congratulations! You must have the proper credentials.");
    }
}