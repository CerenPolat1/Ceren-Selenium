package renastech.day9_Actions_POM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import renastech.base.TestBase2;
import renastech.utilities.BrowserUtils;
import renastech.utilities.DriverUtil;
import renastech.utilities.WebDriverUtil;

public class c2_ActionsExamples extends TestBase2 {
    //go to http://demo.guru99.com/test/simple_context_menu.html
    //double click to double click button
    //then accept the alert that pops up

    Actions actions; //instead of creating this object for each test . We are specifiying at the top
    //then call in the each test

    @Test
    public void TC1_doubleClick(){
        DriverUtil.getDriver().get("http://demo.guru99.com/test/simple_context_menu.html");

        //button[.='Double-Click Me To See Alert']
        WebElement doubleClickButton=DriverUtil.getDriver().findElement(By.xpath("//button[.='Double-Click Me To See Alert']"));

        //WebDriverManager.chromedriver().setup(); egeer bu olsaydi
        //WebDriver driver= new ChromeDriver();
        //actions=new Actions(driver); olacakti ama biz utils kullandigimizdan asagidaki gibi oldu

        actions=new Actions(DriverUtil.getDriver()); //neden Actions'in icine driver girdik,
                 // cunku Actions'i tikladiginda sana driver girmen gerektigini soyluyor o yuzden oraya driver'imizi girdik
        actions.doubleClick(doubleClickButton).perform(); //perform yapmazsan calismaz

        Alert alert=DriverUtil.getDriver().switchTo().alert();
        BrowserUtils.wait(3);
        alert.accept();


        //switch-- driver'in focusu degsitginde yani pencere acildiginda frame de falan kullaniyoruz, alert'de de, windiwsa veya tab'e goturuyor
        //action: mause, klavye uzerindeki oynamalar, hoverover(mausla gezme)

    }

    //go to http://demo.guru99.com/test/simple_context_menu.html
    //right click to right click button
    //then click on edit button
    //then accept the allert that pops up

    @Test
    public void TC2_rightClick(){
        DriverUtil.getDriver().get("http://demo.guru99.com/test/simple_context_menu.html");

        WebElement rightClickButton=DriverUtil.getDriver().findElement(By.xpath("//span[.='right click me']"));
        //right click me bolumu tiklanmiyor, ona ancak sag click  yapip edit deyince alert veriyor

        actions=new Actions(DriverUtil.getDriver());//action, swicth farki ne
        //right click to right  click button

        actions.contextClick(rightClickButton).perform();
        //then click on edit button

        BrowserUtils.wait(1);
        WebElement editButton=DriverUtil.getDriver().findElement(By.xpath("//span[.='Edit']")); //alert yazisini gor ek icin edit'i aldik
        editButton.click();

        //then accept the alert that pops up
        BrowserUtils.wait(1);
        Alert alert=DriverUtil.getDriver().switchTo().alert();
        alert.accept();

    }

    //go to http://demo.guru99.com/test/drag_drop.html
    //drag bank word to account section and drop it
    //then drag 5000 to amount  section and drop it

    @Test
    public void TC3_dragDropExample(){
        DriverUtil.getDriver().get("http://demo.guru99.com/test/drag_drop.html");
        //2 .ocations kullanicaz:1'i sectigin yer, digeri surekledigin yer


        ////debit side'da bulunan accountin icindeki box'a drag yapmak icin locate yapmaliyiz
        //ancak bize uygun herhangi bir bilgi yok, sadece class var o da unique degil

        //o zaman bir parent'a cikacagiz: ol parent, li ise child asil almamiz gereken part



        //drag bank word to account section and drop it
        //2 things needs to be done here
        //first specify location of drag
        //second specify location of drop
        WebElement dragFrom=DriverUtil.getDriver().findElement(By.xpath("//a[.=' BANK ']")); //Bank
        WebElement dropTo=DriverUtil.getDriver().findElement(By.xpath("//ol[@id='bank']/li"));

        actions=new Actions(DriverUtil.getDriver());
        actions.dragAndDrop(dragFrom,dropTo).perform();
                        //elemetler: dragfrom, dropto


        //then drag 5000 to amount  section and drop it
        //2 things needs to be done here
        //first specify location of drag
        //secon specify location of drop

        WebElement dragFrom2=DriverUtil.getDriver().findElement(By.id("fourth")); //4.siradaki 5000'nin kodu
        WebElement dropTo2=DriverUtil.getDriver().findElement(By.xpath("//ol[@id='amt7']//li")); //debit side'daki amount box

        actions.dragAndDrop(dragFrom2,dropTo2).perform();

    }



}