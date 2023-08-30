package tutorialsNinjaCommon;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonUtils {
	public static String generateRandomString() {
		/*String generateString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String randamString = "";
		for (int i=0; i<10; i++) {
			new Random().nextInt(52);
			randamString+=generateString.charAt(5);
		}
		return randamString;*/
		  String generatedstring=RandomStringUtils.randomAlphabetic(8);
	        return(generatedstring);
	}
	
	public static String generateRandomInteger() {
		String generateString = "0123456789"; //double codes will take as string
		String randamString = "";
		for (int i=0; i<10; i++) {
			new Random().nextInt(10);
			randamString+=generateString.charAt(2);
		}
		return randamString;
	}
	public String captureScreenShot(WebDriver driver,String testName) 
	{
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
	
		File sourceScreenshot = screenshot.getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir") +File.pathSeparator+ "Screenshots" +File.pathSeparator+ testName + ".png";
		File destinationScreenshot = new File(destinationPath);
		try {
			FileUtils.copyFile(sourceScreenshot,destinationScreenshot);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationPath;
	}
	

}
