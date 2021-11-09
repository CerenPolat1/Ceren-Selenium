package renastech.day6_WebTable_Allerts_Iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import renastech.utilities.SmartBearUtils;
import renastech.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class c5_smartBearNegativeTest {
    //1- Open a chrome browser
    //2- Go to:http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    //3- enter incorrect username
    //4- enter wrong password
    //5- click login button
    //6- verify error message displayed :Invalid Login or Password.
    //Note : create another utils method under SmartBearUtil class called negativeLoginForSmartBear
    //this method should cover step3,4,5

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        //1- Open a chrome browser
        //2- Go to:http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver= WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

    }

    @Test(dataProvider = "testData")
    public void TC1_NegativeTest(String userName,String password){
        // direct alttakilerin ilkini username, 2.yi de password olarak alacak neden  cunku bu method testData ile eslesti diye
        //userName olarak ilk bolumu, password olarak da 2.bolumu alacak.
        //3- enter incorrect username
        //4- enter wrong password
        //5- click login button
        SmartBearUtils.negativeLoginForSmartBear(driver,userName,password);
        //6- verify error message displayed :Invalid Login or Password.
        WebElement errorMessage=driver.findElement(By.className("error"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    //diyelim positive olarak testlerin gecti bir de negatif olarak bakmak istiyorsun tek tek test olusturmak yerine
    //data provider kullanarak tek seferde yaparsin bunu

    @DataProvider(name = "testData")   //bunun sayesinde istedigin kadar seyi tek seferde run etmis olursun
    public static Object[][] wrongUserCredentails() {

        return new Object[][]{
                {"esther", "esther123"}, //username and password
                {"ozge", "ozge567"},//bunlarin hepsi wrong en alltaki sadece dogru neden fail cunku biz wrong ariyoruz
                {"", "435345"},
                {"mesut", "easy"},
                {"sdas&&& %$", "234 ^&"},
                {"Tester", "test"}  //correct credendial, o yuzden fail verdi
        };
    }
        //bu versiyonunu yapmasaydik soyle uzun versionunu yapacaktik

        @Test
        public void TC2_NegativeTest(){

            //3- enter incorrect username
            //4- enter wrong password
            //5- click login button
            SmartBearUtils.negativeLoginForSmartBear(driver, "sfg","cetg");
            //6- verify error message displayed :Invalid Login or Password.
            WebElement errorMessage=driver.findElement(By.className("error"));
            Assert.assertTrue(errorMessage.isDisplayed());
        }

    @Test
    public void TC3_NegativeTest(){

        //3- enter incorrect username
        //4- enter wrong password
        //5- click login button
        SmartBearUtils.negativeLoginForSmartBear(driver, "dfgh","erxf");
        //6- verify error message displayed :Invalid Login or Password.
        WebElement errorMessage=driver.findElement(By.className("error"));
        Assert.assertTrue(errorMessage.isDisplayed());


}