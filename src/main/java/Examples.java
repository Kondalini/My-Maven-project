import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Examples {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        testMyFirsWebDriver();
    }

    private static void testMyFirsWebDriver() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://training.skillo-bg.com:4200/posts/all");
            driver.manage().window().maximize();
        WebElement login = driver.findElement(By.id("nav-link-login"));
        driver.close();
        }
    }
