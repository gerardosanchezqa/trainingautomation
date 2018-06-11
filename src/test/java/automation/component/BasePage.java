package automation.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasePage extends PagesFactory {

    private final PagesFactory _pagesFactory;
    private final WebDriver _webDriver;

    @FindBy(className = "login")
    @CacheLookup
    WebElement loginButton;

    @FindBy(className = "logout")
    @CacheLookup
    WebElement logoutButton;

    @FindBy(className = "logo")
    @CacheLookup
    WebElement logoImage;

    @FindBy(className = "navigation_page")
    @CacheLookup
    WebElement currentPageBreadcrumbs;

    @FindBy(css = ".step.clearfix")
    @CacheLookup
    private WebElement shoppingCartNavigationBar;

    public BasePage(WebDriver webDriver, PagesFactory pagesFactory) {
        super(webDriver);
        this._webDriver = getWebDriver();
        this._pagesFactory = pagesFactory;
    }

    public void click(WebElement webElement) {
        webElement.click();
    }

    public String getCurrentPageBreadcrumbs() {
        return currentPageBreadcrumbs.getText();
    }

    public boolean isNavBarVisible() {
        return checkVisibility(shoppingCartNavigationBar);
    }

    public boolean checkVisibility(WebElement webElement) {
        return webElement.isDisplayed();
    }

    public String getElementPrice(WebElement webElement) {
        return webElement.getText().replaceAll("[$]", "");
    }

    public void sendKeys(WebElement webElement, String inputText) {

        webElement.sendKeys(inputText);
    }

    public LoginPage clickLoginButton() {
        click(loginButton);
        return withPage().loginPage();
    }

    public LoginPage clickLogoutButton() {

        click(logoutButton);
        return withPage().loginPage();

    }

    public boolean isLoginButtonVisible() {

        return checkVisibility(loginButton);

    }

    public boolean isLogoutButtonVisible() {
        return checkVisibility(logoutButton);
    }


    public WebElement findDressInDressList(List<WebElement> listToIterate, String dressName){
        for (WebElement element : listToIterate){
            if(element.findElement(By.className("product_img_link")).getAttribute("title").equals(dressName)){
                return element.findElement(By.cssSelector(".product-container"));
            }
        }
        return null;
    }

    public String getDressCurrentPrice(WebElement element){
        return getElementPrice(element.findElement(By.cssSelector(".right-block .content_price .price.product-price")));
    }

    public String getDressOldPrice(WebElement element){
        return getElementPrice(element.findElement(By.cssSelector(".right-block .content_price .old-price.product-price")));
    }

    public String getDressDiscount(WebElement element){
        return element.findElement(By.cssSelector(".right-block .content_price .price-percent-reduction")).getText().replaceAll("[%]", "");
    }

    public void clickQuickViewButton(WebElement webElement) {
        Actions builder = new Actions(_webDriver);
        builder.moveToElement(webElement).perform();
        builder.moveToElement(webElement.findElement(By.cssSelector(".left-block .quick-view"))).click().perform();
    }

    public DressDetailsPage clickMoreButton(WebElement webElement) {
        Actions builder = new Actions(_webDriver);
        builder.moveToElement(webElement).perform();
        builder.moveToElement(webElement.findElement(By.cssSelector(".right-block a.button.lnk_view"))).click().perform();
        return withPage().dressDetailsPage();
    }

    public HomePage returnToHomePage() {
        logoImage.click();
        return withPage().homePage();
    }

    public void clearAndSendKeys(WebElement webElement, String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    public void selectDropdown(WebElement webElement, String text) {
        new Select(webElement).selectByVisibleText(text);
    }

    public void acceptAlert() {
        getWebDriver().switchTo().alert().accept();
    }

    public String getPageTitle() {

        return _webDriver.getTitle();
    }

    protected List<WebElement> getElementsList(String cssSelector) {
        List<WebElement> webElementsList = getWebDriver().findElements(By.cssSelector(cssSelector));
        return webElementsList;
    }

    protected PagesFactory withPage() {
        return _pagesFactory;
    }
}