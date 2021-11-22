package renastech.Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import renastech.base.TestBase;



public class GuruLoginPage extends BasePage {



 @FindBy(xpath = "//input[@type='text']")
 public WebElement usernamee;

 @FindBy(xpath= "//input[@type='password']")
  public WebElement passwordd;

 @FindBy(xpath="//input[@name='btnLogin']")
 public WebElement loginn;

 @FindBy(xpath = "/html/body/div[2]/h2")
 private WebElement text;


    public void loginpage (String userName, String password){

     usernamee.sendKeys(userName);
     passwordd.sendKeys(password);
     loginn.click();

 }

 public String gettext(){

  return text.getText();
 }






















}