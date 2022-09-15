import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.TabPage;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.IntStream;

public class Tabs extends BaseTest {
    @Test
    public void switchTabs() throws InterruptedException {
        driver.get("https://www.google.com/");


        TabPage tabPage = new TabPage();
        tabPage.createTabs();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        tabPage.switchBetweenTabs(tabs,1);

    }
}

