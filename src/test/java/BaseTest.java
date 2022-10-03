import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest {
    protected WebDriver driver = BaseDriver.initDriver();
//     protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    protected String baseUrl = "https://www.amazon.com/";

    BasePage basePage = new BasePage();
    HomePage homePage = new HomePage();
    LanguagePage languagePage = new LanguagePage();
    SignUpPage signUpPage = new SignUpPage();

    @BeforeTest
    public void beforeTest(){
        basePage.openSite(baseUrl);
    }
    
    @AfterTest
    public void afterTest(){
        driver.quit();
    }

    @Test
    public void verifyDefaultLanguage() {
       homePage.clickOnLanquageChange();
        Assert.assertTrue(languagePage.isLanguageChecked(Language.EN), "Language is not selected");
        Assert.assertEquals(languagePage.getLanguageValue(Language.EN), "English - EN");
    }

    @Test
    public void verifyDefaultCurrency(){
        homePage.clickOnLanquageChange();
        Assert.assertEquals(languagePage.getDefaultCurrency(),"$ - USD - US Dollar (Default)");
    }

    @Test
    public void verifyCurrencyChange(){
        homePage.clickOnLanquageChange();
        languagePage.changeCurrency("PLN");
        Assert.assertEquals(languagePage.getDefaultCurrency(),"PLN - Polish Zloty");
    }

    @Test
    public void verifyButtonChangeDuringLogin() {
        homePage.clickOnSignIn();
        signUpPage.clickOnCreateAccountButton();
//        wait.until(ExpectedConditions.presenceOfElementLocated(signUpPage.createAccountFormHeader));
        signUpPage.fillUserName("Helen");
        signUpPage.fillEmailField("testHelen@gmail.com");
        signUpPage.fillPasswordField("QWERTY123");
        Assert.assertEquals(signUpPage.getContinueButtonText(), "Verify email");
    }

    @Test
    public void verifyForgotPasswordFormHeader() {
        homePage.clickOnSignIn();
        signUpPage.clickOnNeedHelpLink();
        signUpPage.clickOnForgotPasswordLink();
        Assert.assertEquals(signUpPage.getForgotPasswordFormHeader(), "Password assistance");
    }

}
