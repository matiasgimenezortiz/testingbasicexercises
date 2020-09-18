import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class KeyPressesTest extends BaseTest{
    KeyPressesPage keyPressesPage;
    WebDriver driver;
    WebDriverWait espera;
    WebElement inputBoxElement;
    WebElement enteredTextElement;
    String enteredText;
    char lastEntered;

    public KeyPressesTest(){
        super();
    }

    @BeforeSuite
    public void setUp(){
        driver = chromeDriverConnection();
        espera = new WebDriverWait(driver,10);
        keyPressesPage = new KeyPressesPage(driver);
    }

    @BeforeMethod
    public void setInitialPage(){
        keyPressesPage.visit("https://the-internet.herokuapp.com/key_presses");
        driver.manage().window().maximize();
        espera.until(ExpectedConditions.presenceOfElementLocated(keyPressesPage.titlePageLocator));
    }

    @Test
    public void testEqualText(){
        inputBoxElement = driver.findElement(keyPressesPage.inputBoxLocator);
        inputBoxElement.sendKeys("ABC");
        enteredText = inputBoxElement.getAttribute("value");
        lastEntered = enteredText.charAt(enteredText.length()-1);
        enteredTextElement = driver.findElement(keyPressesPage.enteredTextLocator);
        Assert.assertEquals(enteredTextElement.getText(),"You entered: "+lastEntered);
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
