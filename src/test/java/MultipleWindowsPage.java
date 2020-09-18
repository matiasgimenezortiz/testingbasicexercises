import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowsPage extends Base{
    By newWindowLinkLocator = By.linkText("Click Here");
    By titlePageLocator = By.cssSelector("h3 ");

    public MultipleWindowsPage(WebDriver driver){
        super(driver);
    }

    public void clickNewWindowLink(WebDriver driver){
        click(newWindowLinkLocator);
    }
}
