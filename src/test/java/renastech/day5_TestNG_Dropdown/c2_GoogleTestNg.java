
package renastech.day5_TestNG_Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import renastech.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class c2_GoogleTestNg {
    //1- Go to google
    //2- Verify title is google

    //1- Go to google
    //search laptop
    //make sure title contains laptop

    //common steps
    //setup driver and go to google


    WebDriver driver; // it is now null driver bec. we didnt assign anything

    @BeforeMethod
    public void setUp(){
        //this annotion will apply all of your tests
        //so its better to use comman steps in here so you dont dublicate steps

        driver= WebDriverUtil.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
    }
    //neden bu stepleri buraya koyduk, cunku her zaman sayfa bu adimlarla baslayacak,
    //biz herhangi bir testi okuttugumuzda before method yani icindeki stepler run edip sonra teste donecek
    //boylelikle hem isimiz kolaylasiyor hem zaman tasarrufu cunku obur turlu her biri acin adim adim olusturmak gerekecekti

    @Test(priority = 1)
    public void TC1_googleVerifyTitle() throws InterruptedException {
        System.out.println("TC1 is running");
        //1- Go to google   This is done in the before method
        //2- Verify title is google
        String expectedTitle="Google";
        String actualTitle= driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle,"Title Verification Failed !!!"+actualTitle); //mesaj girdik

    }

    @Test(priority = 2)
    public void TC2_googleVerifySearchBox(){

        //1- Go to google   this is done in before
        System.out.println("TC2 is running");
        //search laptop
        WebElement searchBox=driver.findElement(By.name("q"));

        searchBox.sendKeys("laptop" , Keys.ENTER);

        //make sure title contains laptop
        String actualTitle= driver.getTitle();//laptop - Google Search gibi kelimeleri aradigimizdan asserttrue yaptik. contain icin
        String containedTitle="laptop";

        boolean b=actualTitle.contains(containedTitle);
        Assert.assertTrue(b,"search function failed!!!");


    }


    @AfterMethod
    public void closing(){  //neden aftermethoda koyduk cunku her zaman en son bu okunacagindan hangisini run edersen et en son bu islenecek
        driver.close();
    }

}