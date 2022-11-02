
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LanguagePage extends BasePage {

    private static final String URL = "/customer-preferences/edit?ie=UTF8&preferencesReturnUrl=%2F&ref_=topnav_lang_ais";
    protected String languageIsNotSelectedText = "Language is not selected";

    public By languageList = By.xpath("//input[@name='lop']");
    public By languageItems = By.xpath("//div[@class='a-radio a-radio-fancy']");
    public String itemInList = "//*[@value='%s']";
    public By currencyList = By.xpath("//*[@class='a-dropdown-container']");
    public By currencyListItems = By.xpath("//li[@class='a-dropdown-item']");
    public By currencyListValue = By.xpath("//span[@class='a-dropdown-prompt']");

    protected void openPage() {
        log.info("Open the 'Language' page");
        super.openPage(URL);
    }

    public WebElement findItemInTheLanguageList(Language language) {
        log.info("Find item in the 'Language' list");
        return driver.findElements(languageList).get(language.ordinal());
    }

    public boolean isLanguageChecked(Language language) {
        log.info("Check if item is selected");
        return driver.findElements(languageList).get(language.ordinal()).isSelected();
    }

    public String getLanguageValue(Language language) {
        log.info("Get item name in the 'Language' list");
        return driver.findElements(languageItems).get(language.ordinal()).getText();
    }

    public String getDefaultCurrency() {
        log.info("Find default item in the 'Currency' list");
        return Element.find(currencyListValue).getText();
    }

    public void changeCurrency(Currency currency) {
        log.info("Click 'Currency' list");
        Element.find(currencyList).click();
        log.info("Click on 'Currency' item");
        Element.findAllElements(currencyListItems).get(currency.ordinal()).click();
    }


}
