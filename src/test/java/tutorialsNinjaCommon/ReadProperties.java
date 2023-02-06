package tutorialsNinjaCommon;

import java.io.FileReader;
import java.util.Properties;

public class ReadProperties  {

	public static String readValues(String key) {
		try {
			FileReader fileReader = new FileReader("application.properties");
		    Properties properties = new Properties();
			properties.load(fileReader);
			String browserName =properties.get(key).toString();
			return browserName;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

