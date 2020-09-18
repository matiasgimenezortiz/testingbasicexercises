import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected WebDriver driver;
    WelcomePage welcomePage;
    WebDriverWait espera;

    public BaseTest(){

    }

    @BeforeSuite
    public void setUp(){
        driver = chromeDriverConnection();
        espera = new WebDriverWait(driver,10);
        welcomePage = new WelcomePage(driver);
        welcomePage.visit("https://the-internet.herokuapp.com/");

    }


    public WebDriver chromeDriverConnection(){
        System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver1.exe");
        this.driver = new ChromeDriver();
        return driver;
    }

}
