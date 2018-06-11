package automation.test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(automation.test.ListenerTest.class)

public class DressDiscountTest extends BaseTestCase {

    String dressName = "Printed Chiffon Dress";
    String dressCurrentPrice;
    String dressOldPrice;
    String dressDiscount;
    WebElement selectedDress;

    @Test(priority = 0)
    public void verifyDiscountsOnHomePage() {
        homePage = goToWebsite("http://automationpractice.com/");
        selectedDress = homePage.getElementFromDressName("Printed Chiffon Dress");
        Assert.assertEquals("My Store", homePage.getPageTitle());
        dressCurrentPrice = homePage.getDressCurrentPrice(selectedDress);
        Assert.assertEquals("16.40", dressCurrentPrice);
        dressOldPrice = homePage.getDressOldPrice(selectedDress);
        Assert.assertEquals("20.50", dressOldPrice);
        dressDiscount = homePage.getDressDiscount(selectedDress);
        Assert.assertEquals("-20", dressDiscount);
        Assert.assertEquals(20.50, Double.parseDouble(dressCurrentPrice)+
                Math.abs((Double.parseDouble((dressOldPrice)) * (Double.parseDouble((dressDiscount))) / 100)));
    }

    @Test(priority = 1)
    public void verifyQuickViewOpensAndCloses() {
        homePage.clickQuickViewButton(selectedDress);
        Assert.assertTrue(homePage.isFancyBoxVisible());
        homePage.closeFancyBox();
    }

    @Test(priority = 2)
    public void verifyDressDetailsPricesAndName() {
        try{Thread.sleep(1000);}catch(InterruptedException e){e.printStackTrace();}
        dressDetailsPage = homePage.clickMoreButton(selectedDress);
        Assert.assertEquals("Printed Chiffon Dress - My Store", homePage.getPageTitle());
        Assert.assertEquals(dressName, dressDetailsPage.getDressDetailsName());
        Assert.assertEquals(dressCurrentPrice, dressDetailsPage.getDressDetailsCurrentPrice());
        Assert.assertEquals(dressOldPrice, dressDetailsPage.getDressDetailsOldPrice());
        Assert.assertEquals(dressDiscount, dressDetailsPage.getDressDetailsDiscount());
    }
}