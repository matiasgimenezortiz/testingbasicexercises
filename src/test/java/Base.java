import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Base{
    public Base(){

    }

    public void visit (String url, WebDriver driver){
        driver.get(url);
    }
    public void click(By locator, WebDriver driver){
        driver.findElement(locator).click();
    }
    public boolean isDisplayed(By locator, WebDriver driver){
        return driver.findElement(locator).isDisplayed();
    }
    //Continuar escribiendo todos los wrapping

}
