import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class MultipleWindowsTest extends  BaseTest{
    MultipleWindowsPage multipleWindowsPage;
    WebElement newWindowLink;
    WebDriverWait espera;

    public MultipleWindowsTest(){
        super();
    }

    @BeforeSuite
    public void setUp(){
        multipleWindowsPage = new MultipleWindowsPage();
        driver = chromeDriverConnection();
        espera = new WebDriverWait(driver,10);
    }

    @BeforeMethod
    public void setInitialPage(){
        multipleWindowsPage.visit("https://the-internet.herokuapp.com/windows",driver);
        espera.until(ExpectedConditions.presenceOfElementLocated(multipleWindowsPage.titlePageLocator));
    }

    @Test
    public void testNewWindow() throws InterruptedException {
        multipleWindowsPage.clickNewWindowLink(driver);
        ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));
        espera.until(ExpectedConditions.titleIs("New Window"));
        Thread.sleep(2000); //Just to see the movement
        driver.switchTo().window(windowHandles.get(0));
        Thread.sleep(2000); //Just to see the movement
        Assert.assertEquals(driver.getTitle(),"The Internet");
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
