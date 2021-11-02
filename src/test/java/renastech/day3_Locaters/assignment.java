package renastech.day3_Locaters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class assignment {
    public static void main(String[] args) throws InterruptedException {
        //Task 1: Etsy Title Verification
//        1. Open Chrome browser
//        2. Go to https://www.etsy.com
//        3. Search for "laptop"
//        4. Verify title:
//        Expected: "laptop | Etsy"
//

        WebDriverManager.chromedriver().setup();
        WebDriver chrome= new ChromeDriver();

        chrome.get("https://www.etsy.com");

        WebElement abc=chrome.findElement(By.name("search_query"));
        abc.sendKeys("laptop"+Keys.ENTER);

        String current= chrome.getTitle();
        String mine= "Laptop | Etsy CA";

        if(current.equals(mine)){
            System.out.println("result is expected");
        }else{
            System.out.println("test failed");
        }

        chrome.close();

//        task 2:
//        1. Open Chrome browser
//        2. Go to http://practicerenastech.com/
//        3. Click on Elements button
//        3. Locate all the elements 1,2,3,4 part by using xpath locater



     WebDriverManager.chromedriver().setup();
     WebDriver dnz= new ChromeDriver();
     dnz.get("http://practicerenastech.com/");
     Thread.sleep(1000);
     dnz.findElement(By.id("selenium-Elements")).click();


        dnz.findElement(By.xpath(" //h1[.='Elements part I'] "));
        dnz.findElement(By.xpath(" //h1[.='Elements part II'] "));
        dnz.findElement(By.xpath(" //h1[.='Elements part III'] "));
        dnz.findElement(By.xpath(" //h1[.='Elements part IV'] "));

        dnz.close();

    }

}
