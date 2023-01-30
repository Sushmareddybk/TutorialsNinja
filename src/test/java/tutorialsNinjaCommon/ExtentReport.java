package tutorialsNinjaCommon;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener {
	WebDriver driver;
	public static ExtentSparkReporter htmlReport;
	public static ExtentReports report; 
	public static ExtentTest test;


	public static void extentReport() {

		File filePath =new File(System.getProperty("user.dir")+"/ExtentReports/myReport.html");
		htmlReport = new  ExtentSparkReporter(filePath);
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		htmlReport.config ().setTheme (Theme.DARK); 
		htmlReport.config().setDocumentTitle("TutorialsNinjaTestreport");
		htmlReport.config().setReportName("TutorialsNinjaTestResultReports");
		htmlReport.config().setTimeStampFormat("dd/mm/yyyy-hh:mm:ss");
		/*ReadProperties readData =new ReadProperties();
		
		report.setSystemInfo("browser", readData.getBrowser());
		report.setSystemInfo("OS", "Windows10");
		report. setSystemInfo("Java Version", "17");
		report. setSystemInfo ("username", "Sushma"); 
		htmlReport.config ().setTheme (Theme.DARK); 
		htmlReport.config().setDocumentTitle("TutorialsNinjaTestreport");
		htmlReport.config().setReportName("TutorialsNinjaTestResultReports");
		htmlReport.config().setTimeStampFormat("dd/mm/yyyy-hh:mm:ss");*/
	}
	@Override
	public void onStart(ITestContext context) {
		extentReport();
		System.out.println("OnStart Method Invoked");
	}
	@Override
	public void onTestStart(ITestResult result) {
		String testName=result.getName();
		test = report.createTest(testName);
		test.log(Status.INFO,MarkupHelper.createLabel("OnTestStart: "+testName, ExtentColor.BLUE));
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		String testName=result.getName();
		test = report.createTest(testName);
		test.log(Status.PASS,MarkupHelper.createLabel("OnTestSuccess: "+testName, ExtentColor.GREEN));
	}
	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName();
		test = report.createTest(testName);
		test.log(Status.FAIL, MarkupHelper.createLabel("OnTestFailure: "+testName, ExtentColor.RED));
		test.log(Status.INFO, result.getThrowable());
		String screenshotPath = System.getProperty("user.dir") + "/Screenshots/" + testName + ".png";
		if (result.getStatus()==2) {
			test.fail("CapturedScreenShot:" + test.addScreenCaptureFromPath(screenshotPath));
		}
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		String testName=result.getName();
		test = report.createTest(testName);
		test.log(Status.SKIP,MarkupHelper.createLabel("OnTestSkipped: "+testName, ExtentColor.YELLOW));
		test.log(Status.SKIP,result.getThrowable());
	}
	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
}
