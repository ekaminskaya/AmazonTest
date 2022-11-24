
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    private static final String URL = "";

    private By searchButton = By.xpath("//*[@type='submit']");
    private By dismissButton = By.xpath("//*[@data-action-type='DISMISS']");
    private By hamburgerMenu = By.xpath("//*[@id='nav-hamburger-menu']");
    private By languageChange = By.xpath("//*[@aria-label='Choose a language for shopping.']");
    private By deliverTo = By.xpath("//*[@id='nav-global-location-popover-link']");
    private By signInButton = By.xpath("//*[@data-nav-ref='nav_ya_signin']");
    private By navMenu = By.xpath("//div[@id='nav-belt']");
    private By searchDropdownItems = By.xpath("//select[@id='searchDropdownBox']/option");
    private By gamingAccessoriesCard = By.xpath("//*[text()='Gaming accessories']");
    private By gamingAccessoriesCardItemsList = By.xpath("//*[contains(@href,'/s?k=gaming')]");


    public void clickOnSignIn() {
        log.info("Click 'SignIn' button");
        find(signInButton).click();
    }

    public void clickOnSearch() {
        log.info("Click 'Search' button");
        find(searchButton).click();
    }

    public void clickOnHamburgerMenu() {
        log.info("Click 'HamburgerMenu'");
        find(hamburgerMenu).click();
    }

    public void clickOnDismissButton() {
        log.info("Click 'Dismiss' button");
        find(dismissButton).click();
    }

    public void clickOnLanquageChange() {
        log.info("Click 'LanquageChange' button");
        find(languageChange).click();
    }

    public void clickOnDeliverTo() {
        log.info("Click 'DeliverTo' button");
        find(deliverTo).click();
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
        List<Element> dropdownItems = findAllElements(searchDropdownItems);
        for (int i = 0; i < dropdownItems.size(); i++) {
            dropdownItemsText.add(dropdownItems.get(i).getText());
        }
        return dropdownItemsText;
    }

    public int getGamingAccessoriesCardItemsListSize() {
        return find(gamingAccessoriesCard).findAllElements(gamingAccessoriesCardItemsList).size();
    }


}
