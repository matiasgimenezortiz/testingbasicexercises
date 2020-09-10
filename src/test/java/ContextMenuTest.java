import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {
    WebDriver driver;
    WebElement contextMenuElement;
    WebDriverWait espera;
    ContextMenuPage contextMenuPage;

    public ContextMenuTest(){
        super();
    }

    @BeforeSuite
    public void setUp(){
        driver = chromeDriverConnection();
        contextMenuPage = new ContextMenuPage();
        espera = new WebDriverWait(driver,10);
    }

    @BeforeMethod
    public void setInitialPage(){
        contextMenuPage.visit("https://the-internet.herokuapp.com/context_menu",driver);
        espera.until(ExpectedConditions.presenceOfElementLocated(contextMenuPage.contextMenuLocator));
        driver.manage().window().maximize();
    }

    @Test
    public void testContextMenu() throws InterruptedException {
        contextMenuElement = driver.findElement(contextMenuPage.contextMenuLocator);
        Actions action = new Actions(driver);
        action.contextClick(contextMenuElement).perform();
        espera.until(ExpectedConditions.alertIsPresent());
        Assert.assertNotNull(ExpectedConditions.alertIsPresent());
        //Thread.sleep(3000);//Just to see the action of accepting on the alert...
        driver.switchTo().alert().accept();
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
