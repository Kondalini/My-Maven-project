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
public class hovers {
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
        void hovers () {
            driver.get("http://the-internet.herokuapp.com/hovers");

            WebElement image1 = driver.findElement(By.xpath("(//div[@class='figure']/img)[1]"));
            WebElement userInfo1Div1 = driver.findElement(By.xpath("(//div[@class='figure']/div[@class='figcaption'])[1]"));
            WebElement userInfoName1 = driver.findElement(By.xpath("(//div[@class='figure']/div[@class='figcaption'])[1]/h5"));
            WebElement userInfoProfileLink1 = driver.findElement(By.xpath("(//div[@class='figure']/div[@class='figcaption'])[1]/a"));

            WebElement image2 = driver.findElement(By.xpath("(//div[@class='figure']/img)[2]"));
            WebElement userInfo1Div2 = driver.findElement(By.xpath("(//div[@class='figure']/div[@class='figcaption'])[2]"));
            WebElement userInfoName2 = driver.findElement(By.xpath("(//div[@class='figure']/div[@class='figcaption'])[2]/h5"));
            WebElement userInfoProfileLink2 = driver.findElement(By.xpath("(//div[@class='figure']/div[@class='figcaption'])[2]/a"));

            WebElement image3 = driver.findElement(By.xpath("(//div[@class='figure']/img)[3]"));
            WebElement userInfo1Div3 = driver.findElement(By.xpath("(//div[@class='figure']/div[@class='figcaption'])[3]"));
            WebElement userInfoName3 = driver.findElement(By.xpath("(//div[@class='figure']/div[@class='figcaption'])[3]/h5"));
            WebElement userInfoProfileLink3 = driver.findElement(By.xpath("(//div[@class='figure']/div[@class='figcaption'])[3]/a"));

            Assert.assertFalse(userInfo1Div1.isDisplayed());
            Assert.assertFalse(userInfo1Div2.isDisplayed());
            Assert.assertFalse(userInfo1Div3.isDisplayed());

            Actions builder = new Actions(driver);
            builder.moveToElement(image1).perform();
            Assert.assertTrue(userInfo1Div1.isDisplayed());
            Assert.assertTrue(userInfoName1.isDisplayed());
            Assert.assertTrue(userInfoProfileLink1.isDisplayed());
            Assert.assertEquals(userInfoName1.getText(), "name: user1");
            Assert.assertEquals(userInfoProfileLink1.getText(), "View profile");
            Assert.assertEquals(userInfoProfileLink1.getAttribute("href"), "http://the-internet.herokuapp.com/users/1");

            builder.moveToElement(image2).perform();
            Assert.assertTrue(userInfo1Div2.isDisplayed());
            Assert.assertTrue(userInfoName2.isDisplayed());
            Assert.assertTrue(userInfoProfileLink2.isDisplayed());
            Assert.assertEquals(userInfoName2.getText(), "name: user2");
            Assert.assertEquals(userInfoProfileLink2.getText(), "View profile");
            Assert.assertEquals(userInfoProfileLink2.getAttribute("href"), "http://the-internet.herokuapp.com/users/2");

            builder.moveToElement(image3).perform();
            Assert.assertTrue(userInfo1Div3.isDisplayed());
            Assert.assertTrue(userInfoName3.isDisplayed());
            Assert.assertTrue(userInfoProfileLink3.isDisplayed());
            Assert.assertEquals(userInfoName3.getText(), "name: user3");
            Assert.assertEquals(userInfoProfileLink3.getText(), "View profile");
            Assert.assertEquals(userInfoProfileLink3.getAttribute("href"), "http://the-internet.herokuapp.com/users/3");

        }
    }

