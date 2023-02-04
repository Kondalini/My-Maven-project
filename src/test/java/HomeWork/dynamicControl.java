package HomeWork;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
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

public class dynamicControl {
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
    public void dynamicControl() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement checkbox = driver.findElement(By.xpath("//*[@id = 'checkbox']"));
        Assert.assertTrue(checkbox.isDisplayed());

        WebElement removeButton = driver.findElement(By.xpath("//*[text() = 'Remove']"));
        removeButton.click();
        Assert.assertTrue(driver.findElement(By.id("loading")).isDisplayed());
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));
        Assert.assertFalse(checkbox.isDisplayed());
        Assert.assertEquals(driver.findElement(By.id("message")).getText(), "It's gone!");
        WebElement addBtn = driver.findElement(By.xpath("//*[text()='Add']"));
        Assert.assertTrue(addBtn.isDisplayed());
    }
}
