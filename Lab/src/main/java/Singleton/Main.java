package Singleton;

import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        try {
            Properties properties = PropertiesLoader.getInstance().getProperties();
            for (String s : properties.stringPropertyNames())
                System.out.printf("%s = %s\n", s, properties.getProperty(s));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
