
package renastech.day5_TestNG_Dropdown;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class c5_javaFakerExample {

    @Test
    public void TC1_JavaFakarExample(){
        //to be able to use librarry you need to create instance object from the class
        Faker faker=new Faker();

        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        //each time you run you will have new fake results (fake isimler face yani randomly atama yapar)
        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.address().cityName() = " + faker.address().cityName());

        System.out.println("faker.gameOfThrones().dragon() = " + faker.gameOfThrones().dragon());
        System.out.println("faker.lordOfTheRings().character() = " + faker.lordOfTheRings().character());
        System.out.println("faker.artist().name() = " + faker.artist().name());
    }
}