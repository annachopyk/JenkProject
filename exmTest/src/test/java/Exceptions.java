import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.BaseTest;

public class Exceptions extends BaseTest {
    @Test
    public void Exception(){
        driver.get(" http://www.omayo.blogspot.com ");
        try {
            driver.findElement(By.xpath("//*[@id='hbutton']")).click();

    } catch (Exception e) {
        System.out.println("Something went wrong." + e);
    }
    }
    @Test
    public void Exception2(){ //NoAlertPresentException
        driver.get(" http://www.omayo.blogspot.com ");
        try {
            driver.switchTo( ).alert( ).accept();

        } catch (Exception e) {
            System.out.println("Something went wrong." + e);
        }
    }
    @Test
    public void Exception3(){ //NoSuchElementException
        driver.get(" http://www.omayo.blogspot.com ");
        try {
           // driver.findElement(By.xpath("//*[@id='hbuon']")).click();
            driver.findElement(By.cssSelector("div.date-outer")).click();
        } catch (Exception e) {
            System.out.println("Something went wrong." + e);
        }
    }
    @Test
    public void Exception4(){ //ElementNotInteractableException
        driver.get(" http://www.omayo.blogspot.com ");
        try {
            driver.findElement(By.cssSelector("#tb2")).sendKeys("here text");

        } catch (Exception e) {
            System.out.println("Something went wrong." + e);
        }
    }
    @Test
    public void Exception5(){ //NoSuchWindowException:
        driver.get(" http://www.omayo.blogspot.com ");

        try {
            driver.switchTo().window("Java Exceptions (Try... Catch)");

        } catch (Exception e) {
            System.out.println("Something went wrong." + e);
        }
    }
}
