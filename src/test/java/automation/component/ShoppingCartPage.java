package automation.component;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    @FindBy(className = "standard-checkout")
    @CacheLookup
    private WebElement proceedToCheckoutButton;

    @FindBy(name = "processAddress")
    @CacheLookup
    private WebElement proceedToShippingButton;

    @FindBy(className = "checker")
    @CacheLookup
    private WebElement agreeToTermsCheckbox;

    @FindBy(className = "bankwire")
    @CacheLookup
    private WebElement payByBankWireButton;

    @FindBy(css = "#cart_navigation > button")
    @CacheLookup
    private WebElement confirmOrderButton;

    @FindBy(css = ".cheque-indent")
    @CacheLookup
    private WebElement orderConfirmedText;

    @FindBy(className = "box")
    @CacheLookup
    private WebElement orderConfirmationInformation;



    public ShoppingCartPage(WebDriver webDriver, PagesFactory pagesFactory) {
        super(webDriver, pagesFactory);
    }

    public LoginPage clickProceedToCheckoutButton() {
        click(proceedToCheckoutButton);
        return withPage().loginPage();
    }

    public ShoppingCartPage clickProceedToShippingButton() {
        click(proceedToShippingButton);
        return withPage().shoppingCartPage();
    }

    public ShoppingCartPage clickAgreeToTermsCheckbox() {
        click(agreeToTermsCheckbox);
        return withPage().shoppingCartPage();
    }

    public ShoppingCartPage clickPayByBankWireButton() {
        click(payByBankWireButton);
        return withPage().shoppingCartPage();
    }

    public ShoppingCartPage clickConfirmOrderButton() {
        click(confirmOrderButton);
        return withPage().shoppingCartPage();
    }

    public Boolean isOrderConfirmed() {
        System.out.println(orderConfirmedText.getText());
        if (orderConfirmedText.getText().equals("Your order on My Store is complete.")) {
            return true;
        } else {
            return false;
        }
    }

    public String getOrderConfirmationInformationString() {
        return StringUtils.substringBetween(orderConfirmationInformation.getText(), "order reference ", " in the subject");
    }

}