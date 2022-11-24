import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{
    HomePage homePage = new HomePage();

    @BeforeTest
    public void beforeMethod(){
        homePage.openPage();
    }

    @Test
    public void verifyGamingAccessoriesCardItemsSize(){
        Assert.assertEquals(homePage.getGamingAccessoriesCardItemsListSize(), 4);
    }
}
