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
import java.nio.file.WatchEvent;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class checkboxes {
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
    public void checkboxes() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://the-internet.herokuapp.com/checkboxes"));

        WebElement lable1 = driver.findElement(By.xpath("//*[@type= 'checkbox']"));
        lable1.click();
       Assert.assertTrue(lable1.isSelected());



                  WebElement checkbox2 = driver.findElement(By.xpath("(//form/input[@type='checkbox'])[2]"));
                  checkbox2.click();
                Assert.assertFalse(checkbox2.isSelected());



    }
}

