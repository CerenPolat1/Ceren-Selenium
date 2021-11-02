package renastech.day2_Locaters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class c4_AmazonIdLoc {


    //burada onemli olan ID'nin static olmasi eger dynamic olursa surekli Id valueda degisiklik olur bu da istenmeyen bir durum

    /*
    4.id
    id is not always unique ******
--id will locate by matching id attribute's value.
--id is unique for the specific webElement
--if you have id and it is not dynamic you should always use id .
dynamic (when you refresh if you see id value is changing that means id is dynamic )

syntax : driver.findElement(By.id("id attribute value"));
     */
    public static void main(String[] args) throws InterruptedException {
        //1.open Chrome browser
        //2.Go to https://www.amazon.com
        //3.type laptop on search box
        //4.then click on search button
        //5.verify title

        //        //1.open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //2.Go to https://www.amazon.com
        driver.get("https://www.amazon.com");

        String searchData="hello world java is here";

        //        //3.type hello world java is here on search box
        //id is always unique
        //but we need make sure if id is static (not dynamic)
        //dynamic (when you refresh if you see id value is changing that means id is dynamic )

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchData); //"hello world java is here";
        //peki yukarida yazanin static oldugunu nasil anladik 2 kere inspection yaptik ve baktik degisikli var mi yazida diye

        //driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");
        //yukaridaki laptop yazar ama tiklamaz

        //driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop" , Keys.ENTER);

        // hemen yukaridaki searchbox'a laptop yazip tiklar, ama bunun gibi baska bir method daha var.hangisi?
        // String searchData olusturdun, id icine sendKeys icine searchData yi yazdin
        //bu sekilde sen string'de ne yazdiysan direkt onu olacak, yukaridakinde direkt istedigimiz metni yaziyoduk
        //alttaki de click yapmayi saglar, birinde mercige tiklamadan arama yapti digeri mercege tiklayip
        //islemi farkli yoldan yapmayi sagladi kisacasi




        //        //4.then click on search button
        Thread.sleep(1000);
        driver.findElement(By.id("nav-search-submit-button")).click(); //bu isim, arama butonunun yanida cikan mercek oluyor
        //yukaridaki yazi arama kutusunun icine yazildi, hemen yukaridaki de click yapmayi sagladi



        //5.verify title

        String containsTitle=searchData;
        String actualTitle=driver.getTitle();

        if (actualTitle.contains(containsTitle)){
            System.out.println("Amazon search passed");
        }else{
            System.out.println("Amazon search failed");
            System.out.println("actualTitle = " + actualTitle);
        }

        driver.close();
    }
}