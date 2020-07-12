import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class GoogleSearchTest {
    private WebDriver driver;

    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ww.google.com.ar");
    }

    @Test
    public void testGooglePage(){

        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.clear();
        searchbox.sendKeys("Como ejecutar pruebas con Selenium WebDriver");
        searchbox.submit();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        assertEquals("Como ejecutar pruebas con Selenium WebDriver - Buscar con Google",driver.getTitle());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
