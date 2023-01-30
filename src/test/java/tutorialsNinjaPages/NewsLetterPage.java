package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewsLetterPage {
	WebDriver driver;
	By subscribe = By.name("newsletter");
	By continueButton = By.xpath("//input[@type='submit']");
	public NewsLetterPage(WebDriver driver){
		this.driver = driver;
	}
	public MyAccountPage clickYesToSubscribeAndContinue() {
		driver.findElement(subscribe).click();
		driver.findElement(continueButton).click();
		return new MyAccountPage(driver);
	}
}
