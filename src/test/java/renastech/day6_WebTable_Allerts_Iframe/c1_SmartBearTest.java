package renastech.day6_WebTable_Allerts_Iframe;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import renastech.utilities.BrowserUtils;
import renastech.utilities.SmartBearUtils;
import renastech.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class c1_SmartBearTest {
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
        //2- Go to:http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver= WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //    //3- Login
        SmartBearUtils.loginForSmartBear(driver);

    }

    @Test
    public void TC1(){
        //4. Click on Order

       //a[.='Order']
    //a[@href='Process.aspx']
        //linktext

        WebElement orderLink=driver.findElement(By.xpath("//a[.='Order']")); //order'in inspecti
        orderLink.click();

        //5. Select familyAlbum from product, set quantity to 5, yani quantity'de 5 yazsin
        //firstly, locate dropdown and then we will choose the option

        Select dropdownProduct=new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        //new Select'e geldigimizde bizden yukarinin icine select webelement yani select dropdown girmemizi istiyor

        dropdownProduct.selectByVisibleText("FamilyAlbum");

        WebElement quantity= driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")); //quantity'in inspecti
        quantity.sendKeys(Keys.BACK_SPACE);  //bundan once direct sendkeys:5 yazmistik ama
        // code run ettginde 05 yazisi cikiyodu oradaki 0'i silmek icin bu keywordu kullandik ve 1 adim geri gitti

        //quantity.clear();    //bu keyword ise var olani default olarak 0'a cevirir, diyelim 5 girmistin bunu yazdin
        //sonucusunu 0'a cevirir

        quantity.sendKeys("5");
        //quantity.clear(); //5 olmasi gerekirken o, default olarak 0a ceviriyor

        //6. Click to “Calculate” button
        WebElement calculateButton=driver.findElement(By.xpath("//input[@value='Calculate']"));//niye calculate'i aldik bir cok secenegin var bu unique oldugundan aldik
        calculateButton.click();

        //7. Fill address Info with JavaFaker

        Faker faker=new Faker();
        WebElement customerName=driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        WebElement streetName=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        WebElement cityName=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        WebElement stateName=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        WebElement zipName=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

        customerName.sendKeys(faker.name().fullName());
        streetName.sendKeys(faker.address().streetAddress());
        cityName.sendKeys(faker.address().cityName());
        stateName.sendKeys(faker.address().state());
        zipName.sendKeys(faker.address().zipCode().replaceAll("-",""));
        //neden replaceall kullandik cunku randomly atadigi icin bazisinda - ile bazisinda -'siz yapiyodu

        //8. Click on “visa” radio button
        WebElement visaButton=driver.findElement(By.xpath("//input[@value='Visa']"));
        visaButton.click();

        //9. Generate card number using JavaFaker
        WebElement cardNumber= driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")); //card number
        cardNumber.sendKeys(faker.finance().creditCard().replaceAll("-","")); //- cikardik cunku invalid yaziyodu sayfada
        //niye replace yerine replaceall yazdik sadece replace deseydik sadece bastakini yapip birakacakti o yuzden

        //cardNumber.sendKeys(faker.number().digits(12));
        //6771-8991-1109-4503

        //10Enter expiration date
        WebElement expDate= driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        expDate.sendKeys("05/27");  //neden tarih girdik faker yerine, bunun icin faker bulamadik attik kafadan
        //11. Click on “Process”
        WebElement proccessButton=driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        proccessButton.click();

        //12.Verify success message “New order has been successfully added.” is displayed.
        WebElement succesMessage= driver.findElement(By.xpath("//strong"));//sadece bi tane strong div oldugundan direct onu yazdik  buraya

        Assert.assertEquals(succesMessage.getText(),"New order has been successfully added.");
    }
}