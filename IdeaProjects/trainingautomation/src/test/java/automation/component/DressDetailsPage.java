package automation.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DressDetailsPage extends BasePage {

    @FindBy(id = "our_price_display")
    @CacheLookup
    WebElement dressDetailsCurrentPrice;

    @FindBy(id = "old_price_display")
    @CacheLookup
    WebElement dressDetailsOldPrice;

    @FindBy(id = "reduction_percent_display")
    @CacheLookup
    WebElement dressDetailsDiscount;

    @FindBy(css = "h1, itemprop")
    @CacheLookup
    WebElement dressDetailsName;

    public DressDetailsPage(WebDriver webDriver, PagesFactory pagesFactory) {
        super(webDriver, pagesFactory);
    }

    public String getDressDetailsCurrentPrice() {
        return getElementPrice(dressDetailsCurrentPrice);
    }

    public String getDressDetailsOldPrice() {
        return getElementPrice(dressDetailsOldPrice);
    }

    public String getDressDetailsDiscount() {
        return dressDetailsDiscount.getText().replaceAll("[%]", "");
    }

    public String getDressDetailsName() {
        return dressDetailsName.getText();
    }
}
