package renastech.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverUtil {

    //to be able to achive singelton design pattern we will need to have private constructor
    //no one can be able to create object from this class because we are making constructor private .

    private DriverUtil() {

    }

    private static WebDriver driver; // we are using encapsulation logic in here by making driver priavate
    //we will need to create getter and setter for driver

    public static WebDriver getDriver(){

        if (driver==null){
            String browser=PropertiesReadingUtil.getProperties("browser");

            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;
            }

        }
        return driver;
    }

    public static void closeDriver(){
        if (driver != null){
            driver.quit();
            driver=null;
        }
    }

  /*
   we need to learn functıon of utıls
   exp: what is the function of this driveUtil?
   having singlelton design util, being able to use different driver types:headless drivers, different drivers






   */

}

/*
bu util'leri nasil yarattigimizi ezberlelemize gerek yok, onemli olan bunlarin nasil isledigini anlayabilmek
bir yerde store et isin dustugunde al oaradan kullan
soyle interview sorulari gelebilir:
you said your framework is testnG, CAN YOU EXPLAIN YOUR FRAMEWORK(testng)?

I use code singelton design pattern in my utils
I use configuration proterties to provide  maintance easly
and easy to handle if i need to change anything
also i created drivel utils that has singlelton design pattern method
and it allows me to have driver as one object
and nobody will able to create object from this driver outside of the class directly
thats why i make it private constructor.
my framwork also support  headless options, in my util i also put chrome headless, firefox headless
and i put them to my framwork
propertiesleri degistirerek cok kisa zamanda yeni bir driver ekleyebilir ve onu calistirabilirim
i creta esome base classes to store my before and after methods to reduce of typing extra code










 */