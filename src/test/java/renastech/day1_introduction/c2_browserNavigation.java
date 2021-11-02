package renastech.day1_introduction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class c2_browserNavigation {

    public static void main(String[] args) throws InterruptedException {

        //create the connection between chrome and selenium
        WebDriverManager.chromedriver().setup();

        //create an instance of chrome driver
        WebDriver chromeDriver=new ChromeDriver();
        //parent                  //child

        //maximize the page, extradan yaptik
        chromeDriver.manage().window().maximize();

        chromeDriver.get("https://www.amazon.com");

        Thread.sleep(2000);
        chromeDriver.navigate().back();//yaptiklarini geri ceker sayfayi bos gosterir

        Thread.sleep(2000); //bazen codun browserdan daha hizli calisir o zaman da karisiliklik olur, internet problemi falan tam olarak anlamak iin koyuyoruz duyzgun gorunsuh diye
        chromeDriver.navigate().forward();

        System.out.println("chromeDriver.getTitle() = " + chromeDriver.getTitle());

        chromeDriver.navigate().to("https://www.facebook.com"); //sayfani baska sayfaya gecirir

        Thread.sleep(2000);

        System.out.println("chromeDriver.getTitle() = " + chromeDriver.getTitle());

        chromeDriver.close();
    }
}