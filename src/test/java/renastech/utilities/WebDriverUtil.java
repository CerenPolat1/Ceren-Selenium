package renastech.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtil {

    //  //create connection between driver and browser
    //        WebDriverManager.chromedriver().setup();
    //        WebDriver driver =new ChromeDriver();
    //        driver.get("https://www.google.com");

    //create  a util that takes browser type and create connection between browser and selenium

    public static WebDriver getDriver(String browser){

        if (browser.equalsIgnoreCase("chrome")){
            //chrome browser needs to be setup
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")){
            //setup chrome
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else {
            System.out.println("Browser is not exist !!!");
            System.out.println("Checkk Browser Name");
            System.out.println("browser = " + browser);
            return null;
        }

    }
}