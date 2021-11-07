package renastech.day5_TestNG_Dropdown;

import org.testng.Assert;
import org.testng.annotations.*;

public class c1_TestNGexample {

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

    @Test(priority = 3 ,dependsOnMethods = "TC3_test") //we depended each other with this method
    public void TC1_test(){
        System.out.println("Test1 is running"); //TC3_test fail oldugundan TC1_test de run etmez
    }

    //neden dependsonmethods kullaniyoruz cunku birbiyle iliskili olabilen functionlari kullanmak icin
    //it makes it more efficient
    //or login function, username ve passwordu birletestdin, bunlar olmadan login yapamazsin mesela
    @Test(priority = 1)
    public void TC3_test(){
        System.out.println("Test3 is running");
        String actualword="hello";
        String expectedWord="hello2";

        Assert.assertEquals(actualword,expectedWord);
        System.out.println("continue test3"); //assert true olsaydi bu println run edceekti
    }

    //what is the skip at console??? if we see skip:1, what that means?
    //i means we have depended classes and one of them is not pass.

    @Test(priority = 2)
    public void TC2_test(){
        System.out.println("Test2 is running");
        String str="renastech";
        String str2="renastech";

        Assert.assertTrue(str.equals(str2));

    }

    @Ignore //it will ignore this test and wont run
    @Test
    public void TC4_test(){
        System.out.println("Running Test4");
    }
}