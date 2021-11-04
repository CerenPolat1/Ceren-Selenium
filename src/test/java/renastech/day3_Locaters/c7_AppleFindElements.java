package renastech.day3_Locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import renastech.utilities.WebDriverUtil;

import java.util.List;

public class c7_AppleFindElements {
    //1. Open Chrome browser
    //2. Go to https://www.apple.com
    //3. Click to iPhone
    //4. Print out the texts of all links
    public static void main(String[] args) {
        WebDriver driver = WebDriverUtil.getDriver("Chrome");
        driver.get("https://www.apple.com");

        //3. Click to iPhone

        //xpath has ability to go also from child to parent
        //to child to parent use /..

// *******driver.findElement(By.xpath("//span[.='iPhone']")).click();//neden click yapmiyor
        //cunku bazilari boyle unclickable olabiliyor ve oyle oldugunda onun bi parentina cik

        driver.findElement(By.xpath("//span[.='iPhone']/..")).click(); //parent
        //parent yapabilmek icin /.. ekliyoruz  ************* bu bizi direkt parenta goturuyor


        //4. Print out the texts of all links //sayfada gorulen tum clickable olan seyleri print yap o da:a
        //print out all links
        //count of links that doesnt have text
        //count of links that has text
        //a tag has all the link

        List<WebElement> allLinks =driver.findElements(By.xpath("//body//a"));
        // yani parent (body) to child (a) oluyor.
        // yani tum sayfanin ogelerini kapsayarak a'ya(continue button'una gidiyor).
        //peki neden a'ya(continue button'una gidiyor)?
        //cunku a'da link oldugundan onu seciyoruz a demek href demek o yuzden.baska bir nedeni yok
        //body'nin icinde yer alan link'e ulasmak icin a'ya gidiyoruz cunku a=href demek

        int linkWithText=0; //to count elements that has text
        int linkwithoutText=0; //to count elements that doenst have text

        for (WebElement eachLink : allLinks){
            String elementsToText=eachLink.getText(); //""boyle empty de olabilir  "Airtag" de yazabilir
            System.out.println(elementsToText);

            if (elementsToText.isEmpty()){
                linkwithoutText++;
            }else {
                linkWithText++;
            }
        }

        System.out.println("linkWithText = " + linkWithText);
        System.out.println("linkwithoutText = " + linkwithoutText);
        System.out.println("allLinks.size() = " + allLinks.size());

//run yaptiginda cikan sayilar degisebilir cunku updateler gelir yeni functionlar eklenir vs. ayrica farkli ulkelerde
        //farkli sayilar cikar, ulkeden ulkeye degisir yani




        // how can we understand webelement has link???? /**************
        // html'de gordugun a tag, webelementte link oldugunu soyler sana
    }
}
