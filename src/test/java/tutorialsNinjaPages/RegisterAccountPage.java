package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import tutorialsNinjaCommon.CommonUtils;

public class RegisterAccountPage {
	WebDriver driver;
	By firstNameField = By.name("firstname");
	By lastNameField = By.name("lastname");
	By emailField = By.name("email");
	By telephoneNumField = By.name("telephone");
	By passwordField = By.name("password");
	By confirmPasswordField = By.name("confirm");
	By agreeTermsCheckBox = By.name("agree");
	By submitButton = By.xpath("//input[@type='submit']");	
	public RegisterAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	public AccountSuccessPage enterPersonalDetailsAndClickSubmit(String email, String telephone, String password, String confirm) {
		driver.findElement(firstNameField).sendKeys(CommonUtils.generateRandomString());
		driver.findElement(lastNameField).sendKeys(CommonUtils.generateRandomString());
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(telephoneNumField).sendKeys(telephone);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(confirmPasswordField).sendKeys(confirm);
		driver.findElement(agreeTermsCheckBox).click();
		driver.findElement(submitButton).click();
		return new AccountSuccessPage(driver);
	}
	public String getRegisterAccountPageUrl() {
		return driver.getCurrentUrl();
	}
}
