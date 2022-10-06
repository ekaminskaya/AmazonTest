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
        Assert.assertTrue(languagePage.isLanguageChecked(Language.EN), "Language is not selected");
        Assert.assertEquals(languagePage.getLanguageValue(Language.EN), "English - EN");
    }

    @Test
    public void verifyDefaultCurrency() {
        Assert.assertEquals(languagePage.getDefaultCurrency(), "$ - USD - US Dollar (Default)");
    }

    @Test
    public void verifyCurrencyChange() {
        languagePage.changeCurrency(Currency.IDR);
        Assert.assertEquals(languagePage.getDefaultCurrency(), "IDR - Indonesian Rupiah");
    }
}
