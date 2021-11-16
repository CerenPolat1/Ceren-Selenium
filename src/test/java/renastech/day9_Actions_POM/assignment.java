package renastech.day9_Actions_POM;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import renastech.base.TestBase2;
import renastech.utilities.BrowserUtils;
import renastech.utilities.DriverUtil;

public class assignment extends TestBase2 {
    // Alert Message handling

    //go to "http://demo.guru99.com/test/delete_customer.php"
    //delete customer 53920
    // Switch to Alert
    // Capture alert message.  (Store allert messege )
    // Display alert message	(Print allert message)
    // Accepting alert


    @Test
    public void test1(){

        DriverUtil.getDriver().get("http://demo.guru99.com/test/delete_customer.php");

        WebElement customer=DriverUtil.getDriver().findElement(By.name("cusid"));
        customer.sendKeys("53920");

        WebElement customerr=DriverUtil.getDriver().findElement(By.name("submit"));

        customerr.click();

        Alert alarm= DriverUtil.getDriver().switchTo().alert();
        System.out.println("alarm.getText() = " + alarm.getText());

        BrowserUtils.wait(2);

        alarm.accept();
        alarm.accept();





    }














}
