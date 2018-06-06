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

    @FindBy(className = "fancybox-overlay")
    @CacheLookup
    WebElement fancyBoxOverlay;

    @FindBy(className = "fancybox-close")
    @CacheLookup
    WebElement fancyBoxClose;

    @FindBy(css = "#homeslider > li")
    @CacheLookup
    public List<WebElement> imagesArray;

    @FindBy(css = "#homefeatured > li")
    @CacheLookup
    public List<WebElement> listOfDresses;


    public HomePage(WebDriver webDriver, PagesFactory pagesFactory) {
        super(webDriver, pagesFactory);
    }

    public boolean checkImageVisibility(int imageIndex) {
        return checkVisibility(imagesArray.get(imageIndex));

    }

    public boolean isFancyBoxVisible() {
        return checkVisibility(fancyBoxOverlay);
    }

    public void closeFancyBox() {
        click(fancyBoxClose);
    }

    public void clickImageSliderNext(){
        imageSliderNext.click();
    }

    public void clickImageSliderPrevious(){
        imageSliderPrevious.click();
    }

    public WebElement getElementFromDressName(String dressName){
        return findDressInDressList(listOfDresses, dressName);
    }
}
