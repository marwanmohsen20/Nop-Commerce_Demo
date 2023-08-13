package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemData extends BasePage {
   private WebDriver driver;
    public ItemData(WebDriver driver){
        this.driver=driver;
    }
   private  By addToCartButton= By.xpath("//button[@class='button-1 add-to-cart-button']");
    private WebElement addToCartButtonElement;


    private By successFlashAlert=By.linkText("shopping cart");
    WebElement successFlashElement;
    private By closeAlert=By.className("close");
    WebElement closeAlertElement;
    public By getSuccessFlashAlert() {
        return successFlashAlert;
    }

    private By ShoppingCart=By.linkText("shopping cart");
    private WebElement SHoppingCartElement;

    public void clickShoppingCart(){
        SHoppingCartElement=driver.findElement(ShoppingCart);
        clickingByWebElement(SHoppingCartElement);

    }



    public void clickaddtocart(){

        addToCartButtonElement=driver.findElement(addToCartButton);
        clickingByWebElement(addToCartButtonElement);
    }
    public void clickandclose()
    {
        closeAlertElement=driver.findElement(closeAlert);
        clickingByWebElement(closeAlertElement);
    }




}
