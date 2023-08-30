package tutorialsNinjaCommon;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class BaseTest {
	public Logger log;

	public WebDriver driver;
	public static ExtentSparkReporter htmlReport;
	public static ExtentReports report; 
	public static ExtentTest test;

	@BeforeSuite
	public static void extentReport() {

		File filePath =new File(System.getProperty("user.dir")+"/ExtentReports/myReport.html");
		htmlReport = new  ExtentSparkReporter(filePath);
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		htmlReport.config ().setTheme (Theme.DARK); 
		htmlReport.config().setDocumentTitle("TutorialsNinjaTestreport");
		htmlReport.config().setReportName("TutorialsNinjaTestResultReports");
		htmlReport.config().setTimeStampFormat("dd/mm/yyyy-hh:mm:ss");
	}
	@Parameters ("URL") //parameters
	@BeforeMethod
	public void launchBrowserAndOpenUrl(@Optional ("http://tutorialsninja.com/demo/index.php?route=common/home") ITestResult result, String url) throws MalformedURLException {
		DesiredCapabilities cap = null;
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
		driver = new RemoteWebDriver(new URL("http://192.168.1.65:4444/wd/hub"),cap);
		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		log = LogManager.getLogger("TutorialsNinja");
		driver.get(url);
		log.info("TutorialsNinja Url is Opened");
		driver.manage().window().maximize();
		test = report.createTest(result.getMethod().getMethodName());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@AfterMethod
	public void closeBrowser(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			String screenshotPath = new CommonUtils().captureScreenShot(driver, result.getName());
			String s ="";
			StackTraceElement[] x = result.getThrowable().getStackTrace();
			for (StackTraceElement stackTraceElement : x) {
				s += stackTraceElement.toString()+"\n";
			}
			test.fail(s);
			test.skip(s);
			test.addScreenCaptureFromPath(screenshotPath);
		}
		driver.quit();
	}

	@AfterSuite
	public void onFinish() {
		report.flush();
	}

}



