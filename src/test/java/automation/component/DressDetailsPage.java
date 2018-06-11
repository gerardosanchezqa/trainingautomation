package automation.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DressDetailsPage extends BasePage {

    @FindBy(id = "our_price_display")
    @CacheLookup
    private WebElement dressDetailsCurrentPrice;

    @FindBy(id = "old_price_display")
    @CacheLookup
    private WebElement dressDetailsOldPrice;

    @FindBy(id = "reduction_percent_display")
    @CacheLookup
    private WebElement dressDetailsDiscount;

    @FindBy(css = "h1, itemprop")
    @CacheLookup
    private WebElement dressDetailsName;

    @FindBy(className = "product_quantity_up")
    @CacheLookup
    private WebElement productQuantityUpButton;

    @FindBy(className = "attribute_select")
    @CacheLookup
    private WebElement sizeSelectDropdown;

    @FindBy(id = "add_to_cart")
    @CacheLookup
    private WebElement addToCartButton;

    @FindBy(className = "icon-ok")
    @CacheLookup
    private WebElement successIcon;

    @FindBy(id = "layer_cart_product_attributes")
    @CacheLookup
    private WebElement dressDetailsColorAndSize;

    @FindBy(id = "layer_cart_product_quantity")
    @CacheLookup
    private WebElement dressDetailsQuantity;

    @FindBy(css = "div.button-container > a")
    @CacheLookup
    private WebElement goToCheckoutButton;


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

    public void increaseDressQuantity(int increaseAmount) {
        for (int i = 0; i < increaseAmount; i++) {
            click(productQuantityUpButton);
        }
    }

    public void selectSizeByTitle(String title) {
        Select select = new Select(sizeSelectDropdown);
        select.selectByVisibleText(title);
    }

    public void addDressToCart() {
        click(addToCartButton);
    }

    public boolean isSuccessIconVisible() {
        return checkVisibility(successIcon);
    }

    public String getDressColorAndSize() {
        return dressDetailsColorAndSize.getText();
    }

    public String getDressQuantity() {
        return dressDetailsQuantity.getText();
    }

    public ShoppingCartPage clickGoToCheckoutButton() {
        click(goToCheckoutButton);
        return withPage().shoppingCartPage();
    }
}
