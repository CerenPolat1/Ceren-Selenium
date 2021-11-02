package renastech.day1_introduction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class c1_HelloSelenium {
    public static void main(String[] args) throws InterruptedException {

        //create connection between selenium and browser
        //setup browser
        //web driver is  abstract class,, chromedriver ise method, web driver'da bulunan
        WebDriverManager.chromedriver().setup(); // boylelikle selenium'a browseri kurmus olduk


         //simdi yukaidakini islemek icin object olusturuyoruz:objecti de chromedriverdan (childclass) olusturuyoruz
        //cunku webdriver(parent) inferface oldugundan ondan object olusturulmaz *********
        //aslinda olusturuabilirsin normal javadaki objecti webdriver ile ama sana cok fazla overriding verir

        //create an instance of chromedriver to be able to test with chrome

        WebDriver driver=new ChromeDriver(); //this is also polymorpshim
        //we created a driver which is a chrome driver



        Thread.sleep(2000); //neden bunu koyduk cunku alttaki herkesinkinde ayni hizlda acilmiyor bu sureci gosterecek en azindan diye
        driver.manage().window().maximize();//this line will maximize (ekrani buyutuyor )our browser

//yani yukaridaki diyor ki manage my driver and pencere ac bunun icin ve mazimize et

        //simdiye kadar choremu actik, ekrani buyuttuk ama hala penceremiz bos

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());// ilk once get yapman lazim url'yi sonra bunu yapmalisin aksi halde calismaz
        //before you move on any website driver will be opened in empty page
        //url will be empty as well


        Thread.sleep(2000);

        //lets go to amazon.com
       driver.get("https://www.amazon.com");  //bu olmadan sayfa acilmaz cunku get yapiyorsun

//alttaki seni current url'ye goturuyor ve verify ediyor dogru url mi diye
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());//https://www.amazon.com/
        System.out.println("driver.getTitle() = " + driver.getTitle());//Amazon.com. Spend less. Smile more.

        Thread.sleep(2000);
        driver.close(); //acilan sayfayi  kapatmaya yarar.. manual olarak kapatmaktansa bu sekilde daha kolay

/*
bonigarcia ne ise yarar? ve nedir
bonigarsia bir dependencydir. bonigarcia provides connection between selenium and browser
nerededir?
pom.xml file icindedir
pom.xml file, maven'in icindedir, maven olmazsa pom da olmaz

what kinda tool is in the selenium?
java and maven
what is maven?
maven is a building, you just install your framework and you can use it

selnium-java is also important and it is also dependency

do you have cross funtional testing?
chromdayken firefoxa gecmek gibi



 */
    }

}
   // package olusturmak?
    //package olusturdun sonra da bunun alina class olusturdun
    // sonra baska bir package daha olusturdun elindeki classi bunun icien koyabilirsin

//ya da bir package olusturdun, bunun icine yine bi package olusturdun 2'si tek bir taneymis gibi gorun
//bundan kurtulmak icin 3.bir package olustur. o zaman hepsini tek tek gorebilirsin




