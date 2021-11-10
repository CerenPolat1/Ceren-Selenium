package renastech.day7_Windows_Tabs_Properties;

import org.testng.annotations.Test;
import renastech.utilities.PropertiesReadingUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class c4_PopertiesPractice {

    @Test
    public void TC1_systemProperties(){
        //java has some ready properties that you can get system info
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));
    }

    @Test
    public void TC2_configurationProperties() throws FileNotFoundException {
        //to be able to make our code understand properties file i need to connect to my file
        Properties properties=new Properties();

        String pathForPropertiesFile="configuration.properties";

        //bunu nereden bulduk, configuration.properties'e sag click, copy Path diyerek,,
        // simdi sadece copy yapmak istedigin seyin ustune click yap o kadar
        //we need to get path of file either absulate or root

        //we need to tell compiler to open this file
        FileInputStream fileInputStream=new FileInputStream(pathForPropertiesFile); //2.kisim exception v eriyo onda da throw kullan ya da ne istersen

        try {
            properties.load(fileInputStream);//file needs to be loaded in the automation
            //we use load method that comes from Properties class
        } catch (IOException e) {
            e.printStackTrace();
        }

        //now we can read the file
        System.out.println(properties.getProperty("SmartBear_url")); //bunlar configuration.properties'den geliyor
        System.out.println(properties.getProperty("SmartBear_username"));

        /*
        you can store those type of important things in the properties file instead of storing in the code,
        that would look much better in your file and user creator and
        you can just read it and use in this

        let's say, you use only proporties to test 10 of your test cases for smartbear
        and then suddenly there is another positive user created and that can help you to login
        so you have to go back your 10 of classes and change them for each of classes

        but if you are using configuration.properties, just come to this properties file, and change here what you want
        it will apply all of them, you dont have to change in each 10 classes.. it makes much easier

         */

    }
    @Test
    public void TC3_configurationProperties() throws FileNotFoundException {
        System.out.println(PropertiesReadingUtil.getProperties("SmartBear_url"));
        System.out.println(PropertiesReadingUtil.getProperties("SmartBear_password"));

    }

}