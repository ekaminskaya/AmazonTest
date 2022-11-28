import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LanguagePageTests extends BaseTest {
    LanguagePage languagePage = new LanguagePage();

    @BeforeTest
    public void beforeTest() {
        languagePage.openPage();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    @Test
    public void verifyDefaultLanguage() {
        Assert.assertTrue(languagePage.isLanguageChecked(Language.EN), languagePage.LANGUAGE_IS_NOT_SELECTED_TEXT);
        Assert.assertEquals(languagePage.getLanguageValue(Language.EN), "English - EN");
    }

    @Test
    public void verifyDefaultCurrency() {
        Assert.assertEquals(languagePage.getDefaultCurrency(), "$ - USD - US Dollar (Default)");
    }

    @Test
    public void verifyCurrencyChange() {
        languagePage.closePopUpIfPresent();
        languagePage.changeCurrency(Currency.PLN);
        Assert.assertEquals(languagePage.getDefaultCurrency(), "PLN - Polish Zloty");
    }

}
