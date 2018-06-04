package automation.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(className = "bx-prev")
    @CacheLookup
    WebElement imageSliderPrevious;

    @FindBy(className = "bx-next")
    @CacheLookup
    WebElement imageSliderNext;

    @FindBy(css = "#homeslider > li")
    @CacheLookup
    public List<WebElement> imagesArray;


    public HomePage(WebDriver webDriver, PagesFactory pagesFactory) {
        super(webDriver, pagesFactory);
    }

    public boolean checkImageVisibility(int imageIndex) {
        return checkVisibility(imagesArray.get(imageIndex));

    }

    public void clickImageSliderNext(){
        imageSliderNext.click();
    }

    public void clickImageSliderPrevious(){

    }

}