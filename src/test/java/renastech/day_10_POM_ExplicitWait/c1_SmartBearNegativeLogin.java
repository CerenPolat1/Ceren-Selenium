package renastech.day_10_POM_ExplicitWait;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import renastech.Pages.SmartBearLoginPage;
import renastech.base.TestBase2;
import renastech.utilities.DriverUtil;
import renastech.utilities.PropertiesReadingUtil;

public class c1_SmartBearNegativeLogin extends TestBase2 {
    SmartBearLoginPage smartBearLoginPage;//null object //bu olmadan connection olmuyor
    //how do i create connection between this test class and page class (SmartBearLoginPage)
    //with  instance of SmartBearLoginPage **********
    //peki neden extend etmek yerine instance kullaniyoruz cunku extend edersek oldugu gibi gelecek ama biz degisiklik yapmak istiyoruz

    //enter wrong username
    //enter wrong password
    //verify text is present Invalid Login or Password.
    @Test
    public void TC1_SBNegativeTest(){

        smartBearLoginPage=new SmartBearLoginPage(); //burada da initilize (baslatmak, kullanima hazir hala getirmek) ediyorsun instance'i'

        DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("SmartBear_url"));

        smartBearLoginPage.loginSmartBear(PropertiesReadingUtil.getProperties("SmartBear_invalid_username")
                ,PropertiesReadingUtil.getProperties("SmartBear_invalid_password"));
        // smartBearLoginPage.loginSmartBear("sfjh",";oij");boyle de yapabiliriz ama yukaridaki gibi de
        //buraya invalid deger girince otomatikman negatif oomus oluyor

        String expectedMessage="Invalid Login or Password.";
//        WebElement statusElement=smartBearLoginPage.getStatusMassegeElement(); Smartbearloginpage'de olusturmustuk
//        String actualText=statusElement.getText();
        String actualText2=smartBearLoginPage.getStatusMessage();

        Assert.assertEquals(expectedMessage,actualText2,"negative login failed!!!!");


    }


    // negative login page yaratmaya gerek yok, result'in positive or nagatif olmasi onemli
    //you dont create seperate page for positive and negative result
    //peki page yarattigimizda icine ne olusturuyoruz?
    // webelements ******
    //you dont need negatif login method
    //always try to make your method as resusable as you can

}