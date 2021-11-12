package renastech.day7_Windows_Tabs_Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import renastech.utilities.BrowserUtils;
import renastech.utilities.SmartBearUtils;
import renastech.utilities.WebDriverUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class assignemnt1 {


//1- Open a chrome browser
//2- Go to:http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
//3- Login
//4. Click on view all products
//verify prices for each product
//expected Mymoney 100 ,familyalbum 80 , Screensaver 35


   WebDriver driver;

   @BeforeMethod
    public void before(){
       driver= WebDriverUtil.getDriver("Chrome");
       driver.manage().window().maximize();
       driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");


   }

    @Test
    public void viewallproducts(){

       SmartBearUtils.loginForSmartBear(driver);
        BrowserUtils.wait(3);
      WebElement allproduct= driver.findElement(By.xpath("//a[@href='Products.aspx']"));
      allproduct.click();
        BrowserUtils.wait(3);



    //verify prices for each product
   //expected Mymoney 100 ,familyalbum 80 , Screensaver 35

       WebElement table= driver.findElement(By.className("ProductsTable")); // whole table
       table.click();

       //  //table[@class='ProductsTable']//tr//td    specifik olarak belirtmedigimizden  tr ve td'nin tumunu alir yani tum listeyi
        //  in this way, i list all the elements in the table

        ////table[@class='ProductsTable']//tr[2]//td  boyle yapsaydim listenin 2.sirasindakini tumuyle alacakti yani tum row'u

       List<WebElement> products=new ArrayList<>(driver.findElements(By.xpath("(//table//tbody)[2]//tr//td[1]"))); //
        ////table//tbody)[2] demek html'de 2. olan  table ve tbody'i al,
        //  //tr//td[1] burada da tum colomn'larin 1.sini al yani mymoney, familyalbum, screensaver

       List<WebElement>price=new ArrayList<>(driver.findElements(By.xpath("//table//tbody/tr/td[@align='center'][1]")));
       // //table//tbody/tr/td[@align='center'][1] kisminda da table//tbody/tr/td parent to child oluyor
        //td[@align='center'][1] burada da td'lerin 2.siradakini al diyorsun column olarak peki neden [1] yaziyor??
        //cunku index nosu 0 dan basliyor. o yuzden bu 1. sirada olmus oluyor.


       ArrayList<String> list=new ArrayList<>();

       for (int i=0; i< price.size(); i++){
           list.add(products.get(i).getText()+" "+price.get(i).getText());
       }

       System.out.println("Table list = " + list);

       //verify prices for each product
       //expected Mymoney 100 ,familyalbum 80 , Screensaver 35
       ArrayList<String> expectedList=new ArrayList<>(Arrays.asList("MyMoney $100","FamilyAlbum $80","ScreenSaver $20"));
       Assert.assertEquals(list,expectedList,"Lists does not match!!!");

   }






}











