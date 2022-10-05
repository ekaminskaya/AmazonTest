import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUpPageTests extends BaseTest{

    @BeforeTest
    public void beforeTest(){
        signUpPage.openPage();
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

    @Test
    public void verifyButtonChangeDuringLogin() {
        homePage.clickOnSignIn();
        signUpPage.clickOnCreateAccountButton();
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
