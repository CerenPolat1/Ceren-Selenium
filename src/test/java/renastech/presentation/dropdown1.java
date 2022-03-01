package renastech.presentation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import renastech.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class dropdown1 {

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

    @BeforeMethod
    public void setup(){
        driver= WebDriverUtil.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/");
    }

    @Test
    public void TC1_verifyDefaultOptionInDropdown(){


        driver.findElement(By.xpath("//a[@href='/dropdown']")).click();


        WebElement dropdownBox=driver.findElement(By.id("dropdown"));

        Select dropDown=new Select(dropdownBox);

        //confirm default selected dropdown if it is "Please select an option"

        String deaultOption=dropDown.getFirstSelectedOption().getText();
        String expextedDefault="Please select an option";

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


        WebElement dropdownBox=driver.findElement(By.id("dropdown"));

        Select dropDown=new Select(dropdownBox);

        Thread.sleep(2000);

        //choose  option 2 from dropdown
        dropDown.selectByVisibleText("Option 2");
        Thread.sleep(2000);

        //choose option 1 from dropdown
        dropDown.selectByValue("1");
        Thread.sleep(2000);

        //choose option 2 from dropdown
        dropDown.selectByIndex(2); //index 0:disabled, index1=option1,index2=option2


    }


    }







