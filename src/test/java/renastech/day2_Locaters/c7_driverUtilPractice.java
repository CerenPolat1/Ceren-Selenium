package renastech.day2_Locaters;

import org.openqa.selenium.WebDriver;
import renastech.utilities.WebDriverUtil;

public class c7_driverUtilPractice {

    public static void main(String[] args) {
        //create connection between driver and browser
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver =new ChromeDriver();
//        driver.get("https://www.google.com");
        //yukaridakileri bir daha tek tek yapmak yerine library'den cagirdik:WebDriverUtil


//        //WebDriver driver= WebDriverUtil.getDriver("firefox"); //WebDriverUtil'deki hazir methodu cekiyor
//
//        driver.get("https://www.google.com");
//        driver.close();

        WebDriver driver2=WebDriverUtil.getDriver("chrome"); //webdriverutil ile classi cagirdik,
                                       // getdriver ile de methodun ismini cagirdik ..hazir method yani
        driver2.get("https://www.facebook.com");
        driver2.close();

        //pc'de olmayan driverlari isleme calisinca error veriyor, o yuzden comment e aldim
//        //WebDriver driver3=WebDriverUtil.getDriver("CHROME")// WORKS
//        WebDriver driver3=WebDriverUtil.getDriver("EDGE");// WORKS
//        driver3.get("https://www.facebook.com");

      /*
      eger  edge'i run etmeye calisirsam soyle diyor
      Browser is not exist !!!
Checkk Browser Name
browser = EDGE
cunku WebDriverUtil'den grliyor bu yazi ve edge islenmedi oraya
       */
    }
}