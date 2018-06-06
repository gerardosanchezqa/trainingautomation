package automation.test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(automation.test.ListenerTest.class)

public class DressDiscountTest extends BaseTestCase {

    String dressName = "Printed Chiffon Dress";
    WebElement selectedDress;

    @Test(priority = 0)
    public void verifyDiscountsOnHomePage() {
        homePage = goToWebsite("http://automationpractice.com/");
        selectedDress = homePage.getElementFromDressName("Printed Chiffon Dress");
        Assert.assertEquals("My Store", homePage.getPageTitle());
        Assert.assertEquals("16.40", homePage.getDressCurrentPrice(selectedDress));
        Assert.assertEquals("20.50", homePage.getDressOldPrice(selectedDress));
        Assert.assertEquals("-20", homePage.getDressDiscount(selectedDress));
        Assert.assertEquals(20.50, Double.parseDouble(homePage.getDressCurrentPrice(selectedDress))
                +Math.abs((Double.parseDouble((homePage.getDressOldPrice(selectedDress)))
                        *(Double.parseDouble((homePage.getDressDiscount(selectedDress))))/100))
                );
    }

    @Test(priority = 1)
    public void verifyQuickViewOpensAndCloses() {

        homePage.clickQuickViewButton(selectedDress);
        Assert.assertTrue(homePage.isFancyBoxVisible());
        homePage.closeFancyBox();
    }

    /*@Test(priority = 2)
    public void verifyClickDressImage() {
        homePage.clickDressImage(selectedDress);
        Assert.assertEquals("Printed Chiffon Dress - My Store", homePage.getPageTitle());
    }*/
}