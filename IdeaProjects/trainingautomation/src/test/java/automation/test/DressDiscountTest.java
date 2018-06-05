package automation.test;

        import org.openqa.selenium.By;
        import org.testng.Assert;
        import org.testng.annotations.Listeners;
        import org.testng.annotations.Test;

@Listeners(automation.test.ListenerTest.class)

public class DressDiscountTest extends BaseTestCase {

    @Test(priority = 0)
    public void verifyDiscountsOnHomePage() {
        homePage = goToWebsite("http://automationpractice.com/");
        Assert.assertEquals("My Store", homePage.getPageTitle());
        Assert.assertEquals("$16.40", homePage.getElementPrice(homePage.getElementFromDressName("Printed Chiffon Dress")));
        //System.out.println(homePage.getElementFromDressName("Printed Chiffon Dress").findElement(By.className("price")).getText());
    }

}