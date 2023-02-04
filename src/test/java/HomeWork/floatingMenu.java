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
public class floatingMenu {

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
    void floatingMenu() {
        driver.get("http://the-internet.herokuapp.com/floating_menu");

        WebElement floatingMenuTitle = driver.findElement(By.xpath("//h3[contains(text(), 'Floating Menu')]"));
        Assert.assertTrue(floatingMenuTitle.isDisplayed());
        WebElement menu = driver.findElement(By.id("menu"));
        Assert.assertTrue(menu.isDisplayed());
        WebElement homeMenu = driver.findElement(By.linkText("Home"));
        Assert.assertTrue(homeMenu.isDisplayed());
        WebElement newsMenu = driver.findElement(By.linkText("News"));
        Assert.assertTrue(newsMenu.isDisplayed());
        WebElement contactMenu = driver.findElement(By.linkText("Contact"));
        Assert.assertTrue(contactMenu.isDisplayed());
        WebElement aboutMenu = driver.findElement(By.linkText("About"));
        Assert.assertTrue(aboutMenu.isDisplayed());

        //to perform Scroll on application using Selenium
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)", "");

        Assert.assertTrue(menu.isDisplayed());
        Assert.assertTrue(homeMenu.isDisplayed());
        Assert.assertTrue(newsMenu.isDisplayed());
        Assert.assertTrue(contactMenu.isDisplayed());
        Assert.assertTrue(aboutMenu.isDisplayed());

        js.executeScript("window.scrollBy(0,-1000)", "");

        Assert.assertTrue(menu.isDisplayed());
        Assert.assertTrue(homeMenu.isDisplayed());
        Assert.assertTrue(newsMenu.isDisplayed());
        Assert.assertTrue(contactMenu.isDisplayed());
        Assert.assertTrue(aboutMenu.isDisplayed());

        js.executeScript("window.scrollBy(0,-1000)", "");

        Assert.assertTrue(menu.isDisplayed());
        Assert.assertTrue(homeMenu.isDisplayed());
        Assert.assertTrue(newsMenu.isDisplayed());
        Assert.assertTrue(contactMenu.isDisplayed());
        Assert.assertTrue(aboutMenu.isDisplayed());
    }
}
