
package renastech.day4_radio_checkbox_TestNG;

import org.testng.Assert;
import org.testng.annotations.*;

public class c6_TestNG3 {

    @BeforeClass
    public void setupClass(){ //this one will only run once before everyting in the class
        System.out.println("Before class is running");
    }
    @AfterClass
    public void setupAfterClass(){//this one will only run once after everyting in the class
        System.out.println("After class is running");
    }
    @BeforeMethod
    public void setup(){//this will run before each test annotation
        System.out.println("Before Method is running");
    }
    @AfterMethod
    public void closing(){//this will run after each test annotations
        System.out.println("After method is running");
    }

    @Test(priority = 3)
    public void TC1_test(){
        System.out.println("Test1 is running");
    }
    @Test(priority = 1) //parantez icine priority koyarak hangi sirayla gitmesini istiyorsan belirityorsun
    public void TC3_test(){
        System.out.println("Test3 is running");

        String actualword="hello";
        String expectedWord="hello2";

        //atllatakini if'le yaptigimizda fail yazsini gosterir ama assert gibi fail yazisini gostermez

        Assert.assertEquals(actualword,expectedWord); //assert method ile ikisinin esit olup olmadigini ogreniyoruz
        System.out.println("continue test3");
    }


    //ustteki fail verdi ama diger test caselerde fail yoksa onlar run etmeye devam eder,
    //cunku bu test caselerin hepsi birbirinden bagimsiz olusur o yuzden bireysel calisir
    @Test(priority = 2)
    public void TC2_test(){
        System.out.println("Test2 is running");
        String str="renastech";
        String str2="renastech";

        Assert.assertTrue(str.equals(str2));




    }
}