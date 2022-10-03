import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(){
        this.driver=BaseDriver.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void openSite(String url){
        driver.get(url);
    }


}
