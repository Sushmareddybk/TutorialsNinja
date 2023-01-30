package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgottenPasswordPage {
	WebDriver driver;
	By inputEmail = By.id("input-email");
	By submitButton = By.xpath("//input[@type='submit']");
	By successMsg = By.className("alert-success");
	By warningMsg = By.className("alert-danger");
	public ForgottenPasswordPage(WebDriver driver) {
		this.driver=driver;
	}
	public void enterEmailAndClickContinue(String email) {
		driver.findElement(inputEmail).sendKeys(email);
		driver.findElement(submitButton).click();
	}
	public String displayingAlertSuccessMessage() {
		String alertSuccessMessage = driver.findElement(successMsg).getText();
		return alertSuccessMessage;	
	}
	public String displayingAlertWarningMessage() {
		String alertWarningMessage = driver.findElement(warningMsg).getText();
		return alertWarningMessage;		
	}
}
