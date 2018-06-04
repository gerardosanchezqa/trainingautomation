package automation.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    @CacheLookup
    WebElement emailInput;

    @FindBy(id = "passwd")
    @CacheLookup
    WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    @CacheLookup
    WebElement signInButton;

    public LoginPage(WebDriver webDriver, PagesFactory pagesFactory) {
        super(webDriver, pagesFactory);
    }

    public LoginPage setEmailInput(String inputText) {

        sendKeys(emailInput, inputText);
        return withPage().loginPage();

    }

    public LoginPage setPasswordInput(String inputText) {

        sendKeys(passwordInput, inputText);
        return withPage().loginPage();
    }

    public HomePage clickSignInButton() {

        click(signInButton);
        return withPage().homePage();
    }
}