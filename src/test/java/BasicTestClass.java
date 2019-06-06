org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

public class BasicTestClass {
    private static WebDriver driver;


    @BeforeEach
    public void beforeEach() {
        // if not on windows, update chromedriver directory below
        System.setProperty("webdriver.chrome.driver", "webdrivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

    @Test
    public void basicTest1() throws InterruptedException {
        // write code here:
        // goto www.google.com
        String url = "https://www.google.com";
        driver.get(url);
        
        // Normal validation check the Google logo
        if(driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed()) {
            System.out.println("Google image  exists");
            //Assertions.assertTrue(true);
        }
        
        // Check google search button
        // Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='FPdoLc VlcAe']//input[@name='btnK']")).isDisplayed());
        // Use XPath for Parent element Div by ID and traverse to the input with attribute "value" having Google Search'
        // Assert if the "Google Search" is visible
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id='gbqfbb']/parent::center/child::input[@value='Google Search']")).isDisplayed());

        // Check for "I am Feeling lucky" input of type button (has fixed ID) exists
        // Use the ID to search for the input element
        Assertions.assertTrue(driver.findElement(By.id("gbqfbb")).isDisplayed());
        // Enter text PayPal and click "I am feeling Lucky"
        // Input element has name 'q'
        driver.findElement(By.name("q")).sendKeys("PayPal");
        // Google page has 2 "I am feeling lucky" elements"
        List<WebElement> lucky = driver.findElements(By.xpath("//input[contains(@value,'Feeling Lucky')]"));
        System.out.println("Count of 'I am feeling lucky' buttons: " + lucky.size());
        // Iterate thru the list and check for the visible element
        for (int index = 0; index < lucky.size(); index++) {
            if(lucky.get(index).isDisplayed()) {
                lucky.get(index).click();
                break;
            }
        }

        // Assert PayPal page is loaded
        Assertions.assertTrue(driver.getTitle().contains("Send Money, Pay Online or Set Up a Merchant Account - PayPal"));
        driver.findElement(By.xpath("//a[contains(text(),'Sitemap')]")).click();
        // Verify that SiteMap page is opened
        Assertions.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Site Map')]")).isDisplayed());
        // get all links as list
        List<WebElement> linklist = driver.findElements(By.tagName("a"));
        //Thread.sleep(1000);
        System.out.println("Count of Links on the page: " + linklist.size());
        // iterate thru the list and print the list
        for (int index =0; index < linklist.size(); index++) {
            System.out.println(linklist.get(index).getText() + "-->"+ linklist.get(index).getAttribute("href"));
        }
    }
    @AfterEach
    public void afterEach() {
        driver.close();
    }
}