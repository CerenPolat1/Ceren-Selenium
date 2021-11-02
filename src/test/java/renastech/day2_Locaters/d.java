package renastech.day2_Locaters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class d {
    //TC #6: Facebook header verification
//1. Open Chrome browser
//2. Go to https://www.facebook.com
//3. click Create a Page link
//4. verify new page has header called Create a Page (hint get text method)
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver fb= new ChromeDriver();

        fb.get("https://google.com");
        Thread.sleep(1000);

        fb.get("https://www.facebook.com");

        Thread.sleep(2000);

       fb.findElement(By.className("_8esh")).click();

       String verify=fb.findElement(By.xpath("//div[@class='_203y']")).getText();
       String header= "Create a Page";

       if(verify.equals(header)){
           System.out.println("test passed");
       }else{
           System.out.println("test failed");
       }

    fb.close();




    }
}
