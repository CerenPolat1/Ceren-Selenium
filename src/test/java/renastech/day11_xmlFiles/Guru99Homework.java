package renastech.day11_xmlFiles;


import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import renastech.Pages.Guru99HomePage;
import renastech.Pages.Guru99NewCustomerPage;
import renastech.Pages.GuruLoginPage;

import renastech.utilities.DriverUtil;
import renastech.utilities.PropertiesReadingUtil;


public class Guru99Homework {

//    POM Example TEST
//    Step 1) Go to Guru99 Demo Site   http://demo.guru99.com/V4/
//    Step 2) In Login page check text "Guru99 Bank" is present
//    Step 3) Login into application  with given credentials
//    Step 4) Verify that the Home page contains text as "Manger Id: mngr368294"
//    Step 5) Click on new customer button and verify you are in New Customer Entry Page
//    Step 6) Fill the information for new customer
//    Step 7) Verify new customer added sucessfully
//    user id: mngr368294
//    password: ybAvagy
    //    Hint-TestNG :
    //Pages : In this task you will need to create 3 pages class
    //First one for login page where you need to locate : username,password,Login and Guru99 Bank text
    //Second page is for home page and you need to locate : text Manger Id
    //Third page is for New Customer Entry Page where you need to locate : customer information boxes such as name,adrees,gender,email,password etc.
    //Configuration File
    //store username,pasword , and url
    //Utils
    //use our ready utils such as readingproperties,driver, browser utils
    //Base
    //use our ready testbase classes.
    //Testing
    // while testing first you will verify "Guru99 Bank" is present
    // then you need to Login into application
    // then verify Home page contains text as "Manger Id: mngr368294"
    // click on new customer tab then verify title contains New Customer Entry Page
    // fill all information to be able create a customer
    // verify the message customer registered succesfully.

//    GuruLoginPage loginPage;
//    Guru99HomePage homepage;
//    Guru99NewCustomerPage customerpage;
//    WebDriver driver;


    @Test
    public void test1() throws InterruptedException {


        DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("Guru99_url"));

        GuruLoginPage loginPage = new GuruLoginPage();

        loginPage.loginpage(PropertiesReadingUtil.getProperties("Guru99_username"),
                PropertiesReadingUtil.getProperties("Guru99_password"));
        Thread.sleep(2000);

        String actual = loginPage.gettext();
        String expected = "Guru99 Bank";
        Assert.assertEquals(actual, expected, "test failed");

        //Verify that the Home page contains text as "Manger Id: mngr368294"


        Guru99HomePage homepage = new Guru99HomePage();

        String expected2 = "Manger Id : mngr368294";
        String actual2 = homepage.gettextmanager();

        if (expected2.contains(actual2)) {
            System.out.println("test passed");
        }
        Thread.sleep(2000);

        //Click on new customer button and verify you are in New Customer Entry Page

        Guru99NewCustomerPage customerpage = new Guru99NewCustomerPage();

        customerpage.NewCustomer.click();


//
//
//        String current3="New Customer";
//        String actual3=customerPAGE.getText();
//
//        if(current3.contains(actual3)) {
//            System.out.println("test passed");
//
//        }else{
//            System.out.println(actual3+ " = actual3");
//            System.out.println("current3  =  " + current3 );
//        }


//Fill the information for new customer

        Faker fake = new Faker();

        customerpage.CustomerName.sendKeys(fake.name().fullName());
        customerpage.female.click();
        customerpage.dateOfBirth.sendKeys("01/01/2001");
        customerpage.address.sendKeys(fake.address().streetAddress());
        customerpage.city.sendKeys(fake.address().city());
        customerpage.state.sendKeys(fake.address().state());
        customerpage.pin.sendKeys(fake.address().zipCode());
        customerpage.mobilenumber.sendKeys(fake.phoneNumber().cellPhone());
        customerpage.email.sendKeys("abc@gmail.com");
        customerpage.passwordd.sendKeys("1234brt");
        customerpage.submit.click();

        // verify the message customer registered succesfully.

        String ExpectedMessage = "Customer Registered Successfully!!!";

        Assert.assertEquals(customerpage.expectedSuccesMessage.getText(), ExpectedMessage);

    }
}










