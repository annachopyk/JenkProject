package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomElement {

    public static void clickOn(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        ExpectedCondition<Boolean> elementIsClickable = arg0 -> {
            try {
                element.click();
                return true;
            } catch (Exception e) {
                return false;
            }
        };
        wait.until(elementIsClickable);
    }

    public static void getLoadText(WebDriver driver, WebElement element, int specifiedTimeout) {
        WebDriverWait wait = new WebDriverWait(driver, specifiedTimeout);
        ExpectedCondition<Boolean> elementIsClickable = arg0 -> {
            try {
                element.getText();
                return true;
            } catch (Exception e) {
                return false;
            }
        };
        wait.until(elementIsClickable);

    }


}
