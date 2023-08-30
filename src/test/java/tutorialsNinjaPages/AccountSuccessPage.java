package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountSuccessPage {
	WebDriver driver;
	By registerAccountSuccessMsg = By.id("content");
	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;	
	}
	public String getAccountRegisterSuccessMsg() {
		String registerSuccessMsg = driver.findElement(registerAccountSuccessMsg).getText();
		return registerSuccessMsg; //success msg
	}
}
