
package renastech.day7_Windows_Tabs_Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import renastech.base.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class c3_Windows extends TestBase {


    @Test
    public void TC1_multiWindow(){
        driver.get("http://practicerenastech.com/");
        driver.findElement(By.id("selenium-Elements")).click();
        driver.findElement(By.id("WindowsII")).click();

        System.out.println("before clicking new window driver.getTitle() = " + driver.getTitle());
        ////button[@id='open-window']
        WebElement openWindowButton=driver.findElement(By.xpath("//button[@id='open-window']"));
        openWindowButton.click();
        //after cliclikng this line now you have 2 window
        //and to be able to work on second window
        //change selenium focus on the next window
        System.out.println("after clicking new window driver.getTitle() = " + driver.getTitle());

        Set<String> allwindows=driver.getWindowHandles();//to store all windows

        List<String>windowList=new ArrayList<>();
        for (String window : allwindows){
            windowList.add(window);
            driver.switchTo().window(window);
            System.out.println("after switch driver.getTitle() = " + driver.getTitle());
        }

        driver.switchTo().window(windowList.get(1));
        System.out.println("after switch driver.getTitle() = " + driver.getTitle());

/*
                //span[.='Contact']
                (//span[.='Contact'])[1]
                (//span[.='Contact' and @class='elementor-icon-list-text'])[1]
            //you can use and , or
            //in 'and'both  has to be true
            //in 'or'  one of them is enough
            //contains will work best with ids that are dynamic which has some part as static
 */

        driver.findElement(By.xpath("(//span[.='Contact' and @class='elementor-icon-list-text'])[1]")).click();

    }

}