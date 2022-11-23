import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Element implements WebElement {

    protected static WebDriver driver = BaseDriver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    protected WebElement element;

    public Element(WebElement element){
        this.element=element;
    }

    public Element find(By locator) {
        element = driver.findElement(locator);
        return new Element(element);
    }

    public List<Element> findAllElements(By locator) {
        List<Element> myElements = new ArrayList<>();
        for (WebElement element : driver.findElements(locator)){
            myElements.add(new Element(element));
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
        element.sendKeys(keysToSend);
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
        return element.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return element.isEnabled();
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
        return element.isDisplayed();
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
        return element.getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }
}
