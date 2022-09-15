package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CurrencyEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ClothingItemsClass extends BasePage {
    @FindBy(xpath = "//div[@class='right-block']/div[@itemprop]/span[1]")
    private List<WebElement> listAllPrice;


    public List<String> getAllPricesText() {

        //   wait.until(w -> listAllPrice.size() > 0);
        List prices = new ArrayList<>();
        for (WebElement elem : listAllPrice) {
            //  waitForElementToAppear(elem);
            // scrollToElem(elem,true);
            //  waitForvisibilityOf(elem);
            String text = getMyText(elem);
            prices.add(text);
            //  prices.add(getMyText(elem));
        }
        return prices;
    }

    public boolean ifListContainsSign(List<String> list) {

        boolean ifAllEquals = Arrays.stream(new List[]{list}).distinct().count() == 1;
        boolean ifEqualsSign = false;
        for (CurrencyEnum permission : CurrencyEnum.values()) {
            for (String substring : list) {
                if (substring.contains(permission.getSign())) {
                    ifEqualsSign = true;
                    break;
                }
            }

        }
        return ifAllEquals && ifEqualsSign;
    }

}
