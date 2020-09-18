import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenImagesPage extends Base{
    By allImagesLocator = By.cssSelector("div .example > img");

    public BrokenImagesPage(WebDriver driver){
        super(driver);

    }
}
