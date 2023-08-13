package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;



    private By Email=By.id("Email");
    private WebElement EmailElement;
    private By Password=By.id("Password");
    private  WebElement PasswordElement;

    private By loginButton=By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button");
    private WebElement loginButtonElement;
    private By emptyMailMessage=By.xpath("//*[@id=\"Email-error\"]");
    private String mailErrormessage="Please enter your email";
    private By invalidloginMessage=By.xpath("    /html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]\n");

    private String invalidMessage="Login was unsuccessful. Please correct the errors and try again.";
    public By getEmptyMailMessage() {
        return emptyMailMessage;
    }

    public By getInvalidloginMessage() {
        return invalidloginMessage;
    }

    public String getInvalidMessage() {
        return invalidMessage;
    }

    public String getMailErrormessage() {
        return mailErrormessage;
    }

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public void emaiilText(String email){
        EmailElement= driver.findElement(Email);
        sendText(EmailElement,email);
    }
    public void passwordText(String password){
        PasswordElement= driver.findElement(Password);
        sendText(PasswordElement,password);
    }

    public void clickLoginbutton(){
        loginButtonElement= driver.findElement(loginButton);
        clickingByWebElement(loginButtonElement);
    }
    public void login(String email,String password){
        homePage=new HomePage(driver);
        homePage.clickLogin();
        emaiilText(email);
        passwordText(password);
        clickLoginbutton();
    }
}
