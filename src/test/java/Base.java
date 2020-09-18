import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Base{
    protected WebDriver driver;

    public Base(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void visit (String url){
        driver.get(url);
    }
    public void click(By locator){
        driver.findElement(locator).click();
    }
    public void click(WebElement element){
        element.click();
    }
    public boolean isDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();
    }
    //Continuar escribiendo todos los wrapping

}
