
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

    WebDriver driver; //eger libraryden utiller cagiracaksan bunu kullan, cu nku tek lazim olan variable

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
        driver.findElement(By.xpath("//a[@href='/dropdown']")).click(); // WebDriver driver; ana class'in icinde oldugundan cagirabildik
        //or linktext or //a[.='Dropdown']


        //confirm default selected dropdown is "Please select an option"

        //1-select dropdowns are created by using <Select> tag in HTML
        //and if it is select dropdown you can handle by using Select class

//        HOW MANY TYPES OF DROPDOWN ARE THERE?
//
//                1- Select dropdowns: are created by using <select> tag in HTML
//
//   <select>
//      <option value="1"> option1 </option>
//      <option value="2"> option2 </option>
//      <option value="3"> option3 </option>
//   </select>
//                --use select class to locate them.
//
//        2- HTML dropdowns: these are the dropdowns that are created NOT USING <select>
//        - These dropdowns are handled just like any other webElement you will see on the page.

       WebElement dropdownBox=driver.findElement(By.id("dropdown"));

        Select dropDown=new Select(dropdownBox);

        //confirm default selected dropdown if it is "Please select an option"
        String deaultOption=dropDown.getFirstSelectedOption().getText(); //sayfayi actiginda secili olarak duruyor zaten, o yuzden getfirstselected methodunu kullandik
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
        WebElement dropdownBox=driver.findElement(By.id("dropdown"));//2.sayfadaki kisim

        Select dropDown=new Select(dropdownBox);

        Thread.sleep(2000);//no need to use it is just for making slower to see how it selects

        //choose  option 2 from dropdown
        dropDown.selectByVisibleText("Option 2");
        Thread.sleep(2000);

        //choose option 1 from dropdown
        dropDown.selectByValue("1");
        Thread.sleep(2000);

        //choose option 2 from dropdown
        dropDown.selectByIndex(2); //index 0:disabled, index1=option1,index2=option2

        //aslinda bu dropdown olayi su..bir kutucukta farkli versiyonlari secebilme durumumun olmasi or:
        //option1, option2, option3 bunlarin hepsi dropdown oluyor yani acilan demek

    }

 @AfterMethod
public void closing(){

        //driver.close();
   }


}