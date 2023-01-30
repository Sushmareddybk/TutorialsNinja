package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	By enterEmail = By.name("email");
	By enterPassword = By.name("password");
	By loginButton = By.xpath("//input[@value='Login']");
	By forgottenPasswordLinkInRightColumn = By.partialLinkText("Forgotten Password");
	By forgottenPasswordLinkInLoginField = By.partialLinkText("Forgotten Password");
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	public MyAccountPage enterLoginCredentialsAndClickOnLogin(String email, String password) {
		driver.findElement(enterEmail).sendKeys(email);
		driver.findElement(enterPassword).sendKeys(password);
		driver.findElement(loginButton).click();
		return new MyAccountPage(driver);
	}
	public ForgottenPasswordPage clickOnForgottenPasswordInRightColumn() {
		driver.findElement(forgottenPasswordLinkInRightColumn).click();	
		return new ForgottenPasswordPage(driver);
	}
	public ForgottenPasswordPage clickOnForgottenPasswordInLoginField() {
		driver.findElement(forgottenPasswordLinkInLoginField).click();	
		return new ForgottenPasswordPage(driver);
	}	
	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}
}
