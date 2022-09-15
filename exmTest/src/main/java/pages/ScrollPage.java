package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ScrollPage extends BasePage {
    public WebElement text(String word) {
        return driver.findElement(By.xpath("//*[contains(text(), '" + word + "')]"));
    }

    public void scrollToMyWord(String word) {
        scrollToWord(text(word));

    }

}
