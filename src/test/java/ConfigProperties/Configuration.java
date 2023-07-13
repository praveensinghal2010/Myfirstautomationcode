package ConfigProperties;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Configuration {

	private static Properties properties;

	static {

		properties = new Properties();
		try {
			FileInputStream fis = new FileInputStream("config.properties");
			try {
				properties.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

}
