package renastech.day4_radio_checkbox_TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class assignment2 {
    //1. Open Chrome browser
//2. Go to https://demo.guru99.com/test/radio.html
//3. Verify all checkboxes are not selected (you can use findelements to store in list and use for loop to validate)
//4. Click to checkbox3
//5. Verify checkbox3 is selected
//2. Go to https://demo.guru99.com/test/radio.html
//4. Click to radiobutton2
//5. Verify radiobutton2 is selected

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.guru99.com/test/radio.html");

        Thread.sleep(3000);

        List<WebElement> allcheckbx= driver.findElements(By.xpath("//input[@type='checkbox']")); //nasil olusturduk bunu?
        //normalde 3 check boxi secebilecek bir webelement yoktu o yuzden her birinde ortak olan seyi sectik xpathi olusturuken
        //ortak olan sey de checkbox yazisiydi o yuzden onu aldik
        //neden findElement's' aldik cunku 3 checkbox oldugundan

        for (WebElement each : allcheckbx){
            if (!each.isSelected()){
            }else {
                System.out.println("all check boxes is selected.");
            }
        }
            System.out.println("all check boxes isnt selected.");


            Thread.sleep(2000);


            driver.get("https://demo.guru99.com/test/radio.html");

            WebElement radioButton = driver.findElement(By.cssSelector("input[id='vfb-7-2']"));
            radioButton.click();

            if (radioButton.isSelected()) {
                System.out.println("radio button 2 is selected.");
            } else {
                System.out.println("radio button 2 is unselected.");
            }


            Thread.sleep(2000);

            //driver.close();


        }
    }

