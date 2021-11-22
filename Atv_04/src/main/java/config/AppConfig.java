package config;

import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    public static Properties PROPS = null;

    static {
        try {
            Properties props = new Properties();
            InputStream is = AppConfig.class.getResourceAsStream("/resources/config.properties");
            System.out.println(is);
            props.load(is);
            PROPS = props;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
