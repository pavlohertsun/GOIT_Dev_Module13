
package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class PropertiesReader {
    private static final String FILE_NAME = "hibernate.properties";
    public static String getDbConnectionUrl(){
        try {
            Properties prop = new Properties();
            prop.load(createInputStream());

            return prop.getProperty("hibernate.connection.url");
        }
        catch (IOException ex){
            System.out.println("error while reading username");
            return null;
        }
    }
    public static String getDbUsername(){
        try {
            Properties prop = new Properties();
            prop.load(createInputStream());

            return prop.getProperty("hibernate.connection.username");
        }
        catch (IOException ex){
            System.out.println("error while reading username");
            return null;
        }
    }
    public static String getDbPassword(){
        try{
            Properties prop = new Properties();
            prop.load(createInputStream());

            return prop.getProperty("hibernate.connection.password");
        } catch (IOException ex){
            System.out.println("Error while reading password");
            return null;
        }
    }
    public static InputStream createInputStream(){
        InputStream is = PropertiesReader.class
                .getClassLoader().getResourceAsStream(FILE_NAME);
        if(is == null) {
            System.out.println("empty stream");
            return null;
        }
        return is;
    }

}
