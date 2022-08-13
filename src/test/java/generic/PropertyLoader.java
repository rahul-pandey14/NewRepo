package generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

	static Properties prop;

	public static String getPropertyValue(String key) throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Eclipse\\eclipse\\TestNG\\data.properties");
		prop.load(fis);
		String value = prop.getProperty(key);

		return value;
	}
}
