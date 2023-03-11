import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class ConfigReader {
    private static final String CONFIG_FILE_NAME = "config.properties";
    public String getEncryptionKey() throws IOException {
            Properties prop = new Properties();
            InputStream input = new FileInputStream(CONFIG_FILE_NAME);
            prop.load(input);
            String key = prop.getProperty("encryption.key");
            input.close();
            return key;
    }
}
