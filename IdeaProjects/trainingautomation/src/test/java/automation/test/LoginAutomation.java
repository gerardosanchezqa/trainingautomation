package automation.test;

import automation.component.HomePage;
import automation.component.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginAutomation {

    private WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }

    @Test(priority = 0)
    public void login_test(){
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals("My Store", homePage.getPageTitle());
        Assert.assertTrue(homePage.isLoginButtonViisble());
        LoginPage loginPage = homePage.clickLoginButton();
        Assert.assertEquals("Login - My Store", loginPage.getPageTitle());
        homePage = loginPage.setEmailInput("geraautomationtest@test.com")
                .setPasswordInput("geraautomation")
                .clickSignInButton();
        Assert.assertEquals("My account - My Store", homePage.getPageTitle());
        Assert.assertTrue(homePage.isLogoutButtonViisble());
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }

}