package renastech.studyhall;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class day_6 {

    //Navigate to "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt"
    //Click on the "Try it" button
    //Enter Your name on the Alert Box and Accept alert
    //Verify that your name shown on the page
    //Click on the 'home sign' (it is on the left side of page)
    //Switch to second window tab
    //Click on the "log in" button
    //Enter your credentials
    //Enter the show password button
    //Switch to first tab
    //Click on the "menu" button
    public static void main(String[] args)  {

        //Navigate to "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt"
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        int size = driver.findElements(By.tagName("iframe")).size();
//        System.out.println("Total Frames --" + size);

        //eger iframe kullanmazsan click button calismaz once onu switch etmen gerekir

        //Click on the "Try it" button
        driver.switchTo().frame(driver.findElement(By.id("iframeResult"))); //iframe'min id'si
        WebElement button =driver.findElement(By.xpath("//button[.='Try it']"));
        button.click();
/*
alert box'in icinde eger highlighted yazi varsa yani mavi renkte yazi, o demektir ki onun icindeki
 silmek kolay
eger highlited yazi yoksa box'in icindeki yaziyi silmek icin clear() methodusunu kullanmak gerekir
 */

        //Enter Your name on the Alert Box and Accept alert
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("hasan"); //bu sekilde harry poter yazisi yerine bu isim gelecek
        alert.accept();


        //Verify that you name shown on the page
        WebElement actual=driver.findElement(By.xpath("//p[@id='demo']"));  //"Hello hasan! How are you today?"
        String expected="Hello hasan! How are you today?";
        Assert.assertEquals(expected,actual.getText(),"verification has failed");
        System.out.println("verification has passed, text is= "+ actual.getText());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Click on the 'home sign' (it is on the left side of page)
        driver.switchTo().parentFrame();
        WebElement home=driver.findElement(By.xpath("//a[@id='tryhome']"));//ev seklinde olan(hoome sign) isaret
        home.click();

        //how can we go second tab?:
        // switch tab.how can we do that?
        // we can do 2 way: set  or arraylist

        //Switch to second window tab
        ArrayList<String> newtab=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newtab.get(1)); //index number

        //arraylist yerine set kullansaydin for each loop kullanmak gerekirdi:

//        Set<String> windows=driver.getWindowHandles();
//        for(String i:windows) {
//            driver.switchTo().window(i);
//        }


        //Click on the "log in" button
        driver.findElement(By.id("w3loginbtn")).click();

        //Enter your credentials
        driver.findElement(By.id("modalusername")).sendKeys("hasan");
        driver.findElement(By.id("current-password")).sendKeys("11111111111111");

        //Enter the show password button
        WebElement show= driver.findElement(By.xpath("//span[@class='_8HgG3']"));
        show.click();

        //Switch to first tab
        driver.switchTo().window(newtab.get(0)); //index number for tab, go back


        //Click on the "menu" button
        WebElement menu= driver.findElement(By.xpath("//a[@id='menuButton']"));
        menu.click();





    }



}