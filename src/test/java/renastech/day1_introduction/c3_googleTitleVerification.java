package renastech.day1_introduction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class c3_googleTitleVerification {

    //        Task
    //1.Open Chrome Browser
    //2.Go to google
    //3.Verify title : Expected : Google

    public static void main(String[] args) throws InterruptedException {

        //    //1.Open Chrome Browser
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();

        Thread.sleep(2000);
        //    //2.Go to google
        driver.get("https://www.google.com");

        Thread.sleep(2000);


        //    //3.Verify title : Expected : Google
        String expectedTitle="Google";
        String actualTitle=driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Google Title Verification Has Passed !!");
        }else {
            System.out.println("Google Title Verification Has Failed !!");
            System.out.println("Browser title is " + actualTitle); //bu println leri aciklama gibi dusun
            // ve senin codu yorumlamana daha fazla yardimci olur, 1den fazla olursa yorumnlamak kolay olur
            //or:fail verdi ama neden? gibi, actualtitle o yuzden printe koyduk
        }

        //if you have an issue in if else conditon in selenium, your code will work without any problem
        // but if you have an issue in assert,your test gives error and stop running


        driver.close();
    }
}