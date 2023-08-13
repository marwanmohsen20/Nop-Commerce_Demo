package Register;

import BaseTest.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

public class RegisterPageTest extends TestBase {
    HomePage homepage;
    RegisterPage registerPage;
    LoginPage loginPage;
    ItemData itemData;

    @BeforeTest
    public void calltest(){
        setup();
        loginPage=new LoginPage(driver);
        homepage=new HomePage(driver);
        itemData=new ItemData(driver);


    }


    @Test(priority = 1)
    public void ValidRegister() throws InterruptedException {


        registerPage=homepage.clickRegister();
       registerPage.regesiter("marwan","mohsen","marwan22@gmail.com","maromoh1","maromoh1");
        registerPage.clickRegister();
        Thread.sleep(2000);
        Assert.assertTrue(control.isDisplaying(registerPage.getContinueButton(),driver),"register isnot good");

        registerPage.clickContinue();


    }


    @Test
    public void inValidRegister_existmail(){
        registerPage=homepage.clickRegister();
        registerPage.regesiter("marwan","mohsen","marwan@gmail.com","maromoh1","maromoh1");

        registerPage.clickRegister();
        String expected="The specified email already exists";
        String actual=registerPage.existingmailAlert();
        Assert.assertTrue(actual.contains(expected));

    }
    @Test
    public void inValidRegister_LeaveEmailEmpty(){
        registerPage=homepage.clickRegister();
        registerPage.regesiter("marwan","mohsen","","maromoh1","maromoh1");

        registerPage.clickRegister();
        String expected="Email is required.";

        Assert.assertTrue(control.getTextFromElement(registerPage.getEmailRequired()).contains(expected));


    }
    @Test
    public void inValidRegister_emptyFName(){
        registerPage=homepage.clickRegister();
        registerPage.regesiter("","mohsen","marwan6@gmail.com","maromoh1","maromoh1");
        String expected="First name is required.";
        registerPage.clickRegister();
        Assert.assertTrue(control.getTextFromElement(registerPage.getfNameRequired()).contains(expected));

    }
    @Test
    public void inValidRegister_emptyLName(){
        registerPage=homepage.clickRegister();
        registerPage.regesiter("marwan","","marwan5@gmail.com","maromoh1","maromoh1");
        String expected="Last name is required.";
        registerPage.clickRegister();
        Assert.assertTrue(control.getTextFromElement(registerPage.getlNameRequired()).contains(expected));


    }
    @Test
    public void inValidRegister_NumberInFname(){
        registerPage=homepage.clickRegister();
        registerPage.regesiter("5maro","mohsen","marwan5@gmail.com","maromoh1","maromoh1");

        if(!control.isEnabled(registerPage.getfNameRequired())){
                throw new IllegalStateException("failed message");
        }

        registerPage.clickRegister();



    }
    @Test
    public void inValidRegister_NumberInLname(){
        registerPage=homepage.clickRegister();
        registerPage.regesiter("maro","5mohsen","marwan6@gmail.com","maromoh1","maromoh1");


        if(!control.isEnabled(registerPage.getfNameRequired())){
            throw new IllegalStateException("failed message");
        }
        registerPage.clickRegister();
    }
    @Test
    public void inValidRegister_5LettersPass(){
        registerPage=homepage.clickRegister();
        registerPage.regesiter("marwan","mohsen","marwan6@gmail.com","marom","marom");

        String expected="must have at least 6 characters";

        registerPage.clickRegister();

        Assert.assertTrue(control.getTextFromElement(registerPage.getPassAlert()).contains(expected));
    }

    @Test
    public void inValidRegister_unMatchedPass(){
        registerPage=homepage.clickRegister();
        registerPage.regesiter("marwan","mohsen","marwan111@gmail.com","maromh","maromoh1");
        String expected="The password and confirmation password do not match.";
        registerPage.clickRegister();
        Assert.assertTrue(control.getTextFromElement(registerPage.getConfirmPassAlert()).contains(expected));

    }
    @Test
    public void inValidRegister_leavePassEmpty(){
        registerPage=homepage.clickRegister();
        registerPage.regesiter("marwan","mohsen","marwan111@gmail.com","","maromoh1");

        registerPage.clickRegister();
        String expected="Password is required.";

        registerPage.clickRegister();

        Assert.assertTrue(control.getTextFromElement(registerPage.getPassAlert()).contains(expected));

    }

}
