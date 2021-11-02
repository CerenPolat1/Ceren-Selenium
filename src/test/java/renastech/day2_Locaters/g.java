package renastech.day2_Locaters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class g {

//TASK5: Facebook incorrect login title verification
//1. Open Chrome browser
//2. Go to https://www.facebook.com
//3. Enter incorrect username
//4. Enter incorrect password
//5. Verify title changed to:
//Expected: "Log into Facebook"
public static void main(String[] args) throws InterruptedException {

    WebDriverManager.chromedriver().setup();
    WebDriver browssr=new ChromeDriver();
    browssr.get("https://google.com");

    Thread.sleep(1000);

    browssr.findElement((By.name("q")));
    browssr.get("https://www.facebook.com");

    Thread.sleep(1000);

    browssr.findElement(By.name("email")).sendKeys("adlckj");

    Thread.sleep(1000);
    browssr.findElement(By.name("pass")).sendKeys("bfhn"+ Keys.ENTER);

    String expected="Log in";
    String result= browssr.getTitle();

    if(expected.equals(result)){
        System.out.println("log in");
    }else{
        System.out.println("unvalid information was entered");
    }

browssr.close();



}
}
