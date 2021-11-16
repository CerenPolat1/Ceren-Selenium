
package renastech.Pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import renastech.utilities.DriverUtil;

public abstract class BasePage {



    protected WebDriverWait webDriverWait=new WebDriverWait(DriverUtil.getDriver(),15);

    //this conditon in wait, we will apply in our page. thats why it is good to use here, not on the base class



    /*
IN POM Design you need to have some structure for each page :
1.PageFactory.initElements(driver, this);
		-> It creates connection between  in driver and object of the class.

2. @FindBy annotation to locate webElements.
		-> Using this FindBy annotation, help us to locate web elements.

3. Create methods related webelements
     */

    //    1.PageFactory.initElements(driver, this);
//		-> It creates connection in between driver and object of the class.
    public BasePage()   {

        PageFactory.initElements(DriverUtil.getDriver(),this);
    }
}