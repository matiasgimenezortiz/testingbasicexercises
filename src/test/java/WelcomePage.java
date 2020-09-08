import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends Base{
    By formAuthLink = By.linkText("Form Authentication");
    By basicAuthLink = By.linkText("Basic Auth");
    By brokenImgsLink = By.linkText("Broken Images");
    By dropdownLink = By.linkText("Dropdown");
    By inputsLink = By.linkText("Inputs");

    public WelcomePage(){
        super();
    }

    public void clickFormAuthLink(WebDriver driver){
        click(formAuthLink, driver);
    }
    public void clickBasicAthLink(WebDriver driver){
        click(basicAuthLink,driver);
    }
    public void clickBrokenImgsLink(WebDriver driver){
        click(brokenImgsLink,driver);
    }
    public void clickDropdownLink(WebDriver driver){
        click(dropdownLink,driver);
    }
    public void clickInputsLink(WebDriver driver){
        click(inputsLink,driver);
    }

}
