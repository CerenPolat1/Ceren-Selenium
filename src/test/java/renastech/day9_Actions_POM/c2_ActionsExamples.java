package renastech.day9_Actions_POM;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import renastech.base.TestBase2;
import renastech.utilities.BrowserUtils;
import renastech.utilities.DriverUtil;


public class c2_ActionsExamples extends TestBase2 {
    //go to http://demo.guru99.com/test/simple_context_menu.html
    //double click to double click button
    //then accept the alert that pops up

    Actions actionsss; //instead of creating this object for each test . We are specifying at the top
    //then call it in the each test

    @Test
    public void TC1_doubleClick(){

        DriverUtil.getDriver().get("http://demo.guru99.com/test/simple_context_menu.html");

        //button[.='Double-Click Me To See Alert']

        WebElement doubleClickButton=DriverUtil.getDriver().findElement(By.xpath("//button[.='Double-Click Me To See Alert']"));

        //WebDriverManager.chromedriver().setup(); egeer bu olsaydi
        //WebDriver driver= new ChromeDriver();
        //actions=new Actions(driver); olacakti ama biz utils kullandigimizdan asagidaki gibi oldu

        actionsss=new Actions(DriverUtil.getDriver()); //neden Actions'in icine driver girdik,
                 // cunku Actions'i tikladiginda sana driver girmen gerektigini soyluyor o yuzden oraya driver'imizi girdik
        //ayrica action'in olacagi sayfayi specify ediyoruz.

        actionsss.doubleClick(doubleClickButton).perform(); //perform yapmazsan calismaz
                 //doubleclick bir method

        Alert alert=DriverUtil.getDriver().switchTo().alert();
        BrowserUtils.wait(3);
        alert.accept();


        //switch-- driver'in focusu degistiriyor: yeni pencere (windows veya tab) acildiginda frame de, alert'de de kullaniliyor.
        //action: mause, klavye uzerindeki oynamalar, hoverover(mouse'la gezme)

    }

    //go to http://demo.guru99.com/test/simple_context_menu.html
    //right click to right click button
    //then click on edit button
    //then accept the alert that pops up

    @Test
    public void TC2_rightClick(){
        DriverUtil.getDriver().get("http://demo.guru99.com/test/simple_context_menu.html");

        WebElement rightClickButton=DriverUtil.getDriver().findElement(By.xpath("//span[.='right click me']"));
        //right click me bolumu tiklanmiyor, ona ancak sag click  yapip edit deyince alert veriyor

        actionsss=new Actions(DriverUtil.getDriver());
        //right click to right click button

        actionsss.contextClick(rightClickButton).perform();
        //then click on edit button

        BrowserUtils.wait(1);
        WebElement editButton=DriverUtil.getDriver().findElement(By.xpath("//span[.='Edit']")); //alert yazisini gormek icin edit'i aldik
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
        //2 .location kullanicaz:1'i sectigin yer, digeri surekledigin yer


        ////debit side'da bulunan accountin icindeki box'a drag yapmak icin locate yapmaliyiz
        //ancak bize uygun herhangi bir bilgi yok, sadece class var o da unique degil

        //o zaman bir parent'a cikacagiz: ol parent, li ise child asil almamiz gereken part



        //drag bank word to account section and drop it
        //2 things needs to be done here
        //first specify location of drag
        //second specify location of drop
        WebElement dragFrom=DriverUtil.getDriver().findElement(By.xpath("//a[.=' BANK ']")); //Bank
        WebElement dropTo=DriverUtil.getDriver().findElement(By.xpath("//ol[@id='bank']/li")); //PARENT TO CHILD

        actionsss=new Actions(DriverUtil.getDriver());
        actionsss.dragAndDrop(dragFrom,dropTo).perform();
                        //elementler: dragfrom, dropto


        //then drag 5000 to amount  section and drop it
        //2 things needs to be done here
        //first specify location of drag
        //secon specify location of drop

        WebElement dragFrom2=DriverUtil.getDriver().findElement(By.id("fourth")); //4.siradaki 5000'nin kodu
        WebElement dropTo2=DriverUtil.getDriver().findElement(By.xpath("//ol[@id='amt7']//li")); //debit side'daki amount box

        actionsss.dragAndDrop(dragFrom2,dropTo2).perform();

    }

/*
action ile yapilanlar:

doubleclick
rightclick
drag and drop
hover over

 */

}