import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class BasicTestClass {
    @Test
    public void basicTest1() {
        WebDriver browser;
        // if not on windows, update chromedriver directory below
        System.setProperty("webdriver.chrome.driver", "webdrivers\\chromedriver_win32\\chromedriver.exe");
        browser = new ChromeDriver();
        // write code here:

        browser.close();
    }
}