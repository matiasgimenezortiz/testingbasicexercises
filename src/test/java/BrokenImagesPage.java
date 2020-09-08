import org.openqa.selenium.By;

public class BrokenImagesPage extends Base{
    By allImagesLocator = By.cssSelector("div .example > img");

    public BrokenImagesPage(){
        super();
    }
}
