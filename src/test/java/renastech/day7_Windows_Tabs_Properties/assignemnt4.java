package renastech.day7_Windows_Tabs_Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import renastech.base.TestBase;
import renastech.utilities.DriverUtil;

public class assignemnt4 extends TestBase {
    //    task4
//go to http://the-internet.herokuapp.com/nested_frames
//switch between frames
//get text for each frame hint: use tagname to locate text or xpath

    @Test
    public void TC1_test(){
        driver.get("http://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement text1=driver.findElement(By.tagName("body"));
        System.out.println("text1 = " + text1.getText());
        //System.out.println(driver.findElement(By.tagName("body")).getText());
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-middle");
        WebElement text2= driver.findElement(By.id("content"));
        System.out.println("text2 = " + text2.getText());
        driver.switchTo().parentFrame();

        driver.switchTo().frame(2);
        //syntax of frame: you can put id or name inside that frame without saying driver.findelement.., but if id and name is equal.
        WebElement text3=driver.findElement(By.tagName("body"));
        System.out.println("text3 = " + text3.getText());
        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-bottom");
        WebElement text4=driver.findElement(By.tagName("body"));
        System.out.println("text4 = " + text4.getText());

    }

}