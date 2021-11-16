package renastech.day9_Actions_POM;

import org.testng.annotations.Test;
import renastech.Pages.SmartBearLoginPage;
import renastech.utilities.DriverUtil;
import renastech.utilities.PropertiesReadingUtil;

public class c4_smartBearPOMExample {

    //to be able to work with page you need create an instance from page
    //so you can have access to methods and webelements
    //i will store all my pages in different package

    SmartBearLoginPage instancevariable;

    //farkli bir page'i baska bir page'de store edebiliriz
    //bunu yapabilmek icin store etmek istedigigimiz pagein adiyla bir instance variable olusturuyoruz
    //ayrica bu variable'i methodlarimizda da kullanabiliriz ya da test'lerde


    @Test
    public void TC1_smartBearPossitiveLoginVerification(){

        DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("SmartBear_url"));//property'den cagiriyor url yani configurationdan

        instancevariable = new SmartBearLoginPage(); //diger page'in ismiyle object olusturduk, library haline geliyor
       //object olusturdugumuz icin diger page'deki methodlari burada kullanabiliyoruz

        //instancevariable.loginSmartBear (String username, String password): !!!!!!!!!!!!!!!!! bu asagidaki
        instancevariable.loginSmartBear(PropertiesReadingUtil.getProperties("SmartBear_username"),
                PropertiesReadingUtil.getProperties("SmartBear_password"));



    }
}