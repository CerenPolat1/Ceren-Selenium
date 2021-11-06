
package renastech.day5_TestNG_Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import renastech.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class c3_Dropdown {
    //task1
    //1. Open Chrome browser
    //2. Go to "http://the-internet.herokuapp.com/"
    //3 click on dropdown
    //confirm default selected dropdown is "Please select an option"
    //task2
    //1. Open Chrome browser
    //2. Go to "http://the-internet.herokuapp.com/"
    //3 click on dropdown
    //choose  option 2 from dropdown
    //choose option 1 from dropdown
    //choose option 2 from dropdown

    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        System.out.println("==============Dropdown Testing Started==============");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("==============Dropdown Testing Finished==============");
    }
    @BeforeMethod
    public void setup(){
        driver= WebDriverUtil.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/");
    }

    @Test
    public void TC1_verifyDefaultOptionInDropdown(){
        System.out.println("TC1 Started");
        //1. Open Chrome browser   //done
        //2. Go to "http://the-internet.herokuapp.com/" //done
        //3 click on dropdown
        driver.findElement(By.xpath("//a[@href='/dropdown']")).click();
        //or linktext or //a[.='Dropdown']


        //confirm default selected dropdown is "Please select an option"

        //1-select dropdowns are created by using <Select> tag in HTML
        //and if it is select dropdown you can handle by using Select class
        WebElement dropdownBox=driver.findElement(By.id("dropdown"));

        Select dropDown=new Select(dropdownBox);

        //confirm default selected dropdown is "Please select an option"
        String deaultOption=dropDown.getFirstSelectedOption().getText();
        String expextedDefault="Please select an option";

        System.out.println("deaultOption = " + deaultOption);
        Assert.assertEquals(deaultOption,expextedDefault , " Default option is not \"Please select an option\"");

    }

    @Test
    public void TC2_verifyOptionsFromDropdown() throws InterruptedException {
        System.out.println("TC2 Started");
        //task2
        //1. Open Chrome browser   done
        //2. Go to "http://the-internet.herokuapp.com/"  done
        //3 click on dropdown
        driver.findElement(By.xpath("//a[@href='/dropdown']")).click();

        //select dropdowns are created by using <Select> tag in HTML
        //and if it is select dropdown you can handle by using Select class
        WebElement dropdownBox=driver.findElement(By.id("dropdown"));

        Select dropDown=new Select(dropdownBox);

        Thread.sleep(2000);//no need to use it is just for making slower to see how it selects

        //choose  option 2 from dropdown
        dropDown.selectByVisibleText("Option 2");
        Thread.sleep(2000);
        //choose option 1 from dropdown
        dropDown.selectByValue("1");
        Thread.sleep(2000);
        //choose option 2 from dropdown
        dropDown.selectByIndex(2);

    }

    @AfterMethod
    public void closing(){
        driver.close();
    }


}