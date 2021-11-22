package renastech.day9_Actions_POM;


import org.testng.annotations.Test;
import renastech.Pages.LinkedInLoginPage;
import renastech.utilities.DriverUtil;
import renastech.utilities.PropertiesReadingUtil;




public class LinkedInPomAssignment{

    /*
    go to https://www.linkedin.com/login
enter  wrong username
enter wrong  password
verify "Please enter a valid username" text is present
Hint : use page object model .
//Page :
You will need to create LinkedinLoginPage and store necessary WebElements
Also create a method in your page that can do login function in the method.
Configuration File :
//In the configuration page store linkedin url,username ,password and use in your method or test .
     */


    LinkedInLoginPage linkedInLoginPage;

    @Test
    public void TC1_loginLinkedIn(){

       DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("LinkedIn_url"));

        linkedInLoginPage=new LinkedInLoginPage();

        linkedInLoginPage.loginLinkedIn(PropertiesReadingUtil.getProperties("LinkedIn_WrongUsername"),
                PropertiesReadingUtil.getProperties("LinkedIn_WrongPassword"));

        System.out.println("linkedInLoginPage.getStatusMessage() = " + linkedInLoginPage.getStatusMessage());

    }



}