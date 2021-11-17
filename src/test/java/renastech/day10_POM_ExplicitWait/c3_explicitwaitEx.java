package renastech.day10_POM_ExplicitWait;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import renastech.Pages.SeleniumPracticeExplicitWaitPage;
import renastech.base.TestBase2;
import renastech.utilities.DriverUtil;
import renastech.utilities.PropertiesReadingUtil;

public class c3_explicitwaitEx extends TestBase2 {

    //go to http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html
    //click on timer
    //verify webdriver text gets present

    SeleniumPracticeExplicitWaitPage seleniumPracticeExplicitWaitPage; //null object

    @Test
    public void tc1(){

        seleniumPracticeExplicitWaitPage=new SeleniumPracticeExplicitWaitPage();

        DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("selenium_practice_url"));
        //seleniumPracticeExplicitWaitPage.timerButton.click();

        seleniumPracticeExplicitWaitPage.getDefaultText();
        seleniumPracticeExplicitWaitPage.clickTimerButton();
        seleniumPracticeExplicitWaitPage.getDefaultText();
        //BrowserUtils.wait(5);//neden buraya 5 saniye koyduk cunku aldigimiz yerde yazilar araliklarla cikiyor
        //onlari yakalamak icin bu saniyeleyi girdik ona ragmen sadece 2'sini almisti.
        WebElement actualText=seleniumPracticeExplicitWaitPage.getWebDriverText(); //bu method sayesinde, yaziyi bekleyecek,
        // gordukten sonra run edecek, bu sayede testimiz duzgunce run ediyor, o yuzden testin run etmesi uzun suruyor

//        public WebElement getWebDriverText(){  //seleniumPracticeExplicitWaitPage'den geldi
//            webDriverWait.until(ExpectedConditions.visibilityOf(webDriverText));
////        System.out.println("webDriverText.getText() = " + webDriverText.getText());
//            return webDriverText;

        seleniumPracticeExplicitWaitPage.getDefaultText();
        //bunlarin hepsi seleniumPracticeExplicitWaitPage'den geldi

        Assert.assertEquals(actualText.getText(),"WebDriver" , "Webdriver text is not present on the page!!");
    }
}

// *******************************
//we extend TestBase2 with logic of inheritence
//we get before and after method
//we create page class SeleniumPracticeExplicitWaitPage
//and we stored webelements that we need to be able to do testing and some usefull methods
//create an object from page to be able to call webelements and methods
//you navigate your url with using properties file and properties util
//then you click on timer
//then you waited until webdriver text to be present
//then verify your text was present

//**********************************