import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends Base{

    @FindBy(linkText = "Form Authentication")
    WebElement formAuthLink;

    @FindBy(linkText = "Basic Auth")
    WebElement basicAuthLink;

    @FindBy(linkText = "Broken Images")
    WebElement brokenImgsLink;

    @FindBy(linkText = "Dropdown")
    WebElement dropdownLink;

    @FindBy(linkText = "Inputs")
    WebElement inputsLink;

    public WelcomePage(WebDriver driver){
        super(driver);
    }
    public void clickFormAuthLink(){
        click(formAuthLink);
    }
    public void clickBasicAthLink(){
        click(basicAuthLink);
    }
    public void clickBrokenImgsLink(){
        click(brokenImgsLink);
    }
    public void clickDropdownLink(){
        click(dropdownLink);
    }
    public void clickInputsLink(){
        click(inputsLink);
    }

}
