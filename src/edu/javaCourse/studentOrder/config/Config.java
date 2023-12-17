package edu.javaCourse.studentOrder.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static final String DB_URL = "db.url";
    public static final String DB_LOGIN = "db.login";
    public static final String DB_PASSWORD = "db.password";

    public static final Properties properties = new Properties();

    public static String getProperties(String name){
        if(properties.isEmpty()){
            try(InputStream is = Config.class.getClassLoader().
                    getResourceAsStream("daoProperties")){
                properties.load(is);
            } catch (IOException ex){
                ex.printStackTrace();
                throw new RuntimeException();
            }
        }
        return properties.getProperty(name);
    }
}
