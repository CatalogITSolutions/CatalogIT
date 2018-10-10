package generalUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {

	Properties prop;
	FileInputStream file;
	String filePath;

	public ReadProperties(String filePath) {
		this.filePath = filePath;
	}

	public String readValue(String key) {
		try {
			file = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}

}
