
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {

    private static final String URL = "";

    public final String SIGN_IN_PAGE_HEADER_TEXT = "Sign in";
    public final String LANGUAGE_PAGE_HEADER_TEXT = "Language Settings";
    public final String DELIVER_TO_PAGE_HEADER_TEXT = "Choose your location";

    private By searchButton = By.xpath("//*[@type='submit']");
    private By dismissButton = By.xpath("//*[@data-action-type='DISMISS']");
    private By hamburgerMenu = By.xpath("//*[@id='nav-hamburger-menu']");
    private By languageChange = By.xpath("//*[@aria-label='Choose a language for shopping.']");
    private By deliverTo = By.xpath("//*[@id='nav-global-location-popover-link']");
    private By signInButton = By.xpath("//*[@data-nav-ref='nav_ya_signin']");
    private By navMenu = By.xpath("//div[@id='nav-belt']");
    private By searchDropdownItems = By.xpath("//select[@id='searchDropdownBox']/option");
    private By searchDropdown = By.xpath("//div[@id='nav-search-dropdown-card']//option[1]");
    private By gamingAccessoriesCard = By.xpath("//*[text()='Gaming accessories']");
    private By gamingAccessoriesCardItemsList = By.xpath("//*[contains(@href,'/s?k=gaming')]");
    private By signInPageHeader = By.xpath("//h1[contains(text(),'Sign in')]");
    private By languagePageHeader = By.xpath("//h3[contains(text(),'Language Settings')]");
    private By deliverToWindowHeader = By.xpath("//h4[contains(text(),'Choose your location')]");
    private By deliveryAlert = By.xpath("//div[@role='alertdialog']");
    private By hamburgerMenuContent = By.xpath("//ul[contains(@class,'hmenu-visible')]");
    private By searchField = By.xpath("//input[@type='text']");
    private By searchResultInfo = By.xpath("//*[@data-component-type='s-result-info-bar']/descendant::span[contains(@class,'a-color-state')]");


    public void openPage() {
        log.info("Open the 'Home' page");
        super.openPage(URL);
        if (!isElementPresent(navMenu)) {
            driver.close();
            driver.get(BASE_URL);
        }
    }

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

    public void clickOnLanguageChange() {
        log.info("Click 'LanquageChange' button");
        find(languageChange).click();
    }

    public void clickOnDeliverTo() {
        log.info("Click 'DeliverTo' button");
        find(deliverTo).click();
    }

    public String getSignInPageHeader() {
        log.info("Sign In Page is opened");
        return getPageHeader(signInPageHeader);
    }

    public String getLanguagePageHeader() {
        log.info("Language Settings Page is opened");
        return getPageHeader(languagePageHeader);
    }

    public String getDeliverToWindowHeader() {
        log.info("Choose your location window is opened");
        return getPageHeader(deliverToWindowHeader);
    }

    public boolean isDeliveryAlertDisplay() {
        log.info("Check if alert is displayed");
        return find(deliveryAlert).isDisplayed();
    }

    public boolean isHamburgerMenuDisplay() {
        log.info("Check if menu with categories is displayed");
        return find(hamburgerMenuContent).isDisplayed();
    }

    public String getSearchDropdownCategory() {
        log.info("Get 'Search dropdown' category");
        return find(searchDropdown).getText();
    }

    public void selectCategoryInSearchDropdown(String expectedCategory) {
        List<Element> dropdownItemsList = findAllElements(searchDropdownItems);
        for (Element item : dropdownItemsList) {
            String actualCategory = item.getText();
            if (actualCategory.equalsIgnoreCase(expectedCategory)) {
                log.info("Select category " + expectedCategory + " in Search Dropdown");
                item.click();
            }
        }
    }

    public void searchProduct(String productName) {
        log.info("Enter " + productName + " into search field");
        find(searchField).sendKeys(productName);
        clickOnSearch();
    }

    public String getSearchResultInfo(String value) {
        if (getSearchDropdownCategory().equalsIgnoreCase("All Departments")) {
            searchProduct(value);
        } else {
            selectCategoryInSearchDropdown("All Departments");
            searchProduct(value);
        }
        String s = wait.until(ExpectedConditions.presenceOfElementLocated(searchResultInfo)).getText();
        return s.substring(1, s.length() - 1).toLowerCase();
    }

    public int getGamingAccessoriesCardItemsListSize() {
        log.info("Get Accessories Card Items count");
        return find(gamingAccessoriesCard).findAllElements(gamingAccessoriesCardItemsList).size();
    }

}
