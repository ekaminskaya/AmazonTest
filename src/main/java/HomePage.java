import org.openqa.selenium.By;

public class HomePage extends BasePage{

    protected String url = "";
    public By searchButton = By.xpath("//*[@type='submit']");
    public By dismissButton = By.xpath("//*[@data-action-type='DISMISS']");
    public By hamburgerMenu = By.xpath("//*[@id='nav-hamburger-menu']");
    public By languageChange = By.xpath("//*[@aria-label='Choose a language for shopping.']");
    public By deliverTo = By.xpath("//*[@id='nav-global-location-popover-link']");
    public By signInButton = By.xpath("//*[@data-nav-ref='nav_ya_signin']");
    public By navMenu = By.xpath("//div[@id='nav-belt']");

    public void clickOnSignIn(){
        driver.findElement(signInButton).click();
    }

    public void clickOnSearch(){
        driver.findElement(searchButton).click();
    }

    public void clickOnHamburgerMenu(){
        driver.findElement(hamburgerMenu).click();
    }

    public void clickOnDismissButton(){
        driver.findElement(dismissButton).click();
    }

    public void clickOnLanquageChange(){
        driver.findElement(languageChange).click();
    }

    public void clickOnDeliverTo(){
        driver.findElement(deliverTo).click();
    }

    public void openPage(){
        super.openPage(url);
        if (!isElementPresent(navMenu)) {
            driver.close();
            driver.get(baseUrl);
        }
    }



}
