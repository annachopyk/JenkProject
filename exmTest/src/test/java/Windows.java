import com.aspose.html.HTMLDocument;
import com.aspose.html.converters.Converter;
import com.aspose.html.saving.PdfSaveOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.print.PrintOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseTest;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Windows extends BaseTest {
    @Test
    public void ChangeSize() throws InterruptedException {
        driver.get(" http://www.omayo.blogspot.com ");
        Dimension size = driver.manage().window().getSize();

        driver.manage().window().maximize();
        Dimension sizemaximize = driver.manage().window().getSize();

        driver.manage().window().minimize();
        Dimension sizeminimize = driver.manage().window().getSize();
        driver.manage().window().setSize(new Dimension(900, 768));
        Dimension sizesetSize = driver.manage().window().getSize();

        Assert.assertNotEquals(size,sizemaximize, "sizemaximize");
        Assert.assertEquals(size,sizeminimize,"sizeminimize");
        Assert.assertTrue(sizesetSize.getHeight()==768&&sizesetSize.getWidth()==900,"sizesetSize");
    }

    @Test
    public void pdf() throws IOException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        WebDriver driver1 = new ChromeDriver(chromeOptions);
        driver1.manage().window().maximize();
        driver1.get("http://www.omayo.blogspot.com");
        Pdf pdf =  ((PrintsPage) driver1).print(new PrintOptions());
        Files.write(Paths.get("C:\\Users\\user\\Downloads\\WebPage.pdf"),OutputType.BYTES.convertFromBase64Png(pdf.getContent()));
        driver1.quit();

    }
}
