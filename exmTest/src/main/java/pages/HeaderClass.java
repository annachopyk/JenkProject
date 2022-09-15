package pages;

import elements.CustomElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static utils.CustomElement.clickOn;

public class HeaderClass extends BasePage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"setCurrency\"]")
    private WebElement currency;


    @FindBy(how = How.XPATH, using = "//*[@id=\"setCurrency\"]/div/strong")
    private WebElement currencyName;


    @FindBy(how = How.CSS, using = "button.btn.btn-default.button.exclusive-medium")
    private WebElement showAllButton;


    @FindBy(how = How.XPATH, using = "//*[@id=\"first-currencies\"]/li")
    private List<WebElement> dropDowmCurrencyElements;

    @FindBy(how = How.XPATH, using = "//h1[@class=\"sign-in-input\"]")
    private WebElement error;
    public HeaderClass clickOnCurrency() {
        clickOn(driver, currency);
        return this;

    }
    public HeaderClass clickOnError() {
        clickOn(driver, error);
        return this;

    }

    public HeaderClass clickOnShowAllButton() {
        showAllButton.click();
        return this;
    }

    public HeaderClass clickOnSpecificCurrency(String name) {

        switch (name) {
            case "UAH":
                clickOn(driver, dropDowmCurrencyElements.get(0));
                break;
            case "USD":
                clickOn(driver, dropDowmCurrencyElements.get(1));
                break;
            case "EUR":
                clickOn(driver, dropDowmCurrencyElements.get(2));
                break;
        }
        return this;
    }

    public String getCurrencyNameText() {
        waitForvisibilityOf(currencyName);
        return currencyName.getText();
    }


}
