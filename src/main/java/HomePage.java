import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HomePage extends BasePage {

    private static final Logger log = LogManager.getLogger(HomePage.class);
    private static final String URL = "";

    public By searchButton = By.xpath("//*[@type='submit']");
    public By dismissButton = By.xpath("//*[@data-action-type='DISMISS']");
    public By hamburgerMenu = By.xpath("//*[@id='nav-hamburger-menu']");
    public By languageChange = By.xpath("//*[@aria-label='Choose a language for shopping.']");
    public By deliverTo = By.xpath("//*[@id='nav-global-location-popover-link']");
    public By signInButton = By.xpath("//*[@data-nav-ref='nav_ya_signin']");
    public By navMenu = By.xpath("//div[@id='nav-belt']");
    public By searchDropdownItems = By.xpath("//select[@id='searchDropdownBox']/option");


    public void clickOnSignIn() {
        log.info("Click 'SignIn' button");
        driver.findElement(signInButton).click();
    }

    public void clickOnSearch() {
        log.info("Click 'Search' button");
        driver.findElement(searchButton).click();
    }

    public void clickOnHamburgerMenu() {
        log.info("Click 'HamburgerMenu'");
        driver.findElement(hamburgerMenu).click();
    }

    public void clickOnDismissButton() {
        log.info("Click 'Dismiss' button");
        driver.findElement(dismissButton).click();
    }

    public void clickOnLanquageChange() {
        log.info("Click 'LanquageChange' button");
        driver.findElement(languageChange).click();
    }

    public void clickOnDeliverTo() {
        log.info("Click 'DeliverTo' button");
        driver.findElement(deliverTo).click();
    }

    public void openPage() {
        log.info("Open the 'Home' page");
        super.openPage(URL);
        if (!isElementPresent(navMenu)) {
            driver.close();
            driver.get(BASE_URL);
        }
    }

    public List<String> getSearchDropdownItemsString() {
        List<String> dropdownItemsText = new ArrayList<>();
        List<WebElement> dropdownItems = driver.findElements(searchDropdownItems);
        for (int i = 0; i < dropdownItems.size(); i++) {
            dropdownItemsText.add(dropdownItems.get(i).getText());
        }
        return dropdownItemsText;
    }


}
