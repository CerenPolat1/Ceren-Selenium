package renastech.day3_Locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import renastech.utilities.WebDriverUtil;

public class c1_googleImage {

    public static void main(String[] args) {
        //Task:Google Image link
        //1- Open a chrome browser and go to google
        //2- Click to Image link from top right
        //3- Verify Title contains Image

        //1- Open a chrome browser and go to google
        WebDriver driver=WebDriverUtil.getDriver("chrome");
        driver.get("https://www.google.com");

        driver.findElement(By.linkText("Images")).click(); //<span class="T8VaVe">images</span>
        //driver.findElement(By.partialLinkText("Ima")).click();

        //this weblement has also class name but it is not unique, gmail button also has same class name
        //gmail button is first matching one

//eger diyelim ki html'de id yok orng: class buldun onu arat once bak kac tane var or:2 tane var ve ilki senin kullanacagin
//o zaman sorun olmaz cunku code her zaman ilk gordugnu alir
// ama diyelim senin kullanacagin class baska bir elementde de isim olarak kullalmis
//o zaman o isim yine class isminde mi yoksa baska bir seyde mi or:name, id
//eger baska bir isimdeyse kullanbilirsin cunku sen kendikini class olarak kullanacaksin

        //3- Verify Title contains Image

        String actualTitle=driver.getTitle();
        String containsTitle="Image";

        if (actualTitle.contains(containsTitle)){
            System.out.println("Title passed");
        }else{
            System.out.println("Failed");
            System.out.println("actualTitle = " + actualTitle);
        }

        //driver.close();
    }
}

//interview question: what will your first chose locate your webelement?  //if it is not dynamic, my answer is ID
//eger html'deki id varsa onu kullan cunku o genelde unique baska seferde sana sorun yaratmaz ve kodun duzgunce calisir
//ama eger unique yoksa baska seylere yonel.
//eger id yoksa xpath ve css kullanilir

//eger diyelim ki html'de id yok orng: class buldun onu arat once bak kac tane var or:2 tane var ve ilki senin kullanacagin
//o zaman sorun olmaz cunku code her zaman ilk gordugnu alir
// ama diyelim senin kullanacagin class baska bir elementde de isim olarak kullalmis
//o zaman o isim yine class isminde mi yoksa baska bir seyde mi or:name, id
//eger baska bir isimdeyse kullanbilirsin cunku sen kendikini class olarak kullanacaksin