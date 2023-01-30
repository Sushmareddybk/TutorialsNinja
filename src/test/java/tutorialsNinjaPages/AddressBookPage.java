package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressBookPage {
	WebDriver driver;
	By entriesFromAddressBook =By.xpath("//div[@class='table-responsive']");
	By newAddress = By.partialLinkText("New Address");
	By addressAddedMsg = By.className("alert-success");
	public AddressBookPage(WebDriver driver) {
		this.driver = driver;	
	}
	public String getAddressBookEntries() {
		WebDriverWait variable = new WebDriverWait(driver, 15);
		variable.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//td[@class='text-left']")));	
		return driver.findElement(entriesFromAddressBook).getText();
	}
	public AddAddressPage clickOnNewAddress() {
		driver.findElement(newAddress).click();
		return new AddAddressPage(driver);
	}
	public String getSuccessfullyAddedAddressMsg() {
		return driver.findElement(addressAddedMsg).getText();
	}
}
