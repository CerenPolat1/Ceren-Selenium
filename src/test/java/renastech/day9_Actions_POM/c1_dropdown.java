package renastech.day9_Actions_POM;

import org.openqa.selenium.By;;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import renastech.base.TestBase2;
import renastech.utilities.BrowserUtils;
import renastech.utilities.DriverUtil;

public class c1_dropdown extends TestBase2 {

    @Test
    public void TC1_test(){
        DriverUtil.getDriver().get("https://exchange.sandbox.gemini.com/register/institution");
        WebElement dropdownBox=DriverUtil.getDriver().findElement(By.id("countryDropdown")); //html dropdown
        //peki nerden anladik html dropdown oldugunu cunku kod'da select div yoktu

        //dropdown icinde onlarca ulke var, mesela kubayi istedigimizde nasil yapicaz?
        //eger developer unique id olusturduysa onu locate edip kullanabilirsin  yani her yulke icin ayri bir id olusturmussa vs.
        //sen box'dan cuba'yi secip locate'ini bulsan bile onlar degisken oluyor yani her baska ulke sectiginde degisecek
        // cunku developer unique ya da her ulke icin bir sey  olusturmamis olabiilir
        //o yuzden tum ulkeler icin tek div oldugunda changeable olur, boxa cuba yazdiginda, html codunda cuba cikar yani her ulke icin aynisi olur
        // oyle durumlarda yani ne html'den ne de select'den yararlanabiliyorsam
        // o zaman altttaki yontemi denerim:Keys.ARROW_DOWN)


        dropdownBox.sendKeys("Cuba");
        BrowserUtils.wait(2);
        dropdownBox.sendKeys(Keys.ARROW_DOWN); // asagiyiya inmeni sagliyor, uzerine gelmeni sagliyor
        dropdownBox.sendKeys(Keys.ENTER);

    }
// how do we handle dropdown?
    //select and html
//how we handle html dropdowns?
   //locate it
//how we handle select dropdowns?
    //selectbyvisibletext
    //selectbyvalue
    //selectbyindex
}