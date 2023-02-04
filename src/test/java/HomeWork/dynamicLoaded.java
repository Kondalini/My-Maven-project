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
public class dynamicLoaded {

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
    public void dynamicLoaded() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        WebElement exampel1 = driver.findElement(By.linkText("Example 1: Element on page that is hidden"));
        exampel1.click();
        WebElement startButton  = driver.findElement(By.xpath("//*[@id='start']/button"));
        startButton.click();
        WebElement loadingBar = driver.findElement(By.id("loading"));
        Wait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loadingBar));
        wait.until(ExpectedConditions.invisibilityOf(loadingBar));

        WebElement hello = driver.findElement(By.xpath("//*[@id='finish']/h4"));
        Assert.assertTrue(hello.isDisplayed());
        Assert.assertEquals(hello.getText(), "Hello World!");



    }
}
