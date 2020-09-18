import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class BrokenImagesTest extends BaseTest{
    BrokenImagesPage brokenImagesPage;
    WebDriverWait espera;

    public BrokenImagesTest(){
        super();
    }

    @BeforeSuite
    public void setUp(){
        driver = chromeDriverConnection();
        espera = new WebDriverWait(driver,10);
        brokenImagesPage = new BrokenImagesPage(driver);
    }

    @BeforeTest
    public void setInitialPage(){
        brokenImagesPage.visit("https://the-internet.herokuapp.com/broken_images");
        driver.manage().window().maximize();
    }

    @Test
    //Testing all the images on the page
    public void testingAllImages(){
        List<WebElement> allImages;
        allImages = driver.findElements(brokenImagesPage.allImagesLocator);
        int totalImages = allImages.size();
        System.out.println("Número de imagenes encontradas: "+ totalImages);
        for(WebElement image:allImages){
            if(image.getAttribute("naturalWidth") == "0"){
                Assert.fail("La imagen "+image.getText()+" está rota");
            }
        }

    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
