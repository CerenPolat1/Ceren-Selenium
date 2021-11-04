package renastech.day3_Locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import renastech.utilities.WebDriverUtil;

public class c6_relativeXpath {

    //1-//tagname[@attribute='value']-- looks for tagname attribute and value
    // 2-//tagname[contains(@attribute, 'value')] --locate webelemnt  with the given value if contains
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

//Locater approaches:

//--first option will be id because it is unique (but we will also need to make sure if it is static not dynamic
//--second option can be name, class name, linktext if they are unique (usually name and classname are not unique.
//--then, i perefer xpath

//  Differencec between Css and Xpath
//--Xpath has custom methods but css doesnt have those
//--Xpath has ability to go from child to parent and parent to child
//--but in Css, you can only go from parent to child
//--Css works little faster than Xpath.
