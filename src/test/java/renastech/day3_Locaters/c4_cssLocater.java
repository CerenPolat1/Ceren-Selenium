package renastech.day3_Locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import renastech.utilities.WebDriverUtil;

public class c4_cssLocater {

    public static void main(String[] args) {

//        7-cssSelector
//        it has own syntax
//        common methods that you can use for css
//
//        1- tagname[attribute='value']
//        2- tagname.value -->      (.) means is className in css
//
//        3-tagname#value --> (#) means is id in css
//
//                --you can also go from parent to child
//        div[class='er4g'] > a

        WebDriver driver=WebDriverUtil.getDriver("chrome");

        driver.get("https://www.amazon.com");


//        1- tagname[attribute='value'] // bu methodlardan biri css'de kullanabilcegin
//            input[ dir='auto']  //bu bir ornek, bunu linki silip link yerien yaziyoruz sonra comamnd+f yapip aratiyoruz

//            driver.findElement(By.cssSelector("input[dir='auto']")).sendKeys("tv");
///           input[id='twotabsearchtextbox']

//        3-tagname#value --> # means id in css  //bu da ikinci bir method css icin
//            driver.findElement(By.id("twotabsearchtextbox"));
//            driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
//          input#twotabsearchtextbox

        driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("Tv");
        driver.close();
    }
}
//sevgin, xpath'i kullanmanizi tavsiye ederim dedi
//bir suru css ve xpath method var kullanabilecegimiz
//ama biz en yaygin olanlari ogrenicez