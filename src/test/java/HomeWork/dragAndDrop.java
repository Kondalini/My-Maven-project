package HomeWork;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
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




    public class dragAndDrop {
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
            //not working
        void dragAndDrop() {
            driver.get("http://the-internet.herokuapp.com/drag_and_drop");

            WebElement divA = driver.findElement(By.id("column-a"));
            WebElement divB = driver.findElement(By.id("column-b"));

            Actions builder = new Actions(driver);
            builder.dragAndDrop(divA, divB).perform();
            Action dragAndDrop = builder.clickAndHold(divA).moveToElement(divA).moveToElement(divB).release(divB).build();
            dragAndDrop.perform();

        }
    }