package ExersisesTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExercisesTest {
    @Test
    public void testLogin() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://training.skillo-bg.com:4200/users/login");
        WebElement login = driver.findElement(By.id("nav-link-login"));
        login.click();
        String expectedLoginUrl = "http://training.skillo-bg.com:4200/users/login";
        String actualLoginUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualLoginUrl,expectedLoginUrl, "Login page URL is incorrect!");

        WebElement signInElement = driver.findElement(By.xpath("//p[text()='Sign in']"));
        Assert.assertTrue(signInElement.isDisplayed(), "The 'Sign in' text is not displayed!");

        WebElement userNameField = driver.findElement(By.id("defaultLoginFormUsername"));
            userNameField.sendKeys("Alex78");
        WebElement passwordField = driver.findElement(By.id("defaultLoginFormPassword"));
        passwordField.sendKeys("123456");

        WebElement signInButton = driver.findElement(By.id("sign-in-button"));
        Assert.assertTrue(signInButton.isDisplayed(), "The Sign In button is disabled!");
        signInButton.click();

        WebElement profileLink = driver.findElement(By.xpath("//*[@id='nav-link-profile']"));
        Assert.assertTrue(profileLink.isDisplayed(), "The profile link is not displayed!");
        profileLink.click();

        String actualProfilePageUrl = driver.getCurrentUrl();
        String expectedProfilePagerUrl = "http://training.skillo-bg.com:4200/users/3904";
        Assert.assertEquals(actualProfilePageUrl,expectedProfilePagerUrl, "The profile page url is incorrect!");

         WebElement userNameElement = driver.findElement(By.tagName("h2"));
         String  actualUserName = userNameElement.getText();
         String  expectedUserName = "Alex78";
         Assert.assertEquals(actualUserName, expectedUserName,  "The user name is incorrect!" );

         driver.close();


    }
}
