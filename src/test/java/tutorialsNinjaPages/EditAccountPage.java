package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditAccountPage {
	WebDriver driver;
	By firstNameInPersonalDetails = By.id("input-firstname");
	By lastNameInPersonalDetails = By.id("input-lastname");
	By submitButton = By.xpath("//input[@type='submit']");
	public EditAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	public void editPersonalInformationAndClickContinueToSubmit(String firstName, String lastName) {
		driver.findElement(firstNameInPersonalDetails).clear();
		driver.findElement(firstNameInPersonalDetails).sendKeys(firstName);
		driver.findElement(lastNameInPersonalDetails).clear();
		driver.findElement(lastNameInPersonalDetails).sendKeys(lastName);
		driver.findElement(submitButton).click();
	}
	public String checkForUpdatedInfo() {
		return driver.findElement(firstNameInPersonalDetails).getText();
	}
}
