package renastech.day8_properties_JSexec;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import renastech.base.TestBase2;
import renastech.utilities.BrowserUtils;
import renastech.utilities.DriverUtil;

public class c4_AllertPractice extends TestBase2 {

      /*
         Go to "http://the-internet.herokuapp.com/"
         click JavaScript Alerts
         Click for Js Prompt
         Enter "hello word" text
         Click okay
         Validate your text appearing on the page
         */

    @Test
    public void AllertPractice(){
        DriverUtil.getDriver().get("http://the-internet.herokuapp.com/");
        WebElement jsAllertbutton=DriverUtil.getDriver().findElement(By.xpath("//a[.='JavaScript Alerts']"));
        jsAllertbutton.click();
        //button[.='Click for JS Prompt']

        WebElement clickForPromptButton=DriverUtil.getDriver().findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        clickForPromptButton.click();

        Alert alert=DriverUtil.getDriver().switchTo().alert();
        String word="Hello Word";   //bu yaziyi aslinda kutuya yaziyorn ama biz farketmiyoruz bazen boyle seyler oluyormus automationda ama sonuc passed cikiyor yani testingde sikinti yok
        alert.sendKeys(word);
        BrowserUtils.wait(5);
        alert.accept();

        WebElement actualText=DriverUtil.getDriver().findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(actualText.getText().contains(word));

    }

}
