package automation.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    @FindBy(className = "standard-checkout")
    @CacheLookup
    private WebElement proceedToCheckoutButton;

    public ShoppingCartPage(WebDriver webDriver, PagesFactory pagesFactory) {
        super(webDriver, pagesFactory);
    }

    public LoginPage clickProceedToCheckoutButton() {
        click(proceedToCheckoutButton);
        return withPage().loginPage();
    }
}