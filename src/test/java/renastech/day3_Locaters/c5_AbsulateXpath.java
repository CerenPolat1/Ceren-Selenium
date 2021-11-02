package renastech.day3_Locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import renastech.utilities.WebDriverUtil;

public class c5_AbsulateXpath {

//     1-Absuluate Xpath  ///bunu kullanma  cunku kullanimi kolay ama kullanisli degil cunku developer yeni div falan eklediginde code degisecek
//        -start with /
//            -you need to start top parent (begning of html code)
//        -it is not usefull becasuse it takes from very top from to child
//
//            html
//    head
//            body
//    div
//            div
//    div
//            a
//    div
//            div
//    div
//            body
//    head
//            html
//
//        for ex : /html/body/div/div/a
//                 /html/body/div
//
//        if you have siblings you can use [number]. it will pick the siblings for you
//                         /html/body/div[2]

    public static void main(String[] args) {
        WebDriver driver= WebDriverUtil.getDriver("chrome");
        driver.get("http://practicerenastech.com/");

        WebElement header = driver.findElement(By.xpath("/html/body/app-root/div/div/app-home/h1[1]"));

       //check selenium header on the page

        //isdisplayed == it will check if webelement is present on the page
        //validate if selenium header is present in the renastech page

        if (header.isDisplayed()){
            System.out.println("Selenium header is present");
        }else {
            System.out.println("Slenium heasder is not present!!!!");
            System.out.println("header = " + header);
        }
    }
}