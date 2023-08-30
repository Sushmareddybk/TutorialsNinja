package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import tutorialsNinjaCommon.CommonUtils;

public class AddAddressPage {
	WebDriver driver;
	By firstName = By.name("firstname"); //enters detail
	By lastName = By.name("lastname");
	By address1 = By.name("address_1");
	By cityName = By.name("city");
	By postCodeNum = By.name("postcode");
	By submitButton = By.xpath("//input[@type='submit']");
	By countryId = By.name("country_id");
	By zoneId = By.name("zone_id");
	public AddAddressPage(WebDriver driver) {
		this.driver = driver;	
	}
	public AddressBookPage addAddressAndClickOnContinue(String firstname, String address, String postcode) {
		driver.findElement(firstName).sendKeys(firstname);
		driver.findElement(lastName).sendKeys(CommonUtils.generateRandomString());
		driver.findElement(address1).sendKeys(address);
		driver.findElement(cityName).sendKeys(CommonUtils.generateRandomString());
		driver.findElement(postCodeNum).sendKeys(postcode);
		Select selectCountry = new Select(driver.findElement(countryId));
		selectCountry.selectByVisibleText("Albania");
		Select selectRegionId = new Select(driver.findElement(zoneId));
		selectRegionId.selectByVisibleText("Bulqize");
		driver.findElement(submitButton).submit();	
		return new AddressBookPage(driver);
	}
}
