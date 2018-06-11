package automation.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(automation.test.ListenerTest.class)

public class LoginAutomation extends BaseTestCase {

    @Test(priority = 0)
    public void login_test() {
        homePage = goToWebsite("http://automationpractice.com/index.php");
        Assert.assertEquals("My Store", homePage.getPageTitle());
        Assert.assertTrue(homePage.isLoginButtonVisible());
        loginPage = homePage.clickLoginButton();
        Assert.assertEquals("Login - My Store", loginPage.getPageTitle());
        homePage = loginPage.setEmailInput("geraautomationtest@test.com").setPasswordInput("geraautomation").clickSignInButton();
        Assert.assertEquals("My account - My Store", homePage.getPageTitle());
        Assert.assertTrue(homePage.isLogoutButtonVisible());
    }

    @Test(priority = 1)
    public void logout_test() {
        homePage.clickLogoutButton();
        Assert.assertEquals("Login - My Store", homePage.getPageTitle());
        Assert.assertTrue(loginPage.isLoginButtonVisible());
    }

    @Test(priority = 2)
    public void goToHomePageAndScrollThroughImages() {
        homePage = loginPage.returnToHomePage();
        Assert.assertEquals("My Store", homePage.getPageTitle());
        Assert.assertTrue(homePage.checkImageVisibility(1));
        Assert.assertFalse(homePage.checkImageVisibility(3));
        homePage.clickImageSliderNext();
        try{Thread.sleep(1000);}catch(InterruptedException e){e.printStackTrace();}
        homePage.clickImageSliderNext();
        try{Thread.sleep(1000);}catch(InterruptedException e){e.printStackTrace();}
        Assert.assertTrue(homePage.checkImageVisibility(3));
        Assert.assertFalse(homePage.checkImageVisibility(1));
    }
}