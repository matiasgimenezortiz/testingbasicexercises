import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage extends Base{
    By titlePageLocator = By.cssSelector("form");
    By inputBoxLocator = By.id("target");
    By enteredTextLocator = By.id("result");

    public KeyPressesPage(WebDriver driver){
        super(driver);
    }
}
