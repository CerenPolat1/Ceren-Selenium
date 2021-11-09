package renastech.day5_TestNG_Dropdown;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import renastech.utilities.SmartBearUtils;
import renastech.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class assignment3 {
    //task3. (use different locators that what we did class)
//1- Open a chrome browser
//2- Go to:http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
//3- Enter username --->Tester
//4- Enter password --->test
//5- Click "Login" button
//6- Verify title equals: Web Orders

WebDriver driver;

@BeforeMethod
    public void  beforemethod() throws InterruptedException {

    driver=WebDriverUtil.getDriver("Chrome");
    Thread.sleep(2000);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    SmartBearUtils.loginForSmartBear(driver);
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

}
@Test
    public void verifying (){

  Assert.assertTrue(driver.getTitle().equals("Web Orders"), "failed");
  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
}

@AfterMethod
    public void closing(){
    driver.close();
}

}
