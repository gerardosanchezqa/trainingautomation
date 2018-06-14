package automation.test;

import automation.component.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

/**
 * Created by gsanchez on 3/24/17.
 */
public class BaseTestCase {


    public WebDriver webDriver;
    public PagesFactory pagesFactory;
    HomePage homePage;
    LoginPage loginPage;
    DressDetailsPage dressDetailsPage;
    ShoppingCartPage shoppingCartPage;
    MyAccountPage myAccountPage;
    OrderHistoryPage orderHistoryPage;

    @BeforeTest
    public void before() {
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\Gera\\IdeaProjects\\trainingautomation\\IdeaProjects\\trainingautomation\\chromedriver.exe");

        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pagesFactory = new PagesFactory(webDriver);
}

    public HomePage goToWebsite(String website) {
        webDriver.get(website);
        return new HomePage(webDriver, pagesFactory);
    }

    @AfterTest
    public void after() {
       webDriver.quit();
    }
}