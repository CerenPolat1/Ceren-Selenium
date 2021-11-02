package renastech.day1_introduction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment {
    //TC #1: Facebook title verification
//Task - 1
//Open Chrome Browser
//Go to https://www.facebook.com
//Verify title: Expected: "Facebook - Log In or Sign Up"
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver chrome=new ChromeDriver();

        //when you put chrome.get("https://www.google.com"); it gives error bec.of having already get method

        chrome.get("https://www.facebook.com");

        Thread.sleep(2000);

        //Verifying  title contains : "Facebook - Log In or Sign Up"
        String actualTitle=chrome.getTitle();
        String containTitle= "Facebook - Log In or Sign Up";

        if(actualTitle.equals(containTitle)){
            System.out.println("test is passed as expected");
        }else{
            System.out.println("test is failed");
        }


    }
}
