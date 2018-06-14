package automation.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OrderHistoryPage extends BasePage {

    @FindBy(className = "icon-list-ol")
    @CacheLookup
    private WebElement orderHistoryButton;

    @FindBy(css = ".color-myaccount")
    @CacheLookup
    public List<WebElement> listOfOrderConfirmationNumbers;

    public OrderHistoryPage(WebDriver webDriver, PagesFactory pagesFactory) {
        super(webDriver, pagesFactory);
    }

    public Boolean isOrderConfirmed(String orderNumber) {
        for (WebElement element : listOfOrderConfirmationNumbers) {
            if (element.getText().equals(orderNumber)) {
                return true;
            }
        }
        return false;
    }
}



