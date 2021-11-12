package renastech.day8_properties_JSexec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import renastech.base.TestBase;
import renastech.utilities.PropertiesReadingUtil;
import renastech.utilities.SmartBearUtils;

import java.util.List;

public class c1_SmartBearPractice extends TestBase {
    //open chrome browser
    //go to http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    //click on box which belongs "charles Dodgeson"
    //click on delete button
    //verify if charles deleted from the list

    @Test
    public void TC1_CharlersDeleteVerification(){
        //go to http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get(PropertiesReadingUtil.getProperties("SmartBear_url"));
        SmartBearUtils.loginForSmartBear(driver);
        //click on box which belongs "charles Dodgeson"
        WebElement charlesCheckbox=driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl05_OrderSelector"));//charles Dodgeson
        charlesCheckbox.click();
        //click on delete button
        WebElement deleteButton=driver.findElement(By.className("btnDeleteSelected")); //click yaptigimizi remove ettik
        deleteButton.click();


        //verify if charles deleted from the list

        //after deleting the charles we will need to check all table and make sure charles is not in table anymore
        //first store all names
        List<WebElement> listOfNames=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
                                                                  //tum tablonun 2. siradaki column'nda bulunan namekeri aldik

        //verify charles is not there
        for (WebElement eachName:listOfNames){
            Assert.assertFalse(eachName.getText().equals("Charles Dodgeson") , "Charles is present in the table and verification failed");
        }



    }

    //how can you use scroll down in page with using selenium? ****interview question
    // i am using java script executer method to do that one



}