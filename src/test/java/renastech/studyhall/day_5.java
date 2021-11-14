package renastech.studyhall;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class day_5 {


    //    task4
    //go to http://the-internet.herokuapp.com/nested_frames
    //switch between frames
    //get text for each frame hint: use tagname to locate text or xpath
    @Test
    public void SwitchFrames(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame(driver.findElement(By.name("frame-top"))); //uc frame'i alir
        driver.switchTo().frame(driver.findElement(By.name("frame-left"))); //left frame
        System.out.println(driver.findElement(By.tagName("body")).getText());

        driver.switchTo().parentFrame(); //basta sola gittigimizden simdi tekrar parenta donuyoruz,usteeki frame oluyor, buttom olan degil
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.tagName("div")).getText());// bu framedeki yaziyi (Left) almak istedigimizden dive gittik cunku yazi oradaydi

        driver.switchTo().parentFrame();
        driver.switchTo().frame(2);//index no 2 demek yani right frame
        System.out.println(driver.findElement(By.tagName("body")).getText());


        driver.switchTo().defaultContent(); //  bu html'nin basi oluyor, yani 0'dan basliyor
        driver.switchTo().frame(driver.findElement(By.name("frame-bottom")));
   // driver.switchTo().frame("frame-bottom"); bu sekilde string'in ciine de value yazarak cagirabiliriz
        System.out.println(driver.findElement(By.tagName("body")).getText());

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // WHEN PAGE LOADES, implicitlyWait DOESNT WAIT UNTIL WHAT YOU PUT.
       //implicitlyWait WILL affect our whole code that is in same test block, you dont need to create other implicit in the same block
     //but static wait (thread.sleep) just affect after  thread sleep codes
    }



    @Test
    public void TC2() throws InterruptedException {
        // Alert Message handling
        // go to "http://demo.guru99.com/test/delete_customer.php"
        // delete customer 53920
        // Switch to Alert
        // Captur alert message.
        // Display alert message
        // Accepting alert


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/delete_customer.php");
        driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("1234");
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        System.out.println(driver.switchTo().alert().getText());
        //driver.switchTo().alert().dismiss(); //alert object create yapmadan bu cekilde switchle kullandik
        //peki neden object yaratmadik cunku kod az oldugundan gerek duymadik
        Thread.sleep(10);
           driver.switchTo().alert().accept();
        System.out.println(driver.switchTo().alert().getText());
            Thread.sleep(10);  //static wait= fluent wait ********
           driver.switchTo().alert().accept(); //neden 2 tane accept koyduk cunku 2 tane alert cikiyodu


    }

}
