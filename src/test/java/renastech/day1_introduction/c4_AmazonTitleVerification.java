package renastech.day1_introduction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class c4_AmazonTitleVerification {

    public static void main(String[] args) throws InterruptedException {
        //Task - 2
        //Open Chrome Browser
        //Go to google
        //Navigate back
        //Navigate forward
        //Navigate to https://www.amazon.com
        //Verify title contains : Smile


        //        //Open Chrome Browser
        WebDriverManager.chromedriver().setup();

        WebDriver drvr=new ChromeDriver();
        Thread.sleep(3000);
        //        //Go to google
        drvr.get("https://www.google.com");  //this line takes us to google ,, go to the google

        Thread.sleep(3000);
        //Navigate back
        drvr.navigate().back(); // this line will take us back to empty page
        Thread.sleep(3000);
        //Navigate forward
        drvr.navigate().forward(); // this line will take us forward to google

        Thread.sleep(3000);
        //Navigate to https://www.amazon.com
        drvr.navigate().to("https://www.amazon.com"); //baska sayfadan (google)baska sayfaya (amazon) gecmeni saglar

        //Verify title contains : Smile
        String containsTitle = "Smile";
        String actualTitle = drvr.getTitle();

        if (actualTitle.contains(containsTitle)){
            System.out.println("Amazon Title PAssed");
        }else{
            System.out.println("Amozan title Failed");
            System.out.println("actualTitle = " + actualTitle);
        }


    }
}