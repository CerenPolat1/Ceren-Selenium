package renastech.day3_Locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import renastech.utilities.WebDriverUtil;

public class c6_relativeXpath {

    //1-//tagname[@attribute='value']-- looks for tagname attribute and value
    // 2-//tagname[contains(@attribute, 'value') --locate webelemnt  with the given value if contains
    //3-//tagname[.='text'] --looks for exact text match for any attribute

    public static void main(String[] args) {
        WebDriver driver=WebDriverUtil.getDriver("chrome");
        driver.get("http://practicerenastech.com/");
        driver.manage().window().maximize();

        // //1-//tagname[@attribute='value']-- looks for tagname attribute and value
        //driver.findElement(By.xpath("//mat-card[@id='selenium-Elements']")).click();

        // 2-//tagname[contains(@attribute, 'value') --locate webelemnt  with the given value if contains

        driver.findElement(By.xpath("//mat-card[contains(@id , 'Elements')]")).click();

        //buradan neden selenium'u cikardik cunku unique olmuyordu zaten contain yapiyoruz.
        // o yuzden sadece elementi arattik o da unique cikti

        //            3-//tagname[.='text'] --looks for exact text match for any attribute

        WebElement seleniumheader1=driver.findElement(By.xpath("//h1[.='Elements part I']"));

        if (seleniumheader1.isDisplayed()){ //this method (.isDisplayed) works with webelement
            //isdisplayed will check if the element is presnet on the page
            System.out.println("Header is present");
        }else {
            System.out.println("header is not present" );
            System.out.println("seleniumheader1 = " + seleniumheader1);
        }



    }
}