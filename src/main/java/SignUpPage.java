import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SignUpPage extends BasePage {
    protected String url = "/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&";

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
        super.openPage(url);
    }

    public void fillUserName(String userName) {
        driver.findElement(userNameField).sendKeys(userName);
    }

    public void fillEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickOnCreateAccountButton() {
        driver.findElement(createAccountButton).click();
    }

    public String getContinueButtonText() {
        WebElement buttonText = driver.findElement(continueVerifyButton).findElement(By.xpath("//span[@class='email-text']"));
        return buttonText.getText();
    }

    public void fillPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickOnNeedHelpLink() {
        driver.findElement(needHelpLink).click();
    }


    public void clickOnForgotPasswordLink() {
        driver.findElement(forgotPasswordLink).click();
    }

    public String getForgotPasswordFormHeader() {
        return driver.findElement(forgotPasswordFormHeader).getText();
    }


}
