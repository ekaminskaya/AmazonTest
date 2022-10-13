import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SignUpPage extends BasePage {
    private static final Logger log = LogManager.getLogger(SignUpPage.class);
    private static final String URL = "/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&";
    protected String buttonText = "Verify email";

    public By userNameField = By.xpath(".//input[@id='ap_customer_name']");
    public By emailField = By.xpath("//*[@id='ap_email']");
    public By passwordField = By.xpath("//*[@id='ap_password']");
    public By forgotPasswordLink = By.xpath("//*[@id='auth-fpp-link-bottom']");
    public By createAccountButton = By.xpath("//*[@id='createAccountSubmit']");
    public By continueVerifyButton = By.xpath("//*[@id='auth-continue-announce']");
    public By forgotPasswordFormHeader = By.xpath("//form[@name='forgotPassword']/h1");
    public By createAccountFormHeader = By.xpath("//h1[contains(text(),'Create account')]");
    public By needHelpLink = By.xpath("//*[@class='a-expander-prompt']/ancestor::a");

    protected void openPage() {
        log.info("Open the 'SignUp' page");
        super.openPage(URL);
    }

    public void fillUserName(String userName) {
        log.info("Fill 'userName' field");
        driver.findElement(userNameField).sendKeys(userName);
    }

    public void fillEmailField(String email) {
        log.info("Fill 'email' field");
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickOnCreateAccountButton() {
        log.info("Click 'createAccount' button");
        driver.findElement(createAccountButton).click();
    }

    public String getContinueButtonText() {
        log.info("Find 'continue' button");
        WebElement buttonText = driver.findElement(continueVerifyButton).findElement(By.xpath("//span[@class='email-text']"));
        return buttonText.getText();
    }

    public void fillPasswordField(String password) {
        log.info("Fill 'password' field");
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickOnNeedHelpLink() {
        log.info("Click 'NeedHelp' link");
        driver.findElement(needHelpLink).click();

    }

    public void clickOnForgotPasswordLink() {
        log.info("Click 'ForgotPassword' link");
        driver.findElement(forgotPasswordLink).click();

    }

    public String getForgotPasswordFormHeader() {
        log.info("Open 'Forgot password' page");
        return driver.findElement(forgotPasswordFormHeader).getText();
    }

    public void fillPasswordField2(String password) {
        log.info("Fill 'password' field");
        element.findMyElement(passwordField).sendKeys(password);
    }

}
