import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxesPage extends  Base{
    By checkBoxesLocator = By.cssSelector("#checkboxes>input");

    public CheckboxesPage(){
        super();
    }

    public void clickCheckBox(WebElement checkBox, WebDriver driver){
        click(checkBox,driver);
    }
}
