import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;

public class MLTest {
    private WebDriver driver;
    private By searchBoxLocator = By.name("as_word");
    private By firstResultLocator = By.xpath("/html/body/main/div[1]/div/section/ol/li[1]/div/div[2]/div/h2/a/span");
    private By itemDescriptionLocator = By.cssSelector("#description-includes p");
    private By conditionNewFilterLocator = By.xpath("/html/body/main/div[1]/div/aside/section[2]/dl[6]/dd[1]/a/span[1]");

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.mercadolibre.com.ar/");
        driver.manage().window().maximize();
    }

    @Test
    public void searchItem() throws InterruptedException {
        WebElement searchBox = driver.findElement(searchBoxLocator);
        searchBox.sendKeys("Notebook ASUS i9");
        searchBox.submit();
        WebElement conditionNewFilter = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(conditionNewFilterLocator));
        conditionNewFilter.click();
        WebElement firstResult = new WebDriverWait(driver,10).
                until(ExpectedConditions.elementToBeClickable(firstResultLocator));
        firstResult.click();
        WebElement itemDescription = driver.findElement(itemDescriptionLocator);
        if(itemDescription.isDisplayed()){
            System.out.println("Descripción displayed!");
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
