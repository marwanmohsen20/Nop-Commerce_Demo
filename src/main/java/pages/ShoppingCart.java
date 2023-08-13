package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCart extends BasePage{
    private WebDriver driver;
    private HomePage homePage;
    public ShoppingCart(WebDriver driver){
        this.driver=driver;
    }
    private By continueShoppingButton=By.name("continueshopping");
    WebElement continueShoppingButtonElement;

    private By removeItemButton=By.className("remove-btn");
    WebElement removeItemButtonElement;


    private By agreeTermsBox=By.id("termsofservice");
    WebElement agreeTermsBoxElement;

    private By checkOutButton=By.name("checkout");
    WebElement checkOutButtonElement;

    public HomePage clickContinueButton(){
        continueShoppingButtonElement=driver.findElement(continueShoppingButton);
        clickingByWebElement(continueShoppingButtonElement);
        return new HomePage(driver);
    }
    public void removeItem(){
        removeItemButtonElement=driver.findElement(removeItemButton);
        clickingByWebElement(removeItemButtonElement);
    }
    public void clicktermsOfService(){
        agreeTermsBoxElement= driver.findElement(agreeTermsBox);
        clickingByWebElement(agreeTermsBoxElement);
    }
    public void clickCheckout(){
        checkOutButtonElement= driver.findElement(checkOutButton);
        clickingByWebElement(checkOutButtonElement);
    }
    public Checkout completeCheckout(){
        clicktermsOfService();
        clickCheckout();
        return new Checkout(driver);
    }
}
