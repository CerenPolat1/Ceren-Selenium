package renastech.day2_Locaters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class c3_GmailLinkPartialLoc {

   /* 2.Linktext (equals the text)
--this locater allows us to locate links by their text
--this locater will only works if webelement has links
    How do i understand if the webelement has links ?
        <a href="https//www.amazon.com"> Text amazon </a>
    Tagname --> a
    Attribute --> href
    Atrribute Value https//www.amazon.com
    Link text -- Text amazon*
    syntax : driver.findElement(By.linktext("Text amazon"));
    */
/*
3.Partiallinktext (contain the text)
--this locater allows us to locate links by their text
--but it doesnt need exact match for text

syntax : driver.findElement(By.partialLinktext("amazon"));


--To Search something in html
for mac click command+F
for windows ctrl+F

 */
    public static void main(String[] args) {
        //  //1- Open a chrome browser and go to google
        //        //2- Click to Gmail link from top right
        //        //3- Verify Title contains Gmail, expected: "Gmail"

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        //        //2- Click to Gmail link from top right
        //driver.findElement(By.linkText("Gmail")).click(); // check for exact match  //gmail link
        driver.findElement(By.partialLinkText("Gma")).click();
        //kismi netni alip okutmaya yarar

        //3- Verify Title contains Gmail, expected: "Gmail"

        String containsTitle="Gmail";
        String actualTitle=driver.getTitle();

        if (actualTitle.contains(containsTitle)){
            System.out.println("Gmail passed");
        }else {
            System.out.println("Gmail Failed !! ");
            System.out.println("actualTitle = " + actualTitle);
        }

        driver.close();
    }
}