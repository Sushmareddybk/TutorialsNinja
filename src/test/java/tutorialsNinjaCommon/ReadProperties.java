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
/*try {
			fileReader = new FileReader(System.getProperty("user.dir")+"/propertiesFile/application.properties");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			properties.load(fileReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}*/
	/*public static String getBrowser()
	{
		String value = property.getProperty("browser");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("browser not found");
	}

	public String getBaseUrl()
	{
		String value = property.getProperty("baseurl");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not found");
	}

	public String getEmail()
	{
		String email = property.getProperty("defaultuser");
		if(email!=null)
			return email;
		else
			throw new RuntimeException("email not found");
	}

	public String getPassword()
	{
		String password = property.getProperty("defaultpassword");
		if(password!=null)
			return password;
		else
			throw new RuntimeException("password not found");
	}
}
		*/