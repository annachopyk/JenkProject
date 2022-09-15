package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class CustomElement extends BasePage {
    private final WebElement element;

    public CustomElement(WebElement element) {
        this.element = element;
    }

    public void clickOnElem(By locator) {
        waitForElementToClickable(locator);
        element.click();
    }




}
