package renastech.day2_Locaters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class c6_getText_getAttribute {

    public static void main(String[] args) {
        //create connection between driver and browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.google.com");

        WebElement gmailButton=driver.findElement(By.linkText("Gmail"));

        //linkText disinda className, partialText da kullanilbilirdi nereden anladik
        // html'deki gmail bilgileri bize bunlari uygulayabilecegimizi gosteriyor yazan bilgilerle or:clas,"Gmail"

        System.out.println("gmailButton.getText() = " + gmailButton.getText()); //Gmail
        System.out.println("gmailButton.getAttribute(\"href\") = " + gmailButton.getAttribute("href"));//seni linke goturur
        System.out.println("gmailButton.getAttribute(\"class\") = " + gmailButton.getAttribute("class")); //class ismi gb_f

        WebElement aboutButton = driver.findElement(By.className("MV3Tnb")); //google sayfasindaki about button
        System.out.println("aboutButton.getText() = " + aboutButton.getText()); //About

        System.out.println("aboutButton.getAttribute(\"href\") = " + aboutButton.getAttribute("href")); //https://about.google/?fg=1&utm_source=google-CA&utm_medium=referral&utm_campaign=hp-header
        // element'de sadece bir tane attribute olmaz: class, data-pid, href gibi attr. var bu gmailinkinde
        System.out.println("aboutButton.getAttribute(\"ping\") = " + aboutButton.getAttribute("ping")); ///url?sa=t&rct=j&source=webhp&url=https://about

        //yanii html'de turuncu olarak gorduklerin attribute oluyor
        //text'i bulmak istersek siyah yazanlar text oluyor
        //mor olanlar tag name
        //driver.close();
    }
}