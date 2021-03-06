package renastech.day7_Windows_Tabs_Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import renastech.base.TestBase;
import renastech.utilities.BrowserUtils;

import java.util.Set;

public class c2_Tabs extends TestBase {

    //inheritence example to extend my testbase class to all of my test


    @Test
    public void TC1_tabHandle(){
        driver.get("http://practicerenastech.com/");
        driver.findElement(By.id("selenium-Elements")).click();
        driver.findElement(By.id("WindowsII")).click();

        String currentWindow=driver.getWindowHandle();//this will only store one window, yeni windowda calisman gerekiyor o yuzden bu islemi yapiyoruz
        //and it will store current window that you have
        System.out.println("currentWindow = " + currentWindow);  //window'un codu her zaman unique'tir
        System.out.println("driver.getTitle() = " + driver.getTitle());

        WebElement openTabButton=driver.findElement(By.id("open-tab"));
        openTabButton.click();


        System.out.println("after clicking tab button driver.getTitle() = " + driver.getTitle()); //bize yine usttekiyle ayni sonucu verir
        //ayni sonucu gormek istemiyoruz cunku tab yapmak istiyoruz bunun icin alttakini yapiyoruz
        //since we didnt change driver focus it will give us same thing from beginning

        Set<String> allwindows= driver.getWindowHandles();//this will store all the tabs (windows)
        //neden burada set kullandik cunku bazi methodlarin return typleri string bazilari int
        //peki bunu nereden anliyoruz? .getWindowHandles() methodunun ustune geldigimizde bize return type'inin
        //set oldugunu soyluyor
        //mesela findelement'in return type'i list, o yuzden onu list'e koyuyoruz
        //ama diyelim bu methodlarin return typle'lari void ise o zaman istedigini kullanabilirsin

//        How to get all of the window handles of the currently opened tabs/windows?
//      -> driver.getWindowHandles() --> will return a SET of string that contains all the windows or tabs that you have.

        for (String tab : allwindows){
            driver.switchTo().window(tab); //extra tab icin yapmiyoruz cunku tab de window
            BrowserUtils.wait(2);
            System.out.println(driver.getTitle());
        }
//toplamda 2 tane windowum var, o yuzden 2 tane run etti console'da
    }

//how you get tabs and windows?

//using getwindowhandleS method


}
