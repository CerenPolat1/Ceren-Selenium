package renastech.day2_Locaters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class c5_FacebookClassLoc {

    /*
    5.className :
--className is ***not always unique*** , thats why it might have multiple values of the same attribute
--and it will return you the first one it finds
syntax : driver.findElement(By.className("class attribute value"));
     */

    public static void main(String[] args) {
        //TC #3: Facebook header verification
        //1. Open Chrome browser
        //2. Go to https://www.facebook.com
        //3. Verify header text is as expected:
        //Expected: "Connect with friends and the world around you on Facebook."

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        //2. Go to https://www.facebook.com
        driver.get("https://www.facebook.com");

        //3. Verify header text is as expected:
        //Expected: "Connect with friends and the world around you on Facebook."

        String actualHeader=driver.findElement(By.className("_8eso")).getText(); //class name'in ismi: _8eso
        //-getText() is returning text element as a String, text'i yazmasaydik error veriyordu stringde
        //biz facebook'daki headerin yazini (Connect with friends and the world around you on Facebook) cektik
        /*
        yani ne yapmaya calistik
        faceebok sayfasindaki Connect with friends and the world around you on Facebook. header'ini almak istedik
        html codundaki yeri class olarak yer aldigindan classname methodunu kullandik class name:"_8eso"
        head'irdaki yaziyi alabilmek icin getText'i kullandik
         */

        String expectedHeader="Connect with friends and the world around you on Facebook.";

        if (actualHeader.equals(expectedHeader)){
            System.out.println("Header PAssed !! ");

        }else{
            System.out.println("Header Failed !!!! ");
            System.out.println("actualHeader = " + actualHeader);
        }

       //driver.close();

    }
}