package renastech.studyhall;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import renastech.utilities.WebDriverUtil;
import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class day_4 {

    WebDriver driver; //bunu neden methodlarin disinda kullaniyoruz class'in icinden herhangi bir yerden cagirmak icin

    @BeforeMethod
    public void set() throws InterruptedException {

        //go to website http://demo.guru99.com/test/newtours/register.php

        driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/test/newtours/register.php");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }


    @Test
    public void Test1() throws InterruptedException {

        //fill contact information --- dont use faker here

        driver.findElement(By.name("firstName")).sendKeys("Musab");
        driver.findElement(By.name("lastName")).sendKeys("TheGreat");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("19051905");
        driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("GS1905@hotmail.com");
        Thread.sleep(2000);

        //fill out mailing info

        driver.findElement(By.name("address1")).sendKeys("Lake George");
        driver.findElement(By.name("city")).sendKeys("Albany");
        driver.findElement(By.name("state")).sendKeys("New York");
        driver.findElement(By.name("postalCode")).sendKeys("1905");
        Select country = new Select(driver.findElement(By.name("country")));
        country.selectByVisibleText("NORWAY");
        Thread.sleep(2000);

        //fill user information -- dont use faker here

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("gs1905");
        driver.findElement(By.xpath("//input[@type='password' and @name='password']")).sendKeys("gs1905");
        driver.findElement(By.cssSelector("input[name='confirmPassword']")).sendKeys("gs1905");
        Thread.sleep(2000);

        //click on submit button

        driver.findElement(By.name("submit")).click();

        //verify your username and name displayed in the register page

        List<WebElement> username = driver.findElements(By.tagName("b"));
        WebElement getName = username.get(2);
        String name = getName.getText();
        String expectedName = "Dear Musab TheGreat,";
        Assert.assertEquals(name,expectedName,"The name is not present");

        //Example :  Dear hello dasdad, Note: Your user name is asdasda.

        WebElement getUsername = username.get(3);
        String uName = getUsername.getText();
        String expectedUname = "Note: Your user name is gs1905.";
        Assert.assertEquals(uName,expectedUname,"Username is not present");
    }



//////////////////////////////////////////////////////////////////////////////////////////////
//why do you need manual testing? why dont you do do aoutomation everytime?
    //because we need to do manual testing bacause we need to unserstand functinalites of application

//what is annotation (kullandigimiz @test, @beforemethod vb) in selenium? what kinda thins is it?
 //it is a structure, it is a flow of the test, you can do many things in this way, you can create test cases, also you can ignore them

// console'u actiginda sadece Ts (@Test) olanlari yani test caselerini onemser o yuzden before after methodlar consule da gorunmez

//tell me about your framework????
    // my framework is page object model base.i have some utilities to make our code resusable
    //also i can talk about configuration properties. you can store key and value
    //high level konusman lazim isinle ilgili ki karsindakini etkileyebilesin




    public static void main(String[] aa) throws AWTException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/newtours/register.php");
        driver.manage().window().maximize();

        Thread.sleep(3000);
        //scroll down the page


        //Click on Country Dropdown

        //dropdown'da select varsa onu kullanarak git, diyelim yok alttaki gibi yapabilirsin

        driver.findElement(By.name("country")).click();

        List<WebElement> allOptions = driver.findElements(By.xpath("//select[@name='country']//option"));
        System.out.println(allOptions.size());



        for(int i = 0; i<=allOptions.size()-1; i++) {


            if(allOptions.get(i).getText().contains("ANGOLA")) {

                allOptions.get(i).click();
                break;

            }
        }

        driver.findElement(By.name("submit")).click();

    }
}
