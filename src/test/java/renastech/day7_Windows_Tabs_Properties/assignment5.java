package renastech.day7_Windows_Tabs_Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import renastech.utilities.BrowserUtils;
import renastech.utilities.DriverUtil;
import renastech.utilities.PropertiesReadingUtil;
import renastech.utilities.SmartBearUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class assignment5 {

    //task5
//create a util method that will verify given state name is present in the smart bear table (edited)

    public static void verifyNameFromTable(String enterState){
        DriverUtil.getDriver().manage().window().maximize();
        DriverUtil.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("SmartBear_url"));
        SmartBearUtils.loginForSmartBear(DriverUtil.getDriver());
        //DriverUtil.getDriver().findElement(By.id("ctl00_MainContent_orderGrid"));

        List<WebElement> stateList=DriverUtil.getDriver().findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[8]"));

        for (WebElement eachState: stateList){
            if(eachState.getText().equals(enterState)){
                Assert.assertTrue(eachState.getText().equals(enterState)," is passed");

                return;//if you delete your return it will trigger the fail.
                //without return it doesnt check any true.


            }
        }
        BrowserUtils.wait(2);
        Assert.fail();
    }


    @Test(dataProvider = "stateNames")
    public void TC1_verifyGivenNameInTable(String enterState){
        verifyNameFromTable(enterState);
    }

    @DataProvider(name= "stateNames")
    public static Object[][] dataProvider(){
        return new Object[][]{
                {"ohio"},
                {"US"},
                {"CANADA"},
                {"VIRGINIA"},
                {"HJJHJH"}};

    }

}

