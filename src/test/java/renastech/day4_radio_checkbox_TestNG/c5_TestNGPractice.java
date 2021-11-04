
package renastech.day4_radio_checkbox_TestNG;

import org.testng.annotations.*;

public class c5_TestNGPractice {
    /*
    class'i run ettigimde:
    Before class is running
Before Method is running
Test1 is running
After method is running
Before Method is running
Test2 is running
After method is running
Before Method is running
Test3 is running
After method is running
After class is running

     */

    //main method kullanilmaz

    @BeforeClass
    public void setupClass(){ //this one will only run 'once' before everyting in the class
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

    @Test
    public void TC1_test(){
        System.out.println("Test1 is running");
    }

    /*
    Before class is running
Before Method is running
Test1 is running
After method is running
After class is running

     */
    @Test
    public void TC3_test(){
        System.out.println("Test3 is running");
    }
    /*
    Before class is running
Before Method is running
Test3 is running
After method is running
After class is running
     */

    @Test
    public void TC2_test(){
        System.out.println("Test2 is running");
    }
}