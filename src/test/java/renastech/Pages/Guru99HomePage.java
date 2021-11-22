package renastech.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Guru99HomePage extends BasePage {

    @FindBy(xpath = "//td[@style='color: green']")
    private WebElement textmanager;



  public String gettextmanager(){


   return textmanager.getText();

}




}



