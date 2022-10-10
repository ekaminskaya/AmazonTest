import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "https://www.amazon.com";

    public BasePage() {
        this.driver = BaseDriver.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

   protected void openPage(String url){
        driver.get(baseUrl + url);
   }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

}
