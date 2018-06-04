package automation.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private By emailInput = By.id("email");

    private By passwordInput = By.id("passwd");

    private By signInButton = By.id("SubmitLogin");

    LoginPage(WebDriver driver){

        this.driver = driver;

    }

    public LoginPage setEmailInput(String inputText){

        sendKeys(emailInput, inputText);
        return new LoginPage(driver);

    }

    public LoginPage setPasswordInput(String inputText){

        sendKeys(passwordInput, inputText);
        return new LoginPage(driver);
    }

    public HomePage clickSignInButton(){

        click(signInButton);
        return new HomePage(driver);
    }
}