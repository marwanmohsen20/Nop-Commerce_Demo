package Login;

import BaseTest.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ShoppingCart;

public class LoginPageTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;



    @BeforeTest
    public void calltest(){

        setup();
        homePage=new HomePage(driver);
        loginPage=new LoginPage(driver);


    }

    @Test(priority = 3)
    public void ValidLogin(){

       loginPage.login("marwan22@gmail.com","maromoh1");
        Assert.assertTrue(control.isDisplay(homePage.getLogoutButton()),"login unsuccessfullu");

    }
    @Test
    public void LoginwithoutTypeMail(){

        loginPage.login("","maromoh1");

        Assert.assertTrue(control.getTextFromElement(loginPage.getEmptyMailMessage()).contains(loginPage.getMailErrormessage()));
    }
    @Test
    public void LoginwithoutTypePassword(){

        loginPage.login("marwan@gmail.com","");

        Assert.assertTrue(control.getTextFromElement(loginPage.getInvalidloginMessage()).contains(loginPage.getInvalidMessage()));

    }
    @Test
    public void LoginwithInvalidmail(){

        loginPage.login("marwan234234234@gmail.com","maromo1");

        Assert.assertTrue(control.getTextFromElement(loginPage.getInvalidloginMessage()).contains(loginPage.getInvalidMessage()));

    }



}
