package renastech.day5_TestNG_Dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class assignment4 {

    //    Task4
//    go to website http://demo.guru99.com/test/newtours/register.php
//    fill contact information --- dont use faker here
//    fill out mailing info
//    fill user information -- dont use faker here
//    click on submit button
//    verify your username and name displayed in the register page
//    Example :  Dear hello dasdad, Note: Your user name is asdasda.

    public static void main(String[] args) throws InterruptedException {



    WebDriverManager.chromedriver().setup();
    WebDriver driverr=new ChromeDriver();
    driverr.manage().window().maximize();
    driverr.get("http://demo.guru99.com/test/newtours/register.php");
        Thread.sleep(1000);

    WebElement info=driverr.findElement(By.xpath("//input[@ name='firstName']"));
    info.sendKeys("ekj");
        Thread.sleep(1000);

    WebElement infoo= driverr.findElement(By.name("lastName")) ;
    infoo.sendKeys("sfjv");
        Thread.sleep(1000);

    WebElement infooo=driverr.findElement(By.name("phone"));
    infooo.sendKeys("122334");
        Thread.sleep(1000);

     WebElement infoooo=driverr.findElement(By.id("userName"));
     infoooo.sendKeys("asfg");
        Thread.sleep(1000);

    WebElement info2=driverr.findElement(By.name("address1"));
    info2.sendKeys("fghs");
        Thread.sleep(2000);

    WebElement info3= driverr.findElement(By.xpath("//input[@name='email']"));
    info3.sendKeys("ekj sfjv");
        Thread.sleep(1000);

    WebElement info4= driverr.findElement(By.xpath("//input[@name='password']"));
    info4.sendKeys("hhhhhhh");
        Thread.sleep(1000);

    WebElement info5=driverr.findElement(By.name("confirmPassword"));
    info5.sendKeys("hhhhhhh");

    WebElement info6=driverr.findElement(By.xpath("//input[@name='submit']"));
    info6.click();

   Thread.sleep(2000);



//        WebElement disPlayed=driverr.findElement(By.xpath("//td/p/font/b"));
//        String ActualName=disPlayed.getText();
//        String userName="Dear ekj sfjv,";
//
//        Assert.assertEquals(ActualName,userName,"failed");
//
       Thread.sleep(2000);

        //OR;

       WebElement last=driverr.findElement(By.xpath("//b[contains(.,'Note: Your user name is ekj sfjv.')]"));

       Assert.assertTrue(last.isDisplayed());
        System.out.println("passed");

       WebElement last2=driverr.findElement(By.xpath("//td/p/font/b"));

       Assert.assertTrue(last2.isDisplayed());
        System.out.println("passed");



    driverr.close();


    }
}
