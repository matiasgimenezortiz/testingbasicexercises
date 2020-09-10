import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowsPage extends Base{
    By newWindowLinkLocator = By.linkText("Click Here");
    By titlePageLocator = By.cssSelector("h3 ");

    public MultipleWindowsPage(){
        super();
    }

    public void clickNewWindowLink(WebDriver driver){
        click(newWindowLinkLocator,driver);
    }
}
