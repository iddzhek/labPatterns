package Singleton;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public final class PropertiesLoader {
    private static PropertiesLoader instance;
    public final Properties properties;

    private PropertiesLoader() throws IOException {
        FileReader file = new FileReader("src/main/resources/config.properties");
        properties = new Properties();
        properties.load(file);
    }

    public static synchronized PropertiesLoader getInstance() throws IOException{
        if (instance == null)
            instance = new PropertiesLoader();
        return instance;
    }

    public Properties getProperties(){
        return properties;
    }
}
