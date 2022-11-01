import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class Element implements WebElement {

    protected static WebDriver driver = BaseDriver.getDriver();
    protected WebDriverWait wait;
    protected WebElement element;

    public static Element find(By locator) {
        Element myElement = new Element();
        myElement = (Element) driver.findElement(locator);
        return myElement;
    }

    public static List<Element> findAllElements(By locator) {
        List<Element> myElements = null;
        for (WebElement element : driver.findElements(locator)){
            myElements.add((Element) element);
        }
        return myElements;
    }

    @Override
    public void click() {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    @Override
    public void submit() {
     wait.until(ExpectedConditions.elementToBeClickable(element));
     element.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        clear();
        element.sendKeys();
    }

    @Override
    public void clear() {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
    }

    @Override
    public String getTagName() {
        return element.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return element.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return element.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return element.getLocation();
    }

    @Override
    public Dimension getSize() {
        return element.getSize();
    }

    @Override
    public Rectangle getRect() {
        return element.getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }
}
