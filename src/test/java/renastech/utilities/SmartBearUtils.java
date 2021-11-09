
package renastech.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SmartBearUtils {

    //method goal is to create a util that will do login function for smartbear

    public static void loginForSmartBear(WebDriver driver){  //WebDriver driver, classta yer alan isntance null variable
        //3- Enter username --->Tester
        WebElement username=driver.findElement(By.id("ctl00_MainContent_username"));
        username.sendKeys("Tester");
        //4- Enter password --->test
        WebElement password=driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");
        //5- Click “Login” button
        WebElement loginButton=driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginButton.click();


    }



    ////3- enter incorrect username
    //    //4- enter wrong password
    //    //5- click login button
    //    //Note : create another utils method under SmartBearUtil class called negativeLoginForSmartBear
    //    //this method should cover step3,4,5
    public static void negativeLoginForSmartBear(WebDriver driver,String userID ,String passwordID){
        //3- Enter username --->incorrect username
        WebElement username=driver.findElement(By.id("ctl00_MainContent_username"));
        username.sendKeys(userID);
        //4- Enter password --->incorrect password
        WebElement password=driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys(passwordID);
        //5- Click “Login” button
        WebElement loginButton=driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginButton.click();
    }
}