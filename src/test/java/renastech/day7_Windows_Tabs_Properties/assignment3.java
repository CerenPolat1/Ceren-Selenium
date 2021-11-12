package renastech.day7_Windows_Tabs_Properties;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import renastech.utilities.BrowserUtils;

import java.util.concurrent.TimeUnit;

public class assignment3 {
    // Alert Message handling

    //go to "http://demo.guru99.com/test/delete_customer.php"
    //delete customer 53920
    // Switch to Alert
    // Captur alert message.
    // Display alert message
    // Accepting alert

    WebDriver driver;
    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://demo.guru99.com/test/delete_customer.php");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void TC1_test(){

        //delete customer 53920
        WebElement customerID=driver.findElement(By.name("cusid"));
        customerID.click();
        customerID.sendKeys("53920");

        WebElement submit=driver.findElement(By.name("submit"));
        submit.click();

        // Switch to Alert
        Alert alert=driver.switchTo().alert();
        BrowserUtils.wait(2);
        // Captur alert message.
        // Display alert message
        System.out.println("alert.getText() = " + alert.getText());
        // Accepting alert
        alert.accept();

    }

}
