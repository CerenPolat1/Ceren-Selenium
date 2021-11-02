package renastech.day2_Locaters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class c2_GoogleNameLocater {
    //TASK: Google search
    //1- Open a chrome browser
    //2- Go to: https://google.com
    //3- Write "orange" in search box
    //4- Click google search button
    //5- Verify title:
    //Expected: Title should start with "orange" word
    //6-navigate back
    //7-write banana in search box
    //8-verify title contains banana.

    //1.Name:
    // This locator will be looking into the whole HTML code and return the webelement
    // with matching name attribute value
    // --this  will find and return the first webelement it finds.
    //
    // syntax : driver.findElement(By.name("name attribute value")).

    public static void main(String[] args) throws InterruptedException {
        //go to google
        // 1- Open a chrome browser
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        // //    //2- Go to: https://google.com
        driver.get("https://www.google.com");

        //3- Write "orange" in search box
        //findelement will return you webelement

        //driver.findElement(By.name("q")).sendKeys("orange"); bunu tek adımda yaptık alttakılerı tek tek

        //WebElement searchBox=driver.findElement(By.name("Qasdasd"));//no such element exception
        //run ederken sikinti yaratmaz sadece exception verir peki neden?
        // cunku google htlm'sinde "Qasdasd" boyle bir isim yok

        WebElement searchBox=driver.findElement(By.name("q"));//no such element exception
        //yukaridakiyle searchboxa karsilik gelen kodu bulduk:"q"
        //yani search box'in ismi html kodunda name:q , idi


        searchBox.sendKeys("orange"); //arama butonuna orange yazmis oluyoruz

        Thread.sleep(2000); //neden bunu ekledik gene, cunku pc hiziyla kod hizi eslesmiyo ve exception veriyor diye

        //4- Click google search button
        WebElement googleSearchButton= driver.findElement(By.name("btnK")); //ornegin bu name'den de 2 tane var htmlde
        //o zaman her zaman ilkini alir
        googleSearchButton.click();

        //5- Verify title:
        //Expected: Title should start with "orange" word
        String expectedTitle="orange";
        String actualTitle=driver.getTitle();

        if (actualTitle.startsWith(expectedTitle)){
            System.out.println("Passed For Orange");
        }else {
            System.out.println("Failed For Orange !!!!");
            System.out.println("actualTitle = " + actualTitle); //bunu niye extradan etkledik
            //cunku diyelim fail verecek orange yerine Orange yazdin ve bu senin hatani gosterecek fark ne diye
        }
        Thread.sleep(2000);
        //6-navigate back
        driver.navigate().back();

        Thread.sleep(2000);

        //7-write banana in search box
        driver.findElement(By.name("q")).sendKeys("banana" + Keys.ENTER ); // googleSearchButton.click(); yerine Keys.ENTER kullandik

        //8-verify title contains banana.
        String expectedTitle2="banana";
        String actualTitle2=driver.getTitle();

        if (actualTitle2.startsWith(expectedTitle2)){
            System.out.println("Passed For Banana");
        }else {
            System.out.println("Failed For Banana !!!!");
            System.out.println("actualTitle = " + actualTitle2);
        }

        driver.close();


    }
}

/*
google'da html sayfasini gormek icin sag click-> inspection'i tikla
ardindan acilan html sayfasindan en ust sol kosede arama butonu var element icin
diyelim ki sayfadaki herhangi bir element'in html'deki yerini gormek istiyorsun
o zaman o butona tikla ve istedigin elementin ustune git, boyelikle seni o kodun oraya goturecek
boylelikle burada uygulayabilceksin
ama kodu bulup thmlnin icine mouse'u goturdugunde sayfada baska bir elementin yerini gormek icin
yine o kutucuga tiklaman gerekecek


ayrica, html'deki ornegin "q" adinda fazla element var mi yok mu bakmak lazim aksi halde codunu yanlis calistirip
istemedigin islemi buraya koyabilirsin o yuzden sadece 1 tane yani unique olmasi lazim elementin
bunu bulmak icin: htmlinın ustune gel command_f yap sana asagıda search box cıkacak
boylelıkle kac tane aradıgın seyden var gorebıleceksın
pekı qi elementiden bır suru cıktı bız nıye kullandıkö gırıs dersı oldugundan onemlı bı sey olmadıgından
en azından suan ıcın sadece gostermek ıcın qiyu aldık normalde alınmaz
 */