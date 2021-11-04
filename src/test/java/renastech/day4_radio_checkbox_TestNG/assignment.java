package renastech.day4_radio_checkbox_TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class assignment {
/*
1)Navigate to http://the-internet.herokuapp.com/
2)Validate  page title
3)Validate  page url
4)Click Checkboxes
5)Change Checkbox 1 to “Checked”
6)Validate that its “checked”
7)Change Checkbox 2 to “Unchecked”
8)Validate that Checkbox 2 is “Unchecked”
 */
public static void main(String[] args) throws InterruptedException {

    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.navigate().to("http://the-internet.herokuapp.com/");

    String pagetitle="The Internet";
    String currenttitle= driver.getTitle();

    if(pagetitle.equals(currenttitle)){
        System.out.println("test passed");
    }else {
        System.out.println("test failed");
    }

    String url="http://the-internet.herokuapp.com/";
    String currenturl=driver.getCurrentUrl();

    if(url.equals(currenturl)){
        System.out.println("test passed");
    }else{
        System.out.println("test failed");
    }

    Thread.sleep(1000);
    //Click Checkboxes

    driver.findElement(By.linkText("Checkboxes")).click();


//Change Checkbox 1 to “Checked” adn click


      WebElement checkbutton= driver.findElement((By.xpath("//input[@type='checkbox']")));
      checkbutton.click();
     driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


      if(checkbutton.isSelected()){
          System.out.println("test passed");
      }else{
          System.out.println("test failed");
      }

    //Change Checkbox 2 to “Unchecked”

    WebElement checkbutton2=driver.findElement(By.xpath("//input[2][@type='checkbox']"));
      checkbutton2.click();


   if(!checkbutton2.isSelected()) {
       System.out.println("test passed");

   }else{
       System.out.println("test failed");
   }

   driver.close();

}

}
