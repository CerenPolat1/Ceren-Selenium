
package renastech.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SmartBearUtils {

    //method goal is to create a util that will do login function for smartbear

    public static void loginForSmartBear(WebDriver driver){
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
}