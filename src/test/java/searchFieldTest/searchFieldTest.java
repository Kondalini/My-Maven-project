package searchFieldTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class searchFieldTest {

    private WebDriver driver;

    @AfterMethod
    protected final void tearDownTest() {
        if (this.driver != null) {
            this.driver.close();
        }
    }
        @Test
        public void searchField () {
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

            WebElement signInElement = driver.findElement(By.xpath("//p[text()='Sign in']"));
            wait.until(ExpectedConditions.visibilityOf(signInElement));

            WebElement userNameField = driver.findElement(By.id("defaultLoginFormUsername"));
            userNameField.sendKeys("Alex78");
            WebElement passwordField = driver.findElement(By.id("defaultLoginFormPassword"));
            passwordField.sendKeys("123456");

            WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-button")));
            signInButton.click();

            WebElement searchField = driver.findElement(By.id("search-bar"));
            wait.until(ExpectedConditions.visibilityOf(searchField));
            searchField.sendKeys("Test");

            WebElement searchButton = driver.findElement(By.xpath("//*[@class='fas fa-search']"));
            searchButton.click();
            wait.until(ExpectedConditions.elementToBeClickable(searchButton));


        }
    }