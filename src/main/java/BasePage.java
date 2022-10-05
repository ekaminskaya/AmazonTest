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

    protected void openPage(String pageName) {
        switch (pageName) {
            case "home":
                driver.get(baseUrl);
                break;
            case "language":
                driver.get(baseUrl + "/customer-preferences/edit?ie=UTF8&preferencesReturnUrl=%2F&ref_=topnav_lang_ais");
                break;
            case "signUp":
                driver.get(baseUrl + "/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
                break;
            case "dresses":
                driver.get(baseUrl + "/s?i=fashion-womens-intl-ship&bbn=16225018011&rh=n%3A16225018011%2Cn%3A1040660%2Cn%3A1045024&pd_rd_r=5e62d0e6-37e0-4d32-91f3-1b7a343a8752&pd_rd_w=7MOnQ&pd_rd_wg=Wd8DU&pf_rd_p=6a92dcea-e071-4bb9-866a-369bc067390d&pf_rd_r=9QH9DHW4VJK82CZPYDWD&qid=1646786470&rnid=1040660&ref=pd_gw_unk");
                break;
            default:
                driver.get(baseUrl);
        }
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

}
