package renastech.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkedInLoginPage extends BasePage{


    // I need to locate my webelements to enter wrong user name and wrong password in my LinkedInPomAssignment.

    @FindBy (xpath ="//input[@id='username']")
    public WebElement userNameBox;   //bunlarin her biri instance variable. sadec method'un icine call ediliyor.

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement loginButtton;

    @FindBy(id = "error-for-username")
    private WebElement message;

    public void loginLinkedIn(String userName, String password){

        userNameBox.sendKeys(userName); //variable'i iceri cagiriyoruz, interitance'i dusun, this() kullanmadik cunku isimleri farkli
        passwordBox.sendKeys(password);
        loginButtton.click();
    }

    public String getStatusMessage(){  //neden bunu oliusturduk cunku message private

        return message.getText();
    }
}