package renastech.day4_radio_checkbox_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import renastech.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class c3_radioButtons {
    public static void main(String[] args) {
            /*
        Navigate to https://courses.letskodeit.com/practice
        click on BMW RADIO button
        verify that its selected
        Check Bmw, Benz, honda
        validate that benz i
             */

        WebDriver driver=WebDriverUtil.getDriver("chrome");
        driver.get("https://courses.letskodeit.com/practice");
        //neden navitage to yerine get tercih ediyoruz? loading problemi yuzunden
        //navigate to driveri beklemez ve hizli hareket eder ama get daha yavas ilerler codun duzgun calismasini saglar
        // yani driver'in yuklenmesini bekler get

        driver.manage().window().maximize();//if we dont thisand  you try to locate, it can be problem
        //o yuzden maximize'i kullaniyoruz. and cursor(gosterge) can  move around if we dont put maximize, we prevent that using maxi.
        //we bunu kullnamdiginda bazen locate yapmana da engel oluyor

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //implicit interview sorularindan biri: ne ise yarar nedir gibi


        //radio button (secenek butonu) sana yan yana veya alt alta option sunar, kutucuklar isaretlenir

        //how you handle radio buttons?
        // you will need to locate web element and click it, and then see if this one is selected


        WebElement bmwRadioButton=driver.findElement(By.xpath("//input[@id='bmwradio']"));
        bmwRadioButton.click();

        boolean bmwRadioSelected=bmwRadioButton.isSelected();

        if (bmwRadioSelected){
            System.out.println("Bmw is selected");
        }else {
            System.out.println("Bmw is not selected test failed!!!!");
        }


        WebElement hondaRadioButton=driver.findElement(By.xpath("//input[@id='hondaradio']"));

        if (!hondaRadioButton.isSelected()){
            System.out.println("honda button is not selected test passed ");
        }else{
            System.out.println("honda button is selected test failed");
        }

        //driver.close();
        //diyelim sen kodu yazana kadar pek cok sever run ettin ve asagida chrome sayfalari birikti
        //cunku hala kod yazdigindan driver.close kullanamiyosun
        //isin bittiginde driver.quit kullanarak asagidaki tum sayfalari kapatabilirsin
    }
}