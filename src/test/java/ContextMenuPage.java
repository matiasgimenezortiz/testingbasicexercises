import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends Base{
    By contextMenuLocator = By.cssSelector("#hot-spot");

    @FindBy(css="#hot-spot")
    private WebElement contextMenu;
    
    public ContextMenuPage(WebDriver driver){
        super(driver);
    }
}
