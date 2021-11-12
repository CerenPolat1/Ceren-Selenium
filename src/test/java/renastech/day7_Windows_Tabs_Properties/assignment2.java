package renastech.day7_Windows_Tabs_Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import renastech.utilities.BrowserUtils;
import renastech.utilities.PropertiesReadingUtil;
import renastech.utilities.SmartBearUtils;
import renastech.utilities.WebDriverUtil;

public class assignment2 {
    //    Smartbear software product verification
//       1. Open browser and login to Smartbear software
//       2. Click on View all orders
//       3. Verify Mark Smith has product as  "ScreenSaver"

    WebDriver driver;

@BeforeMethod
    public void before(){
        driver= WebDriverUtil.getDriver("chrome");
        BrowserUtils.wait(1);
        driver.get(PropertiesReadingUtil.getProperties("SmartBear_url"));
        driver.manage().window().maximize();
        SmartBearUtils.loginForSmartBear(driver);
        BrowserUtils.wait(1);

    }

    @Test
    public void TC1_test(){

        //2. Click on View all orders
        WebElement allOrders=driver.findElement(By.xpath("//a[.='View all orders']"));
        allOrders.click();

        //3. Verify Mark Smith has product as  "ScreenSaver"

        String markSmith=driver.findElement(By.xpath("//*[.='Mark Smith']")).getText();
        String actualProduct=driver.findElement(By.xpath("//table//tbody/tr/td[.='FamilyAlbum']")).getText();
        String expected="Mark Smith";
        String product="ScreenSaver";

        Assert.assertEquals(markSmith,expected,"Name does not match!!!");
        Assert.assertEquals(actualProduct,product,"Product is different!!!");

    }

}
