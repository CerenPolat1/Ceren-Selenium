
package renastech.Pages;

import org.openqa.selenium.support.PageFactory;
import renastech.utilities.DriverUtil;

public abstract class BasePage {

    /*
IN POM Design you need to have some structure for each page :
1.PageFactory.initElements(driver, this);
		-> It creates connection in between driver and object of the class.
2. @FindBy annotation to locate webElements.
		-> Using this FindBy annotation, help us to locate web elements.
3. Create methods related webelements
     */

    //    1.PageFactory.initElements(driver, this);
//		-> It creates connection in between driver and object of the class.
    public BasePage(){
        PageFactory.initElements(DriverUtil.getDriver(),this);
    }
}