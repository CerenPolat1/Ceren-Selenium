package renastech.day2_Locaters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class c1_FacebookTitleVerification {

    //TC #1: Facebook title verification
    //Task - 1
    //Open Chrome Browser
    //Go to https://www.facebook.com
    //Verify title: Expected: "Facebook - Log In or Sign Up"
    public static void main(String[] args) {

        //    //Open Chrome Browser
        //setup connection between selenium and browser
        WebDriverManager.chromedriver().setup();
        //create instance of driver

        WebDriver driver=new ChromeDriver(); //instance olusturuyoruz ayni zamanda polimorfisim
        driver.get("https://www.google.com");

        driver.manage().window().maximize();

        //Go to https://www.facebook.com
        driver.get("https://www.facebook.com");

        String expectedTitle="Facebook - Log In or Sign Up"; //sayfayi actiginda link kisminda cikar
        String actualTitle=driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Facebook Title Verification Passed");
        }else {
            System.out.println("Facebook Title Verification Failed!!!!!!!!!");
        }


        //driver.close();

    }
}