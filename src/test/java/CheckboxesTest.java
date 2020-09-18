import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class CheckboxesTest extends BaseTest{
    WebElement checkBox;
    List<WebElement> checkboxesList;
    WebDriverWait espera;
    CheckboxesPage checkboxesPage;

    public CheckboxesTest(){
        super();
    }

    @BeforeSuite
    public void setUp(){
        driver = chromeDriverConnection();
        espera = new WebDriverWait(driver,10);
        checkboxesPage = new CheckboxesPage(driver);

    }

    @BeforeMethod
    public void setInitialPage(){
        checkboxesPage.visit("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().maximize();
    }

    @Test
    //Sets all checkboxes on checked
    public void setAllChecked() throws InterruptedException {
        checkboxesList = driver.findElements(checkboxesPage.checkBoxesLocator);
        int cont = 0;
        for(WebElement checkbox:checkboxesList){
            if (!checkbox.isSelected()){
                checkbox.click();
            }
            cont++;
        }
        Assert.assertEquals(cont,checkboxesList.size());
    }

    @Test
    //Testing with soft assertion
    public void testAllChecked(){
        SoftAssert softTestAllChecked = new SoftAssert();
        checkboxesList = driver.findElements(checkboxesPage.checkBoxesLocator);
        boolean toTest = true;
        for(WebElement checkbox:checkboxesList){
            if (!checkbox.isSelected()){
                toTest = false;
            }
        }
        softTestAllChecked.assertTrue(toTest,"At least one checkbox is unchecked");
        softTestAllChecked.assertAll();
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
