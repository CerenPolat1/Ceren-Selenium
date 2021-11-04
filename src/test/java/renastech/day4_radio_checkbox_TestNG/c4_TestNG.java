package renastech.day4_radio_checkbox_TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class c4_TestNG {

    //main method kullanilmaz

    /*
sadece public class'i tikladiginda alttaki sekilde run eder
       kodlarin bu sirayla run eder:
     before method running
    Test1 is running
   AfterMethod is running
   before method is running
   test3 is running
   aftermethod is running

ayrica testlerdeki sira testlerin isimlerine yani alfabeye gore run eder yani
tc1, tc2, tc3 run eder, burada kodumuz sira degil isim sirasina gore run eder,
 diyelim TC2'yi WTC2 yaptik  bu EN SON run edecek sonra digerleri siraya gore
 yani annotation degfines the order

 */
//run ettiginde cikan default suite demek bu sayfadaki her sey demek:class, test before after
//    seleniumTestngc3 ise pom.xml oluyor

    /*
    testNG'yi nasil import ettik maven Repository safyasina gittik
    arama butonuna testNG yazdik ve sonra en son version'nuna tikladik
    orada cikan depency'i copy yaptik ve pom'daki attaki bos 2 depency yazan yerin ortasina paste yaptik
    boylelikle import ettik
     */
//    kodlarin bu sirayla run eder:
//     @BeforeMethod
//    @Test
//    @AfterMethod

//testng'de main method kullanilmaz ********

    @BeforeMethod
    public void setup(){//this method will run before each test method
        System.out.println("Before Method is Running");
    }
    @AfterMethod
    public void closing(){ //this method will run after each test method
        System.out.println("After Method is running");
    }

    @Test
    public void TC1_test(){
        System.out.println("Test1 is running");
    }

/*
sadece @Test'i tikladiginda alttaki sekilde run eder
       kodlarin bu sirayla run eder:
     @BeforeMethod
    TC1_test
   @AfterMethod
 */

    @Test
    public void TC3_test(){
        System.out.println("Test3 is running");
    }

    @Test
    public void TC2_test(){
        System.out.println("Test2 is running");
    }

    /*
    eger sonuncuyu run edersem soyle cikar:
    Before Method is Running
Test2 is running
After Method is running

yanii her zaman sadece kendi test'ini alir
     */



}