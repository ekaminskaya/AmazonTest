
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SignUpPage extends BasePage {
    private static final String URL = "/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&";
    protected String buttonText = "Verify email";

    private By userNameField = By.xpath(".//input[@id='ap_customer_name']");
    private By emailField = By.xpath("//*[@id='ap_email']");
    private By passwordField = By.xpath("//*[@id='ap_password']");
    private By forgotPasswordLink = By.xpath("//*[@id='auth-fpp-link-bottom']");
    private By createAccountButton = By.xpath("//*[@id='createAccountSubmit']");
    private By continueVerifyButton = By.xpath("//*[@id='auth-continue-announce']");
    private By forgotPasswordFormHeader = By.xpath("//form[@name='forgotPassword']/h1");
    private By createAccountFormHeader = By.xpath("//h1[contains(text(),'Create account')]");
    private By needHelpLink = By.xpath("//*[@class='a-expander-prompt']/ancestor::a");

    protected void openPage() {
        log.info("Open the 'SignUp' page");
        super.openPage(URL);
    }

    public void fillUserName(String userName) {
        log.info("Fill 'userName' field" + userName);
        find(userNameField).sendKeys(userName);
    }

    public void fillEmailField(String email) {
        log.info("Fill 'email' field" + email);
        find(emailField).sendKeys(email);
    }

    public void clickOnCreateAccountButton() {
        log.info("Click 'createAccount' button");
        find(createAccountButton).click();
    }

    public String getContinueButtonText() {
        log.info("Find 'continue' button");
        WebElement buttonText = find(continueVerifyButton).find(By.xpath("//span[@class='email-text']"));
        return buttonText.getText();
    }

    public void fillPasswordField(String password) {
        log.info("Fill 'password' field" + password);
        find(passwordField).sendKeys(password);
    }

    public void clickOnNeedHelpLink() {
        log.info("Click 'NeedHelp' link");
        find(needHelpLink).click();

    }

    public void clickOnForgotPasswordLink() {
        log.info("Click 'ForgotPassword' link");
        find(forgotPasswordLink).click();

    }

    public String getForgotPasswordFormHeader() {
        log.info("Open 'Forgot password' page");
        return find(forgotPasswordFormHeader).getText();
    }

}
