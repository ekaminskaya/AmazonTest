import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest {
    protected WebDriver driver = BaseDriver.initDriver();

    BasePage basePage = new BasePage();
    HomePage homePage = new HomePage();
    LanguagePage languagePage = new LanguagePage();
    SignUpPage signUpPage = new SignUpPage();

}
