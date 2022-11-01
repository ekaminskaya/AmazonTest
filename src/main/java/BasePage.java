import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected static final String BASE_URL = "https://www.amazon.com";
    protected WebDriver driver;
    protected WebDriverWait wait;

    Log log = new Log();
//    Element myElement = new Element();

    public BasePage() {
        this.driver = BaseDriver.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

   protected void openPage(String url){
        driver.get(BASE_URL + url);
   }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

}
