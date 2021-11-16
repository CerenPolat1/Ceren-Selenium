
package renastech.day9_Actions_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import renastech.base.TestBase2;
import renastech.utilities.DriverUtil;

public class c3_actionHoverOver extends TestBase2 {
    //go to http://the-internet.herokuapp.com/hovers
    //move mouse to third image
    //verify text of image present on the screen

    @Test
    public void TC1_HoverOver(){

        DriverUtil.getDriver().get("http://the-internet.herokuapp.com/hovers");

        //h5[.='name:user3'] bu normalde img'i aliyor ama img'in yazisini almiyor yazisini da almasi icin parent'a ciktik

        //h5[.='name: user3']/../../img    // 2 parent'a ciktik
        //h5[.='name: user3']/../preceding-sibling::img

        //direct locate edemediklerimizde ya parent dan chila ya da childan parante gideriz
        // [.  olayinda da text olanlarda kullanbiliyoruz, attribute'u belli olmayanlarda kullniyoruz

        //  /preceding-sibling  will go previous sibling
        //  /following-sibling  will go next sibling
        //yukaridakilerin hepsi ayni kapiya cikiyor

        WebElement thirdimage=DriverUtil.getDriver().findElement(By.xpath("//h5[.='name: user3']/../preceding-sibling::img"));


        Actions actions=new Actions(DriverUtil.getDriver());

        actions.moveToElement(thirdimage).perform();

        WebElement ImageText=DriverUtil.getDriver().findElement(By.xpath("//h5[.='name: user3']")); //text'i assert etmek icin olussturduk bunu aslinda

        boolean testIsPresent=ImageText.isDisplayed();
        Assert.assertTrue(testIsPresent,"text is not present");

        //action'da yaptigimiz hover over yani mouse'u surekleme olayinda kullanilan method:
        //movetoelement
    }
}