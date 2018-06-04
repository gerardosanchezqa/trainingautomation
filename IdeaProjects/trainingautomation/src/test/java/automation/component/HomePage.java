package automation.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private By loginButton = By.className("login");

    private By logoutButton = By.className("logout");

    public HomePage(WebDriver driver){

        this.driver = driver;

    }

    public LoginPage clickLoginButton(){

        click(loginButton);
        return new LoginPage(driver);

    }

    public boolean isLoginButtonViisble(){

        return checkVisibility(loginButton);

    }

    public boolean isLogoutButtonViisble(){

        return checkVisibility(logoutButton);

    }
}