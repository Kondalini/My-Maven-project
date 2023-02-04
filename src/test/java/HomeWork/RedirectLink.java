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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
public class RedirectLink {
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
    public void testRedirectLink() {
        driver.get("https://the-internet.herokuapp.com/redirector");

        WebElement clickHere = driver.findElement(By.id("redirect"));
        clickHere.click();

        WebElement link200 = driver.findElement(By.linkText("200"));
        link200.click();
         WebElement statusCode = driver.findElement(By.linkText("here"));

    }
}
