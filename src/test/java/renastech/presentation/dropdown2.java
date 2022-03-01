package renastech.presentation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import renastech.utilities.SmartBearUtils;
import renastech.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class dropdown2 {

    //1- Open a chrome browser
    //2- Go to:http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    //3- Login
    //4. Click on Order
    //5. Select familyAlbum from product, set quantity to 5
    //6. Click to “Calculate” button
    //7. Fill address Info with JavaFaker
    //8. Click on “visa” radio button
    //9. Generate card number using JavaFaker
    //10Enter expiration date
    //11. Click on “Process”
    //12.Verify success message “New order has been successfully added.” is displayed.

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        //1- Open a chrome browser
        driver= WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //3- Login
        SmartBearUtils.loginForSmartBear(driver);

    }

    @Test
    public void TC1(){

        //4. Click on Order

        WebElement orderLink=driver.findElement(By.xpath("//a[.='Order']"));
        orderLink.click();

        //firstly, locate dropdown and then we will choose the option

        Select dropdownProduct=new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));


        dropdownProduct.selectByVisibleText("FamilyAlbum");

        WebElement quantity= driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")); //quantity
        quantity.sendKeys(Keys.BACK_SPACE);


        quantity.sendKeys("5");



    }
}

