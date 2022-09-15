import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.ScrollPage;

public class ScrollTest extends BaseTest {

    @DataProvider(name = "dataProviderWords")
    private Object[][] dataProviderAddress() {
        return new Object[][]{
                {"dolorem"},{"cupiditate "},{"nam"}
        };
    }

    @Test(dataProvider = "dataProviderWords")
    public void scrollToTextTest(String word){
        ScrollPage scrollPage = new ScrollPage();
        scrollPage.scrollToMyWord(word);

    }
}
