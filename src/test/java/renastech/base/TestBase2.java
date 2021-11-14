package renastech.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import renastech.utilities.BrowserUtils;
import renastech.utilities.DriverUtil;

import java.util.concurrent.TimeUnit;

public abstract class TestBase2 {//abstraction example
    //it has the same purpose with your first TestBase
    @BeforeMethod
    public void setup(){

        DriverUtil.getDriver().manage().window().maximize();
        DriverUtil.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void closing(){
        BrowserUtils.wait(2);
        //DriverUtil.closeDriver();
    }
}