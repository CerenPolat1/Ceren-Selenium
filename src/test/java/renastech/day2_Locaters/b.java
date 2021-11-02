package renastech.day2_Locaters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class b {
    //tc4
//TASK: Google Feeling lucky button
//1- Open a chrome browser
//2- Go to: https://google.com
//3- Write "apple" in search box
//click i am feeling lucky button
//Verify title is Apple
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver chrm= new ChromeDriver();

        chrm.get("https://google.com");

       chrm.findElement(By.name("q")).sendKeys("apple");

        Thread.sleep(2000);
        chrm.findElement(By.className("RNmpXc") ).click();

        String vrfy=chrm.getTitle();
        String neww="Apple";

        if(vrfy.contains(neww)){
            System.out.println("title passed");
        }else{
            System.out.println("title failed");
        }

        chrm.close();



    }
}
