import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxesPage extends  Base{
    By checkBoxesLocator = By.cssSelector("#checkboxes>input");

    public CheckboxesPage(WebDriver driver){
        super(driver);
    }

    public void clickCheckBox(WebElement checkBox, WebDriver driver){
        click(checkBox);
    }
}
