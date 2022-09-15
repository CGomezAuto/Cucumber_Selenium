package utility;

import java.io.FileInputStream;
import java.util.Locale;
import java.util.Properties;

public class FetchConfigProperties {

    public static String fetchPropertyValue(String key) {
        try {
            FileInputStream file = new FileInputStream("./config/Config.properties");
            Properties property = new Properties();
            property.load(file);
            return property.get(key).toString().toLowerCase();
        } catch (Exception exception) {
            exception.printStackTrace();
            throw (new RuntimeException("[ERROR] Key with name: " + key + " does not exists"));
        }
    }
}