package renastech.day1_introduction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class c5_DifferentBrowserSetup {

    public static void main(String[] args) {
        //before you run, make sure you have the browser type in your computer

        WebDriverManager.edgedriver().setup(); //bende bunlar olmadigindan run etmedi
        WebDriver driver=new EdgeDriver();

        WebDriverManager.chromedriver().setup();
        WebDriver driver1=new ChromeDriver();

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver2=new FirefoxDriver();

        //since i dont have io driver in my loptop it wont run
        WebDriverManager.iedriver().setup();
        WebDriver driver3=new InternetExplorerDriver();


        driver.get("https://www.amazon.com");// it will take edge driver to amozon
        driver2.get("https://www.google.com"); // it will take firefox dirver to google

        //neden sadece google run ediyor, cunku sadece onun objewctini call ettik
        //commente koymazsan cogunu yine run etmeyi, commentleri kaldirdim laptopimda olmayanlarin

        //bende edge olmadigindan error veriyor o yuzden comment'a aldim
        //diyelim sende edge var ama gene de calismadi?
        //nedeni browser'in versionunun old olmasi olabilir
    }
}