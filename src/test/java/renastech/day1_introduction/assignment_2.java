package renastech.day1_introduction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment_2 {
    //Task - 2
//Open Chrome Browser
//Go to google
//Navigate back
//Navigate forward
//Navigate to https://www.amazon.com
//Verify title contains : Smile
//-Go to https://www.etsy.com/
//            -Maximize window
//-Verify title doesnt contains "Smile"
//            -Verify Current Url
//-Go to https://www.amazon.com/
//            -Verify title
//-Verify Current Url
//-Navigate Back
//-Refresh
//-Quit browser
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();//Go to google

        WebDriver chrome=new ChromeDriver();//Go to google

        chrome.navigate().back();

        Thread.sleep(2000);
        chrome.navigate().forward();

        chrome.navigate().to("https://www.amazon.com");

        String contain= "Smile";
        String currentitle= chrome.getTitle();

        if(currentitle.contains(contain)){
            System.out.println("test was successfully passed");
        }else{
            System.out.println("test is failed");
        }

      Thread.sleep(2000);

        chrome.navigate().to("https://www.etsy.com/");

        Thread.sleep(1000);

        chrome.manage().window().maximize();

        String current="Smile";
        String etsytitle= chrome.getTitle();

        if(etsytitle.contains(current)){
            System.out.println("test was passed");
        }else{
            System.out.println("test failed");
        }

       String url=chrome.getCurrentUrl();
       String mine= "https://www.etsy.com/";

       if(url.equals(mine)){
           System.out.println("test is passed");
       }else{
           System.out.println("test failed");
       }

       Thread.sleep(1000);
       chrome.navigate().to("https://www.amazon.com");

       String currenttitle= chrome.getTitle();
       String match="Spend less, smile more";

       if(currenttitle.equals(match)){
           System.out.println("test is passed");
       }else{
           System.out.println("test failed");

           Thread.sleep(1000);

           String amazonurl =chrome.getCurrentUrl();
           String mineurl="https://www.amazon.com/";

           if(amazonurl.equals(mineurl)){
               System.out.println("test is passed");
           }else{
               System.out.println("test failed");
           }
       }
       Thread.sleep(1000);
       chrome.navigate().back();
       chrome.navigate().refresh();
       chrome.close();
    }
}
