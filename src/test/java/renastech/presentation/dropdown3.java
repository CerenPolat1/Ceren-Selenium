package renastech.presentation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import renastech.base.TestBase2;
import renastech.utilities.BrowserUtils;
import renastech.utilities.DriverUtil;

public class dropdown3 extends TestBase2 {
    @Test
    public void TC1_test() {
        DriverUtil.getDriver().get("https://exchange.sandbox.gemini.com/register/institution");

        WebElement dropdownBox = DriverUtil.getDriver().findElement(By.id("countryDropdown")); //html dropdown


        dropdownBox.sendKeys("Cuba");

        BrowserUtils.wait(2);
        dropdownBox.sendKeys(Keys.ARROW_DOWN); //go over the text
        dropdownBox.sendKeys(Keys.ENTER); //to choose it
    }
}
