package renastech.day4_radio_checkbox_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import renastech.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class c1_implicitWaitExample {

    public static void main(String[] args) throws InterruptedException {
        //1.open browser
        //2.go to the page https://www.vinexponewyork.com/
        //3.click on attend button

        //1.open browser
        WebDriver driver= WebDriverUtil.getDriver("ChRome");
        driver.manage().window().maximize();
        //2.go to the page https://www.vinexponewyork.com/
        driver.get("https://www.vinexponewyork.com/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //bu second'i minute, milisec yapabilirsin
        // sen buraya 10 sn.girdin ama browser o kadar beklemiyor
        //ne zaman yakalarsa o zaman alir 1 saniyede, 2 saniyede, yani browserin hizina bagli illa 10 saniye sonra sayfaya click yapcak diye bir sey yok

        //we are giving driver an option to wait until page loadded
        //as soon as your weblement loadded it will move on next step
        //it is not going to wait until 10 sn
        //if this was thread.sleep no matter it will always wait for 10 sn

        //Thread.sleep(5000);
        //3.click on attend button
        WebElement attendButton=driver.findElement(By.cssSelector("a[href='/attend/']")); //neden class name'i kullanmadik
        //cunku kelimeler arasi spaceler vardi, oyle olunca kullanmiyoruz cunku kod bizi yaniltabilir
        //peki neden "a[href='/attend/']" bunun yerine a[role='button' kullanmadik cunku ondan 7 tane vardi ve
        //ilki bizim kullanacagimiz olmadigindan kullanamadik bizimki 3.deydi galiba
        //o yuzden only option Css and xpath'ti cunku kullanilabilecek baska locater yoktu

        attendButton.click();


    }
}

//seleniumTestNG and cucumber Bdd have just difference their framework both are IU(user interface) testing