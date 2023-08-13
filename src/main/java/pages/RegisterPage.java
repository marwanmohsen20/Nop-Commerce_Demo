package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {
    private WebDriver driver;

    private By MaleGender= By.id("gender-male");

    private WebElement MaleGenderElement;
    private By Fname=By.id("FirstName");
    private WebElement FnameElement;
    private By Lname=By.id("LastName");
    private WebElement LnameElement;
    private By Email=By.id("Email");
    private WebElement EmailElement;
    private By Password=By.id("Password");
    private  WebElement PasswordElement;
    private By RePassword=By.id("ConfirmPassword");
    private WebElement RePasswordElement;
    private By RegisterButton=By.id("register-button");
    private WebElement RegisterButtonElement;
    private By continueButton=By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/a");
    private WebElement continueButtonElement;
    private By exitMailalert=By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/ul/li");

    By emailRequired=By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[5]/span[2]");

    By fNameRequired=By.xpath("//*[@id=\"FirstName-error\"]");
    By lNameRequired=By.id("LastName-error");
    By passAlert=By.id("Password-error");   
    By confirmpassAlert=By.id("ConfirmPassword-error");


    public By getPassAlert() {
        return passAlert;
    }
    public By getConfirmPassAlert() {
        return confirmpassAlert;
    }

    public By getfNameRequired() {
        return fNameRequired;
    }
    public By getlNameRequired() {
        return lNameRequired;
    }

    public By getEmailRequired() {
        return emailRequired;
    }

    public By getContinueButton() {

        return continueButton;
    }




    public RegisterPage(WebDriver driver) {
        this.driver=driver;
    }

    public void Fnametext(String fname){
        FnameElement= driver.findElement(Fname);
        sendText(FnameElement,fname);
    }
    public void Lnametext(String lname){
        LnameElement= driver.findElement(Lname);
        sendText(LnameElement,lname);
    }
    public void Emailtext(String email){
        EmailElement= driver.findElement(Email);
        sendText(EmailElement,email);
    }
    public void Passwordtext(String password){
        PasswordElement= driver.findElement(Password);
        sendText(PasswordElement,password);
    }
    public void Repasswordtext(String repassword){
        RePasswordElement= driver.findElement(RePassword);
        sendText(RePasswordElement,repassword);
    }
    public void clickMale(){
        MaleGenderElement=driver.findElement(MaleGender);
        clickingByWebElement(MaleGenderElement);
    }
    public void clickRegister(){
        RegisterButtonElement=driver.findElement(RegisterButton);
        clickingByWebElement(RegisterButtonElement);
    }
    public void clickContinue(){
        continueButtonElement=driver.findElement(continueButton);
        clickingByWebElement(continueButtonElement);
    }
    public void regesiter(String firstname, String lastname,String email,String password,String repassword){
        clickMale();
        Fnametext(firstname);
        Lnametext(lastname);
        Emailtext(email);
        Passwordtext(password);
        Repasswordtext(repassword);
    }



    public String existingmailAlert(){
        return driver.findElement(exitMailalert).getText();
    }




}
