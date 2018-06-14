package automation.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    @FindBy(className = "icon-list-ol")
    @CacheLookup
    private WebElement orderHistoryButton;


    public MyAccountPage(WebDriver webDriver, PagesFactory pagesFactory) {
        super(webDriver, pagesFactory);
    }

    public OrderHistoryPage clickOrderHistoryButton() {
        click(orderHistoryButton);
        return withPage().orderHistoryPage();
    }
}