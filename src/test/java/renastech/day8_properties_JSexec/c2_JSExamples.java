package renastech.day8_properties_JSexec;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import renastech.base.TestBase;

import java.util.Set;

public class c2_JSExamples extends TestBase {

    @Test
    public void TC1_handlingWindowWithJSExecuter(){
        driver.get("https://www.youtube.com");

        // 1- We create javascriptExecutor object and we cast our WebDriver type instance into JavascriptExecutor type.

        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
        // 2- Then we have access to the methods that are coming from JavascriptExecutor interface.
        //js.executeScript(Script,Arguments);

        Set<String> windows=driver.getWindowHandles();

        for (String window : windows){
            driver.switchTo().window(window);
            String currentWindow=driver.getWindowHandle();
            System.out.println("currentWindow = " + currentWindow);
            System.out.println("driver.getTitle() = " + driver.getTitle());
        }
    }

    @Test
    public void scroolDownWithJSExecuter(){
        JavascriptExecutor js=(JavascriptExecutor) driver; //creating object
        driver.get("http://demo.guru99.com/test/guru99home/");

        js.executeScript("window.scrollBy(0,1000)"); //bu methodla, sayfayi actiginda sayfanin el altina goturuyor seni
                                        //yukari gitmek istersen -1000 yaparsin, istedigin sayiyi ver, ona gore az veya cok iner veya cikar
                                        //0 merkez noktasi kabul edilir
        //bu method:js.executeScript("window.scrollBy

          /*
        The syntax of ScrollBy() methods is :
        executeScript("window.scrollBy(x-pixels,y-pixels)");
        x-pixels is the number at x-axis,
        it moves to the left if number is positive and
        it move to the right if number is negative .
        y-pixels is the number at y-axis,
        it moves to the down if number is positive and
        it move to the up if number is in negative .
         */
    }

    //java script executer method sayesinde ayni anda birden fazla tab acabiliyoruz

    //how can you use scroll down in page with using selenium? ****interview question
    // i am using java script executer method to do that one

}
