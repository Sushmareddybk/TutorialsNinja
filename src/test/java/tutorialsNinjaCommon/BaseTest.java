package tutorialsNinjaCommon;

import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseTest {
	public Logger log;

	public WebDriver driver;
	@Parameters("URL")
	@BeforeMethod
	public void launchBrowserAndOpenUrl(@Optional("http://tutorialsninja.com/demo/index.php?route=common/home")String url) throws MalformedURLException {
		/*DesiredCapabilities cap = null;
		String browse = ReadProperties.readValues("browser");
		if(browse.equalsIgnoreCase("chrome")) {
			cap = DesiredCapabilities.chrome();
		} else if(browse.equalsIgnoreCase("safari")) {
			cap = DesiredCapabilities.safari();
		} else if(browse.equalsIgnoreCase("edge")) {
			cap = DesiredCapabilities.edge();
		} else if(browse.equalsIgnoreCase("firefox")) {
			cap = DesiredCapabilities.firefox();
		} else
			cap = DesiredCapabilities.chrome();
		driver = new RemoteWebDriver(new URL("http://192.168.1.65:4444/wd/hub"),cap);*/
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		log = LogManager.getLogger("TutorialsNinja");
		driver.get(url);
		log.info("TutorialsNinja Url is Opened");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	@AfterMethod
	public void closeBrowser(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
		new CommonUtils().captureScreenShot(driver, result.getName());
		}driver.quit();
	}
	
	}



