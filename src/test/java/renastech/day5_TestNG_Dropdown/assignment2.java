package renastech.day5_TestNG_Dropdown;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import renastech.utilities.WebDriverUtil;
import java.util.concurrent.TimeUnit;
public class assignment2 {


//task2
//1. Open Chrome browser
//2. Go to "http://the-internet.herokuapp.com/"
//3. click on dropdown
//choose  option 1 from dropdown
//choose option 2 from dropdown
//choose option 1 from dropdown

    WebDriver driver;

    @BeforeMethod
    public void beforeclass(){
        driver= WebDriverUtil.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/");

    }

  @Test
    public void options() throws InterruptedException {


      driver.findElement(By.xpath("//a[@href='/dropdown']")).click();

      WebElement dropdownBox=driver.findElement(By.id("dropdown"));

      Select dropdown= new Select(dropdownBox);

      Thread.sleep(2000);

      dropdown.selectByValue("1"); //option 1 from dropdown

      Thread.sleep(2000);

      dropdown.selectByValue("2"); //option 2 from dropdown

      Thread.sleep(2000);

      dropdown.selectByValue("1");

      Thread.sleep(2000);
  }

   @AfterMethod
    public void closing(){
        driver.close();
   }


    }


