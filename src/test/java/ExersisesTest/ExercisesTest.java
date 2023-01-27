package ExersisesTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;

public class ExercisesTest {
    @Test
    public void testLogin() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://training.skillo-bg.com:4200/posts/all");
        WebElement login = driver.findElement(By.id("nav-link-login"));
        login.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4200/users/login"));
        //String expectedLoginUrl = "http://training.skillo-bg.com:4200/users/login";
        //String actualLoginUrl = driver.getCurrentUrl();
        //Assert.assertEquals(actualLoginUrl,expectedLoginUrl, "Login page URL is incorrect!");

        WebElement signInElement = driver.findElement(By.xpath("//p[text()='Sign in']"));
        wait.until(ExpectedConditions.visibilityOf(signInElement));
        //Assert.assertTrue(signInElement.isDisplayed(), "The 'Sign in' text is not displayed!");

        WebElement userNameField = driver.findElement(By.id("defaultLoginFormUsername"));
        userNameField.sendKeys("Alex78");
        WebElement passwordField = driver.findElement(By.id("defaultLoginFormPassword"));
        passwordField.sendKeys("123456");

        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-button")));
        signInButton.click();
        //WebElement signInButton = driver.findElement(By.id("sign-in-button"));
        //Assert.assertTrue(signInButton.isDisplayed(), "The Sign In button is disabled!");
        //signInButton.click();

        WebElement profileLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-profile")));
        profileLink.click();
        //WebElement profileLink = driver.findElement(By.id("nav-link-profile"));
               //Assert.assertTrue(profileLink.isDisplayed(), "The profile link is not displayed!");
        //profileLink.click();
        //wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4300/users/3904"));
wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4200/users/"));
        //String actualProfilePageUrl = driver.getCurrentUrl();
        //String expectedProfilePagerUrl = "http://training.skillo-bg.com:4200/users/";
        //Assert.assertEquals(actualProfilePageUrl,expectedProfilePagerUrl, "The profile page url is incorrect!");


        String name ="Alex78";
        Boolean isTextDisplayed = wait.until(ExpectedConditions.textToBe(By.tagName("h2"), name));
        Assert.assertTrue(isTextDisplayed, "The username is not displayed!");
        //WebElement userNameElement = driver.findElement(By.tagName("h2"));
        //String  actualUserName = userNameElement.getText();
        //String  expectedUserName = "Alex78";
        //Assert.assertEquals(actualUserName, expectedUserName,  "The user name is incorrect!" );

        driver.close();


    }
}

