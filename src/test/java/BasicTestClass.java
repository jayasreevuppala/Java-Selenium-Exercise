import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BasicTestClass {
    private static WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        // if not on windows, update chromedriver directory below
        System.setProperty("webdriver.chrome.driver", "webdrivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void basicTest1() {

        // write code here:

    }
    @AfterEach
    public void afterEach() {
        driver.close();
    }
}