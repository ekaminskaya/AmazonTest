import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{
    @BeforeTest
    public void beforeTest(){
        homePage.openPage();
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }


}
