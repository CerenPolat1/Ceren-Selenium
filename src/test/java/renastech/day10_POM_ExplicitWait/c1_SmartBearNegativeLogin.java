package renastech.day10_POM_ExplicitWait;

import org.testng.Assert;
import org.testng.annotations.Test;
import renastech.Pages.SmartBearLoginPage;
import renastech.base.TestBase2;
import renastech.utilities.DriverUtil;
import renastech.utilities.PropertiesReadingUtil;

public class c1_SmartBearNegativeLogin extends TestBase2 {

    SmartBearLoginPage smartBearLoginPage;//null object //bu olmadan connection olmuyor
    //landing page=login page
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

//        smartBearLoginPage.usernameBox.sendKeys("");
//        smartBearLoginPage.passwordBox.sendKeys("");
//        smartBearLoginPage.loginButton.click();
       // alttakini bu sekilde de yapabililirdin, biz isimizi kisalttik

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

    /*
    how to read the properties, what the methods that you need to use?
    i read it by my utils(PropertiesReadingUtil), you dont need to know how his util works on detail
    bunlari bilmen onemli:
        //1- create properties object
    //2- get the path and store in String
    //3-  open the file use Fileinputstream method
    //4-  load the file to properties object by using load method from properties
    //5- close.file
    //plus dont forget to handle exceptions
     */
// *******************************
    //we extend TestBase2 with logic of inheritence
    //we get before and after method
    //we create page class
    //and we stored webelements and some usefull methods
    //create an object from page to be able to call webelements and methods
    //you navigate your url
    //then you pass username ,password and click on login button with one method that we created under SMLogin Page
    //then we verified text after we try to logged in with a method that again we create under SMLogin Page
//**********************************

    // negative login page yaratmaya gerek yok, result'in positive or nagatif olmasi onemli
    //you dont create seperate page for positive and negative result
    //peki page yarattigimizda icine ne olusturuyoruz?
    // webelements ******
    //you dont need negatif login method
    //always try to make your method as resusable as you can

}