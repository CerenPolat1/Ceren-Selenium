package renastech.day2_Locaters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment {
    public static void main(String[] args) throws InterruptedException {


//TASK 1: Google search
//1- Open a chrome browser
//2- Go to: https://google.com
//3- Write "orange" in search box
//4- Click google search button
//5- Verify title:
//Expected: Title should start with "apple" word
//6-navigate back
//7-write cherry in search box
//8-verify title contains cherry.

        WebDriverManager.chromedriver().setup();
        WebDriver google= new ChromeDriver(); //Open a chrome browser

        google.get("https://google.com"); // Go to: https://google.com


        WebElement searchbox= google.findElement(By.name("q"));
        searchbox.sendKeys("orange");

        Thread.sleep(2000);
        WebElement click=google.findElement(By.name("btnK"));
        click.click(); //Click google search button

        google.navigate().back();

        WebElement newsearch= google.findElement(By.name("q"));
        newsearch.sendKeys("apple");

        Thread.sleep(1000);

        WebElement clicking=google.findElement(By.name("btnK"));
        clicking.click(); //Click google search button

       String title= google.getTitle();
       String mytitle="apple";

       if(title.startsWith(mytitle)){
           System.out.println("title is expected");
       }else{
           System.out.println("wrong title");
       }

       google.navigate().back();

        WebElement searching= google.findElement(By.name("q"));
        searching.sendKeys("cherry");
        Thread.sleep(1000);

       WebElement fruit=google.findElement(By.name("btnK"));

       fruit.click();

       String ttle= google.getTitle();
       String mytittle="cherry";

       if(ttle.contains(mytittle)){
           System.out.println("title is passed");
       }else{
           System.out.println("title failed");
       }

         google.close();
//task2
//  //1- Open a chrome browser and go to google
//        //2- Click to Images link from top right
//        //3- Verify Title contains Images, expected: "Images"

        WebDriverManager.chromedriver().setup();
        WebDriver browser= new ChromeDriver();
        browser.get("https://google.com");

        WebElement abc=browser.findElement(By.linkText("Images"));
        abc.click();

        String ty=browser.getTitle();
        String my= "Images";

        if(ty.contains(my)){
            System.out.println("title passed");
        }else{
            System.out.println("title failed");
        }

//task3
//1.open Chrome browser
//2.Go to https://www.amazon.com
//3.type TV on search box
//4.then click on search button
//5.verify title

            WebDriverManager.chromedriver().setup();
            WebDriver brsr= new ChromeDriver();

            brsr.get("https://www.amazon.com");

            WebElement sb= brsr.findElement(By.id("twotabsearchtextbox"));
            sb.sendKeys("tv");
            Thread.sleep(2000);

            WebElement ar=brsr.findElement(By.id("nav-search-submit-button"));
            ar.click();

            String g=brsr.getTitle();
            String thy="tv";

            if(g.contains(thy)){
                System.out.println("title passed");
            }else{
                System.out.println("title failed");
            }

            brsr.close();

        //tc4
//TASK: Google Feeling lucky button
//1- Open a chrome browser
//2- Go to: https://google.com
//3- Write "apple" in search box
//click i am feeling lucky button
//Verify title is Apple

            WebDriverManager.chromedriver().setup();
            WebDriver chrm= new ChromeDriver();

            chrm.get("https://google.com");

            chrm.findElement(By.name("q")).sendKeys("apple");

            Thread.sleep(2000);
            chrm.findElement(By.className("RNmpXc") ).click();

            String vrfy=chrm.getTitle();
            String neww="Apple";

            if(vrfy.contains(neww)){
                System.out.println("title passed");
            }else{
                System.out.println("title failed");
            }

            chrm.close();



//TASK5: Facebook incorrect login title verification
//1. Open Chrome browser
//2. Go to https://www.facebook.com
//3. Enter incorrect username
//4. Enter incorrect password
//5. Verify title changed to:
//Expected: "Log into Facebook"

            WebDriverManager.chromedriver().setup();
            WebDriver browssr=new ChromeDriver();
            browssr.get("https://google.com");

            Thread.sleep(1000);

            browssr.findElement((By.name("q")));
            browssr.get("https://www.facebook.com");

            Thread.sleep(1000);

            browssr.findElement(By.name("email")).sendKeys("adlckj");

            Thread.sleep(1000);
            browssr.findElement(By.name("pass")).sendKeys("bfhn"+ Keys.ENTER);

            String expected="Log in";
            String result= browssr.getTitle();

            if(expected.equals(result)){
                System.out.println("log in");
            }else{
                System.out.println("unvalid information was entered");
            }

            browssr.close();

//TC #6: Facebook header verification
//1. Open Chrome browser
//2. Go to https://www.facebook.com
//3. click Create a Page link
//4. verify new page has header called Create a Page (hint get text method)


        WebDriverManager.chromedriver().setup();
        WebDriver fb= new ChromeDriver();

        fb.get("https://google.com");
        Thread.sleep(1000);

        fb.get("https://www.facebook.com");

        Thread.sleep(2000);

        fb.findElement(By.className("_8esh")).click();

        String verify=fb.findElement(By.xpath("//div[@class='_203y']")).getText();
        String header= "Create a Page";

        if(verify.equals(header)){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }

        fb.close();

    }
}
