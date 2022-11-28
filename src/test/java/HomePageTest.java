import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{
    HomePage homePage = new HomePage();

    @BeforeTest
    public void beforeTest(){
        homePage.openPage();
    }

    @AfterTest
    public void afterTest(){driver.quit();}

    @Test
    public void verifyGamingAccessoriesCardItemsSize(){
        Assert.assertEquals(homePage.getGamingAccessoriesCardItemsListSize(), 4);
    }

    @Test
    public void verifySignInButton(){
        homePage.clickOnSignIn();
        Assert.assertEquals(homePage.getSignInPageHeader(), homePage.SIGN_IN_PAGE_HEADER_TEXT);
    }

    @Test
    public void verifyLanguageChangeButton(){
        homePage.clickOnLanguageChange();
        Assert.assertEquals(homePage.getLanguagePageHeader(), homePage.LANGUAGE_PAGE_HEADER_TEXT);
    }

    @Test
    public void verifyDeliverToButton(){
        homePage.clickOnDeliverTo();
        Assert.assertEquals(homePage.getDeliverToWindowHeader(), homePage.DELIVER_TO_PAGE_HEADER_TEXT);
    }

    @Test
    public void verifyDismissButton(){
        homePage.clickOnDismissButton();
        Assert.assertFalse(homePage.isDeliveryAlertDisplay(), "Alert is shown");
    }

    @Test
    public void verifyHamburgerMenu(){
        homePage.clickOnHamburgerMenu();
        Assert.assertTrue(homePage.isHamburgerMenuDisplay(), "Hamburger Menu is not shown");
    }

    @Test
    public void verifySearchField(){
        Assert.assertEquals(homePage.getSearchResultInfo("Laptop"), "laptop");
    }


}
