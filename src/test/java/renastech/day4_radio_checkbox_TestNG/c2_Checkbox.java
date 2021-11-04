package renastech.day4_radio_checkbox_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import renastech.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class c2_Checkbox {

    public static void main(String[] args) throws InterruptedException {
        //1. Open Chrome browser
        //2. Go to https://demo.guru99.com/test/radio.html
        //3. Verify checkbox1 is not selected
        //4. Click to checkbox2
        //5. Verify checkbox2 is selected

        WebDriver driver= WebDriverUtil.getDriver("chrome");
        driver.get("https://demo.guru99.com/test/radio.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //driver.findElement(By.id("vfb-6-0")); //best option to use it cunku id her zaman best option for us/******
        WebElement checkBox1=driver.findElement(By.xpath("//input[@value='checkbox1']")); //sadece oylesine bunu sectik
        //driver.findElement(By.xpath("//input[@id='vfb-6-0']"));

        //        //3. Verify checkbox1 is not selected
        if (!checkBox1.isSelected()){
            System.out.println("Default Verification for checkbox 1 passed");
        }else{
            System.out.println("Default Verification for checkbox 1 failed!!");
        }

        //4. Click to checkbox2
        WebElement checkbox2=driver.findElement(By.xpath("//input[@id='vfb-6-1']"));
        checkbox2.click();
        //5. Verify checkbox2 is selected

        if (checkbox2.isSelected()){
            System.out.println(" Verification for checkbox 2 after click passed");
        }else{
            System.out.println(" Verification for checkbox 2 after click failed");
        }

        //Thread.sleep(3000);
        driver.close();

//checkbox'in calismadigini dusun, bunu verify yapmak icin html sayfasindan yine locator kullanmak gerek
        //to be able to do test Ny web element
        // first action that i need to do is to locate webelement


    }
}