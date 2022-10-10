import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class LanguagePage extends BasePage {

    protected String url = "/customer-preferences/edit?ie=UTF8&preferencesReturnUrl=%2F&ref_=topnav_lang_ais";
    protected String languageIsNotSelectedText = "Language is not selected";

    public By languageList = By.xpath("//input[@name='lop']");
    public By languageItems = By.xpath("//div[@class='a-radio a-radio-fancy']");
    public String itemInList = "//*[@value='%s']";
    public By currencyList = By.xpath("//*[@class='a-dropdown-container']");
    public By currencyListItems = By.xpath("//li[@class='a-dropdown-item']");
    public By currencyListValue = By.xpath("//span[@class='a-dropdown-prompt']");

    protected void openPage() {
        super.openPage(url);
    }

    public WebElement findItemInTheLanguageList(Language language) {
        return driver.findElements(languageList).get(language.ordinal());
    }

    public boolean isLanguageChecked(Language language) {
        return driver.findElements(languageList).get(language.ordinal()).isSelected();
    }

    public String getLanguageValue(Language language) {
        return driver.findElements(languageItems).get(language.ordinal()).getText();
    }

    public String getDefaultCurrency() {
        return driver.findElement(currencyListValue).getText();
    }

    public void changeCurrency(Currency currency) {
        driver.findElement(currencyList).click();
        driver.findElements(currencyListItems).get(currency.ordinal()).click();
    }


}
