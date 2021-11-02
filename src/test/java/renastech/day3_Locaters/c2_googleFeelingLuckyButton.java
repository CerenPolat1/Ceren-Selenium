package renastech.day3_Locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import renastech.utilities.WebDriverUtil;

public class c2_googleFeelingLuckyButton {
    //TASK: Google Feeling lucky button
    //1- Open a chrome browser
    //2- Go to: https://google.com
    //3- Write "apple" in search box
    //click i am feeling lucky button
    //Verify title contains Apple

    public static void main(String[] args) throws InterruptedException {
        //1- Open a chrome browser
        WebDriver driver=WebDriverUtil.getDriver("chrome");

        //2- Go to: https://google.com
        driver.get("https://www.google.com");
        //3- Write "apple" in search box
        //driver.findElement(By.name("q")).sendKeys("Apple");   works

        //driver.findElement(By.className("gLFyf gsfi")).sendKeys("Apple");
        //having spaces in classname will make your code fail,, exception verir, o yuzden space olanlari kullanma
        //you can remove one part see if it is unique you can locate
        //notes kisminda v ar detaylar

        driver.findElement(By.className("gLFyf")).sendKeys("Apple");// spaceden sonrasini cikardik
        //tekrar html'den baktik ve classname olarak bi tek bu var o zaman kullandik
        //bundan "gLFyf" baska classname olmadigindan unique, baska seylerde "gLFyf" bu kullanilmis
        //biixm kcin onemli olan classname'in 2.bir "gLFyf" olmamasi
        Thread.sleep(1000);

        //click i am feeling lucky button
        driver.findElement(By.className("RNmpXc")).click(); //seardch yaparken sayfanin altinda cikan button bu
        //sayfaya google yazisinin altinda yazan degil

        //id'nin static olup oomadigini nasil anlariz, sayfayi refresh yaptigimizda anlariz baakriz id'de fark var ki diye

        //Verify title contains Apple

        String actualTitle=driver.getTitle();
        String expectedTitle="Apple";

        if (actualTitle.contains(expectedTitle)){
            System.out.println("lucky button passed");
        }else{
            System.out.println("lucky button failed");
            System.out.println("actualTitle = " + actualTitle);
        }

        driver.close();
    }
}