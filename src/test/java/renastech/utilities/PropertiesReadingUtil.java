package renastech.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReadingUtil {

    //1- create properties object
    //2- get the path and store in String
    //3-  open the file use Fileinputstream method
    //4-  load the file to properties object by using load method from properties
    //5- close.file
    //plus dont forget to handle exceptions


    private static Properties properties=new Properties(); //file'lari okuyabilmek icin, yani conffiguration'i okuyyabimek icin
    //encapsulation hide the data

    static {//will get execute before everything  //bunu illa static yapmaya gerek yok, testin icine de koyabilirdik
        //2- get the path and store in String
        String pathForPropertiesFile="configuration.properties";
        //3-  open the file use Fileinputstream method
        //we need to tell compiler to open this file
        try {
            FileInputStream fileInputStream=new FileInputStream(pathForPropertiesFile);

            //4-  load the file to properties object by using load method from properties
            properties.load(fileInputStream);//file needs to be loadded in the automation
        } catch (IOException e) {  //biz bu exception'i parent'a cevirdik cunku   properties.load(fileInputStream) icin yeterli degildi
            e.printStackTrace();
            System.out.println("Properties File Not Founded!!!");
        }
    }

    public static String getProperties(String keyword){
        return properties.getProperty(keyword);
    }
}

//configurationn properties:yapilandirma ozellikleri