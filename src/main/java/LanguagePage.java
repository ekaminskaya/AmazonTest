
import org.openqa.selenium.By;

public class LanguagePage extends BasePage {

    private static final String URL = "/customer-preferences/edit?ie=UTF8&preferencesReturnUrl=%2F&ref_=topnav_lang_ais";
    public final String LANGUAGE_IS_NOT_SELECTED_TEXT = "Language is not selected";

    private By languageList = By.xpath("//input[@name='lop']");
    private By languageItems = By.xpath("//div[@class='a-radio a-radio-fancy']");
    private By currencyList = By.xpath("//*[@class='a-dropdown-container']");
    private By currencyListItems = By.xpath("//li[@class='a-dropdown-item']");
    private By currencyListValue = By.xpath("//span[@class='a-dropdown-prompt']");
    private By dismissButton = By.xpath("//*[@data-action-type='DISMISS']");

    public void openPage() {
        log.info("Open the 'Language' page");
        super.openPage(URL);
    }

    public boolean isLanguageChecked(Language language) {
        log.info("Check if item is selected");
        return findAllElements(languageList).get(language.ordinal()).isSelected();
    }

    public String getLanguageValue(Language language) {
        log.info("Get item name in the 'Language' list");
        return findAllElements(languageItems).get(language.ordinal()).getText();
    }

    public String getDefaultCurrency() {
        log.info("Find default item in the 'Currency' list");
        return find(currencyListValue).getText();
    }

    public void changeCurrency(Currency currency) {
        log.info("Click 'Currency' list");
        find(currencyList).click();
        log.info("Click on 'Currency' item");
        findAllElements(currencyListItems).get(currency.ordinal()).click();
    }

    public void closePopUpIfPresent() {
        if (isElementPresent(dismissButton)) {
            log.info("Close pop-up clicking on Dismiss button");
            find(dismissButton).click();
        }
    }


}
