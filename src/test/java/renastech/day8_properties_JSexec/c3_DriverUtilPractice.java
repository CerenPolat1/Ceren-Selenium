package renastech.day8_properties_JSexec;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import renastech.base.TestBase2;
import renastech.utilities.BrowserUtils;
import renastech.utilities.DriverUtil;
import renastech.utilities.PropertiesReadingUtil;

public class c3_DriverUtilPractice extends TestBase2 {

    //go to google
    //search for hello
    //veriffy title contains helllo
    @Test
    public void Tc1_practice(){
        DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("google_url"));

        WebElement searchBox=DriverUtil.getDriver().findElement(By.name("q"));

        String searchItem=PropertiesReadingUtil.getProperties("google_searchData");
        searchBox.sendKeys(searchItem + Keys.ENTER);
        //verify title contains hello

        BrowserUtils.wait(2);
        System.out.println("DriverUtil.getDriver().getTitle() = " + DriverUtil.getDriver().getTitle());
        Assert.assertTrue(DriverUtil.getDriver().getTitle().contains(searchItem));
    }

}