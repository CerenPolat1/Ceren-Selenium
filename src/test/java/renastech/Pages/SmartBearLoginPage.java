package renastech.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SmartBearLoginPage extends BasePage {

    //2. @FindBy annotation to locate webElements.
    //		-> Using this FindBy annotation, help us to locate web elements.
    //3. Create methods related webelements

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement usernameBox; //you assigned id locater to this weblement

    @FindBy(id = "ctl00_MainContent_password")
    public WebElement passwordBox;

    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement loginButton;

    @FindBy(id = "ctl00_MainContent_status")
    private WebElement statusMassege;
    //if this is private, you wont have access from outside
    //you will need create some methods to be able to use it:getter method


    //    //3. Create methods related webelements

    //-Name of these methods should be given as per the task they are performing,
    public void loginSmartBear(String username,String password){   // bu method'a invalid degerler girdiginde test'in negatife doner bunu burada degil bu methodu cagirdigin yerde yaparsin
        //either you can also assign your username and password from properties file
        //or just from coling the method

        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();

    }
/*
yukaridaki methodu niye olusturduk? cunku ihtiyacimiz oldugundan olusturduk because we wanted to login smart bear

alttaki methodu niye olusturduk?
it gıves us status messageç why we created it? because our test was telling us that
it is fail, get me the text of this status.otherwise, we dont need to create these methods
 */





    // negative login page yaratmaya gerek yok, result'in positive or nagatif olmasi onemli
    //you dont create seperate page for positive and negative result
    //peki page yarattigimizda icine ne olusturuyoruz?
    // webelements ******
    //you dont need negatif login method
    //always try to make your method as resusable as you can

    public String getStatusMessage(){  //return type string
        return statusMassege.getText();
    } //getter method bec. of private WebElement statusMassege;

    // bu method'u String yapmak zorunda degiliz, baska turlu de yapabilirdik:

    public WebElement getStatusMassegeElement(){ //boyle de olusturabilirdik, return type:Webelement
        return statusMassege;
    }




}