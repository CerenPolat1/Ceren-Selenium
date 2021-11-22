package renastech.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Guru99NewCustomerPage {

    @FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
    public WebElement NewCustomer;

    @FindBy (xpath = "//input[@type='text']")
    public WebElement CustomerName;

    @FindBy(xpath = "//input[@value='f']")
    public   WebElement female;

    @FindBy(xpath = "//input[@value='m']")
    public WebElement male;

    @FindBy(xpath = "//input[@id='dob']")
    public WebElement dateOfBirth;

    @FindBy (xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/textarea")
    public WebElement address;

    @FindBy(xpath = "//textarea[@rows='5']")
    public WebElement city;

    @FindBy (xpath = "//input[@name='state']")
    public WebElement state;

   @FindBy(xpath = "//input[@name='pinno']")
    public WebElement pin;

   @FindBy(xpath = "//input[@name='telephoneno']")
    public WebElement mobilenumber;

   @FindBy (xpath = "//input[@name='emailid']")
    public WebElement email;

   @FindBy (xpath = "//input[@onkeyup='validatepassword();']")
    public WebElement passwordd;

   @FindBy (xpath = "//input[@name='sub']")
    public WebElement submit;

    @FindBy(xpath="//p[@class='heading3']")
    public WebElement expectedSuccesMessage;











}
