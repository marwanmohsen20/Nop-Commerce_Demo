package BaseTest;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;

import java.io.File;
import java.io.IOException;

public class TestBase {
    protected WebDriver driver;

    protected HomePage homePage;
    protected BasePage control;



    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        control=new BasePage(driver);

    }
    @AfterMethod
    public void recordFaliure(ITestResult result){
        if(ITestResult.FAILURE==result.getStatus()){
            var camera=(TakesScreenshot)driver;
            File screenshots=camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshots,new File("ScreenShots/"+result.getName()+".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }






@AfterTest
    public void quit(){
        driver.quit();
    }
}
