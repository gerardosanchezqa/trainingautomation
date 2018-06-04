package automation.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class BasePage {

    WebDriver driver;

    void click(By element){

        driver.findElement(element).click();
    }

    void sendKeys(By element, String inputText){

        driver.findElement(element).sendKeys(inputText);
    }

    boolean checkVisibility(By element){

        return driver.findElement(element).isDisplayed();

    }

    public String getPageTitle(){

        return driver.getTitle();
    }
}