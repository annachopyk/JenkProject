package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static pages.BaseTest.getDriver;


public class BasePage {
    private static final int TIMEOUT = 30;
    private static final int POLLING = 100;

    protected WebDriver driver;
    protected Wait<WebDriver> wait;

    public BasePage() {
        this.driver = getDriver();
        wait = new WebDriverWait(driver, TIMEOUT);
        PageFactory.initElements(driver, this);
    }

    public void waitForElementToClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitForElementToAppear(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) elem));
    }

    protected WebElement waitForvisibilityOf(WebElement elem) {
        return ((WebDriverWait) wait)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOf(elem));
    }

    protected void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForTextToDisappear(By locator, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
    }

    protected WebElement scrollToElem(WebElement element, boolean isIntoView) {
        ((JavascriptExecutor) driver).executeScript(String.format("arguments[0].scrollIntoView(%b);", isIntoView),
                element);
        return element;
    }

    protected String getMyText(WebElement userNameTxt) {
        String theTextIWant = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].text;", userNameTxt);
        return theTextIWant;
    }

    protected void scrollToWord(WebElement elem) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", elem);
    }

}
