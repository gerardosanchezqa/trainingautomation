package automation.test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(automation.test.ListenerTest.class)

public class EndToEndTest extends BaseTestCase {

    String dressName = "Printed Chiffon Dress";
    String dressCurrentPrice;
    String dressOldPrice;
    String dressDiscount;
    WebElement selectedDress;
    String orderConfirmationString;

    @Test(priority = 0)
    public void verifyDiscountsOnHomePage() {
        homePage = goToWebsite("http://automationpractice.com/");
        selectedDress = homePage.getElementFromDressName("Printed Chiffon Dress");
        dressDetailsPage = homePage.clickMoreButton(selectedDress);
        Assert.assertEquals("Printed Chiffon Dress - My Store", homePage.getPageTitle());
        dressDetailsPage.increaseDressQuantity(2);
        dressDetailsPage.selectSizeByTitle("L");
        dressDetailsPage.addDressToCart();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(dressDetailsPage.isSuccessIconVisible());
        Assert.assertEquals("3", dressDetailsPage.getDressQuantity());
        Assert.assertEquals("Yellow, L", dressDetailsPage.getDressColorAndSize());
        shoppingCartPage = dressDetailsPage.clickGoToCheckoutButton();
        Assert.assertEquals("Your shopping cart", shoppingCartPage.getCurrentPageBreadcrumbs());
        Assert.assertTrue(shoppingCartPage.isNavBarVisible());
        loginPage = shoppingCartPage.clickProceedToCheckoutButton();
        Assert.assertEquals("Authentication", loginPage.getCurrentPageBreadcrumbs());
        Assert.assertTrue(loginPage.isNavBarVisible());
        Assert.assertEquals("Login - My Store", loginPage.getPageTitle());
        shoppingCartPage = loginPage.setEmailInput("geraautomationtest@test.com").setPasswordInput("geraautomation").clickSignInButtonReturnToCart();
        Assert.assertTrue(shoppingCartPage.isNavBarVisible());
        Assert.assertEquals("Addresses", shoppingCartPage.getCurrentPageBreadcrumbs());
        shoppingCartPage.clickProceedToShippingButton();
        Assert.assertEquals("Shipping", shoppingCartPage.getCurrentPageBreadcrumbs());
        shoppingCartPage.clickAgreeToTermsCheckbox().clickProceedToCheckoutButton();
        Assert.assertEquals("Your payment method", shoppingCartPage.getCurrentPageBreadcrumbs());
        shoppingCartPage.clickPayByBankWireButton();
        Assert.assertEquals("Bank-wire payment.", shoppingCartPage.getCurrentPageBreadcrumbs());
        shoppingCartPage.clickConfirmOrderButton();
        Assert.assertEquals("Order confirmation", shoppingCartPage.getCurrentPageBreadcrumbs());
        orderConfirmationString = shoppingCartPage.getOrderConfirmationInformationString();
        Assert.assertTrue(shoppingCartPage.isOrderConfirmed());
        orderHistoryPage = shoppingCartPage.clickGoToMyAccountButton().clickOrderHistoryButton();
        Assert.assertTrue(orderHistoryPage.isOrderConfirmed(orderConfirmationString));
    }
}