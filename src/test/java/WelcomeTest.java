import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class WelcomeTest extends BaseTest{

    public WelcomeTest() {
        super();
    }


    @BeforeMethod
    public void setWelcomePage(){
        driver.manage().window().maximize();
    }

    @Test
    //Asserting equals
    public void formAuthLinkTest(){
        welcomePage.clickFormAuthLink();
        espera.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#content > div > h2")));
        WebElement tituloPagina = driver.findElement(By.cssSelector("#content > div > h2"));
        Assert.assertEquals(tituloPagina.getText(),"Login Page");

    }

    @Test
    //Asserting same
    public void inputsLinkTest(){
        welcomePage.clickInputsLink();
        espera.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#content > div > div > h3")));
        WebElement tituloPagina;
        tituloPagina = driver.findElement(By.cssSelector("#content > div > div > h3"));
        String string = "test";
        Assert.assertSame(tituloPagina.getText().getClass(),string.getClass());
    }

    @Test
    //Asserting true
    public void dropdownLinkTest(){
        welcomePage.clickDropdownLink();
        espera.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#content > div > h3")));
        Assert.assertTrue(welcomePage.isDisplayed(By.cssSelector("#content > div > h3")));
    }

    @Test
    public void basicAuthLink() throws InterruptedException {
        welcomePage.clickBasicAthLink();
        welcomePage.visit("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        Thread.sleep(5000);
    }

    @Test
    public void brokenImgsLink(){
        welcomePage.clickBrokenImgsLink();
        WebElement title = driver.findElement(By.cssSelector("div .example > h3"));
        String textTitle = title.getText();
        Assert.assertEquals(textTitle,"Broken Images");
    }

    @Test
    //Testing a dropdown list
    public void dropdownListLink(){
        welcomePage.clickDropdownLink();
        espera.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#content > div > h3")));
        Select dropdown = new Select(driver.findElement(By.cssSelector("select#dropdown")));
        dropdown.selectByIndex(2);
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

}
