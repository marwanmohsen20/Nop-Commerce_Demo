package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Checkout extends BasePage {
    private WebDriver driver;
    public Checkout(WebDriver driver){
        this.driver=driver;
    }
    private By Fname=By.id("BillingNewAddress_FirstName");
    private WebElement FnameElement;
    private By Lname=By.id("BillingNewAddress_LastName");
    private WebElement LnameElement;
    private By Email=By.id("BillingNewAddress_Email");
    private WebElement EmailElement;
    private By Company=By.id("BillingNewAddress_Company");
    private WebElement CompanyElement;
    private By City=By.id("BillingNewAddress_City");
    private WebElement CityElement;
    private By Address1=By.id("BillingNewAddress_Address1");
    private WebElement Address1Element;
    private By postalCode=By.id("BillingNewAddress_ZipPostalCode");
    private WebElement postalCodeElement;
    private By Address2=By.id("BillingNewAddress_Address2");
    private WebElement Address2Element;
    private By phoneNumber=By.id("BillingNewAddress_PhoneNumber");
    private WebElement phoneNumberElement;
    private By faxNumber=By.id("BillingNewAddress_FaxNumber");
    private WebElement faxNumberElement;
    private By savingBill=By.xpath("//button[@onclick=\"Billing.save()\"]");
    private WebElement savingBillButtonElement;
    private By dropCountry=By.id("BillingNewAddress_CountryId");
    private WebElement dropCountryElment;
    private By dropState=By.id("BillingNewAddress_StateProvinceId");
    private WebElement dropStateElment;
    private By shipLand=By.id("shippingoption_0");
    private WebElement shipLandElement;
    private By oneDayShip=By.xpath("//*[@id=\"shippingoption_1\"]");
    private WebElement oneDayShipElement;
    private By twoDayShip=By.id("shippingoption_2");
    private WebElement twoDayShipElement;
    private By saveShippingMethod=By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button\n");
    private WebElement saveShippingMethodElement;

    private By backSavingBill=By.linkText("Back");
    private WebElement backSavingBillElement;

    private By checkMoney=By.id("paymentmethod_0");
    private WebElement checkMoneyElement;
    private By creditCard=By.id("paymentmethod_1");
    private WebElement creditCardElement;
private By savePaymentMethod=By.xpath("//*[@id=\"payment-method-buttons-container\"]/button\n");
    private WebElement savePaymentMethodElement;
    private By confirmPaymentInfo=By.xpath("//*[@id=\"payment-info-buttons-container\"]/button");
    private WebElement confirmPaymentInfoElment;
    private By confirmorderInfo=By.xpath("    //*[@id=\"confirm-order-buttons-container\"]/button\n");
    private WebElement confirmorderInfoElment;
    private By editBillInfoButton=By.id("edit-billing-address-button");
    private WebElement editBillInfoButtonElement;



    private String confirmOrderMessage="Your order has been successfully processed!";
    private By actualMessage=By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong");

    public By getActualMessage() {
        return actualMessage;
    }
    public String getConfirmOrderMessage() {
        return confirmOrderMessage;
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
    public void Companytext(String company){
        CompanyElement= driver.findElement(Company);
        sendText(CompanyElement,company);
    }
    public void SelecCountry(String text){
        dropCountryElment= driver.findElement(dropCountry);
        selectFromDropDown(dropCountryElment,text);
    }
    public void slecetState(String state){
        dropStateElment= driver.findElement(dropState);
        selectFromDropDown(dropStateElment,state);
    }
    public void Citytext(String city){
        CityElement= driver.findElement(City);
        sendText(CityElement,city);
    }
    public void Address1text(String address){
        Address1Element= driver.findElement(Address1);
        sendText(Address1Element,address);
    }
    public void Address2text(String address){
        Address2Element= driver.findElement(Address2);
        sendText(Address2Element,address);
    }
    public void zipCodetext(String zipCode){
        postalCodeElement= driver.findElement(postalCode);
        sendText(postalCodeElement,zipCode);
    }
    public void phoneNumbertext(String phone){
        phoneNumberElement= driver.findElement(phoneNumber);
        sendText(phoneNumberElement,phone);
    }
    public void Faxtext(String fax){
        faxNumberElement= driver.findElement(faxNumber);
        sendText(faxNumberElement,fax);
    }
    public void clickonContinueSaving(){
        savingBillButtonElement= driver.findElement(savingBill);
        clickingByWebElement(savingBillButtonElement);
    }
    public void sure(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        if(isDisplaying(editBillInfoButton,driver)){
            editBillInfoButtonElement=driver.findElement(editBillInfoButton);
            clickingByWebElement(editBillInfoButtonElement);
        }
    }
     public void fillRestOfData(String companyName,String countryName,String cityName,String address1,String address2,String zipcod,String phonenumber,String fax){


         sure();
            Companytext(companyName);
            SelecCountry(countryName);

            Citytext(cityName);
            Address1text(address1);
            Address2text(address2);
            zipCodetext(zipcod);
            phoneNumbertext(phonenumber);
            Faxtext(fax);
            clickonContinueSaving();

     }
     public void clickShipLand(){
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        shipLandElement=driver.findElement(shipLand);
        clickingByWebElement(shipLandElement);
        clicksaveSHippingMethod();
     }
    public void clickoneDayShip() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        oneDayShipElement=driver.findElement(oneDayShip);

        clickingByWebElement(oneDayShipElement);
        clicksaveSHippingMethod();
    }
    public void clickTwoDayShip(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        twoDayShipElement=driver.findElement(twoDayShip);
        clickingByWebElement(twoDayShipElement);
        clicksaveSHippingMethod();
    }
    public void clicksaveSHippingMethod(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        saveShippingMethodElement=driver.findElement(saveShippingMethod);
        clickingByWebElement(saveShippingMethodElement);
    }
    public void clickbackToSavingBill(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        backSavingBillElement=driver.findElement(backSavingBill);
        clickingByWebElement(backSavingBillElement);
    }
    public void clickCheckPayment(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        checkMoneyElement=driver.findElement(checkMoney);
        clickingByWebElement(checkMoneyElement);
        clickSavePaymentMethood();
    }

    public void clickCreditCardPayment(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        creditCardElement=driver.findElement(creditCard);
        clickingByWebElement(creditCardElement);
        clickSavePaymentMethood();
    }
    public void clickSavePaymentMethood(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        savePaymentMethodElement=driver.findElement(savePaymentMethod);
        clickingByWebElement(savePaymentMethodElement);
    }
    public void clickConfirmPaymentInfo(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        confirmPaymentInfoElment=driver.findElement(confirmPaymentInfo);
        clickingByWebElement(confirmPaymentInfoElment);
    }
    public void clickConfirmorderInfo(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        confirmorderInfoElment=driver.findElement(confirmorderInfo);
        clickingByWebElement(confirmorderInfoElment);
    }




}
