import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class LanguagePage extends BasePage {

    public By languageList = By.xpath("//input[@name='lop']");
    public By languageItems = By.xpath("//div[@class='a-radio a-radio-fancy']");
    public String itemInList = "//*[@value='%s']";
    public By currencyList = By.xpath("//*[@id='icp-currency-dropdown']");
    public By currencyListValue = By.xpath("//span[@class='a-dropdown-prompt']");

    protected void openPage() {
        super.openPage("language");
    }

    public WebElement findItemInTheLanguageListByIndex(String value, int index) {
        return driver.findElements(languageList).get(index).findElement(By.xpath(String.format(itemInList, value)));
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

    public void changeCurrency(String newCurrency) {
        Select currency = new Select(driver.findElement(currencyList));
        currency.selectByValue(newCurrency);
        wait.until(ExpectedConditions.presenceOfElementLocated(currencyList));
    }


}
