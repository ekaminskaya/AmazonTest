import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUpPageTests extends BaseTest{

    SignUpPage signUpPage = new SignUpPage();

    @BeforeTest
    public void beforeTest(){
        signUpPage.openPage();
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

    @Test
    public void verifyCreateAccountButton(){
        signUpPage.clickOnCreateAccountButton();
        Assert.assertEquals(signUpPage.getCreateAccountFormHeader(), "Create account");
    }

    @Test
    public void verifyButtonChangeDuringLogin() {
        signUpPage.clickOnCreateAccountButton();
        signUpPage.fillUserName("Helen");
        signUpPage.fillEmailField("testHelen@gmail.com");
        signUpPage.fillPasswordField("QWERTY123");
        Assert.assertEquals(signUpPage.getContinueButtonText(), signUpPage.BUTTON_TEXT);
    }

    @Test
    public void verifyForgotPasswordFormHeader() {
        signUpPage.clickOnNeedHelpLink();
        signUpPage.clickOnForgotPasswordLink();
        Assert.assertEquals(signUpPage.getForgotPasswordFormHeader(), "Password assistance");
    }

}
