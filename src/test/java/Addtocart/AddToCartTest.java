package Addtocart;

import BaseTest.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

public class AddToCartTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    ItemData itemData;
    ShoppingCart shoppingCart;
    Checkout checkout;



    @BeforeTest
    public void calltest(){

        setup();
        homePage=new HomePage(driver);
        loginPage=new LoginPage(driver);
        itemData=new ItemData(driver);
        shoppingCart=new ShoppingCart(driver);
        checkout=new Checkout(driver);

    }

    @Test(priority = 1)
    public void Add1itemToCart() throws InterruptedException {
        loginPage.login("marwan22@gmail.com","maromoh1");
        homePage.clickingitemdata("HTC");
        Thread.sleep(4000);
        itemData.clickaddtocart();
        homePage.clickShoppingCart();
        shoppingCart.clickContinueButton();
        homePage.backHome();


    }
    @Test(priority = 2)
    public void removeItem1ToCart() throws InterruptedException {

        homePage.clickShoppingCart();
        shoppingCart.removeItem();
        homePage.backHome();





    }
    @Test
    public void SearchAndAdd() throws InterruptedException {
        loginPage.login("marwan22@gmail.com","maromoh1");
        homePage.SearchforItem("laptop");
        homePage.clickingitemdata("Lenovo");
        Thread.sleep(3000);
        itemData.clickaddtocart();
        Assert.assertTrue(control.isDisplay(itemData.getSuccessFlashAlert()));
        homePage.backHome();
    }
    @Test
    public void Add2items() throws InterruptedException {
        loginPage.login("marwan22@gmail.com","maromoh1");
        homePage.clickingitemdata("HTC");
        Thread.sleep(3000);
        itemData.clickaddtocart();
        Assert.assertTrue(control.isDisplay(itemData.getSuccessFlashAlert()));
        homePage.backHome();
        homePage.SearchforItem("laptop");
        homePage.clickingitemdata("Lenovo");
        Thread.sleep(3000);
        itemData.clickaddtocart();
        Assert.assertTrue(control.isDisplaying(itemData.getSuccessFlashAlert(),driver));
        itemData.clickShoppingCart();
        homePage.backHome();

    }
    @Test()
    public void selectFromDashBar() throws InterruptedException {

            loginPage.login("marwan22@gmail.com","maromoh1");
            control.moveAndHover("Computers");
            control.clickByName("Notebooks");
            homePage.clickingitemdata("HP Envy");
            Thread.sleep(3000);
            itemData.clickaddtocart();
        Assert.assertTrue(control.isDisplay(itemData.getSuccessFlashAlert()));

        itemData.clickShoppingCart();


        }



    @Test
    public void compeleteCheckout() throws InterruptedException {
        loginPage.login("marwan22@gmail.com","maromoh1");
        homePage.clickingitemdata("HTC");
        Thread.sleep(3000);
        itemData.clickaddtocart();

        Assert.assertTrue(control.isDisplay(itemData.getSuccessFlashAlert()));
        itemData.clickShoppingCart();
        shoppingCart.completeCheckout();
        checkout.fillRestOfData("","Egypt","cairo","maadi","","69875","+201011830064","");
        checkout.clickoneDayShip();
        checkout.clickCheckPayment();
        checkout.clickConfirmPaymentInfo();
        checkout.clickConfirmorderInfo();
        Assert.assertTrue(control.getTextFromElement(checkout.getActualMessage()).contains(checkout.getConfirmOrderMessage()));
         homePage.backHome();


    }


}
