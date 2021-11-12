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

        /*
        simdi olay su: sen alert box sayfasina geldiginde 'click me' yazan yeri tikladiginda
        sayfa sana uyari veriyo ve inspect yapmana izin vermiyo yani senin html'ye gitmene izin vermiyor
        bunu handle edebilmek icin alert methodsunu ve keywordunu kullaniyoruz.
         */

        //click button
        allertButton.click(); //it is not working like this
        //handle alert
        //since alert is JC alert you need to change your driver focus to alert

        Alert alert=driver.switchTo().alert();  //neden switch yapmak zorundayiz cunku selenium sadece ayni anda tek bir seye odaklanir
        //-> Selenium can only focus one thing at a time.
        BrowserUtils.wait(2);

        alert.accept(); //clicking ok button anlamina geliyor,  sayfa simdi html'ye izin veriyor.
        BrowserUtils.wait(2);
        allertButton.click();

        alert.dismiss(); //sayfada cikan alert uyari yazisini cancel etmeye yariyor
    }



}