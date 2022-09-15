package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    protected static WebDriver driver;

    @BeforeMethod
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.get("http://prestashop.qatestlab.com.ua/uk/3-women");
        //   driver.get("http://the-internet.herokuapp.com/infinite_scroll");

    }
   @AfterClass
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
        driver = null;
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
