
package renastech.day10_POM_ExplicitWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import renastech.utilities.DriverUtil;

import java.util.concurrent.TimeUnit;

public class c2_explicitwaitExample {

    /*
          The Implicit Wait in Selenium is used to tell the web driver to
           wait for a certain amount of time before it throws a "No Such Element Exception".
          The default setting is 0. Once we set the time, the web driver will
          wait for the element for that time before throwing an exception
         */

 /*
        Explicit Wait //sayfa yuklenmeden islemiyor, sayfa yuklendikten sonra calisir
      The Explicit Wait in Selenium is used to tell the Web Driver to wait for
      certain conditions (Expected Conditions) or maximum time exceeded before
      throwing "ElementNotVisibleException" exception.
      It is an intelligent kind of wait, but it can be applied only for specified elements.
      */


    //implicit komple etkiliyo,
    //explicit sadece expectecd conditionslarda kullaniyoruz yani sadece bir webelement icin dusun
    @Test
    public void Tc1_impcilitWait(){
        DriverUtil.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DriverUtil.getDriver().get("https://www.google.com");
        DriverUtil.getDriver().findElement(By.name("q")); //diyelim buraya yanlis deger girdin,
        //exception vermek icin 10 saniye bekleyecek, ama verilen degerle dogruysa 10 saniye beklemeden run edecek
    }

    @Test
    public void Tc2_explicitwait(){

        WebDriverWait driverWait=new WebDriverWait(DriverUtil.getDriver(),15);
        //explicit'i kullanmak icin WebDriverWait class'ini cagirman gerekiyor
        //implicitle mantik ayni specific conditon'i bekler, eger presentsa run eder
        //eger prsent degilse 15 saniye bekler ondan sonra exception verir
        DriverUtil.getDriver().get("https://www.google.com");

        driverWait.until(ExpectedConditions.titleIs("Google"));//

        WebElement box=DriverUtil.getDriver().findElement(By.name("q"));// it won run until(ExpectedConditions.titleIs("Google")) starts to run
        //if (By.name("q") doesnt run,  driverWait.until(ExpectedConditions.titleIs("Google")) will wait 15 sec
        //if (By.name("q") runs, driverWait wont wait 15 sec, it will run fast, contion true oldugunda 15 saniye beklemeden run eder
        driverWait.until(ExpectedConditions.visibilityOf(box));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.name("q")));

    }


}