package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GiftVoucherPage {
	WebDriver driver;
	By name = By.id("input-to-name");
	By email = By.id("input-to-email");
	By birthdayType = By.xpath("//input[@value='7']");
	By message = By.id("input-message");
	By terms = By.name("agree");
	By successPage = By.xpath("//input[@value='Continue']");
	By warningMsg = By.className("alert-danger");

	public GiftVoucherPage(WebDriver driver) {
		this.driver = driver;
	}
	public VoucherSuccessMsgPage enterGiftCertificateDetails() {
		driver.findElement(name).sendKeys("ben");
		driver.findElement(email).sendKeys("ben@gmail.com");  //
		driver.findElement(birthdayType).click();
		driver.findElement(message).sendKeys("HappyBirthday Ben");
		driver.findElement(terms).click();
		return new VoucherSuccessMsgPage(driver);
	}
	public VoucherSuccessMsgPage clickToNavigateVoucherSuccessPage() {
		driver.findElement(successPage).click();
		return new VoucherSuccessMsgPage(driver);
	}
	public GiftVoucherPage giftCertificateWithOutAgreeingToTerms() {
		driver.findElement(name).sendKeys("ben");
		driver.findElement(email).sendKeys("ben@gmail.com");
		driver.findElement(birthdayType).click();
		driver.findElement(message).sendKeys("HappyBirthday Ben");
		return new GiftVoucherPage(driver);
	}
	public String nonRefundableTerms() {
		return driver.findElement(warningMsg).getText();
	}
}
