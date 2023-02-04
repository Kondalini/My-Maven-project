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
public class MultipleWindows {

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
    public void Multiplewindows() {
        driver.get("https://the-internet.herokuapp.com/windows");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://the-internet.herokuapp.com/windows");
        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();

        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        String secondWindowsName = windows.get(1);
        driver.switchTo().window(secondWindowsName);
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://the-internet.herokuapp.com/windows/new");

        String firstWindow = windows.get(0);
        driver.switchTo().window(firstWindow);

        WebElement openingNewWindowText = driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]"));
        Assert.assertTrue(openingNewWindowText.isDisplayed());

        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,"https://the-internet.herokuapp.com/windows");




    }
}
