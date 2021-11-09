
package renastech.day6_WebTable_Allerts_Iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import renastech.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class c4_iframes {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        //1- Open a chrome browser
        //2- Go to:http://the-internet.herokuapp.com/iframe
        driver= WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/iframe");
    }

    @Test
    public void Iframes(){
        //in order to interact with iframes we will need to swticch driver focus to iframes
        //3- Switching by id or name attribute value.
        //driver.switchTo.frame("idValue");
        driver.switchTo().frame("mce_0_ifr");
        WebElement messageBox=driver.findElement(By.id("tinymce"));
        messageBox.clear();
        messageBox.sendKeys("Hello Its ME!!!");

        driver.switchTo().defaultContent();//returns to the main html
        //driver.switchTo().parentFrame() //this will return you previous iframe of html block

        System.out.println("driver.getTitle() = " + driver.getTitle());
    }
}