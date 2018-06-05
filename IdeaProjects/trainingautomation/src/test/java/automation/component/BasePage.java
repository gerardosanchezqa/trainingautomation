package automation.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    public BasePage(WebDriver webDriver, PagesFactory pagesFactory) {
        super(webDriver);
        this._webDriver = getWebDriver();
        this._pagesFactory = pagesFactory;
    }

    public void click(WebElement webElement) {

        webElement.click();
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

    public boolean checkVisibility(WebElement webElement) {

        return webElement.isDisplayed();

    }

    public WebElement findDressInDressList(List<WebElement> listToIterate, String wantedText){
        for (WebElement element : listToIterate){
            if(element.findElement(By.cssSelector("div div.left-block div a.product_img_link img")).getAttribute("alt").equals(wantedText)){
                //System.out.println(element.getAttribute("class"));
                return element.findElement(By.cssSelector("div div.right-block div.content_price"));
            }
        }
        return null;
    }

    public String getElementPrice(WebElement element){
        return element.findElement(By.className("price")).getText();
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