package renastech.day2_Locaters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class n {


//task3
//1.open Chrome browser
//2.Go to https://www.amazon.com
//3.type TV on search box
//4.then click on search button
//5.verify title
public static void main(String[] args) throws InterruptedException {

    WebDriverManager.chromedriver().setup();
    WebDriver brsr= new ChromeDriver();

    brsr.get("https://www.amazon.com");

    WebElement sb= brsr.findElement(By.id("twotabsearchtextbox"));
    sb.sendKeys("tv");
    Thread.sleep(2000);

    WebElement ar=brsr.findElement(By.id("nav-search-submit-button"));
    ar.click();

String g=brsr.getTitle();
String thy="tv";

if(g.contains(thy)){
    System.out.println("title passed");
}else{
    System.out.println("title failed");
}

brsr.close();






}
}
