package HomeWork;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
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

import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.WatchEvent;
import java.sql.Driver;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class dynamicContent {
    WebDriver driver;

    @AfterMethod
    void cleanUp() {

    }

    @BeforeMethod
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void dynamicContent() {
        driver.get("https://the-internet.herokuapp.com/dynamic_content?with_content=static");


        WebElement profile3 = driver.findElement(By.xpath("//div[@class='large-10 columns']"));
        Assert.assertEquals(profile3.getText(), "\n" +
                "            Eaque vel qui beatae id aut provident nulla est doloribus omnis molestiae optio corporis est sint esse dolor ipsum recusandae quae mollitia aut similique maxime quidem laudantium reprehenderit quam ratione.\n" +
                "          ");

        WebElement clickHere = driver.findElement(By.xpath("//*[@id='content']/div/p[2]/a"));
        clickHere.click();
        Assert.assertNotEquals(profile3.getText(), "\n" +
                "            Eaque vel qui beatae id aut provident nulla est doloribus omnis molestiae optio corporis est sint esse dolor ipsum recusandae quae mollitia aut similique maxime quidem laudantium reprehenderit quam ratione.\n" +
                "          ");

    }
    }

