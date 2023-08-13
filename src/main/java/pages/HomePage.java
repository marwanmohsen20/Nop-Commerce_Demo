package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    private WebDriver driver;

    By RegisterButton= By.className("ico-register");

    By LoginButton= By.className("ico-login");
    By LogoutButton=By.className("ico-logout");

    public By getLogoutButton() {
        return LogoutButton;
    }

    By ShoppingCartButton=By.className("ico-cart");

    By homepageImgButton=By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img");
    By searchTextField=By.id("small-searchterms");
    WebElement searchTextFieldElement;
    By searchButton=By.xpath("//*[@id=\"small-search-box-form\"]/button");
    WebElement searchButtonnElement;
    WebElement homepageImgElement;
    WebElement ShoppingCartElement;

    WebElement RegisterButtonElement;

    WebElement LoginButtonElement;

    WebElement LogoutButtonElement;

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    public RegisterPage clickRegister(){
        RegisterButtonElement=driver.findElement(RegisterButton);
        clickingByWebElement(RegisterButtonElement);
        return new RegisterPage(driver);
    }
    public LoginPage clickLogin(){
        LoginButtonElement=driver.findElement(LoginButton);
        clickingByWebElement(LoginButtonElement);
       return new LoginPage(driver);
    }

    public HomePage backHome(){
        homepageImgElement=driver.findElement(homepageImgButton);
        clickingByWebElement(homepageImgElement);
        return new HomePage(driver);
    }
    public void clickLogout(){
        LogoutButtonElement=driver. findElement(LogoutButton);
        clickingByWebElement(LogoutButtonElement);
    }
    public void clickShoppingCart(){

        ShoppingCartElement=driver.findElement(ShoppingCartButton);
        clickingByWebElement(ShoppingCartElement);

    }
    public void SearchforItem(String text){
        searchTextFieldElement=driver.findElement(searchTextField);
        searchButtonnElement=driver.findElement(searchButton);
        sendText(searchTextFieldElement,text);
        clickingByWebElement(searchButtonnElement);
    }




    public ItemData clickingitemdata(String element){
        driver.findElement(By.partialLinkText(element)).click();
        return new ItemData(driver);
    }





}
