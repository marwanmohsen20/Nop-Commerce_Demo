package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    public BasePage(){

    }

    public static void clickingByWebElement(WebElement element){
        element.click();
    }
    public void clickByName(String text){
        driver.findElement(By.partialLinkText(text)).click();
    }
    public static void sendText(WebElement element,String text){
        element.sendKeys(text);
    }
    public  boolean isDisplay(By element){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver.findElement(element).isDisplayed();
    }
    public  boolean isDisplaying(By element,WebDriver driver){
        return driver.findElement(element).isDisplayed();
    }
    public  boolean isEnabled(By element){

        int x=  driver.findElements(element).size();
        if(x>0)
            return true;
        else
            return false;
    }
    public static void selectFromDropDown(WebElement element,String text){
        Select drpdown=new Select(element);
        drpdown.selectByVisibleText(text);
    }
    public String getTextFromElement(By element){
        return driver.findElement(element).getText();
    }

    public String getTitleOfPage(){
        return driver.getTitle();
    }
    public  void moveAndHover(String text){
        WebElement element=driver.findElement(By.partialLinkText(text));
        Actions actions=new Actions(driver);
        actions.moveToElement(element).perform();


    }

}
