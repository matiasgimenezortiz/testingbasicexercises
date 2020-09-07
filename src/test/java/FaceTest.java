import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceTest {
    private WebDriver driver;
    By userBoxSelector = By.id("email");
    By passBoxSelector = By.id("pass");
    By logInButtonSelector = By.id("loginbutton");
    By faceLogoSelector = By.className("_2md");

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
    }

    @Test
    public void tesSignIn() throws InterruptedException {
        WebElement userBox = driver.findElement(userBoxSelector);
        userBox.sendKeys("mattpulga");
        WebElement passBox = driver.findElement(passBoxSelector);
        passBox.sendKeys("wrongpass");
        WebElement logInButton = driver.findElement(logInButtonSelector);
        logInButton.click();
        Thread.sleep(2000);

        WebElement faceLogo = driver.findElement(faceLogoSelector);
        System.out.println(!faceLogo.isDisplayed());
        System.out.println(driver.getTitle());




    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
