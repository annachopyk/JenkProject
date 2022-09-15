package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.interactions.Locatable;

public interface ElementInterface extends WebElement, WrapsElement, Locatable {
    boolean elementWired();
}
