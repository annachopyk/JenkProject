package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class TabPage extends BasePage {
    public void createTabs(){
            IntStream.range(0, 5).forEach(item->{
            driver.switchTo().newWindow(WindowType.TAB);
            driver.navigate().to("https://www.lambdatest.com/");});
    }

    public void switchBetweenTabs(ArrayList<String> tabs, int tabNumber){
        driver.switchTo().window(tabs.get(tabNumber));

    }
    public void switchToFirstTab(ArrayList<String> tabs){
        Actions action= new Actions(driver);
        IntStream.range(0, tabs.size()).forEach(item->{
            action.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys(Keys.TAB).build().perform();
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

    }
    public void switchToLastTab(ArrayList<String> tabs){
        Actions action= new Actions(driver);
        IntStream.range(0, tabs.size()).forEach(item->{
            action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

}


