import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.ClothingItemsClass;
import pages.HeaderClass;
import utils.CurrencyEnum;

import java.util.ArrayList;
import java.util.List;

public class Tests extends BaseTest {


    @Test
    public void CheckSignChange() {
        List<String> resultItemPrices;
        HeaderClass headerClass = new HeaderClass();
        ClothingItemsClass clothing = new ClothingItemsClass();
        /*headerClass
                .clickOnShowAllButton();*/
        for (CurrencyEnum cur : CurrencyEnum.values()) {
           // resultItemPrices = clothing.getAllPricesText();
                    headerClass
                    .clickOnCurrency()
                    .clickOnSpecificCurrency(cur.getTitle());
            resultItemPrices = clothing.getAllPricesText();
            Assert.assertTrue(clothing.ifListContainsSign(resultItemPrices), "assert in " + cur.getTitle());
        }
    }

    @Test
    public void verifyChangingCurrencyName() {
        List resultCurrencyName = new ArrayList();
        HeaderClass headerClass = new HeaderClass();
        for (CurrencyEnum cur : CurrencyEnum.values()) {
            resultCurrencyName.clear();
            resultCurrencyName.add(headerClass
                    .clickOnCurrency()
                    .clickOnSpecificCurrency(cur.getTitle())
                    .getCurrencyNameText());
            Assert.assertTrue(resultCurrencyName.stream().allMatch(el -> el.equals(cur.getTitle())), "error in" + cur.getTitle());

        }
    }
        @Test
        public void T(){
            HeaderClass headerClass = new HeaderClass();

            driver.get("https://www.TheGreatCoursesPlus.com/sign-in");
            headerClass.clickOnError();
        }
    }


