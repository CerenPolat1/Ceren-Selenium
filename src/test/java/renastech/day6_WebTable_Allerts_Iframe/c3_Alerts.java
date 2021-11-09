package renastech.day6_WebTable_Allerts_Iframe;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import renastech.utilities.BrowserUtils;
import renastech.utilities.SmartBearUtils;
import renastech.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class c3_Alerts {
//1- Open a chrome browser
    //2- Go to:http://practicerenastech.com/
    //locate the alert button to click it
    //click button
    //handle alert

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        //1- Open a chrome browser
        //2- Go to:http://practicerenastech.com/
        driver= WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practicerenastech.com/");
    }

    @Test
    public void TC1_alertPractice(){
        driver.findElement(By.id("selenium-Elements")).click();
        driver.findElement(By.id("Alert BoxI")).click();

        //locate the alert button to click it
        WebElement allertButton=driver.findElement(By.id("confirm-demo"));

        //click button
        allertButton.click();
        //handle alert
        //since alert is JC allert you need to cghange your driver focus to allert
        Alert alert=driver.switchTo().alert();
        BrowserUtils.wait(2);
        alert.accept(); //clicking ok
        BrowserUtils.wait(2);
        allertButton.click();
        alert.dismiss(); //will click on cancel button
    }

}